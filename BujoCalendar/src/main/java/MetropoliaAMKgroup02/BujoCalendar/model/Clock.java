package MetropoliaAMKgroup02.BujoCalendar.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import MetropoliaAMKgroup02.BujoCalendar.view.NoteOverviewController;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Clock {
	
	private NoteOverviewController noteController;
	private String curHour = "";

	public String currentTimeHour() {
		SimpleDateFormat formatter= new SimpleDateFormat("HH"); //yyyy-MM-dd 'at' HH:mm:ss z
		Date date = new Date(System.currentTimeMillis());
		curHour = formatter.format(date);
		return formatter.format(date); //17
	}
	public String currentTimeMinutes() {
		SimpleDateFormat formatter= new SimpleDateFormat("mm"); //yyyy-MM-dd 'at' HH:mm:ss z
		Date date = new Date(System.currentTimeMillis());
		return formatter.format(date); //02
	}
	
	public String currentTimeHourplus1() {
		//String parseHour = curTime.substring(0, 2);
		//String parseMin = curTime.substring(curTime.length() - 3);
		
		int time = Integer.parseInt(curHour);
		if (time == 23) {
			time = 0;
		}
		else {
			time = time + 1;
		}
		curHour = Integer.toString(time);
		
		String newTime = curHour; //parseHour + parseMin;
		return newTime;
	}
	
	public String handleStartTime(TextField time) {
		return time.getText();
	}

	public String handleEndTime(TextField time) {
		return time.getText();
	}
	
	public String checkHour(TextField hour) {
		
		if (Integer.parseInt(hour.getText()) < 0 || Integer.parseInt(hour.getText()) > 23) {
			Alert a = new Alert(AlertType.NONE); 
	
	        a.setAlertType(AlertType.ERROR); 
	        a.setTitle("Virheellinen syöte");
	        a.setHeaderText("Syöttämäsi kellonaika on virheellinen.");
	        a.setContentText("Kirjoita kellonaika uudelleen.");
	        a.show();
	        
	        return " !";
		}
        
		else {
			return hour.getText();
		}
        
		/*
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
		return msg;*/
	}
	
	public String checkMin(TextField min) {
	
		if (Integer.parseInt(min.getText()) < 0 || Integer.parseInt(min.getText()) > 59) {
			Alert a = new Alert(AlertType.NONE); 
	
	        a.setAlertType(AlertType.ERROR); 
	        a.setTitle("Virheellinen syöte");
	        a.setHeaderText("Syöttämäsi kellonaika on virheellinen.");
	        a.setContentText("Kirjoita kellonaika uudelleen.");
	        a.show();
	        
	        return "! ";
		}
        
		else {
			return min.getText();
		}
	}
	
	public void setNoteOverviewController(NoteOverviewController controller) {
		this.noteController = controller;
	}
}
