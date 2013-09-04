package com.herpingdo.hakkit;

public class Hakkit {
	private static HakkitServer server = null;
	
	/**
	 * Gets the HakkitServer instance we are using
	 * @return HakkitServer instance.
	 */
	public static HakkitServer getServer() {
		return server;
	}
	
	/**
	 * Sets the HakkitServer instance we are using. Has the side effect of reloading everything.
	 * @param hakkitServer Instance to set it to.
	 */
	public static void setServer(HakkitServer hakkitServer) {
		if (server != null) server.destroy();
		server = hakkitServer;
        server.initialize();
	}
}
