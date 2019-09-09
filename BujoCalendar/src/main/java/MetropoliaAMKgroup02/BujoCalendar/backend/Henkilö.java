package MetropoliaAMKgroup02.BujoCalendar.backend;

/**
 * Vladimir 
 *
 */
public class Henkilö 
{
	private String etunimi, sukunimi, osoite, puhelinnumero, sähköposti, osasto;
	
	public Henkilö(){
		etunimi = view.getEtunimi();
		sukunimi = view.getSukunimi();
		osoite = view.getOsoite();
		puhelinnumero = view.getPuhelinnumero();
		sähköposti = view.getSähköposti();
		osasto = view.getOsasto();
	}

}
