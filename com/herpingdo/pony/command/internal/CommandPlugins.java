package com.herpingdo.pony.command.internal;

import com.herpingdo.pony.command.Command;
import com.herpingdo.pony.command.sender.CommandSender;

public class CommandPlugins extends Command {

	@Override
	public String[] getCommands() {
		return new String[] { "plugins", "pl" };
	}

	@Override
	public boolean onCommand(CommandSender sender, String[] args) {
		sender.sendMessage("Works!");
		return true;
	}

}
