/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.Backend.controller;

import MetropoliaAMKgroup02.Backend.model.TestModel;
import java.net.URI;

/**
 *
 * @author heikki
 */
public class CalendarController extends AbstractController {
	
	/**
	 *
	 * @param body
	 * @return
	 */
	@Override
	protected Object sendResponse(URI uri, String body) {

		TestModel test = new TestModel("Teppo Testaaja", 
			"53", 
			"Kissa kirnauskis");

		return test;
	}
}
