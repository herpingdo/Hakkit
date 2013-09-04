package com.herpingdo.pony;

public class Pony {
	private static PonyServer server = new PonyServer();
	
	public static PonyServer getServer() {
		return server;
	}
	
	public static void setServer(PonyServer ponyServer) {
		server.destroy();
		server = ponyServer;
	}
}
