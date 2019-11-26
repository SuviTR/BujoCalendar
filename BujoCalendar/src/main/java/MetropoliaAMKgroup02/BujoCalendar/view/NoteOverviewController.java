package MetropoliaAMKgroup02.BujoCalendar.view;

import MetropoliaAMKgroup02.BujoCalendar.controller.AppController;
import MetropoliaAMKgroup02.BujoCalendar.fetchers.CalendarFetcher;
import MetropoliaAMKgroup02.BujoCalendar.model.Clock;
import MetropoliaAMKgroup02.BujoCalendar.model.Dates;
import MetropoliaAMKgroup02.BujoCalendar.model.BujoDatePicker;
import MetropoliaAMKgroup02.BujoCalendar.model.NoteEdit;
import MetropoliaAMKgroup02.BujoCalendar.model.Priority;
import MetropoliaAMKgroup02.BujoCalendar.utils.DateAndCalendarConverter;
import MetropoliaAMKgroup02.BujoCalendar.utils.StringToCalConverter;
import MetropoliaAMKgroup02.Common.model.Merkinta;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
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
		
		@FXML
		private Label notePriority;
		
		@FXML
		private TextField alarm; 
		
		@FXML
		private ChoiceBox priorityChoiceBox;
		
		@FXML 
		private TextArea note;
        
        @FXML
        private TextField startHr, startMin, endHr, endMin;

        @FXML
        private DatePicker startDatePicker, endDatePicker;

        private RootLayoutController rootController;
		private NoteEdit noteEdit;
		private Priority priority;
		private Dates dates;
		private BujoDatePicker picker;
		private int whichDayValue = 0;
		private Clock clock;
		private String valid = "";
        private CalendarFetcher calendarFetcher;
        private Stage dialogStage;

        private Merkinta merkinta;

		@FXML
		private void initialize() {	//Lisää startDay:ksi se päivä, jota on klikattu?
			noteEdit = new NoteEdit();
			noteEdit.setNoteOverviewController(this);

            merkinta = new Merkinta();
			
			dates = AppController.getInstance().getDates();
			clock = new Clock();
            /*
			startDay.setText(dates.getCurrentDate().toString()); //tai day clicked
			endDay.setText(dates.getCurrentDate().toString());		//---/---
			startTime.setText(clock.currentTime());
			endTime.setText(clock.currentTimeplus1());
            */
			
			picker = new BujoDatePicker();
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

        @FXML 
        private void startDate() {
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

        }

        @FXML
        private void endDate() {
                
        }

		@FXML
		private void saveAppointment() {
			if (allDayEvent.isSelected()) {
				noteEdit.allDayEvent();
			}
             
            updateMerkinta();

            // If Id=0, this is a new appointment
            if(this.merkinta.getId() == 0) {
                    calendarFetcher.createAppointment(this.merkinta);
            } else {
                    calendarFetcher.editAppointment(this.merkinta);
            }
		
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

		@FXML
		private void deleteAppointment(){
			calendarFetcher.delete(this.merkinta);
			dialogStage.close();
		}
		
        //DEPRECATED 
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
			noteEdit.newNoteTitle(noteTitle.getText());
		}
		
		private void handleNoteMoreInfo() {
			noteEdit.newNoteMoreInfo(noteMoreInfo.getText());
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

        private void handleEndDay() {
                DateConverter conv = new DateConverter();
                conv.setDate(startDay.getText());
                conv.setTime(startTime.getText());
                noteEdit.noteStartDay(conv.getCalendar());
        }

        private void handleStartDay() {
                DateConverter conv = new DateConverter();
                conv.setDate(endDay.getText());
                conv.setTime(endTime.getText());
                noteEdit.setNoteEnd(conv.getCalendar());
        }

        public void setCalendarController(CalendarController calendarController) {
                this.calendarController = calendarController;
        }

}
