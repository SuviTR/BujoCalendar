package MetropoliaAMKgroup02.backend;


/**
 * View Luokka on tehty testauksen varten
 *
 */
public class ViewLuokka
{
	private int merkintaID;
	
	private String nimi, paikka, sisalto;
	Merkinta.Prior prior;
	
	public ViewLuokka(int merkintaID, String nimi, String paikka, String sisalto, Merkinta.Prior prioriteetti ){
		this.merkintaID = merkintaID;
		this.nimi = nimi;	
		this.paikka = paikka;
		this.sisalto = sisalto;
		this.prior = prioriteetti;
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

	public Merkinta.Prior getPrioriteetti(){
		return prior;
	}

}
