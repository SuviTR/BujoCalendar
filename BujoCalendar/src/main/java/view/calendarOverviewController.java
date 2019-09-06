package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import controller.MainApp;
import model.bujoCalendar;

public class calendarOverviewController {
	
	@FXML
	private ImageView calendar;
	
	@FXML
	private ImageView leftHeader;
	@FXML
	private ImageView rightHeader;
	
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
	
	private MainApp mainApp;

	public calendarOverviewController() {
	}

	private void getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); 
	}
	
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

	}
}
