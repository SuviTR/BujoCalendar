package MetropoliaAMKgroup02.BujoCalendar.backend;

/**
 *Backend sovelus
 *
 */
public class App 
{

	
    public static void main( String[] args )
    {
	
	Merkintä merkintä = new Merkintä();
	KalenteriMerkinta kalenteri = new KalenteriMerkintä();
	ToDoList toDoList = new ToDoList(high, "Projekti nimi");
	
	VeiwLoukka = new ViewLuokka(1, "Uusi tapahtuma", "Helsinki", "lsdkfjglasdkjfnv zdn daf", high);	
	
	Henkilo henkilo = new Henkilo();
	henkilo.setNimi("Vladimir");
	henkilo.setSukunimi("Gavrilov");
	henkilo.setOsoite("Helsinki");
	henkilo.setPuhelinnumero("0449890965");
	

	merkintä.add();
	merkinta.toString();

	
	kalenteri.addHenkilö(henkilo);	
	kalenteri.addHalytys(halytys);
	kalenteri.snooze(15);
	
	kalenteri.showOsalistujat();
	kalenteri.showHalytykset();
	
	toDoList.add();
	toDoList.edit();	
				
    }
}
