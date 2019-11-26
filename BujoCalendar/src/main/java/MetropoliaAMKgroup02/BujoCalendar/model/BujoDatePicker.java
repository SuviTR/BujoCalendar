package MetropoliaAMKgroup02.BujoCalendar.model;

import MetropoliaAMKgroup02.BujoCalendar.controller.AppController;
import MetropoliaAMKgroup02.BujoCalendar.view.NoteOverviewController;
import MetropoliaAMKgroup02.BujoCalendar.view.RootLayoutController;
import javafx.application.Application;
import javafx.event.ActionEvent;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BujoDatePicker extends Application { 
	
	private RootLayoutController rootController;
	private NoteOverviewController noteController;
	private String selectedDate;
    private Calendar selectedDateForRealz;
	private int whoValue = 0;
	private int whichDayValue = 0;
	  
    public void start(Stage s) { 
    	
        s.setTitle("Valitse päivä"); 
        Button ok = new Button("Ok");
        Button cancel = new Button("Cancel");
        
        ok.setOnAction(event -> {
                AppController.getInstance().getDates().setCurrentDate(selectedDateForRealz);
        	if (whoValue == 1) {
                    AppController.getInstance().getCalendarOverviewController().updateView();
        	}
        	else if (whoValue == 2) {
        		noteController.setAlarmDay(selectedDate);
        	}
        	s.close();       	
        });
        
        GridPane g = new GridPane(); 

        DatePicker d = new DatePicker(); 
   
        d.setOnAction(event -> {
                LocalDate pickerValue = d.getValue();
            selectedDateForRealz = Calendar.getInstance();
selectedDateForRealz.set(pickerValue.getYear(), pickerValue.getMonthValue()-1, pickerValue.getDayOfMonth());
            System.out.println("Valittu päivä: " + selectedDate);
        });
  
        //g.getChildren().add(d); 
        
        g.setHgap(10);
        g.setVgap(8);
        g.add(d, 0, 1);
        g.add(ok, 1, 2);
        g.add(cancel, 1, 1);
        
        //Closes the BujoDatePicker window
        s.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (! isNowFocused) {
                s.hide();
            }
        });
  
        Scene sc = new Scene(g, 235, 247); 
        sc.getStylesheets().add("datePickerStyle.css");
        
        s.setScene(sc); 
  
        s.show(); 
    } 
  
    public static void main(String args[]) { 
        launch(args); 
    } 
    /*
    public void launchDatePicker() {
    	Application.launch(BujoDatePicker.class);
    }*/
    
    public void whoValue(int value) {
    	whoValue = value;
    }
    public void setRootLayoutController(RootLayoutController rootController) {
		this.rootController = rootController;
	}
    public void setNoteOverviewController(NoteOverviewController noteController) {
		this.noteController = noteController;
	}
} 