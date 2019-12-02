/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.BujoCalendar.model.settings;

/**
 *
 * @author heikki
 */
public interface Setting<T> {

        public enum SettingType {
                DROPDOWN,
                CHECKBOX,
                TEXTFIELD
        };

        public SettingType getType();
        public String getName();
        public String getDescription();
        public T getValue();
        
}
