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
	
	public String checkStartandEndTime(TextField time) {
		
		String msg = time.getText();
		String[] parseTime = new String[2];
		
		try {
			parseTime = time.getText().split(".");
			parseTime = time.getText().split(":");
		}
		
		catch (Exception e) {
			msg = "Väärä muoto syötettäessä kellonaikaa";
		}
		int[] times = new int[2];
		
		for (int i = 0; i < times.length; i++) {	
			times[i] = Integer.parseInt(parseTime[i]);
		}
		
		if (times[0] < 0 && times[0] > 23) {
			msg = time + "syöte on väärin. Kirjoita aika uudelleen.";
		}
		if (times[1] < 0 && times[1] > 59) {
			msg = time + "syöte on väärin. Kirjoita aika uudelleen.";
		}
		return msg;
	}
	
	public void setNoteOverviewController(NoteOverviewController controller) {
		this.noteController = controller;
	}
}
