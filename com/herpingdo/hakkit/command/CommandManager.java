package com.herpingdo.hakkit.command;

import java.util.ArrayList;

import com.herpingdo.hakkit.command.internal.CommandPlugins;
import com.herpingdo.hakkit.command.internal.CommandReload;
import com.herpingdo.hakkit.command.sender.CommandSender;
import com.herpingdo.hakkit.util.StringUtil;

public class CommandManager {
	private ArrayList<Command> commands = null;
	
	public CommandManager() {
		this.commands = new ArrayList<Command>();
		this.commands.add(new CommandPlugins());
		this.commands.add(new CommandReload());
	}
	
	public boolean handleCommand(String raw, CommandSender sender) {
		String[] split = raw.split(" ");
		String[] args;
		if (split.length == 1) {
			args = new String[0];
		} else {
			args = StringUtil.getInstance().popStringArr(split, 1);
		}
		for (Command c : commands) {
			for (String s : c.getCommands()) {
				if (s.equalsIgnoreCase(split[0])) {
					c.onCommand(sender, args);
					return true;
				}
			}
		}
		return false;
	}
}
