package com.herpingdo.pony.command.internal;

import com.herpingdo.pony.Pony;
import com.herpingdo.pony.PonyServer;
import com.herpingdo.pony.command.Command;
import com.herpingdo.pony.command.sender.CommandSender;

public class CommandReload extends Command {

	@Override
	public String[] getCommands() {
		return new String[] { "reload" };
	}

	@Override
	public boolean onCommand(CommandSender sender, String[] args) {
		sender.sendMessage("Reloading server...");
		Pony.setServer(new PonyServer());
		sender.sendMessage("Reloaded!");
		return true;
	}

}
