package backend;


/**
 * View Luokka on tehty testauksen varten
 *
 */
public class ViewLuokka
{
	public String prioriteetti;
	private int merkintaID;
	
	private String nimi, paikka, sisalto;
	
	public ViewLuokka(int merkintaID, String nimi, String paikka, String sisalto, String prioriteetti){
		this.merkintaID = merkintaID;
		this.nimi = nimi;	
		this.paikka = paikka;
		this.sisalto = sisalto;
		this.prioriteetti = prioriteetti;
	}

	public String getNimi(){
		return nimi;	
	}

	public String getPaikka(){
		return paikka;	
	}
	
	public String getSisalto(){
		return sisalto;
	}

	public String getPrioriteetti(){
		return prioriteetti;
	}

}
