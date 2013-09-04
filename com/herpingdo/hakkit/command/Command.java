package com.herpingdo.hakkit.command;

import com.herpingdo.hakkit.command.sender.CommandSender;

public abstract class Command {
	public abstract String[] getCommands();
	public abstract boolean onCommand(CommandSender sender, String[] args);
}
