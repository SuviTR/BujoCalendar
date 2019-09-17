package backend;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

/**
 *Henkilö Test
 *
 */
public class HenkiloTest
{
	Henkilo henkilo = new Henkilo();

	@Test
	@DisplayName ("Test lisää nimi")
	public void testLisaaNimi(){
		
	henkilo.setEtunimi("Nimi");
	assertEquals("Nimi", henkilo.getEtunimi(), "Set nimi metodi ei toimi oikein");
	}	
	
	@Test
	public void testLisaaSukunimi(){
		henkilo.setSukunimi("Sukunimi");
		assertEquals("Sukunimi", henkilo.getSukunimi(), "Set sukunimi metodi ei toimi oikein");
	}

	@Test
	public void testLisaaOsoite(){
		henkilo.setOsoite("Osoite");
		assertEquals("Osoite", henkilo.getOsoite(), "Set osoite metodi ei toimi oikein");
	}

	@Test
	@DisplayName ("Test lisää puhelin numero")
	public void testLisaaPuhelinnumero(){
		henkilo.setPuhelinnumero("32523452343423");
		assertEquals("32523452343423", henkilo.getPuhelinnumero(), "Set puhelinnumero metodi ei toimi oikein");
	}

	@Test
	public void testLisaaSahkoposti(){
		henkilo.setSahkoposti("test@osoite.fi");
		assertEquals("test@osoite.fi", henkilo.getSahkoposti(), "Set sahkoposti metodi ei toimi oikein");
	}

	@Test
	public void testLisaaOsasto(){
		henkilo.setOsasto("Joku osasto");
		assertEquals("Joku osasto", henkilo.getOsasto(), "Set osasto metodi ei toimi oikein");
	}
}
