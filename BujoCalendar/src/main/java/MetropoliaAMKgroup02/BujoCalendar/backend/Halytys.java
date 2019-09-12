package backend;


import java.util.Date; 
/**
 * Vladimir 
 *
 */
public class Halytys implements ITimeSpace
{
	public String aani;
	int status; //on 1, off 0
	Date date; 

	public Halytys(String aani){
		this.aani = aani;
		this.status = 1;
	}

	//Snooze asentaminen
	@Override
	public void setDate(Date date){
		this.date = date;
		status = 1;
	}

	//Toggle asentaminen
	@Override
	public void deleteDate() {
		status = 0;
	}



}
