package MetropoliaAMKgroup02.BujoCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import MetropoliaAMKgroup02.BujoCalendar.model.Dates;

public class DatesTest {

	private Dates dates = new Dates();
	
	@Test
    @DisplayName("Get current date.")
    public void testGetCurrentDate() {
    	
    	String date = dates.getCurrentDateForStartDay();
    	
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");  
    	LocalDateTime now = LocalDateTime.now();  
    	String dateTest = dtf.format(now);  
    	
        assertEquals(date,dateTest, "Dates are not equal.");
    }
	
	@Test
    @DisplayName("Get current weeknumber.")
    public void testGetCurrentWeeknumber() {
    	
    	int week = dates.getWeekNumber();
    	
    	LocalDate date = LocalDate.now();
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int weekTest = date.get(weekFields.weekOfWeekBasedYear());
        
        assertEquals(week,weekTest, "Weeknumbers are not equal.");
    }
	
	@Test
    @DisplayName("Get current month.")
    public void testGetCurrentMonth() {
    	
    	String month = dates.getMonth();
    	
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM");  
    	LocalDateTime now = LocalDateTime.now();  
    	int monthInt = Integer.parseInt(dtf.format(now));  
    	
    	String[] monthName = {"Tammikuu", "Helmikuu",
                "Maaliskuu", "Huhtikuu", "Toukokuu", "Kesäkuu", "Heinäkuu",
                "Elokuu", "Syyskuu", "Lokakuu", "Marraskuu",
                "Joulukuu"};
        String monthTest = monthName[monthInt-1];
        
        assertEquals(month,monthTest, "Months are not equal.");
    }
	
	@Test
    @DisplayName("Get current year.")
    public void testGetCurrentYear() {
    	
    	String year = dates.getYear();
    	
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");  
    	LocalDateTime now = LocalDateTime.now();  
    	String yearTest = dtf.format(now);  
        
        assertEquals(year,yearTest, "Years are not equal.");
    }

}
