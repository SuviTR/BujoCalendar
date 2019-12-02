/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.BujoCalendar.controller;

import MetropoliaAMKgroup02.BujoCalendar.utils.HttpConnection;
import MetropoliaAMKgroup02.BujoCalendar.model.MerkintaList;
import MetropoliaAMKgroup02.Common.model.Merkinta;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author heikki
 */
public class CalendarController {

	private MerkintaList merkintaList;
    private HttpConnection connection;
    private String endpoint = "/calendar";

	public CalendarController() {
		merkintaList = new MerkintaList();
        connection = new HttpConnection();
	}

	
	
	public void fetchAll() {

		Merkinta[] merkinnat = (Merkinta[]) connection.get(endpoint, Merkinta[].class);

		merkintaList.importArray(merkinnat);

	}

	public List<Merkinta> getDay(Calendar date) {
		return merkintaList.getDay(date);
	}

    public void createAppointment(Merkinta merkinta) {
            connection.post(endpoint, merkinta, Merkinta.class);
    }

        
}
