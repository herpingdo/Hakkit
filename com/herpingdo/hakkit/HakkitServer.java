package com.herpingdo.hakkit;

import com.herpingdo.hakkit.command.CommandManager;
import com.herpingdo.hakkit.player.Player;
import com.herpingdo.hakkit.plugin.manager.PluginManager;
import com.herpingdo.hakkit.util.log.HakkitLogger;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.EntityPlayerMP;

import java.util.HashMap;
import java.util.List;

public class HakkitServer {

    private HakkitLogger logger = new HakkitLogger();
    private PluginManager pluginManager = new PluginManager(this);
    private CommandManager commandManager = new CommandManager();
    private HashMap<String, Player> playerList = new HashMap<String, Player>();
    private MinecraftServer minecraftServer;

    public HakkitServer() {

    }

    public void initialize() {
        if (this.minecraftServer == null) {
            this.minecraftServer = MinecraftServer.getServer();
        }
        List<EntityPlayerMP> players = (List<EntityPlayerMP>) this.minecraftServer.getServerConfigurationManager(this.minecraftServer).playerEntityList;
        if (players.size() > 0) {
            for (EntityPlayerMP player : players) {
                this.playerList.put(player.getEntityName(), new Player(player));
            }
        } else {
            this.getLogger().debug("There were no players online when initializing HakkitServer!");
        }
        this.getPluginManager().callEnable();
    }

    /**
     * Called when a player joins the server..
     * Used to add it to Hakkit's internal lists.
     *
     * @param mp The player who joined
     */
    public void handlePlayerJoin(EntityPlayerMP mp) {
        this.playerList.put(mp.getEntityName(), new Player(mp));
    }

    /**
     * Called when a player leaves the server.
     * Used to remove it from Hakkit's internal lists
     *
     * @param mp The player who left
     */
    public void handlePlayerQuit(EntityPlayerMP mp) {
        if (this.playerList.containsKey(mp.getEntityName())) {
            this.playerList.remove(mp.getEntityName());
        }
    }

    /**
     * Gets the list of current players on the server.
     *
     * @return HashMap of player names to Player objects.
     */
    public HashMap<String, Player> getPlayerList() {
        return this.playerList;
    }

    /**
     * Gets a Player object from the list by their name.
     *
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
     *
     * @param minecraftServer The instance.
     */
    public void setMinecraftServer(MinecraftServer minecraftServer) {
        this.minecraftServer = minecraftServer;
    }

    /**
     * Gets the active CommandManager. (Manages calling both internal and plugin commands.)
     *
     * @return CommandManager instance
     */
    public CommandManager getCommandManager() {
        return this.commandManager;
    }

    /**
     * Gets the active PluginManager. (Manages loading plugins and registering/calling events.)
     *
     * @return PluginManager instance
     */
    public PluginManager getPluginManager() {
        return this.pluginManager;
    }

    public HakkitLogger getLogger() {
        return this.logger;
    }
}
