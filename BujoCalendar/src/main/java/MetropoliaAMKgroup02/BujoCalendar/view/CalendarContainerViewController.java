/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.BujoCalendar.view;

import MetropoliaAMKgroup02.BujoCalendar.controller.CalendarController;
import MetropoliaAMKgroup02.BujoCalendar.model.Dates;
import java.util.ArrayList;
import java.util.Calendar;
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

	private ArrayList<CalendarDayViewController> weekdayList;
	private ArrayList<CalendarDayViewController> weekendList;
	private ArrayList<CalendarDayViewController> dayList;

	private int weekDayStart = 7;
	private int weekDayEnd = 21;
	private int weekendDayStart = 10;
	private int weekendDayEnd = 14;
	private Dates dates;
	private CalendarController calendarController;

	CalendarContainerViewController(GridPane calendarContainer, GridPane weekendContainer) {
		this.calendarContainer = calendarContainer;
		this.weekendContainer = weekendContainer;
	}


	public void initDates() {
		this.weekdayList = new ArrayList<>();
		this.weekendList = new ArrayList<>();
		this.dayList = new ArrayList<>();

		Calendar date = this.dates.getMonday();

		for (int i = 0; i < weekdays.length; i++) {
			GridPane day = this.createDateColumn(weekdays[i], this.calendarContainer);
			weekdayList.add(new CalendarDayViewController(day,
				weekDayStart, weekDayEnd, date));

			date = (Calendar) date.clone();
			date.add(Calendar.DAY_OF_WEEK, 1);
		}

		weekendList.add(new CalendarDayViewController(
				this.createDateRow(SATURDAY, weekendContainer),
					weekendDayStart,
					weekendDayEnd, date)
		);

		date = (Calendar) date.clone();
		date.add(Calendar.DAY_OF_WEEK, 1);
		weekendList.add(new CalendarDayViewController(
		this.createDateRow(SUNDAY, weekendContainer), 
				weekendDayStart,
				weekendDayEnd, date));

		// Add all objects to a daylist
		dayList.addAll(weekdayList);
		dayList.addAll(weekendList);
	}

    public void updateDays() {
            Calendar date = this.dates.getMonday();

            for(CalendarDayViewController day : dayList) {
                    day.setDate(date);
                    date.add(Calendar.DATE, 1);
            }
    }

	private GridPane createDateColumn(int day, GridPane container) {
		return this.createDate(day, 0, container);
	}

	private GridPane createDateRow(int day, GridPane container) {
		return this.createDate(0, day, container);
	}

	private GridPane createDate(int column, int row, GridPane container) {

		GridPane dayPane = new GridPane();
		//dayPane.add(
		//	new Label("Testi päivä: " + column + ":" + row),
		//	0, 0);
		container.add(dayPane, column, row);
		return dayPane;
		
	}

	public void drawEvents() {
		for(CalendarDayViewController day : dayList) {
			day.injectEvents(calendarController);
			day.drawEvents();
		}
	}

	void setTimeAndDates(Dates dates) {
		this.dates = dates;
	}

	void setCalendarController(CalendarController calendarController) {
		this.calendarController = calendarController;
	}
}
