/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.Backend.controller;

import MetropoliaAMKgroup02.Backend.Database;
import MetropoliaAMKgroup02.Backend.model.*;
import MetropoliaAMKgroup02.Backend.model.Merkinta.Prior;

import java.util.Calendar;
import java.net.URI;

/**
 *
 * @author vladimir
 */
public class TestController extends AbstractController {
	
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
		CalendarModel merkintoja = new CalendarModel(this.data);
		merkintoja.addMerkinta();
		Object object = merkintoja.getAll();
		
			
		
		return object;
	}
}
