/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.BujoCalendar.controller;

import MetropoliaAMKgroup02.BujoCalendar.model.HttpConnection;
import java.util.ArrayList;

/**
 *
 * @author heikki
 */
public class CalendarController {
	
	public void getAll() {
		HttpConnection connection = new HttpConnection();

		/*ArrayList<Merkinta> merkinnat = (ArrayList) connection.get("/calendar");

		this.merkinnat = merkinnat;

		CalendarView.draw(merkinnat);*/
	}
}
