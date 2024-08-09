
package net.mcreator.halflivedcrisis.network;

import net.mcreator.halflivedcrisis.HalfLivedCrisisMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TauChargeMessage {

	int type, pressedms;

	public TauChargeMessage(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public TauChargeMessage(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(TauChargeMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(TauChargeMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			pressAction(context.getSender(), message.type, message.pressedms);
		});
		context.setPacketHandled(true);
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;

		if (type == 0) {

			TauChargeOnKeyPressedProcedure.execute();
		}

		if (type == 1) {

			TauChargeOnKeyReleasedProcedure.execute();
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		HalfLivedCrisisMod.addNetworkMessage(TauChargeMessage.class, TauChargeMessage::buffer, TauChargeMessage::new, TauChargeMessage::handler);
	}

}
