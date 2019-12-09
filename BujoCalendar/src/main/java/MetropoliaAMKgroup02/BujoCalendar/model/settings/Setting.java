/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.BujoCalendar.model.settings;

import java.util.List;

/**
 *
 * @author heikki
 */
public interface Setting {

        public enum Type {
            LIST,
            BOOLEAN,
            STRING
        };

        public Type getType();
        public String getName();
        public String getDescription();
        public String getValueRepresentation();
        public Object getValue();
        public List getOptionValues();
        public void saveSetting();
        public void loadSetting();
        
}
