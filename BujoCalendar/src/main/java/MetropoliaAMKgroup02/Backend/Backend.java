/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.Backend;

import MetropoliaAMKgroup02.Backend.controller.*;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

/**
 *
 * @author heikki
 */
public class Backend {
	
	public static void main(String[] args) {
		HttpServer server = null;
		try {
			server = HttpServer.create(new InetSocketAddress(8000), 0);
		} catch (Exception e) {
			System.out.println("Http-palvelimen luonti ei onnistunut");
		}
		server.createContext("/test", new TestMerkintaController());
		server.setExecutor(null); // creates a default executor
		System.out.println("Starting server:");
		server.start();
	}
}
