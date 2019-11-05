package MetropoliaAMKgroup02.BujoCalendar.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import MetropoliaAMKgroup02.BujoCalendar.view.NoteOverviewController;
import javafx.scene.control.TextField;

public class Clock {
	
	private NoteOverviewController noteController;
	private String curTime = "";

	public String currentTime() {
		SimpleDateFormat formatter= new SimpleDateFormat("HH:mm"); //yyyy-MM-dd 'at' HH:mm:ss z
		Date date = new Date(System.currentTimeMillis());
		curTime = formatter.format(date);
		return formatter.format(date); //17:11
	}
	
	public String currentTimeplus1() {
		String parseHour = curTime.substring(0, 2);
		String parseMin = curTime.substring(curTime.length() - 3);
		
		int time = Integer.parseInt(parseHour);
		if (time == 24) {
			time = 0;
		}
		else {
			time = time + 1;
		}
		parseHour = Integer.toString(time);
		
		String newTime = parseHour + parseMin;
		return newTime;
	}
	
	public String handleStartTime(TextField time) {
		return time.getText();
	}

	public String handleEndTime(TextField time) {
		return time.getText();
	}
	
	public void setNoteOverviewController(NoteOverviewController controller) {
		this.noteController = controller;
	}
}
