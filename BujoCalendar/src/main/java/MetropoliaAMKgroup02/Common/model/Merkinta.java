package MetropoliaAMKgroup02.Common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Calendar;
import javax.persistence.*;

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

	private int id;
	private String nimi, paikka, sisalto;

	public enum Prior {SMALL, MIDDLE, HIGH};
	public Prior prior;

	
	private Calendar startDate;
	private Calendar endDate;

	public Merkinta() {}

	public Merkinta(String nimi){
		this.nimi = nimi;
	}

	public int getId(){
		return id;
	}

	public void setId(int id){
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
	
	public void setStartDate(Calendar date){
		this.startDate = date;
	}
	
	public String getStartDate(){
		return String.format("%tF" , startDate);
	}

	public void setEndDate(Calendar date){
		this.endDate = date;
	}
	
	public String getEndDate(){
		return String.format("%tF" , endDate);
	}

	@JsonIgnore
	public String getTime(){
		return String.format("%tR" , startDate);
	}

	public void deleteDate(){
		//return null;
	}

	@JsonIgnore
	public int getHour() {
		return startDate.get(Calendar.HOUR);
	}


	@JsonIgnore
	public int getEndHour() {
		return endDate.get(Calendar.HOUR);
	}

	@JsonIgnore
	public Calendar getStart() {
		return startDate;
	}

}

