package com.herpingdo.hakkit.command.internal;

import com.herpingdo.hakkit.Hakkit;
import com.herpingdo.hakkit.HakkitServer;
import com.herpingdo.hakkit.command.Command;
import com.herpingdo.hakkit.command.sender.CommandSender;

public class CommandReload extends Command {

	@Override
	public String[] getCommands() {
		return new String[] { "reload" };
	}

	@Override
	public boolean onCommand(CommandSender sender, String[] args) {
		sender.sendMessage("Reloading server...");
		Hakkit.setServer(new HakkitServer());
		sender.sendMessage("Reloaded!");
		return true;
	}

}
