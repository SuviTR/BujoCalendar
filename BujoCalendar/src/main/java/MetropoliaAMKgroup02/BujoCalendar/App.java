import backend.Halytys;
import backend.Henkilo;
import backend.ITimeSpace;
import backend.Merkinta;
import backend.ToDoList;
import backend.ViewLuokka;
import backend.Kalenterimerkinta;
/**
 *Backend sovelus
 *
 */
public class App 
{

	
    public static void main( String[] args )
    {
	
    	//Merkintä luokka
	Merkinta merkinta = new Merkinta();
	ViewLuokka viewluokka = new ViewLuokka(1, "Uusi merkintä", "Vantaa", "Tärkeä tapaaminen", "vahva");
	merkinta.add(viewluokka);
	System.out.println("*****LISÄÄ MERKINTÄ*****");
	System.out.println("Merkintä nimi: " + merkinta.getNimi());
	System.out.println("Merkintä paikka: " + merkinta.getPaikka());
	System.out.println("Merkintä sisältö: " + merkinta.getSisalto());
	System.out.println("Merkintä prioriteetti: " + merkinta.getPrior());

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
	
	ITimeSpace halytys = new Halytys();
	
	kalenteri.addHalytys(halytys);
	//halytys.snooze(15);
	
	System.out.println("*****NÄYTTÄÄ OSALISTUJAT*****");
	kalenteri.showOsalistujat();
	
	System.out.println("*****NÄYTTÄÄ HÄLYTYKSET*****");
	kalenteri.showHalytykset();
	
	
		//ToDoList luokka
	ToDoList toDoList = new ToDoList("ready", "Projekti nimi");
	//toDoList.add(viewluokka);
	//toDoList.edit();	
				
    }
}
