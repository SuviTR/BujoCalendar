package MetropoliaAMKgroup02.BujoCalendar.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Date;

public class TimeandDates {
	
	private int today;
	private int month;
	private int dayOfWeek;
	
	public static void main(String[] args) {

		Calendar calendar = Calendar.getInstance();  
		
		
		System.out.println("The current date is : " + calendar.getTime());  
		calendar.add(calendar.DATE, -15);  
		System.out.println("15 days ago: " + calendar.getTime());  
		calendar.add(calendar.MONTH, 4);  
		System.out.println("4 months later: " + calendar.getTime());  
		calendar.add(calendar.YEAR, 2);  
		System.out.println("2 years later: " + calendar.getTime());  
		/*
		LocalDate localDate1 = LocalDate.of(2019, Month.OCTOBER, 2); // Set a Local Date whose day is found 
		DayOfWeek dayOfWeek1 = DayOfWeek.from(localDate1); 		 	 // Find the day from the Local Date 
		System.out.println(localDate1 + " which is " + dayOfWeek1.name()); //is Wednesday
		Temporal localDate2 = DayOfWeek.MONDAY.adjustInto(localDate1);  // Adjusting the Date to Monday 
		DayOfWeek dayOfWeek2 = DayOfWeek.from(localDate2); 			 // Find the day from the new Local date 
		System.out.println(localDate2 + " which is " + dayOfWeek2.name());  //is Monday
		*/
	}  
	
	//======= Getting date of today =======
	public int getCurrentDate() {
		
		String[] dateList = new String[2];
		
		Date date = Calendar.getInstance().getTime();
		
		DateFormat dayDate = new SimpleDateFormat("dd");
		String dayString = dayDate.format(date);
		today = Integer.parseInt(dayString);
		System.out.println("Day " + dayString);
		
		return today;
	}
	
	//======= Getting month of today =======
	public int getCurrentMonth() {
		
		String[] dateList = new String[2];
		
		Date date = Calendar.getInstance().getTime();
		
		DateFormat monthDate = new SimpleDateFormat("MM");
		String monthString = monthDate.format(date);
		month = Integer.parseInt(monthString);
		System.out.println("Month " + monthString);
		
		return month;
	}
	
	//======= Getting Weekday =======
	//1=sunday, 2=monday, 3=tuesday, 4=wednesday, 5=thursday, 6=friday, 7=saturday 
	public int getWeekdayName() {
		
		Calendar calendar = Calendar.getInstance();  
		dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println("Day of week " + dayOfWeek); 
		
		return dayOfWeek;
	}
	
	public int updateDate(int dayOfWeek2) {
		
		int rightDay;
		
		int day = dayOfWeek - dayOfWeek2;
		rightDay = today - day;
		
		if (dayOfWeek2 == 1) {  //sunday
			rightDay = today - day + 7;	
		}
		else if (day < 0) {
			day = day * -1;
			rightDay = today + day;
		}
		
		return rightDay;
	}
	
	
		//Date date = new Date();
		//System.out.println(dateFormat.format(date));
		
		/*
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
		String strDate = dateFormat.format(date);  
		*/
}
