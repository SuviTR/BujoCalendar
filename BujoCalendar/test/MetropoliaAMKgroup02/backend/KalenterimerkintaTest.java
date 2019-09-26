package backend;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

/**
 *Kalenteri merkintä test
 *
 */
public class KalenterimerkintaTest
{
	@BeforeAll
	Henkilo henkilo = new Henkilo();

	henkilo.setEtunimi("First name");
	henkilo.setSukunimi("Second name/Surname");
	henkilo.setOsoite("Town");
	henkilo.setPuhelinnumero("12345789");
	henkilo.setSahkoposti("test@mail.fi");
	henkilo.setOsasto("IT");
	
	Henkilo henkilo2 = new Henkilo();
	
	henkilo2.setEtunimi("First name another one");
	henkilo2.setSukunimi("Surname 2");
	henkilo2.setOsoite("Town2");
	henkilo2.setPuhelinnumero("1234");
	
	Kalenterimerkinta kalenteri = new Kalenterimerkinta();
	
	@Test
	@DisplayName("Test add henkilö listaan");
	kalenteri.addHenkilo(henkilo);
	kalenteri.addHenkilo(henkilo2);
	shownNimi = kalenteri.osolistujat.get(0).getEtunimi();
	shownSukunimi = kalenteri.osolistujat.get(0).getSukunimi();
	shownKaup = kalenteri.osolistujat.get(0).getPaikka();
	shownNumero = kalenteri.osolistujat.get(0).getPuhelinnumero();
	shownSahkop = kalenteri.osolistujat.get(0).getSahkoposti();
	shownOsasto = kalenteri.osolistujat.get(0).getOsasto();
	assertEquals("First name", shownNimi.toString(), "Nimi ei ole lisätty oikein"); 
	assertEquals("Second name/Surname", shownSukunimi.toString(), "Sukunimi ei ole lisätty oikein"); 
	assertEquals("Town", shownNumero.toString(), "Kaupunki ei ole lisätty oikein"); 
	assertEquals("12347895",shownNumero.toString(), "Puhelin numero ei ole lisätty oikein"); 
	assertEquals("test@mail.fi",shownSahkop.toString(), "Sähköposti osoite ei ole lisätty oikein"); 
	assertEquals("IT", shownOsasto.toString(), "Osasto ei ole lisätty oikein"); 

	shownNimi = kalenteri.osolistujat.get(1).getEtunimi();
	shownSukunimi = kalenteri.osolistujat.get(1).getSukunimi();
	shownKaup = kalenteri.osolistujat.get(1).getPaikka();
	shownNumero = kalenteri.osolistujat.get(1).getPuhelinnumero();
	shownSahkop = kalenteri.osolistujat.get(1).getSahkoposti();
	shownOsasto = kalenteri.osolistujat.get(1).getOsasto();
	assertEquals("First name another one", shownNimi.toString(), "Nimi ei ole lisätty oikein"); 
	assertEquals("Surname 2",shownSukunimi.toString(), "Sukunimi ei ole lisätty oikein"); 
	assertEquals("Town 2", shownNumero.toString(), "Kaupunki ei ole lisätty oikein"); 
	assertEquals("1234",shownNumero.toString(), "Puhelin numero ei ole lisätty oikein"); 
	assertEquals("null",showSahkop.toString(), "Sähköposti ei ole lisätty oikein"); 


	@Test
	@DisplayName("Test löytää henkilö");	
	kalenteri.loytaa("First name");
	assertEquals("First name", kalenteri.osolistujat.get(0).getEtunimi(); 
}
