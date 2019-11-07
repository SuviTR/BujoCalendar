package MetropoliaAMKgroup02.BujoCalendar.view;

import MetropoliaAMKgroup02.BujoCalendar.controller.AppController;
import MetropoliaAMKgroup02.BujoCalendar.model.Clock;
import MetropoliaAMKgroup02.BujoCalendar.model.Dates;
import MetropoliaAMKgroup02.BujoCalendar.model.MonthView;
import MetropoliaAMKgroup02.BujoCalendar.model.NoteEdit;
import MetropoliaAMKgroup02.BujoCalendar.model.Priority;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NoteOverviewController {
		
		@FXML
		private TextField noteTitle;
		
		@FXML
		private TextArea noteMoreInfo;
		
		@FXML
		private CheckBox allDayEvent;
		
		@FXML
		private Label startDay, endDay;
		
		
		@FXML
		private Label notePriority;
		
		@FXML
		private TextField alarm, startTime, endTime;
		
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
		private MonthView picker;
		private int whichDayValue = 0;
		private Clock clock;
		private String valid = "";
		
		@FXML
		private void initialize() {	//Lisää startDay:ksi se päivä, jota on klikattu?
			noteEdit = new NoteEdit();
			noteEdit.setNoteOverviewController(this);
			
			dates = AppController.getInstance().getDates();
			clock = new Clock();
			startDay.setText(dates.getCurrentDate().toString()); //tai day clicked
			endDay.setText(dates.getCurrentDate().toString());		//---/---
			startTime.setText(clock.currentTime());
			endTime.setText(clock.currentTimeplus1());
			
			picker = new MonthView();
			picker.setNoteOverviewController(this);
			
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
			handleStartandEndTime();
			dialogStage.close();
		
		}
		
		@FXML
		private void handleOpenDatePicker1() {
			picker.whoValue(2);
			whichDayValue = 1;
			openDatePicker();
		}
		
		@FXML
		private void handleOpenDatePicker2() {
			picker.whoValue(2);
			whichDayValue = 2;
			openDatePicker();
		}
		
		private void openDatePicker() {
			Stage s = new Stage();
			picker.start(s);
		}
		
		private void handleStartandEndTime() {
			clock.handleStartTime(startTime);
			clock.handleEndTime(endTime);
		}
		
		public void setAlarmDay(String day) {
			if (whichDayValue == 1) {
				startDay.setText(day);
			}
			else if (whichDayValue == 2) {
				endDay.setText(day);
			}
		}
		
		public void setAlarmTimeandValue(String text) {	
			String texts = alarm.getText() + " " + text;
			alarm.setText(texts);
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
