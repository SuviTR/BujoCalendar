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
import MetropoliaAMKgroup02.BujoCalendar.view.FontOverviewController;

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
	private FontOverviewController fontController;
	private int fontValue;

	public CalendarOverviewController() {
	}

	private void getCurrentDate() {
		
	}
	/*
	public void getTheRightWeek() {
		Label[] list = {mondayDate, tuesdayDate, wednesdayDate, thursdayDate, fridayDate, saturdayDate, sundayDate};
		for (Label day : list) {
			day.setText(päivämäärälista);
		}
		
	}*/
	
	@FXML
	private void handleWeekBack() {
		
	}
	
	@FXML
	private void handleWeekForward() {
		
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
			day.setFont(new Font(newFont,18));
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
