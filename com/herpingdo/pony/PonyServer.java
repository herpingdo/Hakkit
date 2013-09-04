package com.herpingdo.pony;

import java.util.List;
import java.util.HashMap;

import net.minecraft.server.MinecraftServer;
import net.minecraft.src.EntityPlayerMP;

import com.herpingdo.pony.command.CommandManager;
import com.herpingdo.pony.plugin.manager.PluginManager;

public class PonyServer {
	
	private PluginManager pluginManager = new PluginManager();
	private CommandManager commandManager = new CommandManager();
	private HashMap<String, Player> playerList = new HashMap<String, Player>();
	
	public PonyServer() {
		if (this.minecraftServer != null) {
			List<EntityPlayerMP> players = (List<EntityPlayerMP>)this.minecraftServer.getServerConfigurationManager(this.minecraftServer).playerEntityList;
			if (players.size() > 0) {
				for (EntityPlayerMP player : players) {
					this.playerList.put(player.getEntityName(), new Player(player));
				}
			} else {
				System.out.println("There were no players!");
			}
		} else {
			System.out.println("Server was null!");
		}
	}
	
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

	public void destroy() {
		this.pluginManager.callDisable();
		this.playerList.clear();
	}
	
	private MinecraftServer minecraftServer;
	public void setMinecraftServer(MinecraftServer minecraftServer) {
		this.minecraftServer = minecraftServer;
	}
	
	public CommandManager getCommandManager() {
		if (this.commandManager == null) this.commandManager = new CommandManager();
		return this.commandManager;
	}
	
	public PluginManager getPluginManager() {
		if (this.pluginManager == null) this.pluginManager = new PluginManager();
		return this.pluginManager;
	}
}
