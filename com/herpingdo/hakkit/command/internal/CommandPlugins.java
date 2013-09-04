package com.herpingdo.hakkit.command.internal;

import com.herpingdo.hakkit.command.Command;
import com.herpingdo.hakkit.command.sender.CommandSender;

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
