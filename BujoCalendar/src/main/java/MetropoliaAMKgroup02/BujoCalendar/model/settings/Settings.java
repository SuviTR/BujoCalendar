/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.BujoCalendar.model.settings;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heikki
 */
public class Settings {
        private List<Setting> settings; 
        private static Settings INSTANCE;

        private Settings() {
                this.settings = new ArrayList<>();
                this.createSettings();
        }

        public static Settings getInstance() {
            if(Settings.INSTANCE == null) {
                Settings.INSTANCE = new Settings();
            }

            return INSTANCE;
        }

        public List<Setting> getSettings() {
                return settings;
        }

        public void addSetting(Setting setting) {
                this.settings.add(setting);
        }

        private void createSettings() {
            this.addSetting(new LanguageSetting());
        }

}
