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
import java.io.File;
import java.util.ListResourceBundle;
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
         Path path = Paths.get("C:\\Users\\Vision2\\git\\BujoCalendar\\BujoCalendar\\src\\main\\resources\\languages\\language_en.properties");
         try(Stream <Path> subPaths=Files.walk(path)){
             
        lista = subPaths.filter(Files::isRegularFile).collect( Collectors.toList());
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
            if(lang.toString().equals("language_en.properties")){
              String lang2 = "en";
              System.out.println("PRKL");  
              String country2 = "UK";
                String part =lang.getFileName().toString();
                String Path = "languages." + part;
                Locale land2 = new Locale(lang2,country2);
                ResourceBundle resource2 = ResourceBundle.getBundle("language_en.properties",land2);
                
                String str2 = resource2.getString("Name");
                System.out.println(str2);
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
