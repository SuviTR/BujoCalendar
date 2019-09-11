package backend;


import java.time.LocalTime; 
import java.time.LocalDate; 
/**
 * Vladimir 
 *
 */
public class Halytys implements ITimeSpace
{
	public String aani;
	int status; //on 1, off 0

	@Override
	public void snooze(int snoozer){
		localTime = LocalTime.now() + snoozer;
		
	}
	@Override
	public void toogle() {
		status = 0;
	}



}
