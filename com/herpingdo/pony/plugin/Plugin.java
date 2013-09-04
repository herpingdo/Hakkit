package com.herpingdo.pony.plugin;

public abstract class Plugin {
	
	/* Plugin info */
	public abstract String getName();
	public abstract String getVersion();
	public abstract String getAuthor();
	
	/* Initializers */
	public void onEnable() { }
	public void onDisable() { }
	
	/* Commands */
	public String[] getCommands() { return this.getCommand() == null ? null : new String[] { this.getCommand() }; };
	public String getCommand() { return null; };
}
