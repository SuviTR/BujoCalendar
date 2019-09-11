package MetropoliaAMKgroup02.BujoCalendar.backend;

/**
 * Vladimir 
 *
 */
public class ToDoList extends Merkintä
{
	public enum status {inprog, pending, ready, done, def};
	public string projekti;
	
	public ToDoList(enum status, string projekti) {
		this.status = status;
		this.projekti = projekti;	
	}

}

