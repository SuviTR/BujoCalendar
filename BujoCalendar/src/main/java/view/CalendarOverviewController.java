package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.*; 
import java.time.DayOfWeek; 
import java.time.temporal.Temporal; 

import controller.MainApp;
import model.Menu;
import view.FontOverviewController;

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
	private Menu menu;
	//private String newFont;

	public CalendarOverviewController() {
	}

	private void getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); 
	}

	private void getTheRightWeekday() {
		//modeliin
		LocalDate localDate1 = LocalDate.of(2019, Month.OCTOBER, 2); // Set a Local Date whose day is found 
		DayOfWeek dayOfWeek1 = DayOfWeek.from(localDate1); 		 	 // Find the day from the Local Date 
		System.out.println(localDate1 + " which is " + dayOfWeek1.name()); //is Wednesday
		Temporal localDate2 = DayOfWeek.MONDAY.adjustInto(localDate1);  // Adjusting the Date to Monday 
		DayOfWeek dayOfWeek2 = DayOfWeek.from(localDate2); 			 // Find the day from the new Local date 
		System.out.println(localDate2 + " which is " + dayOfWeek2.name());  //is Monday
	}

	@FXML
	private void handleLeftHeader() {
        leftHeader.setPickOnBounds(true); // allows click on transparent areas
        leftHeader.setOnMouseClicked((MouseEvent e) -> {
            System.out.println("Clicked!"); 
            
        });
	}
	
	@FXML
	private void handleWeekdayFont() {
		boolean okClicked = mainApp.showFontOverview();
	}
	
	public void setNewFont(String font) {
		String newFont = font;
		System.out.println("New font style is " + newFont);
		thursday.setFont(new Font(newFont, 30));
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}	
}
