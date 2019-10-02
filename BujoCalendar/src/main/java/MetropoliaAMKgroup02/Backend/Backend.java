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
 * Simple backend for project
 * @author heikki
 */
public class Backend {
	
	public static void main(String[] args) {
		System.out.println("Creating database:");
		Database database = new Database();
		System.out.println("Created.");
		System.out.println("Starting server:");
		Server server = new Server(database);
	}
}
