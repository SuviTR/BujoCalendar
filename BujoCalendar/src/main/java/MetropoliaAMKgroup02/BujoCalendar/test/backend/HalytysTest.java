package backend;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

/**
 *Hälytys Test
 *
 */
public class HalytysTest
{

	Halytys halytys = new Halytys("ääni");

	Calendar date = Calendar.getInstance();
	date.set(2019, 9, 16, 11, 19);

	@Test
	@DisplayName ("Test lisää hälytys")
	public void testLisaaHalytys(){
		
	halytys.setDate(date);
	assertEquals(date.getTime(), halytys.date().getTime(), "Päivämäärä ie ole asennettu oikein");
	}	
}	
