import java.util.Calendar;

import MetropoliaAMKgroup02.backend.*;
/**
 *Backend sovelus
 *
 */
public class App 
{

	
    public static void main( String[] args )
    {
	
    	//Merkintä luokka
	/*Merkinta merkinta = new Merkinta();
	ViewLuokka viewluokka = new ViewLuokka(1, "Uusi merkintä", "Vantaa", "Tärkeä tapaaminen", Merkinta.Prior.HIGH);
	merkinta.add(viewluokka);
	System.out.println("*****LISÄÄ MERKINTÄ*****");
	System.out.println("Merkintä nimi: " + merkinta.getNimi());
	System.out.println("Merkintä paikka: " + merkinta.getPaikka());
	System.out.println("Merkintä sisältö: " + merkinta.getSisalto());
	System.out.println("Merkintä prioriteetti: " + merkinta.getPrior());
	*/
		//Henkilö luokka
	Henkilo henkilo = new Henkilo();
	
	henkilo.setEtunimi("Vladimir");
	henkilo.setSukunimi("Gavrilov");
	henkilo.setOsoite("Helsinki");
	henkilo.setPuhelinnumero("0449890965");
	
	Henkilo henkilo2 = new Henkilo();
	
	henkilo2.setEtunimi("Heikki");
	henkilo2.setSukunimi("Ketoharju");
	henkilo2.setOsoite("Helsinki");
	henkilo2.setPuhelinnumero("0441234567");
	
	Henkilo henkilo3 = new Henkilo();
	
	henkilo3.setEtunimi("Suvi");
	henkilo3.setSukunimi("Rannisto");
	henkilo3.setOsoite("Helsinki");
	henkilo3.setPuhelinnumero("0441234567");
	
	Henkilo henkilo4 = new Henkilo();
	
	henkilo4.setEtunimi("Kari");
	henkilo4.setSukunimi("Lampi");
	henkilo4.setOsoite("Helsinki");
	henkilo4.setPuhelinnumero("0441234567");
		//Kalenterimerkinta luokka
	Kalenterimerkinta kalenteri = new Kalenterimerkinta();
	
	kalenteri.addHenkilo(henkilo);
	kalenteri.addHenkilo(henkilo2);
	kalenteri.addHenkilo(henkilo3);
	kalenteri.addHenkilo(henkilo4);
	
		//Hälytys luokka
	ITimeSpace halytys = new Halytys("huomautus");
	
	Calendar date = Calendar.getInstance();
	date.set(2019, 11, 10, 10, 15);
	
	halytys.setDate(date);	
	kalenteri.addHalytys(halytys);
	halytys.deleteDate();	
	
	
	System.out.println("*****NÄYTTÄÄ OSALISTUJAT*****");
	kalenteri.showOsalistujat();
	System.out.println(kalenteri.osalistujat.get(0).getEtunimi());
	System.out.println("*****NÄYTTÄÄ HÄLYTYKSET*****");
	kalenteri.showHalytykset();
	
	
		//ToDoList luokka
	ViewLuokka toDoData = new ViewLuokka(2, "Uusi tehtävä", "Helsinki", "Tehtävä sisältö", Merkinta.Prior.SMALL);
	ToDoList toDoList = new ToDoList("Ready", "Projekti nimi");
	toDoList.add(toDoData);
	System.out.println("*****LISÄÄ TEHTÄVÄ*****");
	System.out.println("Tehtävä nimi: " + toDoList.getNimi());
	System.out.println("Tehtävä paikka: " + toDoList.getPaikka());
	System.out.println("Tehtävä sisältö: " + toDoList.getSisalto());
	System.out.println("Tehtävä prioriteetti: " +  toDoList.getPrior());
}
}
