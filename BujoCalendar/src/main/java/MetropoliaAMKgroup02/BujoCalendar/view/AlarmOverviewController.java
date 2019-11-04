package MetropoliaAMKgroup02.BujoCalendar.view;

import MetropoliaAMKgroup02.BujoCalendar.model.AlarmView;
import MetropoliaAMKgroup02.BujoCalendar.model.NoteEdit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class AlarmOverviewController {
	
	private AlarmView alarmView;
	private NoteOverviewController noteController;
	private boolean okClicked = false;
	private Stage dialogStage;
	private String time;
	private String value;

	@FXML
	private TextField alarmTime;
	
	@FXML
	private RadioButton min, hour, day, week;
	
	@FXML
	private ToggleGroup toggleGroup1;
	
	@FXML
	private CheckBox alarmApp, alarmEmail;
	
	@FXML
	private void initialize() {
		alarmView = new AlarmView();
		alarmView.setAlarmOverviewController(this);
	}
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public boolean isOkClicked() {
		return okClicked;
	}

	@FXML
	private void handleOk() {
		okClicked = true;
		noteController.setAlarmTimeandvalue(alarmTimeandValue());
		dialogStage.close();
	}
	
	private void handleAlarmTime() {
		time = alarmTime.getText();
	}
	
	@FXML
	private void handleAlarmOptions() {
		
		toggleGroup1 = new ToggleGroup();

		min.setToggleGroup(toggleGroup1);
		hour.setToggleGroup(toggleGroup1);
		day.setToggleGroup(toggleGroup1);
		week.setToggleGroup(toggleGroup1);

		if (min.isSelected()) {
			value = alarmView.getTimeValue("min");
			
		}
		else if (hour.isSelected()) {
			value = alarmView.getTimeValue("hour");
			
		}
		else if (day.isSelected()) {
			value = alarmView.getTimeValue("day");
		
		}
		else if (week.isSelected()) {
			value = alarmView.getTimeValue("week");
		}
	}
	
	public String alarmTimeandValue() {
		handleAlarmTime();
		return time + " " + value;
	}
	
	public void setNoteOverviewController(NoteOverviewController controller) {
		this.noteController = controller;
	}

}
