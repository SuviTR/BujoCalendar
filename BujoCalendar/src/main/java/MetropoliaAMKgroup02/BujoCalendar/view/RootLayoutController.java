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
	
	public void getSelectedDateView(String date) {
		mainApp.getSelectedDateView(date);
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}
