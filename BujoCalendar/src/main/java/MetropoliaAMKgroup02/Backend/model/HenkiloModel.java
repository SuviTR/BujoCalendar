package MetropoliaAMKgroup02.Backend.model;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import MetropoliaAMKgroup02.Backend.Database;
import MetropoliaAMKgroup02.Backend.model.*;
import MetropoliaAMKgroup02.Common.model.Henkilo;


public class HenkiloModel{
	
	private SessionFactory istuntotehdas = null;
	
	public HenkiloModel(Database data){
		this.istuntotehdas = data.getIstuntoTehdas();
	}
	public void addHenkilo(Henkilo henkilo) {
		Transaction transaktio = null;
		try(Session istunto = istuntotehdas.openSession()) {
			transaktio = istunto.beginTransaction();

			istunto.saveOrUpdate(henkilo);
	
			transaktio.commit();
			istunto.close();
		}
	}
	public void addHenkilo() {
		Transaction transaktio = null;
		try(Session istunto = istuntotehdas.openSession()) {
			transaktio = istunto.beginTransaction();
			Henkilo henkilo = new Henkilo();
			henkilo.setEtunimi("Vladimir");
			henkilo.setSukunimi("Gavrilov");
			istunto.saveOrUpdate(henkilo);
	
			transaktio.commit();
			istunto.close();
		}
	}
	// Tiedon haku (kaikki henkilöt) (Read)
	public Object getAll() {
			Session istunto = istuntotehdas.openSession();
			istunto.beginTransaction();
			List result = istunto.createQuery( "from Henkilo" ).list();
			
			istunto.getTransaction().commit();
			istunto.close();
			
			return (Object) result;
				
		}
	// Tiedon haku avaimen perusteella (Read)
	public Object getHenkilo(int id) {
			Session istunto = istuntotehdas.openSession();
			istunto.beginTransaction();
			Henkilo henkilo = new Henkilo();
			istunto.load(henkilo, id);
			//String result = henkilo.getEtunimi() + " " + henkilo.getSukunimi();
			istunto.getTransaction().commit();
			istunto.close();
			
			return (Object) henkilo;
	}
	
}
