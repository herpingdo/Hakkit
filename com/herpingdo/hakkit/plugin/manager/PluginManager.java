package com.herpingdo.hakkit.plugin.manager;

import com.herpingdo.hakkit.HakkitServer;
import com.herpingdo.hakkit.plugin.Plugin;
import com.herpingdo.hakkit.plugin.internal.TestPlugin;
import com.herpingdo.hakkit.util.log.HakkitLogger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class PluginManager {
	
	private ArrayList<Plugin> loadedPlugins;
	private HashMap<Plugin, ArrayList<Listener>> listeners = new HashMap<Plugin, ArrayList<Listener>>();
    private HakkitServer server;
	
	public PluginManager(HakkitServer server) {
        this.server = server;
		this.loadedPlugins = new ArrayList<Plugin>();
		this.loadInternalPlugins();
		//his.callEnable();
	}
	
	private void loadInternalPlugins() {
		this.loadPlugin(new TestPlugin());
	}
	
	private void loadPlugin(Plugin p) {
        this.loadedPlugins.add(p);
        server.getLogger().info(p.getName(), "loaded.");
	}

    /**
     * Call onEnable() for all of the loaded plugins.
     */
	public void callEnable() {
		for (Plugin plugin : this.loadedPlugins) {
			plugin.onEnable();
			server.getLogger().info(plugin.getName(), "by", plugin.getAuthor(), "version", plugin.getVersion(), "enabled!");
		}
	}
	
	/**
	 * Called when server is reloaded or stopped, to unload plugins.
	 */
	public void callDisable() {
		for (Plugin plugin : this.loadedPlugins) {
			plugin.onDisable();
			System.out.println(plugin.getName() + " disabled.");
		}
		this.loadedPlugins.clear();
		this.listeners.clear();
	}
	
	/**
	 * Calls an event.
	 * @param event The event to call.
	 */
	public void callEvent(Event event) {
        HakkitLogger logger = this.server.getLogger();
        for (Entry<Plugin, ArrayList<Listener>> entry : listeners.entrySet()) {
			for (Listener listener : entry.getValue()) {
				Class listenerClass = listener.getClass();
				for (Method method : listenerClass.getMethods()) {
					Class[] methodParameters = method.getParameterTypes();
					if (methodParameters.length >= 1 && methodParameters[0].getSimpleName().equals(event.getEventName())) {
						if (method.isAnnotationPresent(EventHandler.class)) {
							try {
								method.invoke(listener, event);
							} catch (IllegalAccessException e) {
								e.printStackTrace();
							} catch (IllegalArgumentException e) {
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
	
	public void registerEvents(Listener listener, Plugin plugin) {
        ArrayList<Listener> pluginListeners;
        if (this.listeners.containsKey(plugin)) {
            pluginListeners = this.listeners.get(plugin);
        } else {
            pluginListeners = new ArrayList<Listener>();
        }
        pluginListeners.add(listener);
	    this.listeners.put(plugin, pluginListeners);
        this.server.getLogger().debug("Registered listener for plugin", plugin.getName());

	}
}
