package MetropoliaAMKgroup02.backend;

import java.util.Calendar;
import java.persistence.*;

/**
 * Vladimir 
 *
 */
@Entity
@Table(name="Merkintoja")
public class Merkinta
{
	@Id
	@GeneratedValue

	private Long id;

	public enum Prior {SMALL, MIDDLE, HIGH};
	public Prior prior;

	private String nimi, paikka, sisalto;
	Calendar date;

	public Merkinta() {}

	public Merkinta(String name){
		this.nimi = nimi;
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
	
	public void setNimi(String nimi){
		this.nimi = nimi;
	}

	public String getNimi() {
		return nimi;
	}

	public void setPaikka(String paikka){
		this.paikka = paikka;
	}

	public String getPaikka() {
		return paikka;
	}
	
	public void setSisalto(String sisalto){
		this.sisalto = sisalto;
	}

	public String getSisalto() {
		return sisalto;
	}
	
	public void setPrior(Prior prior){
		this.prior = prior;
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

