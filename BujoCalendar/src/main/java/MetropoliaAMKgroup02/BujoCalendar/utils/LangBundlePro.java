package MetropoliaAMKgroup02.BujoCalendar.utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vision2
 */

import java.util.ListResourceBundle;
import java.util.ResourceBundle.Control;
import java.util.ResourceBundle;
import java.util.Locale;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public  class LangBundlePro {

        private Locale land;
        private ResourceBundle language;
        public String name = "";
        public String age = "";
        public String ad = "";

        
  /*
        Luokka, joka vastaa resurssitiedostojen lataamisesta.
        Sitä voi pyytää lataamaan tietyn resurssitiedoston
        Luokassa on myös toiminto, joka palauttaa listan
        saatavissa olevista resurssitiedostoista.
    
        public List getResourceFiles()
        public ResourceFile loadResourceFile()
    */

    public LangBundlePro(Locale land) {
        loadLanguage(land);
    }

    public void loadLanguage(Locale land) {
            String lan = "language_"+ land.getLanguage();
            language = ResourceBundle.getBundle(lan,land);
    }
  
    public String getString(String key){
        return language.getString(key);
    }


}

