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
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class NoteOverviewController {
	
	@FXML
	private TextField noteTitle, alarm, startHr, startMin, endHr, endMin;
	
	@FXML
	private TextArea noteMoreInfo;
	
	@FXML
	private CheckBox allDayEvent;
	
	@FXML
	private Label notePriority, startDay, endDay;
	
	@FXML
	private ChoiceBox priorityChoiceBox;
	
    @FXML
    private DatePicker startDatePicker, endDatePicker;

    private boolean okClicked = false;
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
	
	public boolean isOkClicked() {
		return okClicked;
	}

    @FXML 
    private void startDate() {

    }

    @FXML
    private void endDate() {
            
    }

	@FXML
	private void handleSave() {
		okClicked = true;
		
		if (allDayEvent.isSelected()) {
			noteEdit.allDayEvent();
		}          
        updateMerkinta();

        // If Id=0, this is a new appointment
        if(this.merkinta.getId() == 0) {
            calendarFetcher.createAppointment(this.merkinta);
        } 
        
        else {
            calendarFetcher.editAppointment(this.merkinta);
        }
        dialogStage.close();
	}

	@FXML
	private void handleDelete(){
		/*
		boolean b = noteEdit.removeNoteWarning();
		if (b) {
			deleteNote(b);
			okClicked = true;
			dialogStage.close();
		}*/
		okClicked = true;
		calendarFetcher.delete(this.merkinta);	
		dialogStage.close();
	}
	
	public void deleteNote(boolean b) {
		
		if (b == true) {
			calendarFetcher.delete(this.merkinta);			
		}
		
	}
	
	@FXML
	private void handleStartDayPicker() {
		String selectedDate = startDatePicker.getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		startDay.setText(selectedDate);
	}
	
	@FXML
	private void handleEndDayPicker() {
		String selectedDate = endDatePicker.getValue().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		endDay.setText(selectedDate);
	}
	
    // DePERECATED
	private void openDatePicker() {
		Stage s = new Stage();
		picker.start(s);
	}
	


	public void setAlarmDay(String day) {
		/*if (whichDayValue == 1) {
			startDay.setText(day);
		}
		else if (whichDayValue == 2) {
			endDay.setText(day);
		}*/
	}

	
	public void setAlarmTimeandValue(String text) {	
		String texts = alarm.getText() + " " + text;
		alarm.setText(texts);
	}
	
	private void handleNoteTitle() {
        this.merkinta.setNimi(noteTitle.getText());
	}
	
	private void handleNoteMoreInfo() {
        this.merkinta.setSisalto(noteMoreInfo.getText());
	}
	
	@FXML
	private void handleAllDayEventCheckBox() {
		if (allDayEvent.isSelected()) {
			startHr.setVisible(false);
			startMin.setVisible(false);
			endHr.setVisible(false);
			endMin.setVisible(false);
		}					
		else {
			startHr.setVisible(true);
			startMin.setVisible(true);
			endHr.setVisible(true);
			endMin.setVisible(true);
		}
	}
	
	@FXML
	private void handleOpenAlarmView() {
		rootController.showAlarmOverview();
	}

	@FXML
	private void handleHour() {
		startHr.setText(clock.checkHour(startHr));
		endHr.setText(clock.checkHour(endHr));
	}
	
	@FXML
	private void handleMin() {
		startMin.setText(clock.checkMin(startMin));
		endMin.setText(clock.checkMin(endMin));
	}
	
    private void updateStartDay() {
        merkinta.setStartDate(handleDay(startDatePicker, startHr, startMin));
    }

    private void updateEndDay() {
        merkinta.setEndDate(handleDay(endDatePicker, endHr, endMin));
    }

    private Calendar handleDay(DatePicker datePicker, TextField hr, TextField min) {
        DateAndCalendarConverter conv = new DateAndCalendarConverter();
        LocalTime time = conv.createLocalTime(hr.getText(), min.getText());
        return conv.LocalsToCal(datePicker.getValue(), time);
    }

    public void setMerkinta(Merkinta merkinta) {
        this.merkinta = merkinta;
        this.updateView();
    }

    private void updateView() {
        this.noteTitle.setText(merkinta.getNimi());
        DateAndCalendarConverter conv = new DateAndCalendarConverter();
        this.startDatePicker.setValue(conv.CalToLocalDate(merkinta.getStart()));
        this.endDatePicker.setValue(conv.CalToLocalDate(merkinta.getEndDate()));
        this.startHr.setText(conv.hourRepresentation(merkinta.getStart()));
        this.startMin.setText(conv.minuteRepresentation(merkinta.getStart()));
        this.endHr.setText(conv.hourRepresentation(merkinta.getEndDate()));
        this.endMin.setText(conv.minuteRepresentation(merkinta.getEndDate()));

        noteEdit.setId(merkinta.getId());
    }

    private void updateMerkinta() {

        this.merkinta.setNimi(this.noteTitle.getText());
        this.merkinta.setAllDay(this.allDayEvent.isSelected());
        this.merkinta.setSisalto(this.noteMoreInfo.getText());

        this.updateStartDay();
        this.updateEndDay();
    }

    public void setRootLayoutController(RootLayoutController controller) {
		this.rootController = controller;
	}
    
    public void setCalendarFetcher(CalendarFetcher calendarFetcher) {
        this.calendarFetcher = calendarFetcher;
    }
}