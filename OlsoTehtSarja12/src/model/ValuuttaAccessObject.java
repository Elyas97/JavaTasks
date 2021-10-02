package model;

/**
 * @author Elyas

 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



import org.hibernate.*;

public class ValuuttaAccessObject implements IValuuttaDAO {
	private SessionFactory istuntotehdas = null; 
	private Valuutta valuutat[];
	public ValuuttaAccessObject() {
		
		try {
			istuntotehdas = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.err.println("Istuntotehtaan luominen ei 	onnistunut.");
			System.exit(-1);
		}
	}

	@Override
	public boolean createValuutta(Valuutta valuutta) {
		boolean temp =false;
		Transaction transaktio=null;
		try(Session istunto = istuntotehdas.openSession()){
		
		 transaktio=istunto.beginTransaction();
		 istunto.save(valuutta);
		
		transaktio.commit();
		}catch(Exception e) {
			if(transaktio!=null) {
				transaktio.rollback();
			}
		}
		return temp;
		
	}

	@Override
	public Valuutta readValuutta(String tunnus) {
		Transaction transaktio=null;
		Valuutta val=null;
		try(Session istunto = istuntotehdas.openSession()){
		transaktio=istunto.beginTransaction();

		 val = new Valuutta();
		istunto.load(val,  tunnus);
		
		transaktio.commit();
		}catch(Exception e){
			if(transaktio!=null) {
				transaktio.rollback();
			}
		}
		if(val==null) {
			System.out.println("Ei löytynyt");
		}
		return val;
		
	}
	

	@Override
	public Valuutta[] readValuutat() {
		Transaction transaktio=null;
		try(Session istunto = istuntotehdas.openSession()){
		
		 transaktio=istunto.beginTransaction();
		List<Valuutta>result = istunto.createQuery( "from Valuutta" ).getResultList();
		valuutat= new Valuutta[result.size()];
		
		for(int i=0;i<result.size();i++) {
			valuutat[i]= result.get(i);

		}
		
		transaktio.commit();
		
		}catch(Exception e) {
			if(transaktio!=null) {
				transaktio.rollback();
			}
		}
		return valuutat;
		
	}

	@Override
	public boolean updateValuutta(Valuutta valuutta) {
		boolean temp=false;
		String nimi=valuutta.getNimi();
		double kurssi=valuutta.getVaihtokurssi();
		Transaction transaktio=null;
		try(Session istunto = istuntotehdas.openSession();){
		
		 transaktio=istunto.beginTransaction();
		 valuutta=(Valuutta)istunto.get(Valuutta.class, valuutta.getTunnus());
		if(valuutta!=null) {
			valuutta.setNimi(nimi);
			valuutta.setVaihtokurssi(kurssi);
			temp=true;
		}
		
		transaktio.commit();
		
		}catch(Exception e) {
			if(transaktio!=null) {
				transaktio.rollback();
			}
		}
		return temp;
		
	}

	@Override
	public boolean deleteValuutta(String tunnus) {
		boolean temp=false;
		Transaction transaktio=null;
		try(Session istunto = istuntotehdas.openSession()){
		
		 transaktio=istunto.beginTransaction();
		 Valuutta valuutta=(Valuutta)istunto.get(Valuutta.class, tunnus);
		if(valuutta!=null) {
			istunto.delete(valuutta);
			temp = true;
		}
		
		transaktio.commit();
		
		}catch(Exception e) {
			if(transaktio!=null) {
				transaktio.rollback();
			}
		}
		return temp;
	}
	public void finalize() {
		try {
		if(istuntotehdas!=null) {
			istuntotehdas.close();
		}
		}catch(Exception e) {
			System.out.println("Resurssien sulkemisessa virhe");
		}
		
	}

}
