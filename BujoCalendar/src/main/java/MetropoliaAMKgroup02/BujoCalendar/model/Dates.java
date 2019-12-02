package MetropoliaAMKgroup02.BujoCalendar.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Dates {
	
	private Calendar currentDate;
	private Calendar monday;
	private Calendar tuesday;
	private Calendar wednesday;
	private Calendar thursday;
	private Calendar friday;
	private Calendar saturday;
	private Calendar sunday;
	
    private Locale locale;
	
	public Dates() {
		this.locale = new Locale("fi", "FI");	
		this.setCurrentDate(Calendar.getInstance(this.locale));
	}
	
	//======= Get date of today =======
	public void setCurrentDate(Calendar date) {
		this.currentDate = (Calendar) date.clone();
        this.updateDays();

	}

    private void updateDays() {

        Calendar date = (Calendar) this.currentDate.clone();
		// Scroll back to last monday:
		while(!(date.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY)) {
			date.add(Calendar.DAY_OF_WEEK, -1);
		}

		this.monday = (Calendar) date.clone();
		date.add(Calendar.DAY_OF_WEEK, 1);
		this.tuesday = (Calendar) date.clone();
		date.add(Calendar.DAY_OF_WEEK, 1);
		this.wednesday = (Calendar) date.clone();
		date.add(Calendar.DAY_OF_WEEK, 1);
		this.thursday = (Calendar) date.clone();
		date.add(Calendar.DAY_OF_WEEK, 1);
		this.friday = (Calendar) date.clone();
		date.add(Calendar.DAY_OF_WEEK, 1);
		this.saturday = (Calendar) date.clone();
		date.add(Calendar.DAY_OF_WEEK, 1);
		this.sunday = (Calendar) date.clone();

    }

	public Calendar getCurrentDate() {
		return currentDate;
	}

	public Calendar getMonday() {
		return (Calendar) this.monday.clone();
	}
	
	//======= Get week number of current date =======
	public int getWeekNumber() {
            return this.currentDate.get(Calendar.WEEK_OF_YEAR);
	}
	

	//======= Get selected date from datepicker and dates of days of weeks =======
	public String[] selectedDate(String date) { //date = 20190925 = 25.9.2019 Kuukausi ja vkonro vielä
		return new String[3];
	}
	
	//======= Get month =======
	public String getMonth() {	
        return this.currentDate.getDisplayName(Calendar.MONTH, Calendar.LONG_STANDALONE, this.locale);
	}
	
	//======= Get year number =======
	public String getYear() {		
        return this.currentDate.getDisplayName(Calendar.YEAR, Calendar.LONG_STANDALONE, this.locale);
	}
	
	public void nextWeek() {	
        this.currentDate.add(Calendar.DATE, 7);
        this.updateDays();
            
	}
	
	public void previousWeek() {
        this.currentDate.add(Calendar.DATE, -7);
        this.updateDays();
	}

    public Locale getLocale() {
        return this.locale;
    }

    public String getWeekNumberAsString() {
        return String.valueOf(this.getWeekNumber());
    }
}