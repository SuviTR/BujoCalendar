package MetropoliaAMKgroup02.BujoCalendar.backend;

/**
 * Vladimir 
 *
 */
public class MerkintäTest
{
	private String nimi, paikka, sisältö;
	private enum prior{small, middle, high};
	Date date;
	Date time;

	@BeforeAll
	Merkintä merkintä = new Merkintä("Uusi merkintä");
	ViewLuokka view = new ViewLuokka(1, "Uusi tapahtuma", "Helsinki", "Sovittu tapaminen kahvilassa", high);

	@Test
	@DisplayName
	
	public void addTest(){
		merkintä.Add();	
		assertEquals();
	}

	public void editTest(int merkintäID){
	}
	
	public void snoozeTest(int snoozer){
	}
	
	public void muokkaaDate(){}
	public void muokkaTime(){}
	

}

