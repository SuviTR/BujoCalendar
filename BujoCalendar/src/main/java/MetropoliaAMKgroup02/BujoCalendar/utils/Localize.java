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
        
    
 
/*        Locale[] languages = {
            new Locale("en", "UK"),
            new Locale("fi", "FI"),
            new Locale("se","SE")
        };*/
       

       String lang2 = "se";
       String location2 = "EN";
       
       
      
       LangBundlePro country = new LangBundlePro(new Locale(lang2));
       ResourceBundle language = country.LoadResourceFile(new Locale(lang2));
       
      String list = String.join(",", language.keySet());
      System.out.println(language.getBaseBundleName());
      System.out.println(list);
      
       
      System.out.println(language.getString("name"));
      System.out.println(language.getString("age"));
      System.out.println(language.getString("ad"));
      
      /*
       LangBundle  g = new LangBundle(land);
       List <Path> lista = g.ListAllFiles();
       g.printList(lista);
       System.out.println("******************************************");
       System.out.println();
       g.loadLanguage(lista.get(0));
       System.out.println();
       g.loadLanguage(lista.get(1));
       System.out.println();
       g.loadLanguage(lista.get(2));
       */
       
       
       //g.loadLanguage(lista2.get(2));
                // L10N -> Localisation
        // I10N -> Internationalisation
        
        //locale
        //ResourceBundle -> java.util.*;
        
      
}
}