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
	private ImageView calendar, leftHeader, rightHeader;
	@FXML
	private Label month, week;
	@FXML
	private Label monday, tuesday, wednesday, thursday, friday, saturday, sunday;
	@FXML
	private Label mondayDate, tuesdayDate, wednesdayDate, thursdayDate,  fridayDate, 
				  saturdayDate, sundayDate;
	@FXML
	private Label monday07, monday08, monday09, monday10, monday11, monday12, monday13, monday14,
				  monday15, monday16, monday17, monday18, monday19, monday20, monday21,
				  tuesday07, tuesday08, tuesday09, tuesday10, tuesday11, tuesday12, tuesday13, tuesday14,
				  tuesday15, tuesday16, tuesday17, tuesday18, tuesday19, tuesday20, tuesday21,
				  wednesday07, wednesday08, wednesday09, wednesday10, wednesday11, wednesday12, 
				  wednesday13, wednesday14, wednesday15, wednesday16, wednesday17, wednesday18, 
				  wednesday19, wednesday20, wednesday21,
				  thursday07, thursday08, thursday09, thursday10, thursday11, thursday12, 
				  thursday13, thursday14, thursday15, thursday16, thursday17, thursday18, thursday19, 
				  thursday20, thursay21,
				  friday07, friday08, friday09, friday10, friday11, friday12, friday13, friday14,
				  friday15, friday16, friday17, friday18, friday19, friday20, friday21,
				  saturday07, saturday08, saturday09, saturday10, saturday11, saturday12, 
				  saturday13, saturday14, saturday15, saturday16, saturday17, saturday18, 
				  saturday19, saturday20, saturday21,
				  sunday07, sunday08, sunday09, sunday10, sunday11, sunday12, sunday13, sunday14,
				  sunday15, sunday16, sunday17, sunday18, sunday19, sunday20, sunday21;
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
		
		String[] dayList = dates.selectedDate(date);
		
		mondayDate.setText(dayList[0]);
		tuesdayDate.setText(dayList[1]);
		wednesdayDate.setText(dayList[2]);
		thursdayDate.setText(dayList[3]);
		fridayDate.setText(dayList[4]);
		saturdayDate.setText(dayList[5]);
		sundayDate.setText(dayList[6]);
		
	}
	//======= Notes =======
	public void handleNote() {
		
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