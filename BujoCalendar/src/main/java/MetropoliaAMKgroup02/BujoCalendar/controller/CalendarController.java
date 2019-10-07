/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.BujoCalendar.controller;

import MetropoliaAMKgroup02.BujoCalendar.model.HttpConnection;
import MetropoliaAMKgroup02.BujoCalendar.model.MerkintaList;
import MetropoliaAMKgroup02.Common.model.Merkinta;
import java.util.ArrayList;

/**
 *
 * @author heikki
 */
public class CalendarController {

	private MerkintaList merkintaList;

	public CalendarController() {
		merkintaList = new MerkintaList();
	}

	
	
	public void getAll() {
		HttpConnection connection = new HttpConnection();

		Merkinta[] merkinnat = (Merkinta[]) connection.get("/calendar", Merkinta[].class);

		merkintaList.importList(merkinnat);

		System.out.println(merkintaList.getAll());
	}
}
