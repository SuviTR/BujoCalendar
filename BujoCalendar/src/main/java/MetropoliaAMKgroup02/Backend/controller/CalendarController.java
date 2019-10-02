/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.Backend.controller;

import MetropoliaAMKgroup02.Backend.Database;
import MetropoliaAMKgroup02.Backend.model.*;
//import MetropoliaAMKgroup02.Backend.model.Merkinta.Prior;

import java.util.Calendar;
import java.net.URI;

/**
 *
 * @author vladimir
 */
public class CalendarController extends AbstractController {
	public CalendarController(Database data) {
		super(data);
	}
	
	/**
	 *
	 * @param body
	 * @return
	 */
	@Override
	protected Object sendResponse(URI uri, String body) {
//		CalendarModel merkintoja = new CalendarModel(this.data);
//		merkintoja.addMerkinta();
//		Object object = merkintoja.getAll();

		TestModel test = new TestModel("Teppo Testaaja", 
			"53", 
			"Kissa kirnauskis");

		return test;
	}

	@Override
	protected Object handleGet(int id, URI uri) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	protected Object handlePost(String body, URI uri) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	protected Object handlePut(int id, String body, URI uri) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	protected Object handleDelete(int id, URI uri) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	protected Object handleGet(URI uri) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	protected Object handlePut(String string, URI uri) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	protected Object handleDelete(URI uri) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
