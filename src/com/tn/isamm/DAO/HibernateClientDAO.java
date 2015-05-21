package com.tn.isamm.DAO;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tn.isamm.beans.Client; 






/**
 * Author Radhouene Rouached
 */
@Repository
public class HibernateClientDAO implements ClientDAO{
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean create(Client c) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(c);
		tx.commit();
		session.close();
		return true;
		
	}

	@Override
	public boolean update(Client c) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(c);
		tx.commit();
		session.close();
		return true;
		
	}

	@Override
	public boolean delete(Client c) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Client c2=(Client)session.get(Client.class, c.getIdClient());
		session.delete(c2);
		tx.commit();
		session.close();
		return true;

		
	}

	@Override
	public Client findById(int id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Client c=(Client)session.get(Client.class, new Integer(id));
		tx.commit();
		session.close();
		return(c); 
	}

	@Override
	public List<Client> findByAll() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("from Client");
		List<Client> l=(List<Client>)q.list();
		tx.commit();
		session.close();
		return l;
	}

	

}
