package com.herpingdo.pony.command;

import com.herpingdo.pony.command.sender.CommandSender;

public abstract class Command {
	public abstract String[] getCommands();
	public abstract boolean onCommand(CommandSender sender, String[] args);
}
