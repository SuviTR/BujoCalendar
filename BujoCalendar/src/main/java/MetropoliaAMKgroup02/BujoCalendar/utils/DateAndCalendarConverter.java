/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.BujoCalendar.utils;

import MetropoliaAMKgroup02.BujoCalendar.controller.AppController;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

/**
 *
 * @author heikki
 */
public class DateAndCalendarConverter {
        
        public LocalDate CalToLocalDate(Calendar cal) {
                LocalDate date = LocalDate.of(
                        cal.get(Calendar.YEAR),
                        // Calendar 0-11, LocalDate 1-12
                        cal.get(Calendar.MONTH) + 1,
                        cal.get(Calendar.DAY_OF_MONTH)
                );
                return date;
        }

        public LocalTime CalToLocalTime(Calendar cal) {
                LocalTime time = LocalTime.of(cal.get(Calendar.HOUR_OF_DAY), 
                        cal.get(Calendar.MINUTE));
                return time;
        }

        public Calendar LocalsToCal(LocalDate date, LocalTime time) {

                Calendar cal = Calendar.getInstance(AppController.getInstance()
                        .getLocale());

                cal.set(date.getYear(),
                        // Calendar 0-11, LocalDate 1-12
                        date.getMonthValue()- 1,
                        date.getDayOfMonth());
                cal.set(Calendar.HOUR_OF_DAY, time.getHour());
                cal.set(Calendar.MINUTE, time.getMinute());
                return cal;
        }

        public LocalTime createLocalTime(String hour, String minute) {
                return LocalTime.of(Integer.parseInt(hour), Integer.parseInt(minute));
        }

        public String hourRepresentation(Calendar cal) {
                int hour = cal.get(Calendar.HOUR_OF_DAY);
                return String.format("%02d", hour);
        }

        public String minuteRepresentation(Calendar cal) {
                int min = cal.get(Calendar.MINUTE);
                return String.format("%02d", min);
        }

        private void LocalDate(int parseInt, int parseInt0) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
}
