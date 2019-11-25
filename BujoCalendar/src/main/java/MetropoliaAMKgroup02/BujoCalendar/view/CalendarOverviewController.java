package MetropoliaAMKgroup02.BujoCalendar.view;

import MetropoliaAMKgroup02.BujoCalendar.controller.AppController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.*; 
import java.time.DayOfWeek; 
import java.time.temporal.Temporal; 

import MetropoliaAMKgroup02.BujoCalendar.controller.MainApp;
import MetropoliaAMKgroup02.BujoCalendar.model.FontMenu;
import MetropoliaAMKgroup02.BujoCalendar.model.NoteEdit;
import MetropoliaAMKgroup02.BujoCalendar.model.Dates;
import java.util.ArrayList;
import java.util.Calendar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
* @author suvi
*/

public class CalendarOverviewController {

	@FXML
	private ImageView calendar, leftHeader, rightHeader;
	@FXML
	private Label month, week;
	@FXML
	private Label monday, tuesday, wednesday, thursday, friday, saturday, sunday;
	@FXML
	private Label mondayDate, tuesdayDate, wednesdayDate, thursdayDate,  fridayDate, 
				  saturdayDate, sundayDate;
	
	@FXML
	private MenuButton fonts;

	@FXML
	private GridPane calendarContainer;

	@FXML
	private GridPane weekendContainer;
	
	private MainApp mainApp;
	private Dates dates;
	private NoteEdit notes;
	private CalendarContainerViewController calendarView;

	private int fontValue;
	private int nextWeek = 0;
	private int prevWeek = 0;
	private int weekCounter = 0;
	private boolean boolCurrentOrSelected = true;
	private String selectedDate = "";
    private final ArrayList<Label> dayLabels;

    public CalendarOverviewController() {
            this.dates = AppController.getInstance().getDates();
            this.dayLabels = new ArrayList<Label>();
    }

	/**
    * Initializes the CalendarOverviewController.
    */
	public void initView() {
		
		this.getCurrentDate();
		this.calendarView = new CalendarContainerViewController(
			calendarContainer, weekendContainer);
		this.calendarView.setTimeAndDates(dates);
		this.calendarView.setCalendarController(mainApp.getCalendarController());
		this.calendarView.initDates();

        dayLabels.add(this.mondayDate);
        dayLabels.add(tuesdayDate);
        dayLabels.add(wednesdayDate);
        dayLabels.add(thursdayDate);
        dayLabels.add(fridayDate);
        dayLabels.add(saturdayDate);
        dayLabels.add(sundayDate);

	}

	public void updateView() {
        this.calendarView.updateDays();
		String monthYear = dates.getMonth() + " " + dates.getYear();
		month.setText(monthYear);
		
		week.setText(dates.getWeekNumberAsString());
        this.calendarView.drawEvents();
        this.updateDateNames();
	}
	
	public void handleCurrentDateOrSelectedDate(String date, boolean value) {
		boolCurrentOrSelected = value;
		if (boolCurrentOrSelected == true) {
			getCurrentDate();
		}
		else {
			selectedDate = date;
			handleSelectedDateView(selectedDate);
		}
	}

	/**
    * 
    */
	public void getCurrentDate() {
		
        this.updateDateNames();

		String monthYear = dates.getMonth() + " " + dates.getYear();
		month.setText(monthYear);
		
		week.setText(dates.getWeekNumberAsString());
	}
	
	/**
    * 
    */
	@FXML
	private void handleWeekForward() {		
		dates.nextWeek();
        this.updateView();
	}

    private void updateDateNames() {
        Calendar date = dates.getMonday();
        for(Label l : dayLabels) {
                l.setText(String.valueOf(date.get(Calendar.DAY_OF_MONTH)));
                date.add(Calendar.DATE, 1);
        }
    }
	
	/**
    * 
    */
	@FXML
	private void handleWeekBack() {
		/*
		backCounter = (backCounter + 1)* (-1);
		totalCounter = backCounter + forwardCounter;
		backCounter = backCounter* (-1);*/
		
		
		dates.previousWeek();

        this.updateView();
	}
	
	/**
    * 
    */
	public void handleSelectedDateView(String date) {
		
		String[] dayList = dates.selectedDate(date);
		
		mondayDate.setText(dayList[0]);
		tuesdayDate.setText(dayList[1]);
		wednesdayDate.setText(dayList[2]);
		thursdayDate.setText(dayList[3]);
		fridayDate.setText(dayList[4]);
		saturdayDate.setText(dayList[5]);
		sundayDate.setText(dayList[6]);
		
		String monthString = dates.getMonth();
		String yearString = dates.getYear();
		String monthYear = monthString + " " + yearString;
		month.setText(monthYear);
		
		week.setText(dates.getWeekNumberAsString());
		
	}
	//======= Notes =======
	public void handleNote() {
		
	}
	
	@FXML
	private void handleOpenNoteOverview() {
		mainApp.handleOpenNoteOverview();
	}
	
	

	//======= Edit view =======
	@FXML
	private void handleLeftHeader() {
        leftHeader.setPickOnBounds(true); // allows click on transparent areas
        leftHeader.setOnMouseClicked((MouseEvent e) -> {
            System.out.println("Clicked!"); 
            
        });
	}
	
	//======= Editing calendar fonts =======
	
	/**
    * 
    */
	@FXML
	private void handleWeekdayFonts() {
		fontValue = 1;
		boolean okClicked = mainApp.showFontOverview();
	}
	
	public void setNewWeekdayFont(String font) {
		String newFont = font;
		System.out.println("New weekday font style is " + newFont);
		
		Label[] list = {monday, tuesday, wednesday, thursday, friday, saturday, sunday};
		for (Label day : list) {
			day.setFont(new Font(newFont,15));
		}
	}
	
	/**
    * 
    */
	@FXML
	private void handleWeekdayDateFonts() {
		fontValue = 2;
		boolean okClicked = mainApp.showFontOverview();
	}
	
	/**
    * 
    */
	public void setNewWeekdayDateFont(String font) {
		String newFont = font;
		System.out.println("New date font style is " + newFont);
		
		Label[] list = {mondayDate, tuesdayDate, wednesdayDate, thursdayDate, fridayDate, saturdayDate, sundayDate};
		for (Label day : list) {
			day.setFont(new Font(newFont,13));
		}
	}
	
	/**
    * 
    */
	@FXML
	private void handleHeaderFonts() {
		fontValue = 3;
		boolean okClicked = mainApp.showFontOverview();
	}
	
	/**
    * 
    */
	public void setNewHeaderFont(String font) {
		String newFont = font;
		System.out.println("New month and week font style is " + newFont);
		
		Label[] list = {month, week};
		for (Label day : list) {
			day.setFont(new Font(newFont,24));
		}
	}
	
	/**
    * 
    */
	public void callFontValue() {
		int value = mainApp.fontValue(fontValue);
		System.out.println("handle " + value);
	}
	
	//======= Mood Module =======
	public void setMoodModule() {
		
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}	

}
