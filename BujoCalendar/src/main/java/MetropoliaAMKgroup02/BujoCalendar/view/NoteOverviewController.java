package MetropoliaAMKgroup02.BujoCalendar.view;

import org.dom4j.Node;

import MetropoliaAMKgroup02.BujoCalendar.model.AlarmView;
import MetropoliaAMKgroup02.BujoCalendar.model.Dates;
import MetropoliaAMKgroup02.BujoCalendar.model.FontMenu;
import MetropoliaAMKgroup02.BujoCalendar.model.NoteEdit;
import MetropoliaAMKgroup02.BujoCalendar.model.Priority;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NoteOverviewController {
		
		@FXML
		private TextField noteTitle;
		
		@FXML
		private TextArea noteMoreInfo;
		
		@FXML
		private CheckBox allDayEvent;
		
		@FXML
		private Label startDay, endDay, startTime, endTime;
		
		@FXML
		private Label notePriority;
		
		@FXML
		private TextField alarm;
		
		@FXML
		private ChoiceBox priorityChoiceBox;
		
		@FXML 
		private TextArea note;
		
		
		private RootLayoutController rootController;
		private boolean okClicked = false;
		private Stage dialogStage;
		private NoteEdit noteEdit;
		private AlarmOverviewController alarmController;
		private Priority priority;
		private String alarmValue;
		private Dates dates;
		
		@FXML
		private void initialize() {	//Lisää startDay:ksi se päivä, jota on klikattu?
			noteEdit = new NoteEdit();
			noteEdit.setNoteOverviewController(this);
			
			dates = new Dates();
			startDay.setText(dates.getCurrentDate());
			endDay.setText(dates.getCurrentDate());
			
			//startDay = currentDay() tai selectedDay();
			//endDay = currentDay() tai selectedDay();
			//startTime = currentTime();
			//endTime = currentTime() + 1;
			
			priority = new Priority();
			priorityChoiceBox.setValue("Normal");
		    priorityChoiceBox.setItems(priority.getPriorityList());
		    
		    // A listener 
		    priorityChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() { 
	            // If the item of the list is changed 
	            public void changed(ObservableValue ov, Number value, Number new_value) { 
	            	priority.selectedPriority(new_value.intValue());
	            } 
	        }); 
		   
		    noteTitle.setFocusTraversable(false);
	        noteMoreInfo.setFocusTraversable(false);
		}
		
		public void setDialogStage(Stage dialogStage) {
			this.dialogStage = dialogStage;
		}

		public boolean isOkClicked() {
			return okClicked;
		}

		@FXML
		private void handleOk() {
			okClicked = true;
			handleNoteTitle();
			handleNoteMoreInfo();
			if (allDayEvent.isSelected()) {
				noteEdit.noteStartDay(startDay);
			}
			else {
				noteEdit.noteDayandTime(startDay, endDay, startTime, endTime);
			}
			dialogStage.close();
		}

		public void setAlarmTimeandvalue(String text) {
			alarm.setText(text);
		}
		
		private void handleNoteTitle() {
			noteEdit.newNoteTitle(noteTitle);
		}
		
		private void handleNoteMoreInfo() {
			noteEdit.newNoteMoreInfo(noteMoreInfo);
		}
		
		@FXML
		private void handleAllDayEventCheckBox() {
			if (allDayEvent.isSelected()) {
				endDay.setVisible(false);
				startTime.setVisible(false);
				endTime.setVisible(false);
			}					
			else {
				endDay.setVisible(true);
				startTime.setVisible(true);
				endTime.setVisible(true);
			}
		}
		
		@FXML
		private void handleOpenAlarmView() {
			rootController.showAlarmOverview();
		}

		public void setRootLayoutController(RootLayoutController controller) {
			this.rootController = controller;
		}

}
