package view;

import model.Menu;
import view.CalendarOverviewController;
import controller.MainApp;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class FontOverviewController {

	private boolean okClicked = false;
	private Stage dialogStage;
	private CalendarOverviewController calController;
	private String newFont;
	private Menu menu;
	
	@FXML
	private MenuButton chooseFont;

	@FXML
	private void initialize() {
		Menu menu = new Menu();
		menu.setFontOverviewController(this);
		
		ObservableList<MenuItem> items = menu.getFontList();
		chooseFont.getItems().addAll(items);
		
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public boolean isOkClicked() {
		return okClicked;
	}

	@FXML
	private void handleOk() {
		String font = newFont;
		calController.setNewFont(newFont);
		okClicked = true;
		dialogStage.close();
	}
	
	public void sendNewFont(String font) {
		newFont = font;
	}

	@FXML
	private void handleCancel() {
		dialogStage.close();
	}
	
	public void setCalendarOverviewController(CalendarOverviewController controller) {
		this.calController = controller;
	}
}
