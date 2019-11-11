/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.BujoCalendar.controller;

import MetropoliaAMKgroup02.BujoCalendar.model.Dates;
import java.util.Locale;

/**
 *
 * @author heikki
 */
public class AppController {

        private static AppController controller = null;

        private final Dates dates;
        private final Locale locale;

        private AppController() {
                this.dates = new Dates();
                this.locale = dates.getLocale();
        }

        public static AppController getInstance() {
                if(controller == null) {
                        controller = new AppController();
                } 

                return controller;
        }

        public Dates getDates() {
                return this.dates;
        }

        public Locale getLocale() {
                return locale;
        }

        
}
