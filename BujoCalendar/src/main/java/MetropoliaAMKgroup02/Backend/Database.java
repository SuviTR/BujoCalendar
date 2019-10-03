/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.Backend;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * Simple database class
 * @author heikki
 */
public class Database {
	
	private SessionFactory istuntotehdas = null;

	public Database() {

		System.out.println("Luodaan istuntotehdas");
		StandardServiceRegistry registry ;
		try {
			registry = new StandardServiceRegistryBuilder().configure().build();
			istuntotehdas =  new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}
		catch(Exception e) {
			System.out.println("Istuntotehtaan luonti ei onnistunut");
			//StandardServiceRegistryBuilder.destroy(registry);
			e.printStackTrace();
			System.exit(-1);
		}
	}


	public SessionFactory getIstuntoTehdas() {
		return this.istuntotehdas;
	}

}
