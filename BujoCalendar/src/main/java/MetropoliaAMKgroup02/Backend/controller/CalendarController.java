/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.Backend.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author heikki
 */
public class CalendarController implements HttpHandler {
	public void handle(HttpExchange HttpServer) throws IOException {
           InputStream is = HttpServer.getRequestBody();
           //read(is); // .. read the request body
           String response = "This is the response";
           HttpServer.sendResponseHeaders(200, response.length());
           OutputStream os = HttpServer.getResponseBody();
           os.write(response.getBytes());
           os.close();
       }
}
