package MetropoliaAMKgroup02.BujoCalendar.view;

import MetropoliaAMKgroup02.BujoCalendar.model.AlarmView;
import MetropoliaAMKgroup02.BujoCalendar.model.NoteEdit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
		if (isInputValid()) {
			okClicked = true;
			noteController.setAlarmTimeandValue(alarmTimeandValue());
			dialogStage.close();
		}
	}
	
	private String handleAlarmTime() {
		time = alarmTime.getText();
		alarmView.getAlarmTime(time);
		return time;
	}
	
	@FXML
	private String handleAlarmOptions() {
		
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
		return value;
	}
	
	public String alarmTimeandValue() {
		handleAlarmTime();
		return time + " " + value;
	}
	
	private boolean isInputValid() {

        String errorMessage = "";
        
        int validInt;

        try {
            validInt = Integer.parseInt(alarmTime.getText());
 
            if (validInt > 59 || validInt < 1) {
                errorMessage += "Antamasi ilmoitusaika ei ole 1-59 väliltä!\n"; 
            }
 
        } 
        catch (NumberFormatException ex) {
        	errorMessage += "Et ole antanut ilmoitusaikaa tai\nantamasi ilmoitusaika ei ole kokonaisluku, esim. 10!\n";
        }

        if (value == null) {
        	errorMessage += "Et ole valinnut ilmoitusajan tyyppiä vaihtoehdoista!\n";
        }
        
        if (errorMessage.length() == 0) {
            return true;
        } 
        else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Antamasi ilmoitusaika on epävalidi.");
            alert.setHeaderText("Korjaathan epävalidin ilmoitusajan");
            alert.setContentText(errorMessage);
            
            alert.showAndWait();
            
            return false;
        }
    }
	
	public void setNoteOverviewController(NoteOverviewController controller) {
		this.noteController = controller;
	}

}
