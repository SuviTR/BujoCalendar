package MetropoliaAMKgroup02.BujoCalendar;

import MetropoliaAMKgroup02.BujoCalendar.model.TimeandDates;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Arrays;
import java.util.Locale;

public class TimeandDatesTest {
	
	private TimeandDates timeDates = new TimeandDates();
	
	@BeforeEach
    public void currentDate() {
        timeDates.getCurrentDate();
    }

    @Test
    public void testGetCurrentDate() {
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
    	LocalDateTime now = LocalDateTime.now();  
    	String date = dtf.format(now);  
    	
    	String dateTest = timeDates.getCurrentDate();
    	
        assertEquals(date,dateTest, "Dates are not equal.");
    }

    @Test
    @DisplayName("Test if a week number is equal to the current week number")
    public void testGetWeekNumber() {
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
    	LocalDateTime now = LocalDateTime.now();  
    	String date = dtf.format(now); 
    	
        int weekTest = timeDates.getWeekNumber(date);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
        LocalDate lDate = LocalDate.parse(date, formatter);

        WeekFields wf = WeekFields.of(Locale.getDefault());
        TemporalField weekNum = wf.weekOfWeekBasedYear(); 
        int week = Integer.parseInt(String.format("%02d",lDate.get(weekNum)));
        
        assertEquals(week, weekTest, "Week numbers are not equal.");
    }

    @Test
    @DisplayName("Test if a week number is right based on a date of thursday")
    public void testGetWeekNumber2() {
    	String date = "2019-10-10";
    	int weekTest = timeDates.getWeekNumber(date);
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
        LocalDate lDate = LocalDate.parse(date, formatter);

        WeekFields wf = WeekFields.of(Locale.getDefault());
        TemporalField weekNum = wf.weekOfWeekBasedYear(); 
        int week = Integer.parseInt(String.format("%02d",lDate.get(weekNum)));
        
        assertEquals(week, weekTest, "Week numbers are not equal.");
    }
    
    @Test
    @DisplayName("Test if dates are equal to current dates")
    public void testDates() {
        String[] datesTest = timeDates.getWeekDates(40);
        String[] dates = new String[] {"30","01","02","03","04","05","06"};
        boolean boolTest = Arrays.equals(dates, datesTest);
        boolean bool = true;
        assertEquals(bool,boolTest, "Dates are not equal.");
    }
 
    @Test
    @DisplayName("Test if week number is right when moving a week back of forward")
    public void testGetNewWeekNumber() {
    	timeDates.getWeekDates(43);
    	String newWeekTest = timeDates.getNewWeekNumber();
        String newWeek = "43";
        assertEquals(newWeek, newWeekTest, "Week numbers are not equal.");
    }
    
    @Test
    @DisplayName("Test if a week number is right based on a date of monday")
    public void testGetNewWeekNumber2() {
    	String date = "2019-10-07";
    	timeDates.selectedDate(date);
    	String weekStringTest = timeDates.getNewWeekNumber();
    	int weekTest = Integer.parseInt(weekStringTest);
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
        LocalDate lDate = LocalDate.parse(date, formatter);

        WeekFields wf = WeekFields.of(Locale.getDefault());
        TemporalField weekNum = wf.weekOfWeekBasedYear(); 
        int week = Integer.parseInt(String.format("%02d",lDate.get(weekNum)));
        
        assertEquals(week, weekTest, "Week numbers are not equal.");
    }
    
    @Test
    @DisplayName("Test if dates are equal to a chosen week")
    public void testSelectedDate() {
    	String[] datesTest = timeDates.selectedDate("2019-10-24");
        String[] dates = new String[] {"21","22","23","24","25","26","27"};
        boolean boolTest = Arrays.equals(dates, datesTest);
        boolean bool = true;
        assertEquals(bool, boolTest, "Dates are not equal.");
    }
   
    @Test
    @DisplayName("Test if a month is right based on a current week")
    public void testGetMonth() {
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
    	LocalDateTime now = LocalDateTime.now();  
    	String date = dtf.format(now); 
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
        LocalDate lDate = LocalDate.parse(date, formatter);

        WeekFields wf = WeekFields.of(Locale.getDefault());
        TemporalField weekNum = wf.weekOfWeekBasedYear(); 
        int week = Integer.parseInt(String.format("%02d",lDate.get(weekNum)));
    	
    	timeDates.getWeekDates(week);
    	
    	String monthTest = timeDates.getMonth();
    	
        String month = "Lokakuu";	//KOVAKOODATTU!!
        
        assertEquals(month, monthTest, "Months are not equal.");
    }
    
    @Test
    @DisplayName("Test if a month is right based on a randomly selected week")
    public void testGetMonth2() {
    	timeDates.getWeekDates(50);
    	String monthTest = timeDates.getMonth();
        String month = "Joulukuu";
        assertEquals(month, monthTest, "Months are not equal.");
    }
    
    @Test
    @DisplayName("Test if a year is equal to a current year")
    public void testGetYear() {
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
    	LocalDateTime now = LocalDateTime.now();  
    	String date = dtf.format(now); 
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
        LocalDate lDate = LocalDate.parse(date, formatter);

        WeekFields wf = WeekFields.of(Locale.getDefault());
        TemporalField weekNum = wf.weekOfWeekBasedYear(); 
        int week = Integer.parseInt(String.format("%02d",lDate.get(weekNum)));
        
    	timeDates.getWeekDates(week);
    	String yearTest = timeDates.getYear();
        String year = "2019";					//KOVAKOODATTU!!
        assertEquals(year, yearTest, "Years are not equal.");
    }
}
