package MetropoliaAMKgroup02.BujoCalendar.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
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
import MetropoliaAMKgroup02.BujoCalendar.model.Menu;
import MetropoliaAMKgroup02.BujoCalendar.model.TimeandDates;

public class CalendarOverviewController {

	@FXML
	private ImageView calendar;

	@FXML
	private ImageView leftHeader;
	@FXML
	private ImageView rightHeader;
	
	@FXML
	private Label month;
	@FXML
	private Label week;

	@FXML
	private Label monday;
	@FXML
	private Label tuesday;
	@FXML
	private Label wednesday;
	@FXML
	private Label thursday;
	@FXML
	private Label friday;
	@FXML
	private Label saturday;
	@FXML
	private Label sunday;

	@FXML
	private Label mondayDate;
	@FXML
	private Label tuesdayDate;
	@FXML
	private Label wednesdayDate;
	@FXML
	private Label thursdayDate;
	@FXML
	private Label fridayDate;
	@FXML
	private Label saturdayDate;
	@FXML
	private Label sundayDate;
	
	@FXML
	private MenuButton fonts;

	private MainApp mainApp;
	private TimeandDates dates;
	private int fontValue;
	private int backCounter = 0;
	private int forwardCounter = 0;
	private int totalCounter = 0;

	public CalendarOverviewController() {
	}

	public void getCurrentDate() {
		dates = new TimeandDates();
		dates.getCurrentDate();
		dates.getCurrentMonth();
		dates.getWeekdayName();
		
		String mondayString = dates.updateDate(2);
		String tuesdayString = dates.updateDate(3);
		String wednesdayString = dates.updateDate(4);
		String thursdayString = dates.updateDate(5);
		String fridayString = dates.updateDate(6);
		String saturdayString = dates.updateDate(7);
		String sundayString = dates.updateDate(1);
		
		mondayDate.setText(mondayString);
		tuesdayDate.setText(tuesdayString);
		wednesdayDate.setText(wednesdayString);
		thursdayDate.setText(thursdayString);
		fridayDate.setText(fridayString);
		saturdayDate.setText(saturdayString);
		sundayDate.setText(sundayString);
		
		String monthString = dates.updateMonth();
		String yearString = dates.updateYear();
		String monthYear = monthString + " " + yearString;
		month.setText(monthYear);
		
		int weekNumberInt = dates.updateWeekNumber();
		week.setText(String.valueOf(weekNumberInt));
	}
	
	@FXML
	private void handleWeekForward() {	
		forwardCounter++;
		backCounter = backCounter * (-1);
		totalCounter = backCounter + forwardCounter;
		backCounter = backCounter * (-1);
		
		dates = new TimeandDates();
		dates.getCurrentDate();
		dates.getCurrentMonth();
		dates.getWeekdayName();
		
		String mondayString = dates.nextWeek(2, totalCounter);
		String tuesdayString = dates.nextWeek(3, totalCounter);
		String wednesdayString = dates.nextWeek(4, totalCounter);
		String thursdayString = dates.nextWeek(5, totalCounter);
		String fridayString = dates.nextWeek(6, totalCounter);
		String saturdayString = dates.nextWeek(7, totalCounter);
		dates.getSaturday(saturdayString);
		String sundayString = dates.nextWeek(1, totalCounter);
		
		mondayDate.setText(mondayString);
		tuesdayDate.setText(tuesdayString);
		wednesdayDate.setText(wednesdayString);
		thursdayDate.setText(thursdayString);
		fridayDate.setText(fridayString);
		saturdayDate.setText(saturdayString);
		sundayDate.setText(sundayString);
		
		String monthString = dates.getNewMonth();
		month.setText(monthString);
		
		int weekInt = dates.getWeekNumber();
		String weekString = Integer.toString(weekInt);
		week.setText(weekString);
	}
	
	@FXML
	private void handleWeekBack() {
		backCounter = (backCounter + 1)* (-1);
		totalCounter = backCounter + forwardCounter;
		backCounter = backCounter* (-1);
		
		dates = new TimeandDates();
		dates.getCurrentDate();
		dates.getCurrentMonth();
		dates.getWeekdayName();
		
		String mondayString = dates.lastWeek(2, totalCounter);
		String tuesdayString = dates.lastWeek(3, totalCounter);
		String wednesdayString = dates.lastWeek(4, totalCounter);
		String thursdayString = dates.lastWeek(5, totalCounter);
		String fridayString = dates.lastWeek(6, totalCounter);
		String saturdayString = dates.lastWeek(7, totalCounter);
		dates.getSaturday(saturdayString);
		String sundayString = dates.lastWeek(1, totalCounter);
		
		mondayDate.setText(mondayString);
		tuesdayDate.setText(tuesdayString);
		wednesdayDate.setText(wednesdayString);
		thursdayDate.setText(thursdayString);
		fridayDate.setText(fridayString);
		saturdayDate.setText(saturdayString);
		sundayDate.setText(sundayString);
		
		String monthString = dates.getNewMonth();
		month.setText(monthString);
		
		int weekInt = dates.getWeekNumber();
		String weekString = Integer.toString(weekInt);
		week.setText(weekString);
	}
	
	public void handleSelectedDateView(String date) {
		dates.selectedDate(date);
	}

	
	@FXML
	private void handleLeftHeader() {
        leftHeader.setPickOnBounds(true); // allows click on transparent areas
        leftHeader.setOnMouseClicked((MouseEvent e) -> {
            System.out.println("Clicked!"); 
            
        });
	}
	
	//======= Editing calendar fonts ======= 
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
	
	@FXML
	private void handleWeekdayDateFonts() {
		fontValue = 2;
		boolean okClicked = mainApp.showFontOverview();
	}
	
	public void setNewWeekdayDateFont(String font) {
		String newFont = font;
		System.out.println("New date font style is " + newFont);
		
		Label[] list = {mondayDate, tuesdayDate, wednesdayDate, thursdayDate, fridayDate, saturdayDate, sundayDate};
		for (Label day : list) {
			day.setFont(new Font(newFont,13));
		}
	}
	
	@FXML
	private void handleHeaderFonts() {
		fontValue = 3;
		boolean okClicked = mainApp.showFontOverview();
	}
	
	public void setNewHeaderFont(String font) {
		String newFont = font;
		System.out.println("New month and week font style is " + newFont);
		
		Label[] list = {month, week};
		for (Label day : list) {
			day.setFont(new Font(newFont,24));
		}
	}
	
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