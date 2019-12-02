/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.BujoCalendar.controller;

import MetropoliaAMKgroup02.BujoCalendar.model.Dates;
import MetropoliaAMKgroup02.BujoCalendar.utils.LangBundlePro;
import MetropoliaAMKgroup02.BujoCalendar.view.CalendarOverviewController;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author heikki
 */
public class AppController {

        private static AppController controller = null;

        private final Dates dates;
        private final Locale locale;
        private CalendarOverviewController calOverviewController;
        private LangBundlePro country;

        private MainApp mainApp;

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
        
        public void SetLangBundlePro (LangBundlePro country){
           
            this.country =  country;
        }
        
        public String getTranslation(String key){
            
          return country.getString(key);
       
        }
        public Dates getDates() {
                return this.dates;
        }

        public Locale getLocale() {
                return locale;
        }

        public void setCalendarOverviewController(CalendarOverviewController ctrl) {
                this.calOverviewController = ctrl;
        }

        public CalendarOverviewController getCalendarOverviewController() {
                return this.calOverviewController;
        }

        public void setMainApp(MainApp mainApp) {
                if(this.mainApp == null) {
                        this.mainApp = mainApp;
                }
        }

        public MainApp getMainApp() {
                return this.mainApp;
        }

}
