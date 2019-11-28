package MetropoliaAMKgroup02.BujoCalendar.utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kari
 */
import java.io.FilenameFilter;
import java.io.File;
import java.util.ListResourceBundle;
import java.util.ResourceBundle.Control;
import java.util.ResourceBundle;
import java.util.Locale;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public  class LangBundle extends ListResourceBundle{

        private Locale target;
        private List <Path> lista;
        private ResourceBundle svenska;
        private ResourceBundle english;
        private ResourceBundle suomi;
        private Scanner gateKeeper;
        
  /*
        Luokka, joka vastaa resurssitiedostojen lataamisesta.
        Sitä voi pyytää lataamaan tietyn resurssitiedoston
        Luokassa on myös toiminto, joka palauttaa listan
        saatavissa olevista resurssitiedostoista.
    
        public List getResourceFiles()
        public ResourceFile loadResourceFile()
    */
    
        LangBundle(Locale Languages){
            target = Languages;
        }
    
    public List ListAllFiles() throws IOException{
         

        
        Path path = Paths.get("C:\\Users\\Vision2\\git\\BujoCalendar\\BujoCalendar\\src\\main\\resources\\");
         try(Stream <Path> subPaths=Files.walk(path)){
              
            lista = subPaths.filter(Files::isRegularFile).filter(p ->p.endsWith(".properties")).collect( Collectors.toList());
        
            
         
            
         } catch(IOException e){
             e.printStackTrace();
         }
       
        return lista;
    }     
        
    void printList(List <Path> lista){
        
        for (int i=0 ;  i<lista.size(); i++){ 
        System.out.println(lista.get(i).getFileName());

        
        } 
    }
     
   
        void loadLanguage(Path lang) {
            if(lang.getFileName().toString().equals("language_se.properties")){
              String lang2 = "se";
              String country2 = "SE";
              String part =lang.getFileName().toString();
              //lang.
              String[] cutter = part.split("\\.");
              String road = cutter[0];
              System.out.println(road);
              Locale land2 = new Locale(lang2,country2);
              svenska = ResourceBundle.getBundle( road, land2);
             
              String str2 = svenska.getString("name");
              String str3 = svenska.getString("age");
              String str4 = svenska.getString("ad");
              System.out.println(str2);
              System.out.println(str3);
              System.out.println(str4);
            } if(lang.getFileName().toString().equals("language_en.properties")){
              String lang2 = "en";
              String country2 = "UK";
              String part =lang.getFileName().toString();
              String[] cutter = part.split("\\.");
              String road = cutter[0];
            //System.out.println(path);
              Locale land2 = new Locale(lang2,country2);
              english = ResourceBundle.getBundle(road, land2);
             
              String str2 = english.getString("name");
              String str3 = english.getString("age");
              String str4 = english.getString("ad");
              System.out.println(str2);
              System.out.println(str3);
              System.out.println(str4);
            } if(lang.getFileName().toString().equals("language_fi.properties")){
              String lang2 = "fi";
              String country2 = "FI";
              String part =lang.getFileName().toString();
              String[] cutter = part.split("\\.");
              String road = cutter[0];
            //System.out.println(path);
              Locale land2 = new Locale(lang2,country2);
              suomi = ResourceBundle.getBundle(road, land2);
             
              String str2 = suomi.getString("name");
              String str3 = suomi.getString("age");
              String str4 = suomi.getString("ad");
              System.out.println(str2);
              System.out.println(str3);
              System.out.println(str4);
            }
    }
    
    
    
    
    
     void openFile(){
         
         try{
             gateKeeper = new Scanner(new File("C:\\Users\\Vision2\\git\\BujoCalendar\\BujoCalendar\\src\\main\\resources\\languages\\language_en.properties"));
         } catch (Exception e){
            System.out.println("Houston, We have a problem!");
         } 
     }
     
     void readFile(){
         while(gateKeeper.hasNext()){
             String key = gateKeeper.next();
             String value = gateKeeper.next();
             
             System.out.println(key + " " + value);
         }
     }
     
     void closeFile(){
         gateKeeper.close();
     }
     
     
    
        
        
        
        void listingLanguages(Locale languages){
        
        
        System.out.println(languages.toString());
        if(languages.toString().equals("se,SE")){
        ResourceBundle resource = ResourceBundle.getBundle("language_se",languages);
        String key = resource.getString(resource.toString());
       
        }
    }
        
     /*   
      ResourceBundle resource = ResourceBundle.getBundle("language_en",land);
        
       String str = resource.getString("test");
       System.out.println(str);
       
       
       String lang2 = "se";
       String country2 = "SE";
       
        Locale land2 = new Locale(lang2,country2);
        ResourceBundle resource2 = ResourceBundle.getBundle("language_se",land2);
        
       String str2 = resource2.getString("Name");
       System.out.println(str2);

  
    protected Object[][] getContents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
    }
    */

    @Override
    protected Object[][] getContents() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
