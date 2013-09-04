package com.herpingdo.hakkit;

import java.util.List;
import java.util.HashMap;

import net.minecraft.server.MinecraftServer;
import net.minecraft.src.EntityPlayerMP;

import com.herpingdo.hakkit.command.CommandManager;
import com.herpingdo.hakkit.player.Player;
import com.herpingdo.hakkit.plugin.manager.PluginManager;

public class HakkitServer {
	
	private PluginManager pluginManager = new PluginManager();
	private CommandManager commandManager = new CommandManager();
	private HashMap<String, Player> playerList = new HashMap<String, Player>();
	private MinecraftServer minecraftServer;
	
	public HakkitServer() {
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
	
	/**
	 * Called when a player joins the server..
	 * Used to add it to Hakkit's internal lists. 
	 * @param mp The player who joined
	 */
	public void handlePlayerJoin(EntityPlayerMP mp) {
		this.playerList.put(mp.getEntityName(), new Player(mp));
	}
	
	/**
	 * Called when a player leaves the server.
	 * Used to remove it from Hakkit's internal lists
	 * @param mp The player who left
	 */
	public void handlePlayerQuit(EntityPlayerMP mp) {
		if (this.playerList.containsKey(mp.getEntityName())) {
			this.playerList.remove(mp.getEntityName());
		}
	}
	
	/**
	 * Gets the list of current players on the server.
	 * @return HashMap of player names to Player objects.
	 */
	public HashMap<String, Player> getPlayerList() {
		return this.playerList;
	}
	
	/**
	 * Gets a Player object from the list by their name.
	 * @param name The player's name
	 * @return Player object corresponding to the player.
	 */
	public Player getPlayerByName(String name) {
		return this.playerList.get(name);
	}

	/**
	 * Makes sure the server cleans up after itself.
	 */
	public void destroy() {
		this.pluginManager.callDisable();
		this.playerList.clear();
	}
	
	/** 
	 * Sets the MinecraftServer instance that Hakkit will use for various things.
	 * @param minecraftServer The instance.
	 */
	public void setMinecraftServer(MinecraftServer minecraftServer) {
		this.minecraftServer = minecraftServer;
	}
	
	/**
	 * Gets the active CommandManager. (Manages calling both internal and plugin commands.)
	 * @return CommandManager instance
	 */
	public CommandManager getCommandManager() {
		if (this.commandManager == null) this.commandManager = new CommandManager();
		return this.commandManager;
	}
	
	/**
	 * Gets the active PluginManager. (Manages loading plugins and registering/calling events.)
	 * @return PluginManager instance
	 */
	public PluginManager getPluginManager() {
		if (this.pluginManager == null) this.pluginManager = new PluginManager();
		return this.pluginManager;
	}
}
