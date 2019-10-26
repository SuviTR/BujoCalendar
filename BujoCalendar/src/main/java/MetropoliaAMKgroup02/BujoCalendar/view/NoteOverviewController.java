package MetropoliaAMKgroup02.BujoCalendar.view;

import org.dom4j.Node;

import MetropoliaAMKgroup02.BujoCalendar.model.FontMenu;
import MetropoliaAMKgroup02.BujoCalendar.model.NoteEdit;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NoteOverviewController {
	
		/*
		@FXML
		private TextField noteTitle;
		
		@FXML
		private Label noteTitle;*/

		@FXML
		private VBox vbox;
		
		@FXML
		private CheckBox allDayEvent;
		
		@FXML
		private Label startDay, endDay, startTime, endTime;
		
		@FXML
		private Label noteAlarm, notePriority;
		
		@FXML 
		private TextArea note;
		
		
		private RootLayoutController rootController;
		private boolean okClicked = false;
		private Stage dialogStage;
		private NoteEdit noteEdit;
		
		@FXML
		private void initialize() {
			noteEdit = new NoteEdit();
			noteEdit.setNoteOverviewController(this);
		}
		
		public void setDialogStage(Stage dialogStage) {
			this.dialogStage = dialogStage;
		}

		public boolean isOkClicked() {
			return okClicked;
		}

		@FXML
		private void handleOk() {
			okClicked = true;
			dialogStage.close();
		}
		
		@FXML
		private void handleNoteTitle() {
			noteEdit.newNoteTitle(vbox);
		}
		
		@FXML
		private void handleAllDayEventCheckBox() {
			if (allDayEvent.isSelected()) {
				endDay.setVisible(false);
				startTime.setVisible(false);
				endTime.setVisible(false);
			}					
			else {
				endDay.setVisible(true);
				startTime.setVisible(true);
				endTime.setVisible(true);
			}
		}
		
		
		public void setRootLayoutController(RootLayoutController controller) {
			this.rootController = controller;
		}

}
