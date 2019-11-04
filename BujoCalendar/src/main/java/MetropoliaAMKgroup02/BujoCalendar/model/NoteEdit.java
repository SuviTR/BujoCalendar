package MetropoliaAMKgroup02.BujoCalendar.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import MetropoliaAMKgroup02.BujoCalendar.view.NoteOverviewController;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class NoteEdit {
	
	private NoteOverviewController noteController;

	public void newNoteTitle(TextField title) {
		title.setPromptText("Otsikko");
	}
	
	public void newNoteMoreInfo(TextArea text) {
		text.setPromptText("Lisätietoa");
	}
	
	public void setNoteOverviewController(NoteOverviewController controller) {
		this.noteController = controller;
	}

}
