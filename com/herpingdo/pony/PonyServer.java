package com.herpingdo.pony;

import java.util.HashMap;

import net.minecraft.src.EntityPlayerMP;

import com.herpingdo.pony.command.CommandManager;
import com.herpingdo.pony.plugin.PluginManager;

public class PonyServer {
	private PluginManager pluginManager;
	private CommandManager commandManager;
	
	public CommandManager getCommandManager() {
		if (this.commandManager == null) this.commandManager = new CommandManager();
		return this.commandManager;
	}
	
	public PluginManager getPluginManager() {
		if (this.pluginManager == null) this.pluginManager = new PluginManager();
		return this.pluginManager;
	}
	
	private HashMap<String, Player> playerList = new HashMap<String, Player>();
	
	public void handlePlayerJoin(EntityPlayerMP mp) {
		this.playerList.put(mp.getEntityName(), new Player(mp));
	}
	
	public void handlePlayerQuit(EntityPlayerMP mp) {
		if (this.playerList.containsKey(mp.getEntityName())) {
			this.playerList.remove(mp.getEntityName());
		}
	}
	
	public HashMap<String, Player> getPlayerList() {
		return this.playerList;
	}
	
	public Player getPlayerByName(String name) {
		return this.playerList.get(name);
	}
}
