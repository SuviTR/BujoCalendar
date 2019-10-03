package MetropoliaAMKgroup02.Backend.model;


import java.util.Calendar;
import java.util.Date; 
/**
 * Vladimir 
 *
 */
public class Halytys implements ITimeSpace
{
	public String aani;
	int status; //on 1, off 0
	public Calendar date = Calendar.getInstance(); 

	public Halytys(String aani){
		this.aani = aani;
		this.status = 1;
	}

	//Snooze asentaminen
	public void setDate(Calendar date){
		System.out.println(date.getTime());
		this.date = date;
		status = 1;
	}

	//Toggle asentaminen
	@Override
	public void deleteDate() {
		status = 0;
	}

	@Override
	public Calendar date() {
		return date;
	}

	@Override
	public Calendar time() {
		return date;
	}



}
