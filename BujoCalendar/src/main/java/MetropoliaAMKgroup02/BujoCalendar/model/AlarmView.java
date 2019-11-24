package MetropoliaAMKgroup02.BujoCalendar.model;

import MetropoliaAMKgroup02.BujoCalendar.view.AlarmOverviewController;
import MetropoliaAMKgroup02.BujoCalendar.view.NoteOverviewController;
import MetropoliaAMKgroup02.BujoCalendar.view.RootLayoutController;
import MetropoliaAMKgroup02.Common.model.Halytys;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AlarmView {
	
	private AlarmOverviewController alarmController;
	private Halytys halytys;
	
	public String getAlarmTime(String time) {
		return time;
	}
	
	/**
	 * Checks what radiobutton user has clicked and gives text for the front.
	 * @param value includes the value of the radiobutton.
	 * @return valueText is the text what is going to add to front.
	 */
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
	
	public void sendAlarmInfoToCommonHalytys() {
		
	}
	
	/**
	 * Sets the AlarmOverviewController.
	 * @param alarmController is the AlarmOverviewController.
	 */
	public void setAlarmOverviewController(AlarmOverviewController controller) {
		this.alarmController = controller;
	}
}
