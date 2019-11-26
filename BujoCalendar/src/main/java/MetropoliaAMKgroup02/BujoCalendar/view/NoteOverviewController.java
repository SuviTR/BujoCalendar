package MetropoliaAMKgroup02.BujoCalendar.view;

import MetropoliaAMKgroup02.BujoCalendar.controller.AppController;
import MetropoliaAMKgroup02.BujoCalendar.controller.CalendarController;
import MetropoliaAMKgroup02.BujoCalendar.model.Clock;
import MetropoliaAMKgroup02.BujoCalendar.model.Dates;
import MetropoliaAMKgroup02.BujoCalendar.model.MonthView;
import MetropoliaAMKgroup02.BujoCalendar.model.NoteEdit;
import MetropoliaAMKgroup02.BujoCalendar.model.Priority;
import MetropoliaAMKgroup02.BujoCalendar.utils.DateConverter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NoteOverviewController {
	
	@FXML
	private CheckBox allDayEvent;
	@FXML
	private Label startDay, endDay, notePriority;
	@FXML
	private DatePicker startDayPicker, endDayPicker;
	@FXML
	private TextField noteTitle, alarm, startTime, endTime;
	@FXML
	private ChoiceBox priorityChoiceBox;
	@FXML 
	private TextArea note, noteMoreInfo;
	@FXML
	private Button saveNote, deleteNote;
		
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
    private CalendarController calendarController;
	
    /**
     * Initializes the note editing window.
     * Initializes the startDay and endDay with the current day or the day that a user has clicked.
     * Initializes the startTime with the current time and endTime with the current time + 1 hour.
     * Initializes the priority choicebox with the priority values.
     */
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
	
	/**
	 * Sets the Note editing window.
	 * @param dialogStage is the new stage.
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	 * Keeps tracking if the ok button is clicked.
	 * @return okClicked includes the value if the button is clicked or not.
	 */
	public boolean isOkClicked() {
		return okClicked;
	}
	
	/**
	 * When the ok button is clicked all the information of the note editing window 
	 * is sent to different model class' to saving the information to database.
	 */
	@FXML
	private void handleOk() {
		okClicked = true;
		handleNoteTitle();
		handleNoteMoreInfo();
		if (allDayEvent.isSelected()) {
			noteEdit.allDayEvent();
		}
        handleStartDay();
        handleEndDay();
         
		handleStartandEndTime();

        calendarController.createAppointment(noteEdit.createMerkinta());
		dialogStage.close();
	}
	
	/**
	 * Method sends the information of the note that a user wanted to delete to backend.
	 */
	@FXML
	private void handleRemoveNote() {
		//CalendarController calCtrl = new CalendarController();
		noteEdit.removeNoteWarning();
	}
	
	/**
	 *
	 */
	@FXML
	private void handleStartDayPicker() {
		String selectedDate = startDayPicker.getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		startDay.setText(selectedDate);
	}
	
	/**
	 *
	 */
	@FXML
	private void handleEndDayPicker() {
		String selectedDate = endDayPicker.getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		endDay.setText(selectedDate);
	}
	
	/**
	 * Opens the datepicker.
	 */
	private void openDatePicker() {
		Stage s = new Stage();
		picker.start(s);
	}
	
	@FXML
	private void handleDatePicker() {
		
	}
	
	/**
	 * Get the values of the labels.
	 * Is called when ok button is clicked.
	 */
	private void handleStartandEndTime() {
		clock.handleStartTime(startTime);
		clock.handleEndTime(endTime);
	}
	
	/**
	 * Calls the clock class to check if the input is correct.
	 */
	@FXML
	public void handleStartTime() {
		startTime.setText(clock.checkStartandEndTime(startTime));
	}
	
	/**
	 * Calls the clock class to check if the input is correct.
	 */
	@FXML
	public void handleEndTime() {
		endTime.setText(clock.checkStartandEndTime(endTime));
	}
	
	/**
	 * Sets the start and end day of the alarm.
	 */
	public void setAlarmDay(String day) {
		/*
		if (whichDayValue == 1) {
			startDay.setText(day);
		}
		else if (whichDayValue == 2) {
			endDay.setText(day);
		}*/
	}
	
	/**
	 * Calls the clock class to check if the input is correct.
	 */
	public void setAlarmTimeandValue(String text) {	
		String texts = alarm.getText() + " " + text;
		alarm.setText(texts);
	}
	
	/**
	 * Sends the note title text to noteEdit class.
	 */
	private void handleNoteTitle() {
		noteEdit.newNoteTitle(noteTitle.getText());
	}
	
	/**
	 * Sends the note info text to noteEdit class.
	 */
	private void handleNoteMoreInfo() {
		noteEdit.newNoteMoreInfo(noteMoreInfo.getText());
	}
	
	/**
	 * Sets endDay, start and end time invisible if the allDayEvent checkbox is clicked 
	 * and the other way round.
	 */
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
	
	/**
	 * Opens the alarm editing window.
	 */
	@FXML
	private void handleOpenAlarmView() {
		rootController.showAlarmOverview();
	}
	
	/**
	 * Handles the end day of the note.
	 */
    private void handleEndDay() {
            DateConverter conv = new DateConverter();
            conv.setDate(startDay.getText());
            conv.setTime(startTime.getText());
            noteEdit.noteStartDay(conv.getCalendar());
    }

    /**
	 * Handles the start day of the note.
	 */
    private void handleStartDay() {
            DateConverter conv = new DateConverter();
            conv.setDate(endDay.getText());
            conv.setTime(endTime.getText());
            noteEdit.noteEndDay(conv.getCalendar());
    }
    
    /**
	 * Sets the RootLayoutController.
	 * @param controller is the RootLayoutController.
	 */
	public void setRootLayoutController(RootLayoutController controller) {
		this.rootController = controller;
	}

	/**
	 * Sets the CalendarController.
	 * @param controller is the CalendarController.
	 */
    public void setCalendarController(CalendarController calendarController) {
            this.calendarController = calendarController;
    }

}
