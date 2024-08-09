package net.mcreator.halflivedcrisis.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.halflivedcrisis.HalfLivedCrisisMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HalfLivedCrisisModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		HalfLivedCrisisMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		HalfLivedCrisisMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			if (!event.isWasDeath()) {
				clone.pistol_ammo = original.pistol_ammo;
				clone.smg_ammo = original.smg_ammo;
				clone.magnum_ammo = original.magnum_ammo;
				clone.gauss_ammo = original.gauss_ammo;
				clone.has_long_jump_module = original.has_long_jump_module;
				clone.has_hev_suit = original.has_hev_suit;
				clone.jump_var = original.jump_var;
				clone.shotgun_ammo = original.shotgun_ammo;
				clone.pusle_rifle_ammo = original.pusle_rifle_ammo;
				clone.ammo_display = original.ammo_display;
				clone.health = original.health;
				clone.health_display = original.health_display;
				clone.suit_battery = original.suit_battery;
				clone.suit_battery_display = original.suit_battery_display;
				clone.spare_ammo = original.spare_ammo;
				clone.crossbow_ammo = original.crossbow_ammo;
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					HalfLivedCrisisMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					HalfLivedCrisisMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					HalfLivedCrisisMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "half_lived_crisis_worldvars";
		public double prop_pos_y = 0;
		public double prop_pos_z = 0;
		public double prop_pos_x = 0;
		public double player_rotation = 0;

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			prop_pos_y = nbt.getDouble("prop_pos_y");
			prop_pos_z = nbt.getDouble("prop_pos_z");
			prop_pos_x = nbt.getDouble("prop_pos_x");
			player_rotation = nbt.getDouble("player_rotation");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("prop_pos_y", prop_pos_y);
			nbt.putDouble("prop_pos_z", prop_pos_z);
			nbt.putDouble("prop_pos_x", prop_pos_x);
			nbt.putDouble("player_rotation", player_rotation);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				HalfLivedCrisisMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "half_lived_crisis_mapvars";

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				HalfLivedCrisisMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		private final int type;
		private SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			if (nbt != null) {
				this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
				if (this.data instanceof MapVariables mapVariables)
					mapVariables.read(nbt);
				else if (this.data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt);
			}
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("half_lived_crisis", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double pistol_ammo = 0;
		public double smg_ammo = 0;
		public double magnum_ammo = 0;
		public double gauss_ammo = 0;
		public boolean has_long_jump_module = false;
		public boolean has_hev_suit = false;
		public boolean jump_var = false;
		public double shotgun_ammo = 0;
		public double pusle_rifle_ammo = 0;
		public String ammo_display = "\"\"";
		public double health = 100.0;
		public String health_display = "\"\"";
		public double suit_battery = 100.0;
		public String suit_battery_display = "\"\"";
		public String spare_ammo = "\"\"";
		public double crossbow_ammo = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				HalfLivedCrisisMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("pistol_ammo", pistol_ammo);
			nbt.putDouble("smg_ammo", smg_ammo);
			nbt.putDouble("magnum_ammo", magnum_ammo);
			nbt.putDouble("gauss_ammo", gauss_ammo);
			nbt.putBoolean("has_long_jump_module", has_long_jump_module);
			nbt.putBoolean("has_hev_suit", has_hev_suit);
			nbt.putBoolean("jump_var", jump_var);
			nbt.putDouble("shotgun_ammo", shotgun_ammo);
			nbt.putDouble("pusle_rifle_ammo", pusle_rifle_ammo);
			nbt.putString("ammo_display", ammo_display);
			nbt.putDouble("health", health);
			nbt.putString("health_display", health_display);
			nbt.putDouble("suit_battery", suit_battery);
			nbt.putString("suit_battery_display", suit_battery_display);
			nbt.putString("spare_ammo", spare_ammo);
			nbt.putDouble("crossbow_ammo", crossbow_ammo);
			return nbt;
		}

		public void readNBT(Tag tag) {
			CompoundTag nbt = (CompoundTag) tag;
			pistol_ammo = nbt.getDouble("pistol_ammo");
			smg_ammo = nbt.getDouble("smg_ammo");
			magnum_ammo = nbt.getDouble("magnum_ammo");
			gauss_ammo = nbt.getDouble("gauss_ammo");
			has_long_jump_module = nbt.getBoolean("has_long_jump_module");
			has_hev_suit = nbt.getBoolean("has_hev_suit");
			jump_var = nbt.getBoolean("jump_var");
			shotgun_ammo = nbt.getDouble("shotgun_ammo");
			pusle_rifle_ammo = nbt.getDouble("pusle_rifle_ammo");
			ammo_display = nbt.getString("ammo_display");
			health = nbt.getDouble("health");
			health_display = nbt.getString("health_display");
			suit_battery = nbt.getDouble("suit_battery");
			suit_battery_display = nbt.getString("suit_battery_display");
			spare_ammo = nbt.getString("spare_ammo");
			crossbow_ammo = nbt.getDouble("crossbow_ammo");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.pistol_ammo = message.data.pistol_ammo;
					variables.smg_ammo = message.data.smg_ammo;
					variables.magnum_ammo = message.data.magnum_ammo;
					variables.gauss_ammo = message.data.gauss_ammo;
					variables.has_long_jump_module = message.data.has_long_jump_module;
					variables.has_hev_suit = message.data.has_hev_suit;
					variables.jump_var = message.data.jump_var;
					variables.shotgun_ammo = message.data.shotgun_ammo;
					variables.pusle_rifle_ammo = message.data.pusle_rifle_ammo;
					variables.ammo_display = message.data.ammo_display;
					variables.health = message.data.health;
					variables.health_display = message.data.health_display;
					variables.suit_battery = message.data.suit_battery;
					variables.suit_battery_display = message.data.suit_battery_display;
					variables.spare_ammo = message.data.spare_ammo;
					variables.crossbow_ammo = message.data.crossbow_ammo;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
