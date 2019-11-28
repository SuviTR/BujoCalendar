/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.BujoCalendar.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author heikki
 */
public class Settings {
        private List<Setting> settings; 

        public Settings() {
                this.settings = new ArrayList<>();
        }

        public List<Setting> getSettings() {
                return settings;
        }

        public void setSetting(Setting setting) {
                this.settings.add(setting);
        }

}
