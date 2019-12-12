/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.BujoCalendar.view;

import MetropoliaAMKgroup02.BujoCalendar.model.settings.Setting;
import MetropoliaAMKgroup02.BujoCalendar.model.settings.Settings;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
        }
    }

    private void drawComboBox(Setting s) {

        //List options = (List) s.getOptionValues();
        int i = 0;
        for(String v : (List<String>) s.getOptionValues()) {
            settingPane.add(new Label(v), i, 0);
            i++;
        }
    }

    private void drawCheckBox(Setting s) {

    }

    private void drawTextField(Setting s) {

    }

    /*
    private ComboBox<Locale> createComboBox() {
        ComboBox<Locale> comboBox = new ComboBox<>();
        ObservableList<Locale> options = FXCollections.observableArrayList(Locale.ENGLISH, Locale.GERMAN);
        comboBox.setItems(options);
        comboBox.setConverter(new StringConverter<Locale>() {
            @Override
            public String toString(Locale object) {
                return object.getDisplayLanguage();
            }

            @Override
            public Locale fromString(String string) {
                return null;
            }
        });
        comboBox.setCellFactory(p -> new LanguageListCell());
        comboBox.getSelectionModel().selectFirst();

        comboBox.setOnAction(event -> loadView(comboBox.getSelectionModel().getSelectedItem()));
        return comboBox;
    }
*/
}
