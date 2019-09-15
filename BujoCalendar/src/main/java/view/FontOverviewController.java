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
	private int fontValue;
	
	@FXML
	private MenuButton chooseFont;

	@FXML
	private void initialize() {
		Menu menu = new Menu();
		menu.setFontOverviewController(this);
		
		ObservableList<MenuItem> items = menu.getFontList();
		chooseFont.getItems().addAll(items);
		fontValue = fontValue(fontValue);
		System.out.println("ini " + fontValue);
		
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public boolean isOkClicked() {
		return okClicked;
	}

	@FXML
	private void handleOk() {
		System.out.println("ok " + fontValue);
		if (fontValue == 1) {
			calController.setNewWeekdayFont(newFont);
		}
		else if (fontValue == 2) {
			calController.setNewWeekdayDateFont(newFont);
		}
		else if (fontValue == 3) {
			calController.setNewHeaderFont(newFont);
		}
		okClicked = true;
		dialogStage.close();
	}
	
	public int fontValue(int value) {
		fontValue = value;
		System.out.println("font " + fontValue);
		return fontValue = value;
	}
	public void sendNewWeekdayFont(String font) {
		newFont = font;
	}

	@FXML
	private void handleCancel() {
		dialogStage.close();
	}
	
	public void setCalendarOverviewController(CalendarOverviewController calController) {
		this.calController = calController;
	}
}