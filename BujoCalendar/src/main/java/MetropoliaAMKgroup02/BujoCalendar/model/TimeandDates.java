package MetropoliaAMKgroup02.BujoCalendar.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Date;

public class TimeandDates {
	
	private int month;
	private int dayOfWeek;
	private int dayOfWeek2;
	private int saturday;
	private String monday;
	private String mondayYearMonth;
	private String weekDate;
	
	//======= Get date of today =======
	public int getCurrentDate() {
		
		Date date = Calendar.getInstance().getTime();
		
		DateFormat dayDate = new SimpleDateFormat("dd");
		String dayString = dayDate.format(date);
		int today = Integer.parseInt(dayString);
		System.out.println("Day " + dayString);
		
		return today;
	}
	
	//======= Get month of today =======
	public int getCurrentMonth() {
		
		Date date = Calendar.getInstance().getTime();
		
		DateFormat monthDate = new SimpleDateFormat("MM");
		String monthString = monthDate.format(date);
		month = Integer.parseInt(monthString);
		System.out.println("Month " + monthString);
		
		return month;
	}
	
	//======= Get Weekday =======
	//1=sunday, 2=monday, 3=tuesday, 4=wednesday, 5=thursday, 6=friday, 7=saturday 
	public int getWeekdayName() {
		
		Calendar calendar = Calendar.getInstance();  
		dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println("Day of week " + dayOfWeek); 
		
		return dayOfWeek;
	}
	
	//======= Correct date =======
	public int updateDate(int calDayOfWeek) {
		dayOfWeek2 = calDayOfWeek;
		int rightDate;
		
	    Calendar calendar = Calendar.getInstance();
		
    	//today, past days and days forward		
		int dayInt = dayOfWeek - calDayOfWeek; 
		calendar.add(Calendar.DAY_OF_YEAR, -dayInt);
		
		Date date2 = calendar.getTime();
		DateFormat dateDate2 = new SimpleDateFormat("dd");
	    String day = dateDate2.format(date2);
		int today = Integer.parseInt(day);
		rightDate = today;
		
		if (calDayOfWeek == 1) {	//sunday
			calendar.add(Calendar.DAY_OF_YEAR, 7);
			
			date2 = calendar.getTime();
			dateDate2 = new SimpleDateFormat("dd");
		    day = dateDate2.format(date2);
			today = Integer.parseInt(day);
			rightDate = today;
			return rightDate;
		}
		return rightDate;
	}
	
	public void getSaturday(int saturdayDate) {
		saturday = saturdayDate;
	}

	public int getWeekNumber() {
		String input = weekDate;
		String format = "yyyyMMdd";
		System.out.println("get" + weekDate);

		SimpleDateFormat df = new SimpleDateFormat(format);
		Date date = new Date();
		try {
			date = df.parse(input);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week = cal.get(Calendar.WEEK_OF_YEAR);
		System.out.println("Week" + week);
		return week;
	}
	
	public int nextWeek(int calDayOfWeek,int count) { //Muuta Stringeiksi
		
		int nextWeekDay;
		
	    Calendar calendar = Calendar.getInstance();
		
    	//today, past days and days forward		
		int dayInt = dayOfWeek - calDayOfWeek - 7*count; 
		calendar.add(Calendar.DAY_OF_YEAR, -dayInt);
		
		Date date2 = calendar.getTime();
		DateFormat dateDate2 = new SimpleDateFormat("dd");
	    String day = dateDate2.format(date2);
		int today = Integer.parseInt(day);
		nextWeekDay = today;
		
		if (calDayOfWeek == 2) {
			DateFormat dateDate3 = new SimpleDateFormat("yyyyMM");
			String yearWeekString = dateDate3.format(date2);
			mondayYearMonth = yearWeekString;
			monday = day;
			weekDate = mondayYearMonth+monday;
			
			System.out.println("WeekDate" + weekDate);
		}
		
		if (calDayOfWeek == 1) {	//sunday

			Calendar calendar2 = Calendar.getInstance();
			dayInt = saturday + 11;
			calendar2.add(Calendar.DAY_OF_YEAR, dayInt);
			
			date2 = calendar2.getTime();
			dateDate2 = new SimpleDateFormat("dd");
		    day = dateDate2.format(date2);
			today = Integer.parseInt(day);
			nextWeekDay = today;
			System.out.println("Sunday");
			return nextWeekDay;
		}
		return nextWeekDay;
	}
	
	public int lastWeek(int calDayOfWeek,int count) {
		
		int nextWeekDay;
		
	    Calendar calendar = Calendar.getInstance();
		
    	//today, past days and days forward		
		int dayInt = dayOfWeek - calDayOfWeek - 7*count; 
		calendar.add(Calendar.DAY_OF_YEAR, -dayInt);
		
		Date date2 = calendar.getTime();
		DateFormat dateDate2 = new SimpleDateFormat("dd");
	    String day = dateDate2.format(date2);
		int today = Integer.parseInt(day);
		nextWeekDay = today;
		System.out.println("lastweek " + nextWeekDay);
		
		if (calDayOfWeek == 2) {
			DateFormat dateDate3 = new SimpleDateFormat("yyyyMM");
			String yearWeekString = dateDate3.format(date2);
			mondayYearMonth = yearWeekString;
			monday = day;
			weekDate = mondayYearMonth+monday;
			
			System.out.println("WeekDate" + weekDate);
		}
		
		if (calDayOfWeek == 1) {	//sunday
			
			Calendar calendar2 = Calendar.getInstance();
			dayInt = saturday + 11;
			calendar2.add(Calendar.DAY_OF_YEAR, dayInt);
			
			date2 = calendar2.getTime();
			dateDate2 = new SimpleDateFormat("dd");
		    day = dateDate2.format(date2);
			today = Integer.parseInt(day);
			nextWeekDay = today;
			
			System.out.println("Sunday");
			return nextWeekDay;
		}
		return nextWeekDay;
	}
	
	//======= Get month name =======
	public String updateMonth() {
		String monthString = "";
		
		switch (month) {
		  case 1:
		    monthString = "Tammikuu";
		    break;
		  case 2:
			monthString = "Helmikuu";
		    break;
		  case 3:
			monthString = "Maaliskuu";
		    break;
		  case 4:
			monthString = "Huhtikuu";
		    break;
		  case 5:
			monthString = "Toukokuu";
		    break;
		  case 6:
			monthString = "Kesäkuu";
		    break;
		  case 7:
			monthString = "Heinäkuu";
			break;
		  case 8:
			monthString = "Elokuu";
			break;
		  case 9:
			monthString = "Syyskuu";
			break;
		  case 10:
			monthString = "Lokakuu";
			break;
		  case 11:
			monthString = "Marraskuu";
			break;
		  case 12:
			monthString = "Joulukuu";
		    break;
		}
		return monthString;
	}
	
	//======= Get year number =======
	public String updateYear() {
		int year = 0;
		
		Date date = Calendar.getInstance().getTime();

		DateFormat yearDate = new SimpleDateFormat("yyyy");
		String yearString = yearDate.format(date);
		System.out.println("Year " + yearString);

		return yearString;
	}
	
	//======= Get week number =======
	public int updateWeekNumber() { 
		Calendar calendar = Calendar.getInstance();  
		int weekNumber = calendar.get(Calendar.WEEK_OF_YEAR);
		System.out.println("Weeknumber" + weekNumber); 
		
		return weekNumber;
	}
	
		//Date date = new Date();
		//System.out.println(dateFormat.format(date));
		
		/*
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
		String strDate = dateFormat.format(date);  
		*/
}
