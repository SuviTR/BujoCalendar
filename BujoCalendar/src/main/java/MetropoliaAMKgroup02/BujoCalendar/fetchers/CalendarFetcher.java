/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.BujoCalendar.fetchers;

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
public class CalendarFetcher {

	private MerkintaList merkintaList;
    private HttpConnection connection;
    private String endpoint = "/calendar";

	public CalendarFetcher() {
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

    public void editAppointment(Merkinta merkinta) {
            String id = String.valueOf(merkinta.getId());
            connection.put(endpoint + "/" + id, merkinta, Merkinta.class);
    }

	public void delete(int merkintaId) {
		merkintaList.removeMerkinta(merkintaId);
		connection.delete(endpoint + "/" + merkintaId);
	}
}
