package backend;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Vladimir 
 *
 */
public class Merkinta
{
	public enum Prior {SMALL, MIDDLE, HIGH};
	public Prior prior;

	private String nimi, paikka, sisalto;
	LocalDate date;
	LocalTime time; 
	

	public Merkinta() {}

	public void add(ViewLuokka viewLuokka){
		
		nimi = viewLuokka.getNimi();
		paikka = viewLuokka.getPaikka();
		sisalto = viewLuokka.getSisalto();
		prior = viewLuokka.getPrioriteetti();
	}

	public void edit(ViewLuokka viewLuokka){
		
		nimi = viewLuokka.getNimi();
		paikka = viewLuokka.getPaikka();
		sisalto = viewLuokka.getSisalto();
		prior = viewLuokka.getPrioriteetti();

	}
	
	public String getNimi() {
		return nimi;
	}
	
	public String getPaikka() {
		return paikka;
	}
	
	public String getSisalto() {
		return sisalto;
	}
	
	public Prior getPrior() {
		return prior;
	}
	
	public void snooze(int snoozer){
		snoozeTime = time.now() + snoozer;		
	}

}

