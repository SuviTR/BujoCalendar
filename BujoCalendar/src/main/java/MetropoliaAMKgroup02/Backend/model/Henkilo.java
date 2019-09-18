package src.main.java.MetropoliaAMKgroup02.Backend.model;


/**
 * Vladimir 
 *
 */
public class Henkilo 
{

	private String etunimi, sukunimi, osoite, puhelinnumero, sahkoposti, osasto;
	
	public Henkilo(){}

	public void setEtunimi(String etunimi){
		this.etunimi = etunimi;
	}

	public void setSukunimi(String sukunimi){
		this.sukunimi = sukunimi;
	}

	public void setOsoite(String osoite){
		this.osoite = osoite;
	}

	public void setPuhelinnumero(String puhelinnumero){
		this.puhelinnumero = puhelinnumero;
	}

	public void setSahkoposti(String sahkoposti){
		this.sahkoposti = sahkoposti;
	}

	public void setOsasto(String Osasto){
		this.osasto = osasto;
	}

	public String getEtunimi() {
		return etunimi;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public String getOsoite() {
		return osoite;
	}

	public String getPuhelinnumero() {
		return puhelinnumero;
	}

	public String getSahkoposti() {
		return sahkoposti;
	}

	public String getOsasto() {
		return osasto;
	}
	
	
	
	
}
