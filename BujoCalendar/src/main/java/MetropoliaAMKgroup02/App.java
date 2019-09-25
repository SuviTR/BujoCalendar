package MetropoliaAMKgroup02;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.DateFormat;
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
    	s.show();*/
    	
    	
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
} 


/*

public class App extends JPanel{
	public static void main( String[] args ) {
		
		
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
		}
		
		
	}
}
*/
