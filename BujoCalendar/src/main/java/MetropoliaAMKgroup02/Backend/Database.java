package MetropoliaAMKgroup02.Backend;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Database {
	
	private SessionFactory istuntotehdas = null;
	
	public SessionFactory getIstuntotehdas() {
		return istuntotehdas;
	}



	public void yhdistaa() {
		System.out.println("Luodaan istuntotehdas");
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
	
		try {
			istuntotehdas =  new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}
		catch(Exception e) {
			System.out.println("Istuntotehtaan luonti ei onnistunut");
			StandardServiceRegistryBuilder.destroy(registry);
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
