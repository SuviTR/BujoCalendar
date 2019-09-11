package MetropoliaAMKgroup02.BujoCalendar.backend;

/**
 * Vladimir 
 *
 */
public class Merkintä implements ITimeSpace
{
	public enum prioriteetti {small, middle, high};
	private int merkintäID;
	
	private String nimi, paikka, sisaltö;
	LocalDate date;
	LocalTime time;
	

	public Merkintä(String nimi) {
		this.nimi = nimi;	
	}

	public void Add(){
		
		nimi = viewLuokka.getNimi();
		paikka = viewLuokka.getPaikka();
		sisältö = viewLuokka.getSisältö();
		prioriteetti = viewLuokka.getPrioriteetti();
	}

	public void Edit(int merkintäID){
		
		this.merkintäID = merkintäID;

		nimi = viewLuokka.getNimi();
		paikka = viewLuokka.getPaikka();
		sisältö = viewLuokka.getSisältö();
		prioriteetti = viewLuokka.getPrioriteetti();

	}
	
	public void snooze(int snoozer){
		snoozeTime = time.now() + snoozer;		
	}

}

