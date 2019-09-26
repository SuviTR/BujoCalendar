/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.Backend.controller;

import MetropoliaAMKgroup02.Backend.Database;
import java.net.URI;

/**
 *
 * @author heikki
 */
public class HenkiloController extends AbstractController {

	public HenkiloController(Database data) {
		super(data);
	}

	@Override
	protected Object sendResponse(URI uri, String body) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
