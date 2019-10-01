package MetropoliaAMKgroup02;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
/*
public class App extends Application { 
	  
    // launch the application 
    public void start(Stage s) 
    { 
    	/*
    	//Create the DatePicker.
    	DatePicker datePicker = new DatePicker();

    	//Add some action (in Java 8 lambda syntax style).
    	datePicker.setOnAction(event -> {
    	 LocalDate date = datePicker.getValue();
    	 System.out.println("Selected date: " + date);
    	});

    	//Add the DatePicker to the Stage.
    	StackPane root = new StackPane();
    	root.getChildren().add(datePicker);
    	s.setScene(new Scene(root, 500, 650));
    	s.show();
    	
    	
        // set title for the stage 
        s.setTitle("creating date picker"); 
  
        // create a tile pane 
        TilePane r = new TilePane(); 
  
        // create a date picker 
        DatePicker d = new DatePicker(); 
  
        // add button and label 
        r.getChildren().add(d); 
  
        // create a scene 
        Scene sc = new Scene(r, 200, 200); 
  
        // set the scene 
        s.setScene(sc); 
  
        s.show(); 
    } 
  
    public static void main(String args[]) 
    { 
        // launch the application 
        launch(args); 
    } 
} */




public class App extends JPanel{
	public static void main( String[] args ) {

		String[] dayList = new String[7];
		
		
		Date date = Calendar.getInstance().getTime();
		DateFormat dayDate = new SimpleDateFormat("yyyy-MM-dd");
		String dayString = dayDate.format(date);
		
		String format = "yyyy-MM-dd";

		SimpleDateFormat df = new SimpleDateFormat(format);
		Date dateParse = new Date();
		try {
			dateParse = df.parse(dayString);
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
		
		/*
		
		// get a calendar instance, which defaults to "now"
	    Calendar calendar = Calendar.getInstance();
	    
	    // get a date to represent "today"
	    Date today = calendar.getTime();
	    System.out.println("today:    " + today);
	 
	    int ikh = 1;
	    // add one day to the date/calendar
	    calendar.add(Calendar.DAY_OF_YEAR, -ikh);
	    
	    // now get "tomorrow"
	    Date tomorrow = calendar.getTime();

	    // print out tomorrow's date
	    System.out.println("tomorrow: " + tomorrow);
	  
	
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43

		//----------Dates-----------------
		// Set a Local Date whose day is found 
		LocalDate localDate1 = LocalDate.of(2019, Month.OCTOBER, 2); 

		// Find the day from the Local Date 
		DayOfWeek dayOfWeek1 = DayOfWeek.from(localDate1); 

		// Printing the Local Date 
		System.out.println(localDate1 + " which is " + dayOfWeek1.name()); 

		Temporal localDate2 = DayOfWeek.MONDAY.adjustInto(localDate1); 

		// Find the day from the new Local date 
		DayOfWeek dayOfWeek2 = DayOfWeek.from(localDate2); 

		// Printing the new Local Date 
		System.out.println(localDate2 + " which is " + dayOfWeek2.name()); 

		//----------Fonts-----------------
		String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		

		ArrayList<MenuItem> items1 = new ArrayList<MenuItem>();
		
		for (int i = 0; i < fonts.length; i++) {
			System.out.println(fonts[i]);
		}*/
		
		
	}
}

