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

	public void getCurrentDate() {		//LOOPPI!!!!
		dates = new TimeandDates();
		dates.getCurrentDate();
		dates.getCurrentMonth();
		dates.getWeekdayName();
		
		int mondayInt = dates.updateDate(2);
		int tuesdayInt = dates.updateDate(3);
		int wednesdayInt = dates.updateDate(4);
		int thursdayInt = dates.updateDate(5);
		int fridayInt = dates.updateDate(6);
		int saturdayInt = dates.updateDate(7);
		int sundayInt = dates.updateDate(1);
		
		String mondayString = Integer.toString(mondayInt);
		String tuesdayString = Integer.toString(tuesdayInt);
		String wednesdayString = Integer.toString(wednesdayInt);
		String thursdayString = Integer.toString(thursdayInt);
		String fridayString = Integer.toString(fridayInt);
		String saturdayString = Integer.toString(saturdayInt);
		String sundayString = Integer.toString(sundayInt);
		
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
		System.out.println("total for " + totalCounter);
		
		dates = new TimeandDates();
		dates.getCurrentDate();
		dates.getCurrentMonth();
		dates.getWeekdayName();
		
		int mondayInt = dates.nextWeek(2, totalCounter);
		
		int tuesdayInt = dates.nextWeek(3, totalCounter);
		int wednesdayInt = dates.nextWeek(4, totalCounter);
		int thursdayInt = dates.nextWeek(5, totalCounter);
		int fridayInt = dates.nextWeek(6, totalCounter);
		int saturdayInt = dates.nextWeek(7, totalCounter);
		dates.getSaturday(saturdayInt);
		int sundayInt = dates.nextWeek(1, totalCounter);
		
		String mondayString = Integer.toString(mondayInt);
		String tuesdayString = Integer.toString(tuesdayInt);
		String wednesdayString = Integer.toString(wednesdayInt);
		String thursdayString = Integer.toString(thursdayInt);
		String fridayString = Integer.toString(fridayInt);
		String saturdayString = Integer.toString(saturdayInt);
		String sundayString = Integer.toString(sundayInt);
		
		mondayDate.setText(mondayString);
		tuesdayDate.setText(tuesdayString);
		wednesdayDate.setText(wednesdayString);
		thursdayDate.setText(thursdayString);
		fridayDate.setText(fridayString);
		saturdayDate.setText(saturdayString);
		sundayDate.setText(sundayString);
		
		int weekInt = dates.getWeekNumber();
		String weekString = Integer.toString(weekInt);
		week.setText(weekString);
	}
	
	@FXML	//Ei toimi
	private void handleWeekBack() {	//Ei vielä huomioitu viikkojen ja kuukausien vaihtumista
		backCounter = (backCounter + 1)* (-1);
		System.out.println("back " + backCounter);
		totalCounter = backCounter + forwardCounter;	//ei toimi
		
		System.out.println("total back " + totalCounter);
		backCounter = backCounter* (-1);
		
		dates = new TimeandDates();
		dates.getCurrentDate();
		dates.getCurrentMonth();
		dates.getWeekdayName();
		
		int mondayInt = dates.lastWeek(2, totalCounter);
		int tuesdayInt = dates.lastWeek(3, totalCounter);
		int wednesdayInt = dates.lastWeek(4, totalCounter);
		int thursdayInt = dates.lastWeek(5, totalCounter);
		int fridayInt = dates.lastWeek(6, totalCounter);
		int saturdayInt = dates.lastWeek(7, totalCounter);
		dates.getSaturday(saturdayInt);
		int sundayInt = dates.lastWeek(1, totalCounter);
		
		String mondayString = Integer.toString(mondayInt);
		String tuesdayString = Integer.toString(tuesdayInt);
		String wednesdayString = Integer.toString(wednesdayInt);
		String thursdayString = Integer.toString(thursdayInt);
		String fridayString = Integer.toString(fridayInt);
		String saturdayString = Integer.toString(saturdayInt);
		String sundayString = Integer.toString(sundayInt);
		
		mondayDate.setText(mondayString);
		tuesdayDate.setText(tuesdayString);
		wednesdayDate.setText(wednesdayString);
		thursdayDate.setText(thursdayString);
		fridayDate.setText(fridayString);
		saturdayDate.setText(saturdayString);
		sundayDate.setText(sundayString);
		
		int weekInt = dates.getWeekNumber();
		String weekString = Integer.toString(weekInt);
		week.setText(weekString);
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
			day.setFont(new Font(newFont,16));
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
