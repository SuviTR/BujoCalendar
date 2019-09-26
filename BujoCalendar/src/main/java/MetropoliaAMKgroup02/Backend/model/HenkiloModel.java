package MetropoliaAMKgroup02.Backend.model;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import MetropoliaAMKgroup02.Backend.Database;
import MetropoliaAMKgroup02.Backend.model.*;


public class HenkiloModel{
	
	private SessionFactory istuntotehdas = null;
	
	public HenkiloModel(Database data){
		this.istuntotehdas = data.getIstuntoTehdas();
	}
	public void addHenkilo() {
		Transaction transaktio = null;
		try(Session istunto = istuntotehdas.openSession()) {
			transaktio = istunto.beginTransaction();

			Henkilo henkilo = new Henkilo();
			
			henkilo.setEtunimi("Vladimir");
			henkilo.setSukunimi("Gavrilov");
			henkilo.setOsoite("Helsinki");
			henkilo.setPuhelinnumero("0449890965");
			
			Henkilo henkilo2 = new Henkilo();
			
			henkilo2.setEtunimi("Heikki");
			henkilo2.setSukunimi("Ketoharju");
			henkilo2.setOsoite("Helsinki");
			henkilo2.setPuhelinnumero("0441234567");
			
			Henkilo henkilo3 = new Henkilo();
			
			henkilo3.setEtunimi("Suvi");
			henkilo3.setSukunimi("Rannisto");
			henkilo3.setOsoite("Helsinki");
			henkilo3.setPuhelinnumero("0441234567");
			
			Henkilo henkilo4 = new Henkilo();
			
			henkilo4.setEtunimi("Kari");
			henkilo4.setSukunimi("Lampi");
			henkilo4.setOsoite("Helsinki");
			henkilo4.setPuhelinnumero("0441234567");

			istunto.saveOrUpdate(henkilo);
			istunto.saveOrUpdate(henkilo2);
			istunto.saveOrUpdate(henkilo3);
			istunto.saveOrUpdate(henkilo4);
	
			transaktio.commit();
			istunto.close();
		}
	}
	// Tiedon haku (kaikki henkilöt) (Read)
	public Object getAll() {
			Session istunto = istuntotehdas.openSession();
			istunto.beginTransaction();
			List result = istunto.createQuery( "from Henmkilo" ).list();
			
			istunto.getTransaction().commit();
			istunto.close();
			
			return (Object) result;
				
		}
	
}
