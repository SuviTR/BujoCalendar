/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.BujoCalendar.controller;

import MetropoliaAMKgroup02.BujoCalendar.view.MerkintaView;
import java.util.ArrayList;
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
	
	public CalendarDayController(GridPane dayContainer, int startTime, int endTime) {
		this.container = dayContainer;

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

}
