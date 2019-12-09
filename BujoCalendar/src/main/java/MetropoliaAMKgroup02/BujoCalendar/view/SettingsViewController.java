/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.BujoCalendar.view;

import MetropoliaAMKgroup02.BujoCalendar.model.settings.Setting;
import MetropoliaAMKgroup02.BujoCalendar.model.settings.Settings;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author heikki
 */
public class SettingsViewController {

    private Settings settings;

    @FXML
    private GridPane settingPane;
    
    @FXML
    private void initialize() {

        this.settings = Settings.getInstance();

        drawSettings();
    }

    int position=0;

    private void drawSettings() {


        for (Setting s : settings.getSettings()) {
            switch(s.getType()) {
                case BOOLEAN:
                    drawCheckBox(s); 
                    break;
                case LIST:
                    drawComboBox(s);
                    break;
                case STRING:
                    drawTextField(s);
                    break;
            }
	position++;
        }
    }

    private void drawComboBox(Setting s) {

	ComboBox comboBox= createComboBox(s.getOptionValues());
        settingPane.add(comboBox, position, 0);
    }

    private void drawCheckBox(Setting s) {

    	boolean value = (boolean) s.getValue();
	CheckBox checkBox = new CheckBox(s.getName());
	checkBox.setAllowIndeterminate(true);
        settingPane.add(checkBox, position, 0);

    }

    private void drawTextField(Setting s) {

	String value = (String) s.getValue();
	    TextField textField = new TextField(value);
        settingPane.add(textField, position, 0);

    }

   
    private ComboBox<String> createComboBox(List list) {
        ComboBox<String> comboBox = new ComboBox<>();
        ObservableList<String> options = FXCollections.observableArrayList(list);
        comboBox.setItems(options);
        comboBox.getSelectionModel().selectFirst();

        return comboBox;
    }


}
