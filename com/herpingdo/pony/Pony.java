package com.herpingdo.pony;

public class Pony {
	private static final PonyServer server = new PonyServer();
	
	public static PonyServer getServer() {
		return server;
	}
}
