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
 * @author heikki
 */
public class TestMerkintaController extends AbstractController {
	
	public TestMerkintaController(Database data) {
		super(data);
	}

	/**
	 *
	 * @param body
	 * @return
	 */
	@Override
	protected Object sendResponse(URI uri, String body) {

		Merkinta merkinta = new Merkinta("Uusi merkinta");
		
		merkinta.setPaikka("Viipuri");
		merkinta.setSisalto("matka Venäjälle");
		Calendar date = Calendar.getInstance();
		date.set(2019, 8, 21, 7, 21);
		merkinta.setDate(date);
		merkinta.setPrior(Prior.HIGH);
		
		
		return merkinta;
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
	protected Object handlePut() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	protected Object handleDelete() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
