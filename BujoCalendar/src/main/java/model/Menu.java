package model;

import java.awt.GraphicsEnvironment;
import javafx.scene.control.*; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.collections.*;
import view.FontOverviewController;

public class Menu {
	
	private FontOverviewController fontController;
	private ObservableList<MenuItem> calendarFonts;
	private MenuItem menuItem;
	private String newFont;

	//======= Getting available fonts ======= 
	private String[] FontList() {
		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		return fonts;
	}
	
	//======= Making MenuItem list of fonts ======= 
	//------- Adding id and action to every MenuItem ------- 
	public ObservableList<MenuItem> getFontList() {

		calendarFonts = FXCollections.observableArrayList();
		EventHandler<ActionEvent> action = changeFont();

		String[] fonts = FontList();
		
		for (int i = 0; i < fonts.length; i++) {
			MenuItem fontName = new MenuItem(fonts[i]);
			fontName.setId(Integer.toString(i));
			fontName.setOnAction(action);
			calendarFonts.add(fontName);
		}
		return calendarFonts;
	}
	
	//======= Adding EventHandlers to MenuItems ======= 
	//======= Letting CalendarOverviewController know the new font =======
	private EventHandler<ActionEvent> changeFont() {	
		return new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				menuItem = (MenuItem) event.getSource();
				newFont = menuItem.getText();
				fontController.sendNewFont(newFont);
			}
		};
	}
	
	public void setFontOverviewController(FontOverviewController controller) {
		this.fontController = controller;
	}
}