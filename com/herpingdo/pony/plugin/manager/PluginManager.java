package com.herpingdo.pony.plugin.manager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import com.herpingdo.pony.plugin.Plugin;
import com.herpingdo.pony.plugin.internal.TestPlugin;

public class PluginManager {
	
	private ArrayList<Plugin> loadedPlugins;
	
	public PluginManager() {
		this.loadedPlugins = new ArrayList<Plugin>();
		this.loadInternalPlugins();
		this.callEnable();
	}
	
	private void loadInternalPlugins() {
		this.loadPlugin(new TestPlugin());
	}
	
	private void loadPlugin(Plugin p) {
		System.out.println(p.getName() + " loaded.");
	}
	
	private void callEnable() {
		for (Plugin plugin : this.loadedPlugins) {
			plugin.onEnable();
			System.out.println(plugin.getName() + " enabled.");
		}
	}
	
	public void callDisable() {
		for (Plugin plugin : this.loadedPlugins) {
			plugin.onDisable();
			System.out.println(plugin.getName() + " disabled.");
		}
	}
	
	public void callEvent(Listener listener, Event event) {
		for (Plugin plugin : loadedPlugins) {
			Class pluginClass = plugin.getClass();
			for (Method method : pluginClass.getMethods()) {
				Class[] methodParameters = method.getParameterTypes();
				if (methodParameters.length > 1 && methodParameters[0].getSimpleName().equals(event.getEventName())) {
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
