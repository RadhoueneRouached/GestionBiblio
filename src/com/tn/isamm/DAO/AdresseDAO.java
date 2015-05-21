package com.tn.isamm.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tn.isamm.beans.Adresse;

/**
 * Author Radhouene Rouached
 */
@Repository
public class AdresseDAO extends DAO<Adresse> {

	private SessionFactory sessionfactory ;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionfactory = sessionFactory;
	}
	public AdresseDAO(SessionFactory sessionFactory) {
	this.sessionfactory = sessionFactory; 
	}

	public AdresseDAO() {
		}

	@Override
	public void create(Adresse adresse) throws TransactionException {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		try {
			transaction = s.beginTransaction();
			s.save(adresse);
			transaction.commit();

		} catch (HibernateException he) {
			System.out.println("creation adresse impossible ");
			he.printStackTrace();
			transaction.rollback();

		} finally {
			s.close();

		}

	}

	@Override
	public Adresse find(int id) {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		transaction = s.beginTransaction();
		return (Adresse) s.get(Adresse.class, id);
	}

	@Override
	public boolean delete(Adresse obj) {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		try {
			transaction = s.beginTransaction();
			s.delete(obj);
			transaction.commit();
			return true;
		} catch (HibernateException he) {
			he.printStackTrace();
			transaction.rollback();
			return false;
		} finally {
			s.close();

		}

	}

	@Override
	public boolean update(Adresse obj) {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		try {
			transaction = s.beginTransaction();
			s.update(obj);
			transaction.commit();
			return true;
		} catch (HibernateException he) {
			he.printStackTrace();
			transaction.rollback();
			return false;
		}

		finally {
			s.close();

		}

	}

	@Override
	public List findAll() {
		Session s = sessionfactory.openSession();
		Transaction transaction = null;
		try {

			transaction = s.beginTransaction();
			Criteria q = s.createCriteria(Adresse.class);
			List l = q.list();
			return l;

		} catch (Exception e) {
			System.out.print(" on ne peut pas trouver tous les adresses");
		}

		finally {
			s.close();

		}

		return null;
	}

}
