/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.BujoCalendar.utils;

import java.util.Locale;
import java.util.ResourceBundle;
import MetropoliaAMKgroup02.BujoCalendar.utils.LangBundle;
import java.util.ListResourceBundle;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 *
 * @author Vision2
 */
public class Localize {

        public static void main(String[] args) throws IOException {
        
    
      

       String lang2 = "dk";
       
       LangBundlePro country = new LangBundlePro(new Locale(lang2));
       country.LoadResourceFile(new Locale(lang2));
       
   
      
       
      System.out.println(country.getString("name"));
      System.out.println(country.getString("age"));
      System.out.println(country.getString("ad"));
      
      System.out.println(country.getString("monday"));
      System.out.println(country.getString("tuesday"));
      System.out.println(country.getString("wednesday"));
      System.out.println(country.getString("thursday"));
      System.out.println(country.getString("friday"));
      System.out.println(country.getString("saturday"));
      System.out.println(country.getString("sunday"));
      
       
       //g.loadLanguage(lista2.get(2));
                // L10N -> Localisation
        // I10N -> Internationalisation
        
        //locale
        //ResourceBundle -> java.util.*;
        
      
}
}