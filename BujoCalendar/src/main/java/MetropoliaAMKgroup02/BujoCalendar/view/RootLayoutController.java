package MetropoliaAMKgroup02.BujoCalendar.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import MetropoliaAMKgroup02.BujoCalendar.controller.MainApp;
import MetropoliaAMKgroup02.BujoCalendar.model.BujoDatePicker;
import MetropoliaAMKgroup02.BujoCalendar.model.NoteEdit;


public class RootLayoutController {
	
	private MainApp mainApp;
	private BujoDatePicker monthView;
	private boolean boolCurrentDate = true;

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
		monthView = new BujoDatePicker();
		monthView.setRootLayoutController(this);
		Stage s = new Stage();
		monthView.start(s);
		monthView.whoValue(1);
	}
	
	@FXML
	private void handleCurrentDate() {
		boolCurrentDate = true;
		mainApp.handleCurrentDate(boolCurrentDate);
	}
	
	public void handleSelectedDateView(String date) {
		boolCurrentDate = false;
		mainApp.handleSelectedDateView(date, boolCurrentDate);
		
	}

    public void updateEvents() {
            mainApp.updateEvents();
    }
	
	@FXML
	public void handleViewCurrentDate() {
		boolCurrentDate = true;
		mainApp.handleCurrentDate(boolCurrentDate);
	}
	
	@FXML
	public void handleNewNote() {
		mainApp.showNoteOverview();
	}
	
	public void showAlarmOverview() {
		boolean okClicked = mainApp.showAlarmOverview();
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	

}
