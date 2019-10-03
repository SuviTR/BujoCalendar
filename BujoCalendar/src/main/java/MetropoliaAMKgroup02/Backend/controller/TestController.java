/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.Backend.controller;

import MetropoliaAMKgroup02.Backend.Database;
import MetropoliaAMKgroup02.Backend.model.*;
import java.io.IOException;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author heikki
 */
public class TestController extends AbstractController {
	
	public TestController(Database data) {
		super(data);
	}

	/**
	 *
	 * @param uri
	 * @param body
	 * @return
	 */
	@Override
	protected Object sendResponse(URI uri, String body)  {
		throw new UnsupportedOperationException("Deprecated"); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	protected Object handleGet(int id, URI uri) {
		return new TestModel("Get-metodi", uri.getPath(), "ID: " + id);
	}

	@Override
	protected Object handleGet(URI uri) {
		return new TestModel("Get-metodi ilman id:tä", "", "");
	}

	@Override
	protected Object handlePost(String body, URI uri) {
		TestModel testModel = new TestModel();
		testModel.setName("Testmodel!!!");

		try {
			testModel = this.mapper.readValue(body, TestModel.class);
		} catch (IOException ex) {
			Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return testModel;
	}

	@Override
	protected Object handlePut(int id, String body, URI uri) {
		return new TestModel("PUT-metodi", uri.getPath(), "ID: " + id);
	}

	@Override
	protected Object handleDelete(int id, URI uri) {
		return new TestModel("Delete-metodi", uri.getPath(), "ID: " + id);
	}

	@Override
	protected Object handlePut(String string, URI uri) {
		return new TestModel("PUT-metodi", uri.getPath(), uri.getHost());
	}

	@Override
	protected Object handleDelete(URI uri) {
		return new TestModel("DELETE-metodi", uri.getPath(), uri.getHost());
	}


}
