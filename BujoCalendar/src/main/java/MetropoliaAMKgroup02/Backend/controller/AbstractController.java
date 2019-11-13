/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.Backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import MetropoliaAMKgroup02.Backend.Database;
import MetropoliaAMKgroup02.Common.JSONHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import static java.lang.Thread.sleep;
import java.net.URI;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author heikki
 */
public abstract class AbstractController extends JSONHandler implements HttpHandler {
	protected Database data;
	 
	public AbstractController(Database data) {
		this.data = data;
	}

	@Override
	public void handle(HttpExchange HttpObject) throws IOException {

		System.out.println(new Date().toString() + " Got request from: " + HttpObject.getRequestURI().toString());
		InputStream is = HttpObject.getRequestBody();
		byte requestBody[] = new byte[1024];
		is.read(requestBody);
		
		String method = HttpObject.getRequestMethod();
		Object responseObj;
		URI uri;
		uri = HttpObject.getRequestURI();
		Integer id;
		
		switch (method) {
			case "GET":
			id = this.parseId(uri);
				if (id == null) {
					responseObj = this.handleGet(uri);

				} else {
					responseObj = this.handleGet(id, uri);
				}
				break;
			case "PUT":
				id = this.parseId(uri);
				if (id == null) {
					responseObj = this.handlePut("", uri);

				} else {
					responseObj = this.handlePut(id, new String(requestBody), HttpObject.getRequestURI());
				}
				break;
			case "POST":
				responseObj = this.handlePost(new String(requestBody), HttpObject.getRequestURI());
				break;
			case "DELETE":
				id = this.parseId(uri);
				if (id == null) {
					responseObj = this.handleDelete(HttpObject.getRequestURI());
				} else {
					responseObj = this.handleDelete(id, HttpObject.getRequestURI());
				}
				break;
			default:
				responseObj = new Object();
				break;
		}

		String response = this.json(responseObj);
		
		byte[] bytes = response.getBytes();

		HttpObject.getResponseHeaders().add("Content-type", "application/json");
		HttpObject.sendResponseHeaders(200, bytes.length);
		OutputStream os = HttpObject.getResponseBody();
		try {
			os.write(bytes);
			os.close();
		} catch(Exception e) {
			System.out.println("Outputstream kirjoitus epäonnistui:");
			e.printStackTrace();
		}
	}

	protected String json(Object obj) {
		return this.ObjToJSON(obj);
	}

	private Integer parseId(URI uri) {
		String path = uri.getPath();

		if (path == null) {
			return null;
		}
		
		String[] parts = path.split("/");

		try {
			// 0="/", 1=emdpoint, 2=id
			Integer id = Integer.parseInt(parts[2]);
			return id;
		} catch(Exception e) {
			// First part of the URL wasn't id...
			return null;
		}


	}

	protected abstract Object sendResponse(URI uri, String body);
	protected abstract Object handleGet(URI uri);
	protected abstract Object handleGet(int id, URI uri);
	protected abstract Object handlePost(String body, URI uri);
	protected abstract Object handlePut(int id, String body, URI uri);
	protected abstract Object handlePut(String string, URI uri);
	protected abstract Object handleDelete(int id, URI uri);
	protected abstract Object handleDelete(URI uri);

}
