package MetropoliaAMKgroup02.BujoCalendar;
import java.until.ArrayList;
/**
 * Vladimir 
 *
 */
public class Kalenterimerkintä implements IKalenteriMerkintä
{
	private ArrayList<Henkilo> osalistujat = new ArrayList<Henkilo>();
	private ArrayList<Halytys> halytykset = new ArrayList<Halytys>();
	
	public void addHenkilo(Henkilo henkilo){
		osalistujat.add(henkilo);				
	}
	public void showOsalistujat(){
		System.out.println(osalistujat);		
	} 
	
	public void addHalytys(Halytys halytys){
		halytykset.add(halytys)
	}

}
