package MetropoliaAMKgroup02.BujoCalendar.backend;

import java.time.LocalTime; 
import java.time.LocalDate; 
/**
 * Vladimir 
 *
 */
public class Hälytys interface TimeSpace
{
	public enum ääni {huomautus, valmis, pulssi };
	private boolean status = true;

	LocalTime time;
	LocalDate date;

	private String nimi, paikka, sisalto;
	
	public Hälytys (enum ääni, boolean status) {
		this.ääni = ääni;
		this.status = status;	
	}
	
	public LocalTime getTime(){
		return LocalTime.now();
	}

	public LocalDate getDay(){
		return LocalDate.now();
	}

	public void snooze(int snoozer){
		this.time = currentTime + snoozer;
		
	}

	public void toogle() {
		status = false;
	}
}
