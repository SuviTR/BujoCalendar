package backend;

import java.util.List;
import java.util.ArrayList;
/**
 * Vladimir 
 *
 */
public class Kalenterimerkinta extends Merkinta
{
	List<Henkilo> osalistujat = new ArrayList<>();
	List<ITimeSpace> halytykset = new ArrayList<>();
	
	public void addHenkilo(Henkilo henkilo){
		osalistujat.add(henkilo);				
	}
	public void showOsalistujat(){
		for (Henkilo o : osalistujat) {
			System.out.println("......");
			System.out.println("Nimi: " + o.getEtunimi() + ", Sukunimi: " + o.getSukunimi() + ", Osoite: " + o.getOsoite());
			System.out.println("Puhelin numero: " + o.getPuhelinnumero() + ", Sähköpostiosoite: " + o.getSahkoposti());
		}
				
	} 
	
	public void addHalytys(ITimeSpace halytys){
		halytykset.add(halytys);
	}
	
	public void showHalytykset() {
		for (ITimeSpace h : halytykset) {
			System.out.println(h.getDate() +", " + h.getTime());
		}
		
	}

}
