package MetropoliaAMKgroup02.BujoCalendar.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import MetropoliaAMKgroup02.BujoCalendar.controller.MainApp;
import MetropoliaAMKgroup02.BujoCalendar.model.MonthView;


public class RootLayoutController {
	
	private MainApp mainApp;
	private MonthView monthView;
	private boolean boolCurrentDate = true;
	private boolean boolSelectedDate = false;

	@FXML
	private MenuItem weekdayFonts ;

	public RootLayoutController() {
	}

	@FXML
	private void handleChangeWeekdayFonts() {
		System.out.println("Clicked!");

	}
	
	@FXML
	private void handleSelectDay() {
		monthView = new MonthView();
		monthView.setRootLayoutController(this);
		Stage s = new Stage();
		monthView.start(s);
	}
	
	@FXML
	private void handleCurrentDate() {
		boolCurrentDate = true;
		//boolSelectedDate = false;
		mainApp.handleCurrentDate(true);
	}
	
	public void handleSelectedDateView(String date) {
		mainApp.handleSelectedDateView(date, false);
		boolCurrentDate = false;
		//boolSelectedDate = true;
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
