package BujoCalendar.src.main.java.MetropoliaAMKgroup02.BujoCalendar.backend;

import java.util.Calendar;

/**
 * Vladimir 
 *
 */
public interface ITimeSpace 
{
	public void setDate(Calendar date);
	public Calendar date();
	public Calendar time();
	public void deleteDate();
}
