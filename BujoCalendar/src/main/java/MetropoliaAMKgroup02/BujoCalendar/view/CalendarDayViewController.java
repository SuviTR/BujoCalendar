/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.BujoCalendar.view;

import MetropoliaAMKgroup02.BujoCalendar.controller.CalendarController;
import MetropoliaAMKgroup02.BujoCalendar.view.MerkintaView;
import MetropoliaAMKgroup02.BujoCalendar.view.MerkintaView;
import MetropoliaAMKgroup02.Common.model.Merkinta;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author heikki
 */
public class CalendarDayViewController {

	private final GridPane container;
	private final int startTime;
	private final int endTime;
	private ArrayList<MerkintaView> events;
	private Calendar date;
	
	public CalendarDayViewController(GridPane dayContainer, int startTime, int endTime, Calendar date) {
		this.container = dayContainer;
		this.date = date;

		if(endTime < startTime) {
			throw new IllegalArgumentException("EndTime must be bigger than StartTime");
		}
		this.startTime = startTime;
		this.endTime = endTime;

		this.events = new ArrayList<>();
		this.initView();

	}


	private int rowCount() {
		return this.endTime - this.startTime;
	}

	private void initView() {
            this.container.getChildren().clear();
		for (int i = startTime; i < endTime; i++) {
			container.addRow(i, new Text(""));
		}
	}

    public void setDate(Calendar date) {
            this.date = (Calendar) date.clone();
            this.initView();
    }

	public void drawEvents() {
		
		if (events == null) {
			return;
		}

		for(MerkintaView event : events) {

			int eStartTime = event.getStartTime();
			int eEndTime = event.getEndTime();

			container.add(event.getGridPane(),
				0,
				eStartTime,
				1,
				eEndTime
			);
		}
	}

	public void injectEvents(CalendarController calendarController) {
        events.clear();
		List<Merkinta> eventList = calendarController.getDay(date);
		for (Merkinta merkinta : eventList) {
			events.add(new MerkintaView((merkinta)));
		}
	}

}
