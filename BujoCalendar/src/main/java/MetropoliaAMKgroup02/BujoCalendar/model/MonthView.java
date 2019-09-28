package MetropoliaAMKgroup02.BujoCalendar.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import MetropoliaAMKgroup02.BujoCalendar.controller.MainApp;
import MetropoliaAMKgroup02.BujoCalendar.view.RootLayoutController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class MonthView extends Application { 
	
	private RootLayoutController rootController;
	private TimeandDates dates;
	private String selectedDate;
	  
    public void start(Stage s) { 
    	
        s.setTitle("Valitse päivä"); 
        Button ok = new Button("Ok");
        Button cancel = new Button("Cancel");
        
        ok.setOnAction(event -> {
        	System.out.println("Ok");
        	rootController.getSelectedDateView(selectedDate);
        	
        });
        
        GridPane g = new GridPane(); 

        DatePicker d = new DatePicker(); 
        
        // Action
        d.setOnAction(event -> {
        	selectedDate = d.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            System.out.println("Valitty päivä: " + selectedDate);
        });
  
        // add button and label 
        g.getChildren().add(d); 
        
        g.setHgap(10);
        g.setVgap(20);
        g.add(ok, 1, 1);
        g.add(cancel, 1, 0);
  
        Scene sc = new Scene(g, 235, 200); 
        s.setScene(sc); 
  
        s.show(); 
    } 
  
    public static void main(String args[]) { 
        launch(args); 
    } 
    
    public void launchDatePicker() {
    	Application.launch(MonthView.class);
    }
    
    public void setRootLayoutController(RootLayoutController rootController) {
		this.rootController = rootController;
	}
    public void setTimeandDates(TimeandDates dates) {
    	this.dates = dates;
    }
} 