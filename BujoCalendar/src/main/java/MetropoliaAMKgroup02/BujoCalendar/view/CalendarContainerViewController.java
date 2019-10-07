/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.BujoCalendar.view;

import MetropoliaAMKgroup02.BujoCalendar.controller.CalendarDayController;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author heikki
 */
public class CalendarContainerViewController {
	
	//Dates:
	private final int MONDAY = 1;
	private final int TUESDAY = 2;
	private final int WEDNESDAY = 3;
	private final int THURSDAY = 6;
	private final int FRIDAY = 7;
	// This is the last column:
	private final int WEEKEND = 8;

	// These are on different gridpane:
	private final int SATURDAY = 0;
	private final int SUNDAY = 2;

	private final int[] weekdays = {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY};
	private final int[] weekend_days = {SATURDAY, SUNDAY};

	private final GridPane calendarContainer;
	private final GridPane weekendContainer;

	private ArrayList<CalendarDayController> weekdayList;
	private ArrayList<CalendarDayController> weekendList;

	private int weekDayStart = 7;
	private int weekDayEnd = 21;
	private int weekendDayStart = 10;
	private int weekendDayEnd = 14;

	CalendarContainerViewController(GridPane calendarContainer, GridPane weekendContainer) {
		this.calendarContainer = calendarContainer;
		this.weekendContainer = weekendContainer;
		this.weekdayList = new ArrayList<>();
		this.weekendList = new ArrayList<>();
	}


	public void initDates() {

		for (int i = 0; i < weekdays.length; i++) {
			GridPane day = this.createDateColumn(weekdays[i], this.calendarContainer);
			weekdayList.add(new CalendarDayController(day,
				weekDayStart, weekDayEnd));
		}

		this.createDateRow(SATURDAY, weekendContainer);
		this.createDateRow(SUNDAY, weekendContainer);

	}

	private GridPane createDateColumn(int day, GridPane container) {
		return this.createDate(day, 0, container);
	}

	private GridPane createDateRow(int day, GridPane container) {
		return this.createDate(0, day, container);
	}

	private GridPane createDate(int column, int row, GridPane container) {

		GridPane dayPane = new GridPane();
		dayPane.add(
			new Label("Testi päivä: " + column + ":" + row),
			0, 0);
		container.add(dayPane, column, row);
		return dayPane;
		
	}

	private void createWeekend() {
		
	}

	/*public void drawEvents(events, day) {

		for (event in events) {

		}
	}*/

}
