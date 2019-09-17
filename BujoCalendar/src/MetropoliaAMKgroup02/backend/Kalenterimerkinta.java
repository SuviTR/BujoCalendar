package MetropoliaAMKgroup02.backend;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 * Vladimir 
 *
 */
public class Kalenterimerkinta extends Merkinta
{
	List<Henkilo> osalistujat = new ArrayList<>();
	List<ITimeSpace> halytykset = new ArrayList<>();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
	
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
			System.out.println(dateFormat.format(h.date().getTime()) +", " + timeFormat.format(h.time().getTime()));
		}
		
	}

}
