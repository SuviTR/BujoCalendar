package MetropoliaAMKgroup02.BujoCalendar.model;

import MetropoliaAMKgroup02.Backend.controller.CalendarController;
import MetropoliaAMKgroup02.BujoCalendar.view.NoteOverviewController;
import MetropoliaAMKgroup02.Common.model.Merkinta;
import java.util.Calendar;
import java.util.Optional;

import javax.swing.JOptionPane;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler; 


public class NoteEdit {
	
	private NoteOverviewController noteController;
	private Merkinta note;
    private String title;
    private String text;
    private Calendar startDate;
    private Calendar endDate;
    private boolean allDay;
    private int id;

    /**
     * Gets the title name of the note.
     * @param title is the title of the note.
     */
	public void newNoteTitle(String title) {
		//note.setNimi(title.getText());
        this.title = title; 
	}
	
	/**
	 * Gets the note text of the note.
	 * @param text is the more information text from the textarea.
	 */
	public void newNoteMoreInfo(String text) {
		//note.setSisalto(text.getText());
        this.text = text;
	}
	
	/**
	 * Gets the start date of the note.
	 * @param startDate is the start date of the note.
	 */
	public void noteStartDay(Calendar startDate) {
        this.startDate = startDate;
	}
	
	/**
	 * Gets the end date of the note.
	 * @param endDate is the end date of the note.
	 */
    public void noteEndDay(Calendar endDate) {
        this.endDate = endDate;
    }

	/**
	 * Pulls together all information from the note editing window
	 * and makes them a Merkinta.
	 */
    public Merkinta createMerkinta() { //Alarm is missing!!!!!!
        Merkinta merkinta = new Merkinta();
        merkinta.setNimi(this.title);
        merkinta.setId(id);
        merkinta.setSisalto(text);
        merkinta.setStartDate(startDate);
        merkinta.setEndDate(endDate);
        return merkinta;
    }

    public void allDayEvent() {
        this.allDay = true;
    }
    
    /**
     * Alerts the user of removing a note.
     * Asks confirmation of removing a note.
     */
    public boolean removeNoteWarning() {
 
    	boolean b;
        Alert a = new Alert(AlertType.NONE); 

        a.setAlertType(AlertType.CONFIRMATION); 
        a.setTitle("Vahvistus merkinnän poistamiseksi");
        a.setHeaderText("Oletko varma, että haluat poistaa tämän merkinnän?");
        a.setContentText("Jos et ole, paina cancel-nappia. "
        		+ "Jos olet varma, että haluat poistaa tämän merkinnän, paina ok-nappia.");
        /*
        a.setTitle("Confirmation of removing a note");
        a.setHeaderText("Are you sure you want to remove this note?");
        a.setContentText("If not, please click the cancel button. "
        		+ "If you are sure to removing this note, please click the ok button.");*/

        Optional<ButtonType> result = a.showAndWait();
        if (result.get() == ButtonType.OK){
        	b = true;
        	//noteController.deleteNote(true);
        }
        else {
        	b = false;
        	//noteController.deleteNote(false);
        }

        a.show(); 
        return b;
    }

    public void setId(int id) {
        this.id = id;
    }
    
	public void setNoteOverviewController(NoteOverviewController controller) {
		this.noteController = controller;
	}    

}
