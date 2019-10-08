/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.BujoCalendar.controller;

import MetropoliaAMKgroup02.BujoCalendar.view.MerkintaView;
import MetropoliaAMKgroup02.Common.model.Merkinta;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javafx.scene.layout.GridPane;

/**
 *
 * @author heikki
 */
public class CalendarDayController {

	private final GridPane container;
	private final int startTime;
	private final int endTime;
	private ArrayList<MerkintaView> events;
	private final Calendar date;
	
	public CalendarDayController(GridPane dayContainer, int startTime, int endTime, Calendar date) {
		this.container = dayContainer;
		this.date = date;

		if(endTime < startTime) {
			throw new IllegalArgumentException("EndTime must be bigger than StartTime");
		}
		this.startTime = startTime;
		this.endTime = endTime;
	}


	private int rowCount() {
		return this.endTime - this.startTime;
	}

	public void drawEvents() {
		
		for(MerkintaView event : events) {
			container.add(event.getGridPane(),
			0, 
			event.getStartTime(),
			0,
			event.getEndTime());
		}
	}

	public void injectEvents(CalendarController calendarController) {
		List<Merkinta> eventList = calendarController.getDay(date);
		for (Merkinta merkinta : eventList) {
			events.add(new MerkintaView((merkinta)));
		}
	}

}
