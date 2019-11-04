package MetropoliaAMKgroup02.BujoCalendar.model;

import MetropoliaAMKgroup02.BujoCalendar.view.AlarmOverviewController;
import MetropoliaAMKgroup02.BujoCalendar.view.NoteOverviewController;
import MetropoliaAMKgroup02.BujoCalendar.view.RootLayoutController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AlarmView {
	
	private AlarmOverviewController alarmController;
	
	public String getAlarmTime(TextField time) {
		String alarmTime = time.getText();
		return alarmTime;
	}
	
	public String getTimeValue(String value) {
		String valueText = "";
		
		if (value.equals("min")) {
			valueText = "min ennen";
		}
		else if (value.equals("hour")) {
			valueText = "h ennen";
		}
		else if (value.equals("day")) {
			valueText = "pv ennen";
		}
		else if (value.equals("week")) {
			valueText = "vko ennen";
		}
		return valueText;
	}
	
	public void setAlarmOverviewController(AlarmOverviewController controller) {
		this.alarmController = controller;
	}
}
