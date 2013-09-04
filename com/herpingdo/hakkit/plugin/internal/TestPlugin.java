package com.herpingdo.hakkit.plugin.internal;

import com.herpingdo.hakkit.plugin.Plugin;
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
		System.out.println(this.getName() + " enabled!");
	}

}
