package MetropoliaAMKgroup02.BujoCalendar;

import MetropoliaAMKgroup02.BujoCalendar.model.TimeandDates;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;

public class TimeandDatesTest {
	
	private TimeandDates timeDates = new TimeandDates();
	
	@BeforeEach
    public void currentDate() {
        timeDates.getCurrentDate();
    }

    @Test
    public void testGetCurrentDate() {
    	String dateTest = timeDates.getCurrentDate();
    	String date = "2019-10-02";
        assertEquals(date,dateTest, "Dates are not equal.");
    }

    @Test
    @DisplayName("Test if a week number is equal to the current week number")
    public void testGetWeekNumber() {
        int weekTest = timeDates.getWeekNumber("2019-10-02");
        int week = 40;
        assertEquals(week, weekTest, "Week numbers are not equal.");
    }

    @Test
    @DisplayName("Test if week number is right based on a date of monday.")
    public void testGetWeekNumber2() {
    	int weekTest = timeDates.getWeekNumber("2019-10-07");
        int week = 41;
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
    	timeDates.getWeekDates(40);
    	String monthTest = timeDates.getMonth();
        String month = "Syyskuu/Lokakuu";
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
    	timeDates.getWeekDates(40);
    	String yearTest = timeDates.getYear();
        String year = "2019";
        assertEquals(year, yearTest, "Years are not equal.");
    }
}
