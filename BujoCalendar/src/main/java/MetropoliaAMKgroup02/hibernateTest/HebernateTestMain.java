/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MetropoliaAMKgroup02.hibernateTest;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author heikki
 */
public class HebernateTestMain {

	public static void main(String[] args) {
		System.out.println("Luodaan istuntotehdas");
		SessionFactory istuntotehdas = null;
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

		Transaction transaktio = null;
		try(Session istunto = istuntotehdas.openSession()) {
			transaktio = istunto.beginTransaction();
			Merkinta merk = new Merkinta("Uusi merkintä");
			merk.setPaikka("Helsinki");
			merk.setSisalto("Tosi tärkeä tapahtuma");
			Calendar date = Calendar.getInstance();
			date.set(2018, 10, 11);
			merk.setDate(date);

			transaktio.commit();
			istunto.close();
		}
		istuntotehdas.close();

	}

}
