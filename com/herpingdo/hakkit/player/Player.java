package com.herpingdo.hakkit.player;

import net.minecraft.src.ChatMessageComponent;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.EnumChatFormatting;
import net.minecraft.src.Packet3Chat;

import com.herpingdo.hakkit.command.sender.CommandSender;

public class Player implements CommandSender {
	
	private EntityPlayerMP mp = null;
	
	public Player(EntityPlayerMP mp) {
		this.mp = mp;
	}

	@Override
	/**
	 * Implemented from CommandSender. Sends a message to the player.
	 * @param message Message to send to the player.
	 */
	public void sendMessage(String message) {
		mp.playerNetServerHandler.sendPacket(new Packet3Chat(ChatMessageComponent.func_111082_b(message, new Object[] {})));
	}
	
	
}
