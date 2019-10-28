package MetropoliaAMKgroup02.BujoCalendar.model;

import MetropoliaAMKgroup02.BujoCalendar.view.AlarmOverviewController;
import MetropoliaAMKgroup02.BujoCalendar.view.NoteOverviewController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class AlarmView {
	
	private AlarmOverviewController alarmController;
	
	public void setAlarmOverviewController(AlarmOverviewController controller) {
		this.alarmController = controller;
	}
}
