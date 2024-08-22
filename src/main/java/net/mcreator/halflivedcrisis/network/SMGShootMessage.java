
package net.mcreator.halflivedcrisis.network;

import net.mcreator.halflivedcrisis.HalfLivedCrisisMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SMGShootMessage {

	int type, pressedms;

	public SMGShootMessage(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public SMGShootMessage(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(SMGShootMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(SMGShootMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
		});
		context.setPacketHandled(true);
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		HalfLivedCrisisMod.addNetworkMessage(SMGShootMessage.class, SMGShootMessage::buffer, SMGShootMessage::new, SMGShootMessage::handler);
	}

}
