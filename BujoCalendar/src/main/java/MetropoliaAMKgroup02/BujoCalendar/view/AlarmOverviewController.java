package MetropoliaAMKgroup02.BujoCalendar.view;

import MetropoliaAMKgroup02.BujoCalendar.model.AlarmView;
import MetropoliaAMKgroup02.BujoCalendar.model.NoteEdit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AlarmOverviewController {
	
	private AlarmView alarmView;
	private NoteOverviewController noteController;
	private boolean okClicked = false;
	private Stage dialogStage;

	@FXML
	private TextField AlarmTime;
	
	@FXML
	private CheckBox min, hour, day, week;
	
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
		dialogStage.close();
	}
	
	@FXML
	private void handleAlarmTime() {
		System.out.println(AlarmTime.getText());
	}
	
	@FXML
	private void handleAlarmOptions() {
		
		ObservableList<CheckBox> options = FXCollections.observableArrayList();
		options.addAll(min, hour, day, week);
		/*
		for (int i = 0; i < options.size(); i++) {
			if (options.get(i).isSelected()) {
				CheckBox selected = options.get(i);
				for (int j = 0; j < options.size(); j++) {
					if (!selected.equals(options.get(i))) {
						options.get(i).setSelected(false);
					}
				}
			}
		}*/
		
		if (min.isSelected()) {
			hour.setSelected(false);
			day.setSelected(false);
			week.setSelected(false);
		}
		else if (hour.isSelected()) {
			min.setSelected(false);
			day.setSelected(false);
			week.setSelected(false);
		}
		else if (day.isSelected()) {
			min.setSelected(false);
			hour.setSelected(false);
			week.setSelected(false);
		}
		else if (week.isSelected()) {
			min.setSelected(false);
			hour.setSelected(false);
			day.setSelected(false);
		}
	}
	

	public void setNoteOverviewController(NoteOverviewController controller) {
		this.noteController = controller;
	}

}
