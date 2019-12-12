/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.BujoCalendar.model.settings;

import MetropoliaAMKgroup02.BujoCalendar.controller.AppController;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author heikki
 */
public class LanguageSetting implements Setting {

    private final Type type = LanguageSetting.Type.LIST;
    private final String name = "languageSettingName";
    private final String description = "languageSettingDescription";
    private List<Locale> options;
    private Locale value;

    public LanguageSetting() {
        this.options = new ArrayList<>();
        options.add(new Locale("en"));
        options.add(new Locale("fi"));
        options.add(new Locale("sv"));
        options.add(new Locale("da"));
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public String getName() {
        //return this.name;
        return AppController.getInstance().getTranslation(this.name);
    }

    @Override
    public String getDescription() {
        return AppController.getInstance().getTranslation(this.description);
    }

    @Override
    public Locale getValue() {
        return this.value;
    }

    @Override
    public void setValue(int index) {
        this.value = this.options.get(index);
    }
    

    @Override
    public String getValueRepresentation() {
        return this.value.getDisplayName();
    }

    public List<String> getOptionValues() {
        List<String> list = new ArrayList<>();
        for (Locale l : options) {
            list.add(l.getDisplayName());
        }

        return list;
    }

    @Override
    public void saveSetting() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadSetting() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
