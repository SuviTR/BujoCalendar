package MetropoliaAMKgroup02.BujoCalendar.backend;

import java.time.LocalTime; 
import java.time.LocalDate; 
/**
 * Vladimir 
 *
 */
public class Hälytys interface ITimeSpace
{
	public enum ääni {huomautus, valmis, pulssi };
	private boolean status = true;

	LocalTime localTime;
	LocalDate localDate;
	
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
