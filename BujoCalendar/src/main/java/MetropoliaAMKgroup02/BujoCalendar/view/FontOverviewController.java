package MetropoliaAMKgroup02.BujoCalendar.view;

import MetropoliaAMKgroup02.BujoCalendar.model.FontMenu;
import MetropoliaAMKgroup02.BujoCalendar.view.CalendarOverviewController;
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

	/**
	 * Initializes the Font editing window.
	 */
	@FXML
	private void initialize() {
		FontMenu menu = new FontMenu();
		menu.setFontOverviewController(this);
		
		ObservableList<MenuItem> items = menu.getFontList();
		chooseFont.getItems().addAll(items);
		fontValue = fontValue(fontValue);
	}

	/**
	 * Sets the stage that the window appears.
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	 * Keeps tracking if the ok button is clicked.
	 * @return okClicked includes the value if the button is clicked or not.
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * When the ok button is clicked this method sends the information of the new font's name 
	 * to the right class based on the fontValue.
	 */
	@FXML
	private void handleOk() {
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
	
	/**
	 * FontValue includes the information of what text item on the calendar has been clicked and 
	 * which text's font styles are supposed to change.
	 * @param value is the value of the different text items on the calendar view 
	 * for example header texts or weekday names.
	 * @return fontValue is the value of the text items.
	 */
	public int fontValue(int value) {
		fontValue = value;
		return fontValue = value;
	}
	
	/**
	 * Gets the name of the new font style.
	 * @param font includes the new font style.
	 */
	public void sendNewWeekdayFont(String font) {
		newFont = font;
	}

	/**
	 * Closes the font editing window when a user clicks the cancel button.
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}
	
	/**
	 * Sets the calendarOverviewController.
	 */
	public void setCalendarOverviewController(CalendarOverviewController calController) {
		this.calController = calController;
	}
}
