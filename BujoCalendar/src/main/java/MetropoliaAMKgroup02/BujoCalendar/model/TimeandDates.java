package MetropoliaAMKgroup02.BujoCalendar.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class TimeandDates {
	
	private String date;
	private int month;
	private int dayOfWeek;
	private int dayOfWeek2;
	private int saturday;

	private String monday;
	private String yearMonth;
	private String weekDate;
	private String newMonthMon;
	private String newMonthSun;
	
	private MonthView monthView;
	
	//======= Get date of today =======
	
	public String getCurrentDate() {
		
		Date d = Calendar.getInstance().getTime();
		DateFormat dayDate = new SimpleDateFormat("yyyy-MM-dd");
		date = dayDate.format(d);
		
		return date;
		
		
		/*
		Date date = Calendar.getInstance().getTime();

		DateFormat dayDate = new SimpleDateFormat("dd");
		String dayString = dayDate.format(date);
		int today = Integer.parseInt(dayString);
		
		return today;*/
	}
	public int getWeekNumber(String date) {
		
		String format = "yyyy-MM-dd";
		SimpleDateFormat df = new SimpleDateFormat(format);
		Date dateParse = new Date();
		try {
			dateParse = df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateParse);
		
		int week = cal.get(Calendar.WEEK_OF_YEAR);
		
		return week;
		
		/*
		String input = weekDate;
		String format = "yyyyMMdd";

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
		return week;*/
	}
	
	public String[] getDate(String date, int week) {
		
		String[] dayList = new String[7];
		
		String format = "yyyy-MM-dd";
		SimpleDateFormat df = new SimpleDateFormat(format);
		/*
		SimpleDateFormat df = new SimpleDateFormat(format);
		Date dateParse = new Date();
		try {
			dateParse = df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateParse);
		
		int week = cal.get(Calendar.WEEK_OF_YEAR);*/
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, week);     

		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		String mon = df.format(cal.getTime());
		String monDay = mon.substring(mon.length() - 2);
		dayList[0] = monDay;
		System.out.println("mon" + monDay);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		String tue = df.format(cal.getTime());
		String tueDay = tue.substring(tue.length() - 2);
		dayList[1] = tueDay;
		System.out.println("mon" + tueDay);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		String wed = df.format(cal.getTime());
		String wedDay = wed.substring(wed.length() - 2);
		dayList[2] = wedDay;
		System.out.println("mon" + wedDay);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		String thu = df.format(cal.getTime());
		String thuDay = thu.substring(thu.length() - 2);
		dayList[3] = thuDay;
		System.out.println("mon" + thuDay);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		String fri = df.format(cal.getTime());
		String friDay = fri.substring(fri.length() - 2);
		dayList[4] = friDay;
		System.out.println("mon" + friDay);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		String sat = df.format(cal.getTime());
		String satDay = sat.substring(sat.length() - 2);
		dayList[5] = satDay;
		System.out.println("mon" + satDay);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		String sun = df.format(cal.getTime());
		String sunDay = sun.substring(sun.length() - 2);
		dayList[6] = sunDay;
		System.out.println("mon" + sunDay);
		
		return dayList;
	}
	
	
	
	//======= Get month of today =======
	public int getCurrentMonth() {
		
		Date date = Calendar.getInstance().getTime();
		
		DateFormat monthDate = new SimpleDateFormat("MM");
		String monthString = monthDate.format(date);
		month = Integer.parseInt(monthString);
		
		return month;
	}
	
	//======= Get Weekday =======
	//1=sunday, 2=monday, 3=tuesday, 4=wednesday, 5=thursday, 6=friday, 7=saturday 
	public int getWeekdayName() {
		Calendar calendar = Calendar.getInstance();  
		dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek;
	}
	
	//======= Correct date =======
	public String updateDate(int calDayOfWeek) {
		dayOfWeek2 = calDayOfWeek;
		String rightDate;
		
	    Calendar calendar = Calendar.getInstance();
		
    	//today, past days and days forward		
		int dayInt = dayOfWeek - calDayOfWeek; 
		calendar.add(Calendar.DAY_OF_YEAR, -dayInt);
		
		Date date2 = calendar.getTime();
		DateFormat dateDate2 = new SimpleDateFormat("dd");
	    String today = dateDate2.format(date2);
		rightDate = today;
		
		if (calDayOfWeek == 1) {	//sunday
			calendar.add(Calendar.DAY_OF_YEAR, 7);
			
			date2 = calendar.getTime();
			dateDate2 = new SimpleDateFormat("dd");
		    today = dateDate2.format(date2);
			rightDate = today;
			return rightDate;
		}
		return rightDate;
	}
	
	public void getSaturday(String saturdayDate) {
		int saturdayInt = Integer.parseInt(saturdayDate);
		saturday = saturdayInt;
	}

	
	
	public String getNewMonth() { //Vuosi pitää lisätä kuukauden perään
		String newMonth = "";

		String[] list = new String[] {"01","Tammikuu","02","Helmikuu","03","Maaliskuu","04","Huhtikuu", 
									  "05","Toukokuu","06","Kesäkuu","07","Heinäkuu","08","Elokuu", 
									  "09","Syyskuu","10","Lokakuu","11","Marraskuu","12","Joulukuu"};
		
		for (int i = 0; i < list.length; i++) {
			if (newMonthMon.equals(list[i])) {
				newMonth = list[i+1];
				System.out.println(list[i+1] + newMonth);
				break;	
			}
		}
		
		/*
		if (!newMonthMon.equals(newMonthSun)) { //Ei toimi oikein Syyskuu/Syyskuu
			
			for (int j = 0; j < list.length; j++) {
				if (newMonthMon.equals(list[j])) {
					newMonth = newMonth + "/" + list[j+1];
					System.out.println(list[j+1] + newMonth);
					break;	
				}
			}
		}*/
		System.out.println("newMont " + newMonth);
		return newMonth;
	}
	
	public String nextWeek(int calDayOfWeek,int count) { 
		String nextWeekDay;
		
	    Calendar calendar = Calendar.getInstance();
		
    	//today, past days and days forward		
		int dayInt = dayOfWeek - calDayOfWeek - 7*count; 
		calendar.add(Calendar.DAY_OF_YEAR, -dayInt);
		
		Date date2 = calendar.getTime();
		DateFormat dateDate2 = new SimpleDateFormat("dd");
	    String today = dateDate2.format(date2);
		nextWeekDay = today;
		
		if (calDayOfWeek == 2) {	//getting a weeknumber
			DateFormat dateDate3 = new SimpleDateFormat("yyyyMM");
			String yearWeekString = dateDate3.format(date2);
			yearMonth = yearWeekString;
			monday = today;
			weekDate = yearMonth+monday;
			
			newMonthMon = yearWeekString.substring(yearWeekString.length() - 2); //getting the right month
			System.out.println("WeekDate" + weekDate);
		}
		
		if (calDayOfWeek == 1) {	//sunday

			Calendar calendar2 = Calendar.getInstance();
			dayInt = saturday + 8;
			calendar2.add(Calendar.DAY_OF_YEAR, dayInt);
			
			date2 = calendar2.getTime();
			dateDate2 = new SimpleDateFormat("dd");
		    today = dateDate2.format(date2);
			nextWeekDay = today;
			return nextWeekDay;
		}
		return nextWeekDay;
	}
	
	public String lastWeek(int calDayOfWeek,int count) {
		
		String nextWeekDay;
		
	    Calendar calendar = Calendar.getInstance();
		
    	//today, past days and days forward		
		int dayInt = dayOfWeek - calDayOfWeek - 7*count; 
		calendar.add(Calendar.DAY_OF_YEAR, -dayInt);
		
		Date date2 = calendar.getTime();
		DateFormat dateDate2 = new SimpleDateFormat("dd");
	    String today = dateDate2.format(date2);
		nextWeekDay = today;
		
		if (calDayOfWeek == 2) {	//getting a weeknumber
			DateFormat dateDate3 = new SimpleDateFormat("yyyyMM");
			String yearWeekString = dateDate3.format(date2);
			yearMonth = yearWeekString;
			monday = today;
			weekDate = yearMonth+monday;
			
			newMonthMon = yearWeekString.substring(yearWeekString.length() - 2);	//getting the right month
		}
		
		if (calDayOfWeek == 1) {	//sunday
			
			Calendar calendar2 = Calendar.getInstance();
			dayInt = saturday + 8;
			calendar2.add(Calendar.DAY_OF_YEAR, dayInt);
			
			date2 = calendar2.getTime();
			dateDate2 = new SimpleDateFormat("dd");
		    today = dateDate2.format(date2);
			nextWeekDay = today;

			return nextWeekDay;
		}
		return nextWeekDay;
	}
	
	//======= Get selected date from datepicker =======
	public String[] selectedDate(String date) { //date = 20190925 = 25.9.2019 Kuukausi ja vkonro vielä
		
		String[] dayList = new String[7];
		String format = "yyyy-MM-dd";

		SimpleDateFormat df = new SimpleDateFormat(format);
		Date dateParse = new Date();
		try {
			dateParse = df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateParse);
		int week = cal.get(Calendar.WEEK_OF_YEAR);
		
		cal.set(Calendar.WEEK_OF_YEAR, week);     
		
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		String mon = df.format(cal.getTime());
		String monDay = mon.substring(mon.length() - 2);
		dayList[0] = monDay;
		cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		String tue = df.format(cal.getTime());
		String tueDay = tue.substring(tue.length() - 2);
		dayList[1] = tueDay;
		cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		String wed = df.format(cal.getTime());
		String wedDay = wed.substring(wed.length() - 2);
		dayList[2] = wedDay;
		cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		String thu = df.format(cal.getTime());
		String thuDay = thu.substring(thu.length() - 2);
		dayList[3] = thuDay;
		cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		String fri = df.format(cal.getTime());
		String friDay = fri.substring(fri.length() - 2);
		dayList[4] = friDay;
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		String sat = df.format(cal.getTime());
		String satDay = sat.substring(sat.length() - 2);
		dayList[5] = satDay;
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		String sun = df.format(cal.getTime());
		String sunDay = sun.substring(sun.length() - 2);
		dayList[6] = sunDay;
		
		return dayList;
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

		return yearString;
	}
	
	//======= Get week number =======
	public int updateWeekNumber() { 
		Calendar calendar = Calendar.getInstance();  
		int weekNumber = calendar.get(Calendar.WEEK_OF_YEAR);
		return weekNumber;
	}
}