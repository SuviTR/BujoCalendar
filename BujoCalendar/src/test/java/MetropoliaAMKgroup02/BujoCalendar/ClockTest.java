package MetropoliaAMKgroup02.BujoCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.GraphicsEnvironment;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import MetropoliaAMKgroup02.BujoCalendar.model.Clock;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuItem;

public class ClockTest {

	private Clock clock = new Clock();

    @Test
    @DisplayName("Get current hour.")
    public void testGetCurrentTimeHour() {
    	
    	String hr = clock.currentTimeHour();
    	
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH");  
    	LocalDateTime now = LocalDateTime.now();  
    	String hrTest = dtf.format(now);
    	
        assertEquals(hr,hrTest, "Hours are not equal.");
    }
    
    @Test
    @DisplayName("Current hour + 1.")
    public void testCurrentTimeHourplus1() {
    	
    	clock.currentTimeHour();
    	String hr = clock.currentTimeHourplus1();
    	
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH");  
    	LocalDateTime now = LocalDateTime.now();  
    	int hrIntTest = Integer.parseInt(dtf.format(now))+1;
    	String hrTest = Integer.toString(hrIntTest);
    	
        assertEquals(hr,hrTest, "Hours after adding 1 hour are not equal.");
    }
    
    @Test
    @DisplayName("Get current minutes.")
    public void testGetCurrentMinutes() {
    	
    	String min = clock.currentTimeMinutes();
    	
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("mm");  
    	LocalDateTime now = LocalDateTime.now();  
    	String minTest = dtf.format(now);
    	
        assertEquals(min,minTest, "Minutes are not equal.");
    }
}
