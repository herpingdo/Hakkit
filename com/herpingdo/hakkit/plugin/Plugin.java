package com.herpingdo.hakkit.plugin;

import com.herpingdo.hakkit.Hakkit;
import com.herpingdo.hakkit.HakkitServer;
import com.herpingdo.hakkit.util.log.HakkitLogger;

public abstract class Plugin {

    private HakkitLogger logger = null;

	/* Plugin info */
	/**
	 * Gets the plugin's name.
	 * @return Name of the plugin.
	 */
	public abstract String getName();
	/**
	 * Gets the plugin's author.
	 * @return Name of the plugin's author
	 */
	public abstract String getAuthor();
	/**
	 * Gets the plugin's version
	 * @return Plugin version string.
	 */
	public abstract String getVersion();
	
	/* Initializers */
	/**
	 * Called when the plugin is enabled.
	 */
	public void onEnable() { }
	/**
	 * Called when the plugin is disabled.
	 */
	public void onDisable() { }
	
	/* Commands */
	public String[] getCommands() { return this.getCommand() == null ? null : new String[] { this.getCommand() }; };
	public String getCommand() { return null; };

    /* Various utility methods. */
    public HakkitServer getServer() {
        return Hakkit.getServer();
    }

    public HakkitLogger getLogger() {
        if (this.logger == null) {
            this.logger = new HakkitLogger(this.getName());
        }
        return this.logger;
    }
}
