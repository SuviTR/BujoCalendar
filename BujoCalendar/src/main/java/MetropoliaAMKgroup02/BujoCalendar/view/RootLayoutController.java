package MetropoliaAMKgroup02.BujoCalendar.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;

import MetropoliaAMKgroup02.BujoCalendar.controller.MainApp;

public class RootLayoutController {

	@FXML
	private MenuItem weekdayFonts ;

	private MainApp mainApp;

	public RootLayoutController() {
	}


	@FXML
	private void handleChangeWeekdayFonts() {

		System.out.println("Clicked!");

	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

	}
}
