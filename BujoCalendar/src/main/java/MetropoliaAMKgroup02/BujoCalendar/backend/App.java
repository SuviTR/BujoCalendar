package MetropoliaAMKgroup02.BujoCalendar.backend;

/**
 *Backend sovelus
 *
 */
public class App 
{
	private Merkintä merkintä;
	private Database database;
	
	
	//Mietin että pitää olla joku "DataAccessObject"
	database = new Database();

	public void addMerkintä(){
		merkintä = new Merkintä();
		merkintä.add();
	}
	
	public void editMerkintä(){
		merkintä.edit(int database.getMerkintäId);
	}

	
}

	public void edit(

	
    public static void main( String[] args )
    {
	
    }
}
