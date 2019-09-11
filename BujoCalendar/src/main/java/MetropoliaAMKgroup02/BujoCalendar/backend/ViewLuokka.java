package MetropoliaAMKgroup02.BujoCalendar.backend;

/**
 * View Luokka on tehty testauksen varten
 *
 */
public class ViewLuokka
{
	public enum prioriteetti {small, middle, high};
	private int merkintäID;
	
	private String nimi, paikka, sisalto;
	
	public ViewLuokka(int merkintäID, string nimi, string paikka, string sisältö, enum prioriteetti){
		this.merkintäID = merkintäID;
		this.nimi = nimi;	
		this.paikka = paikka;
		this.sisältö = sisältö;
		this.prioriteetti = prioriteetti;
	}

	public string getNimi(){
		return nimi;	
	}

	public string getPaikka(){
		return paikka;	
	}
	
	public string getSisältö(){
		return sisältö;	
	}

	public enum getPrioriteetti(){
		return prioriteetti;
	}

}
