/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.BujoCalendar.view;

import MetropoliaAMKgroup02.BujoCalendar.model.settings.Setting;
import MetropoliaAMKgroup02.BujoCalendar.model.settings.Settings;
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
           settingPane.add(new Label(s.getName()), 0, 0);
        }
    }
}
