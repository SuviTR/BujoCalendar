package MetropoliaAMKgroup02.backend;

import java.util.Calendar;

/**
 * Vladimir 
 *
 */
public abstract class Merkinta
{
	public enum Prior {SMALL, MIDDLE, HIGH};
	public Prior prior;

	private String nimi, paikka, sisalto;
	Calendar date;

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
	
	public void setDate(Calendar date){
		this.date = date;
	}
	
	public String getDate(){
		return String.format("%tF" , date);
	}

	public String getTime(){
		return String.format("%tR" , date);
	}

	public void deleteDate(){
		//return null;
	}

}

