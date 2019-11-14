package MetropoliaAMKgroup02.Backend.model;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import MetropoliaAMKgroup02.Backend.Database;
import MetropoliaAMKgroup02.Common.model.Merkinta;
import MetropoliaAMKgroup02.Common.model.Merkinta.Prior;


public class CalendarModel {
	
	private SessionFactory istuntotehdas = null;
	
	public CalendarModel(Database data){
		this.istuntotehdas = data.getIstuntoTehdas();
	}
	public void addMerkinta(Merkinta merkinta) {
		Transaction transaktio = null;
		try(Session istunto = istuntotehdas.openSession()) {
			transaktio = istunto.beginTransaction();
			istunto.saveOrUpdate(merkinta);
	
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

	public Object getMerkinta(int id) {
		Session istunto = istuntotehdas.openSession();
		istunto.beginTransaction();
		Merkinta merkinta = new Merkinta();
		istunto.load(merkinta, id);
		istunto.getTransaction().commit();
		istunto.close();
		
		return (Object) merkinta;
	}
	
	public Object editMerkinta(Merkinta merkinta) {
		Session istunto = istuntotehdas.openSession();
		istunto.beginTransaction();
		
		istunto.merge(merkinta);
		istunto.getTransaction().commit();
		istunto.close();
		
		return (Object) merkinta;
	}
	
	public Object deleteMerkinta(int id) {
		Session istunto = istuntotehdas.openSession();
		istunto.beginTransaction();
		
		Merkinta pois = (Merkinta) getMerkinta(id);
		istunto.delete(pois);
		istunto.getTransaction().commit();
		istunto.close();
		
		return (Object) pois;
	}
}
