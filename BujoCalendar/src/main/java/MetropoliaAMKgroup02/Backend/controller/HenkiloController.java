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
public class HenkiloController extends AbstractController {

	HenkiloModel henkilot = new HenkiloModel(this.data);

	public HenkiloController(Database data) {
		super(data);
	}

	@Override
	protected Object sendResponse(URI uri, String body) {
		HenkiloModel henkilo = new HenkiloModel(data);
		return henkilo.getAll();
	}

	@Override
	protected Object handleGet(URI uri) {
		// TODO Auto-generated method stub
		HenkiloModel henkilo = new HenkiloModel(data);
		return henkilo.getAll();
	}

	@Override
	protected Object handleGet(int id, URI uri) {
		HenkiloModel henkilo = new HenkiloModel(this.data);
		return henkilo.getHenkilo(id);
	}

	@Override
	protected Object handlePost(String body, URI uri) {
		HenkiloModel henkiloModel = new HenkiloModel(this.data);
		Henkilo henkilo = new Henkilo();
		try {
			henkilo = this.mapper.readValue(body, Henkilo.class);
		} catch (IOException ex) {
			Logger.getLogger(HenkiloController.class.getName()).log(Level.SEVERE, null, ex);
		}
		henkiloModel.addHenkilo(henkilo);
		return henkilo;
	}

	@Override
	protected Object handlePut(int id, String body, URI uri) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
/*		HenkiloModel henkilo = new HenkiloModel(this.data);
		henkilo.getHenkilo(id);
		return henkilo;
		*/
	}

	@Override
	protected Object handleDelete(int id, URI uri) {

		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//		return new TestModel("Delete-metodi", uri.getPath(), "ID: " + id);
	}

	@Override
	protected Object handlePut(String string, URI uri) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//		return new TestModel("PUT-metodi", uri.getPath(), uri.getHost());
	}

	@Override
	protected Object handleDelete(URI uri) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//		return new TestModel("DELETE-metodi", uri.getPath(), uri.getHost());
	}

}
