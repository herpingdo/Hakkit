package com.herpingdo.pony;

import net.minecraft.src.ChatMessageComponent;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.EnumChatFormatting;
import net.minecraft.src.Packet3Chat;

import com.herpingdo.pony.command.sender.CommandSender;

public class Player implements CommandSender {
	
	private EntityPlayerMP mp = null;
	
	public Player(EntityPlayerMP mp) {
		this.mp = mp;
	}

	@Override
	public void sendMessage(String message) {
		//mp.playerNetServerHandler.sendPacket(new Packet3Chat(message));
		mp.playerNetServerHandler.sendPacket(new Packet3Chat(ChatMessageComponent.func_111082_b(message, new Object[] {})));
	}
	
	
}
