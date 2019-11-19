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
       String country2 = "SE";
       
       Locale land = new Locale(lang2, country2);
       LangBundle  g = new LangBundle(land);
       List <Path> lista = g.ListAllFiles();
       g.printList(lista);
       g.loadLanguage(lista.get(0));
                // L10N -> Localisation
        // I10N -> Internationalisation
        
        //locale
        //ResourceBundle -> java.util.*;
        
      
}
}