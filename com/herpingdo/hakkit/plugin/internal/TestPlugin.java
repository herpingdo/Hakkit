package com.herpingdo.hakkit.plugin.internal;

import com.herpingdo.hakkit.Hakkit;
import com.herpingdo.hakkit.plugin.Plugin;
import com.herpingdo.hakkit.plugin.event.GameTickEvent;
import com.herpingdo.hakkit.plugin.manager.EventHandler;
import com.herpingdo.hakkit.plugin.manager.Listener;


public class TestPlugin extends Plugin implements Listener {

	@Override
	public String getName() {
		return "TestPlugin";
	}

	@Override
	public String getVersion() {
		return "0.01";
	}

	@Override
	public String getAuthor() {
		return "herpingdo";
	}
	
	@Override
	public void onEnable() {
        Hakkit.getServer().getPluginManager().registerEvents(this, this);
        System.out.println(this.getName() + " enabled!");
	}

    @EventHandler
    public void onGameTick(GameTickEvent evt) {
        System.out.println("Hacks");
    }

}
