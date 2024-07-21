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

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
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
			}
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
				}
			});
			context.setPacketHandled(true);
		}
	}
}
