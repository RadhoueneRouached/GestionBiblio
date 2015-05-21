package com.tn.isamm.DAO;

import java.sql.Connection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 * Author Radhouene Rouached
 */
 public abstract class   DAO<T> {
		
	public abstract  void create(T obj);
	public abstract boolean delete(T obj);
	public abstract boolean update(T obj );
	public abstract T find(int id);
	public abstract List findAll();
}
