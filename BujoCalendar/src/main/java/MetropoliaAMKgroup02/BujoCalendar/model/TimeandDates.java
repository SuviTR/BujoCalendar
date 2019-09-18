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
	
	//======= Get date of today =======
	public int getCurrentDate() {
		
		Date date = Calendar.getInstance().getTime();
		
		DateFormat dayDate = new SimpleDateFormat("dd");
		String dayString = dayDate.format(date);
		today = Integer.parseInt(dayString);
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
	public int updateDate(int dayOfWeek2) {
		
		Calendar cal = Calendar.getInstance();
	    int lastDayOfCurrentMonth = cal.getActualMaximum(Calendar.DATE);
	    
	    cal.add(Calendar.MONTH, -1);
	    cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
	    //System.out.println(cal.get(Calendar.MONTH));
	    int lastDayOfLastMonth = cal.get(Calendar.DAY_OF_MONTH);
		
		int rightDate;
		
		int day = dayOfWeek - dayOfWeek2; //today and days forward
		rightDate = today - day;
		
		if (dayOfWeek2 == 1) {  //sunday
			rightDate = today - day + 7;	
		}
		else if (day < 0) {		//past days
			day = day * -1;
			rightDate = today + day;
			
		}
		
		if (rightDate > lastDayOfCurrentMonth) {
			if (rightDate - lastDayOfCurrentMonth == 1) {
				rightDate = 1;
			}
			else if (rightDate - lastDayOfCurrentMonth == 2) {
				rightDate = 2;
			}
			else if (rightDate - lastDayOfCurrentMonth == 3) {
				rightDate = 3;
			}
			else if (rightDate - lastDayOfCurrentMonth == 4) {
				rightDate = 4;
			}
			else if (rightDate - lastDayOfCurrentMonth == 5) {
				rightDate = 5;
			}
			else if (rightDate - lastDayOfCurrentMonth == 6) {
				rightDate = 6;
			}
		}
		return rightDate;
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
