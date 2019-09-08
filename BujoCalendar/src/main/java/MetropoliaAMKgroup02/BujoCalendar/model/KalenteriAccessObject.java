package model;
import java.sql.*;
import java.until.ArrayList;
import java.util.List;

import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.*;


public class KalenteriAccessObject {
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	SessionFactory istuntotehdas= null;

	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		/* Alkutoimet: SessionFactoryn luonti (raskasta, vain kerran). */
	public KalenteriAccessObject () {
		
		
		try{
			istuntotehdas = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		}
		catch(Exception e){
			System.out.println("Oh no");
			StandardServiceRegistryBuilder.destroy( registry );
			e.printStackTrace();
		}
	}
public void addMerkintä() {
		Session istunto = istuntotehdas.openSession();
		Transaction transaktio = null;
		try{
			transaktio = istunto.beginTransaction();
			Merkintä m = new Merkintä();
			m.add();
			istunto.saveOrUpdate(m);
			transaktio.commit();
		}
		catch(Exception e){
			if (transaktio!=null) transaktio.rollback();
			throw e;
		}
		finally{
			istunto.close();
		}
	}
public void editMerkintä() {
		
		// Tiedon haku Session.get-metodilla + päivitys

		Session istunto = istuntotehdas.openSession();
		istunto = istuntotehdas.openSession();
		istunto.beginTransaction();
		idMerkintä = getMerkintäIdKäyttäjältä;

		Merkintä m  = (Merkintä)istunto.get(Merkintä.class, jdMerkintä);
		if (m!= null){
			m.edit();  // Kyseessä persistentti objekti. Pävitys suoraan tauluun!!!
		}
		else{
			System.out.println("Ei löytynyt päivitettäävää");
		}

		istunto.getTransaction().commit();
		istunto.close();

		istunto = istuntotehdas.openSession();
		istunto.beginTransaction();
	}

	public void deleteMerkintä() {

		// Tiedon haku Session.get-metodilla + poisto jos löytyi

		Session istunto = istuntotehdas.openSession();
		istunto = istuntotehdas.openSession();
		istunto.beginTransaction();

		idMerkintä = getMerkintäIdKäyttäjältä;
		Merkintä m = (Merkintä)istunto.get(Merkintä.class, id.Merkintä);

		if (m!= null) {
			System.out.println("Edellisen päivityksen jälkeen " + m.getTunnus()); 
			istunto.delete(m);
		}

		istunto.getTransaction().commit();
		istunto.close();
		
	}
}
