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


public  class LangBundlePro extends ListResourceBundle{

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

    LangBundlePro(Locale land) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  
   
      ResourceBundle LoadResourceFile(Locale land) {
            //String url = "C:\\Users\\Vision2\\git\\BujoCalendar\\BujoCalendar\\src\\main\\resources\\";
            String lan = "language_"+ land.getLanguage();
            language = ResourceBundle.getBundle(lan,land);
           /* 
            String list = String.join(",", language.keySet());
            String[] keys = list.split(",");
            String key1 = keys[0];
            String key2 = keys[1];
            String key3 = keys[2];
              
            
               name= language.getString(key2);
               age = language.getString(key3);
               ad = language.getString(key1);
             
              System.out.println(list);
              System.out.println(name);
              System.out.println(age);
              System.out.println(ad);
            */
           return language;
            }

    @Override
    protected Object[][] getContents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

