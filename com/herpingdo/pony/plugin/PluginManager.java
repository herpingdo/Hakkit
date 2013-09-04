package com.herpingdo.pony.plugin;

import java.util.ArrayList;

public class PluginManager {
	
	private ArrayList<Plugin> loadedPlugins;
	
	public PluginManager() {
		this.loadedPlugins = new ArrayList<Plugin>();
	}
	
	private void loadInternalPlugins() {
		
	}
}
