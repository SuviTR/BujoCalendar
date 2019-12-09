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
	
	/**
	 * Sets the current date and calls the updateDays().
	 * @param date is the current date.
	 */
	//======= Get date of today =======
	public void setCurrentDate(Calendar date) {
		this.currentDate = (Calendar) date.clone();
        this.updateDays();

	}

	/**
	 * Gets the current date and sets the right dates to every day of week.
	 */
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

	/**
	 * Gets the date of monday.
	 * @return the date of monday.
	 */
	public Calendar getMonday() {
		return (Calendar) this.monday.clone();
	}
	
	/**
	 * Get week number based on the current date.
	 * @return week number
	 */
	public int getWeekNumber() {
        return this.currentDate.get(Calendar.WEEK_OF_YEAR);
	}
	
	//======= Get selected date from datepicker and dates of days of weeks =======
	public String[] selectedDate(String date) { //date = 20190925 = 25.9.2019 Kuukausi ja vkonro vielä
		return new String[3];
	}
	
	/**
	 * Get month name based on the current week's monday and sunday date.
	 * @return monthString is the current month name based on that 
	 * the month of the monday and the sunday are in the same month.
	 * @return monthString is the current months of the monday and sunday dates.
	 */
	//======= Get month =======
	public String getMonth() {	
        String mon = this.monday.getDisplayName(Calendar.MONTH, Calendar.LONG_STANDALONE, this.locale);
        String sun = this.sunday.getDisplayName(Calendar.MONTH, Calendar.LONG_STANDALONE, this.locale);

        String monthString = "";
        String monthString2 = "";
        
        //if(this.locale == suomi) else currentday
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
	
	/**
	 * Get the current year based on the monday and sunday date.
	 * @return one year name or two year names based on if the monday and sunday are from different years.
	 */
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
	
	/**
	 * Get next week's dates when clicking the right arrow icon from the week view.
	 */
	public void nextWeek() {	
        this.currentDate.add(Calendar.DATE, 7);
        this.updateDays();
            
	}
	
	/**
	 * Get previous week's dates when clicking the left arrow icon from the week view.
	 */
	public void previousWeek() {
        this.currentDate.add(Calendar.DATE, -7);
        this.updateDays();
	}

	/**
	 * Get the local country and region values.
	 * @return the local country/region values.
	 */
    public Locale getLocale() {
        return this.locale;
    }

    /**
     * Get the week number of the current week.
     * @return week number.
     */
    public String getWeekNumberAsString() {
        return String.valueOf(this.getWeekNumber());
    }
}