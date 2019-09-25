/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.Backend;

import MetropoliaAMKgroup02.Backend.controller.TestController;
import MetropoliaAMKgroup02.Backend.controller.HenkiloController;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

/**
 *
 * @author heikki
 */
public class Server {
	
	HttpServer server = null;

	public Server() {

		try {
			this.server = HttpServer.create(new InetSocketAddress(8000), 0);
		} catch (Exception e) {
			System.out.println("Http-palvelimen luonti ei onnistunut");
		}

		this.createContexts();

		server.setExecutor(null); // creates a default executor
		server.start();
		System.out.println("Server started. Listening http://localhost:8000");
	}

	private void createContexts() {

		server.createContext("/calendar", new TestController());
		server.createContext("/henkilo", new HenkiloController());
	}
}
