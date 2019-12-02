package MetropoliaAMKgroup02.BujoCalendar.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import MetropoliaAMKgroup02.BujoCalendar.view.NoteOverviewController;
import MetropoliaAMKgroup02.Common.model.Merkinta;
import java.util.Calendar;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class NoteEdit {
	
	private NoteOverviewController noteController;
	private Merkinta note;
        private String title;
        private String text;
        private Calendar startDate;
        private Calendar endDate;
        private boolean allDay;
        private int id;

	public void newNoteTitle(String title) {
		//note.setNimi(title.getText());
        this.title = title;
	}
	
	public void newNoteMoreInfo(String text) {
		//note.setSisalto(text.getText());
        this.text = text;
	}
	
	public void noteStartDay(Calendar startDate) {
            this.startDate = startDate;
	}
	
    public void setNoteEnd(Calendar endDate) {
            this.endDate = endDate;
    }
	
	public void setNoteOverviewController(NoteOverviewController controller) {
		this.noteController = controller;
	}

    public Merkinta createMerkinta() {
            Merkinta merkinta = new Merkinta();
            merkinta.setId(id);
            merkinta.setNimi(this.title);
            merkinta.setSisalto(text);
            merkinta.setStartDate(startDate);
            merkinta.setEndDate(endDate);
            return merkinta;
    }

        public void allDayEvent() {
                this.allDay = true;
        }

        public void setId(int id) {
                this.id = id;
        }

}
