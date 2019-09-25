package MetropoliaAMKgroup02.BujoCalendar.model;

import java.time.LocalDate;

import MetropoliaAMKgroup02.BujoCalendar.controller.MainApp;
import MetropoliaAMKgroup02.BujoCalendar.view.RootLayoutController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class MonthView extends Application { 
	
	private RootLayoutController rootController;
	  
    public void start(Stage s) { 
    	
        s.setTitle("Valitse päivä"); 
        TilePane r = new TilePane(); 

        DatePicker d = new DatePicker(); 
        
        // Action
        d.setOnAction(event -> {
            LocalDate date = d.getValue();
            System.out.println("Valitty päivä: " + date);
        });
  
        // add button and label 
        r.getChildren().add(d); 
  
        Scene sc = new Scene(r, 235, 200); 
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
} 