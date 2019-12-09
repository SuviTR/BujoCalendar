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
    
    public String getCurrentDateForStartDay() {
    	Calendar date = (Calendar) this.currentDate.clone();
    	Date date2 =  date.getTime();
    	SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
    	return format1.format(date2);  
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
        String mon = this.monday.getDisplayName(Calendar.MONTH, Calendar.LONG_STANDALONE, this.locale);
        String sun = this.sunday.getDisplayName(Calendar.MONTH, Calendar.LONG_STANDALONE, this.locale);

        String monthString = "";
        String monthString2 = "";
        
        switch (mon) {
		case "tammikuu":
			monthString = "Tammikuu";
			monthString2 = "Tammikuu/Helmikuu";
			break;
		case "helmikuu":
			monthString = "Helmikuu";
			monthString2 = "Helmikuu/Maaliskuu";
			break;
		case "maaliskuu":
			monthString = "Maaliskuu";
			monthString2 = "Maaliskuu/Huhtikuu";
			break;
		case "huhtikuu":
			monthString = "Huhtikuu";
			monthString2 = "Huhtikuu/Toukokuu";
			break;
		case "toukokuu":
			monthString = "Toukokuu";
			monthString2 = "Toukokuu/Kesäkuu";
			break;
		case "kesäkuu":
			monthString = "Kesäkuu";
			monthString2 = "Kesäkuu/Heinäkuu";
			break;
		case "heinäkuu":
			monthString = "Heinäkuu";
			monthString2 = "Heinäkuu/Elokuu";
			break;
		case "elokuu":
			monthString = "Elokuu";
			monthString2 = "Elokuu/Syyskuu";
			break;
		case "syyskuu":
			monthString = "Syyskuu";
			monthString2 = "Syyskuu/Lokakuu";
			break;
		case "lokakuu":
			monthString = "Lokakuu";
			monthString2 = "Lokakuu/Marraskuu";
			break;
		case "marraskuu":
			monthString = "Marraskuu";
			monthString2 = "Marraskuu/Joulukuu";
			break;
		case "joulukuu":
			monthString = "Joulukuu";
			monthString2 = "Joulukuu/Tammikuu";
			break;
		}
        
        if (mon.equals(sun)) {
			return monthString;
		}
		
		else {
			return monthString2;
		}
	}
	
	//======= Get year number =======
	public String getYear() {		
        //return this.currentDate.getDisplayName(Calendar.YEAR, Calendar.LONG_STANDALONE, this.locale); //null!!
		int yMon = this.monday.get(Calendar.YEAR);
		int ySun = this.sunday.get(Calendar.YEAR);
		
		if (yMon == ySun) {
			return Integer.toString(yMon);
		}
		else {
			return Integer.toString(yMon) + "/" + Integer.toString(ySun);
		}
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