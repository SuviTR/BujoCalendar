package MetropoliaAMKgroup02.BujoCalendar.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import MetropoliaAMKgroup02.BujoCalendar.view.NoteOverviewController;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class NoteEdit {
	
	private NoteOverviewController noteController;

	public void newNoteTitle(VBox vbox) {
		
		VBox vBox = vbox;
		int currentPos = 0;
		Map<Integer, TextField> toInsert = new HashMap<>(); // map with TextFields that need to be inserted at position
		for (Iterator<Node> iterator = vBox.getChildren().iterator(); iterator.hasNext(); ) {
			Node child = iterator.next();
			if (child instanceof Label) {
				Label lbl = (Label)child;
				TextField text = new TextField();
				text.setPromptText(lbl.getText());
				iterator.remove(); // remove the label that is at index currentPos
				toInsert.put(currentPos, text);
			}
			currentPos++;
		}
		for (Integer pos : toInsert.keySet()) {
			TextField field = toInsert.get(pos);
			vBox.getChildren().add(pos, field); // Add the Text field at the old position of the Label
		}
	}
	

	
	public void setNoteOverviewController(NoteOverviewController controller) {
		this.noteController = controller;
	}

}
