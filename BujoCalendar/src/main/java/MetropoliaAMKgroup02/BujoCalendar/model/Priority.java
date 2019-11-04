package MetropoliaAMKgroup02.BujoCalendar.model;

import java.time.format.DateTimeFormatter;

import MetropoliaAMKgroup02.BujoCalendar.view.NoteOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Priority  { 
	
	private ObservableList<String> priorities;
	
	public ObservableList<String> getPriorityList() {
		
		priorities = FXCollections.observableArrayList();
	    priorities.addAll("Low","Normal","High");   
	    return priorities; 
	}
	
	public String selectedPriority(int value) {
		
		String selectedPriority = "";
		
		switch (value) {
		case 0:
			selectedPriority = priorities.get(0);
			break;
		case 1:
			selectedPriority = priorities.get(1);
			break;
		case 2:
			selectedPriority = priorities.get(2);
			break;			
		}
		return selectedPriority;
	}

}
