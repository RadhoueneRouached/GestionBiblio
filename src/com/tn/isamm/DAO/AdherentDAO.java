package com.tn.isamm.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tn.isamm.beans.Adherent;
import com.tn.isamm.beans.Administrateur;

/**
 * Author Radhouene Rouached
 */
@Repository
public class AdherentDAO extends DAO<Adherent> {

	
	private SessionFactory sessionFactory ;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public AdherentDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public AdherentDAO() {}


	public void create(Adherent adherent) {
		Session s = sessionFactory.openSession(); 
		Transaction transaction = null;
		try {

			
			AdministrateurDAO dao = new AdministrateurDAO(sessionFactory); 
			Administrateur a = new Administrateur(); 
			a = dao.find(1); 
			transaction = s.beginTransaction();
			adherent.setAdministrateur(a);
			s.save(adherent);
			transaction.commit();

		} catch (HibernateException he) {
			he.printStackTrace();
			transaction.rollback();
		}

		finally {
			s.close();

		}

	}

	// public boolean delete(Adherent m);

	public Adherent find(int id) {
		Session s = sessionFactory.openSession();
		Adherent adr = new Adherent();
		@SuppressWarnings("unused")
		Transaction transaction = null;
		try {
			transaction = s.beginTransaction();
			adr = (Adherent) s.get(Adherent.class, id);
			transaction.commit();
			return adr;
		} catch (Exception e) {
			System.out.print("");
		} finally {
			s.close();

		}
		return null;
	}

	@Override
	public boolean delete(Adherent obj) {
		Session s = sessionFactory.openSession();
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
	public boolean update(Adherent obj) {
		Session s = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			AdministrateurDAO dao = new AdministrateurDAO(sessionFactory); 
			Administrateur a = new Administrateur(); 
			a = dao.find(1); 
			
			transaction = s.beginTransaction();
			obj.setAdministrateur(a);
			s.update(obj);
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

	@SuppressWarnings("rawtypes")
	public List<Adherent> findAll() {
		Session s = sessionFactory.openSession();
		Transaction transaction = null;

		try {

			transaction = s.beginTransaction();
			Criteria q = s.createCriteria(Adherent.class);
			List l = q.list();
			transaction.commit();
			return l;

		} catch (Exception e) {

			System.out.print(" on ne peut pas trouver tous les adherents");
			// transaction.rollback();

		} finally {
			s.close();

		}

		return null;
	}

	public Long nombreTotalAdherent() {
		Session s = sessionFactory.openSession();
		Transaction transaction = null;
		Long count = (long) 0;
		try {
			transaction = s.beginTransaction();
			Query query = s
					.createQuery("select count(id_adherent) from Adherent ");
			count = (Long) query.uniqueResult();
			transaction.commit();
			return count;
		} catch (HibernateException he) {
			he.printStackTrace();
			transaction.rollback();
			
		} finally {
			s.close();

		}
		return count;
	}

	public Adherent findByLogin(String login, String pwd) {
		Session s = sessionFactory.openSession();
		Transaction transaction = null;
		Criteria criteria = null;
		try {
			transaction = s.beginTransaction();
			criteria = s.createCriteria(Adherent.class);

			Criterion log = Restrictions.ilike("email", login);
			Criterion pwd1 = Restrictions.ilike("pass", pwd);

			LogicalExpression andExp = Restrictions.and(log, pwd1);
			// LogicalExpression andExp3 = Restrictions.and(andExp , active);

			criteria.add(andExp);

			transaction.commit();
			return (Adherent) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("Adhrent non trouvé ");
		} finally {
			s.close();

		}
		return null;
	}
}
