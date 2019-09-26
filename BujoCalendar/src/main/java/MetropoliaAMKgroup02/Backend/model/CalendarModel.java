package MetropoliaAMKgroup02.Backend.model;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import MetropoliaAMKgroup02.Backend.Database;
import MetropoliaAMKgroup02.Backend.model.Merkinta;
import MetropoliaAMKgroup02.Backend.model.Merkinta.Prior;


public class CalendarModel {
	
	private SessionFactory istuntotehdas = null;
	
	public CalendarModel(Database data){
		this.istuntotehdas = data.getIstuntoTehdas();
	}
	public void addMerkinta() {
		Transaction transaktio = null;
		try(Session istunto = istuntotehdas.openSession()) {
			transaktio = istunto.beginTransaction();
			Merkinta merk = new Merkinta("Uusi merkintä");
			merk.setPaikka("Helsinki");
			merk.setSisalto("Tosi tärkeä tapahtuma!");
			Calendar date = Calendar.getInstance();
			date.set(2018, 10, 11);
			merk.setDate(date);
			Merkinta merk2 = new Merkinta("Uusi merkintä2");
			merk2.setPrior(Prior.SMALL);
			istunto.saveOrUpdate(merk);
			istunto.saveOrUpdate(merk2);
	
			transaktio.commit();
			istunto.close();
		}
	}
	// Tiedon haku (kaikki valuutat) (Read)
	public Object getAll() {
			Session istunto = istuntotehdas.openSession();
			istunto.beginTransaction();
			List result = istunto.createQuery( "from Merkinta" ).list();
			
			istunto.getTransaction().commit();
			istunto.close();
			
			return (Object) result;
				
		}
	
}
