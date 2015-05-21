package com.tn.isamm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.isamm.DAO.AbstarctDAOFactory;
import com.tn.isamm.DAO.AdministrateurDAO;
import com.tn.isamm.DAO.DAO;
import com.tn.isamm.beans.Administrateur;

@Service
public class AdministrateurServiceImpl implements AdministrateurService {

	private AdministrateurDAO adminDao; 
	
	@Autowired
	public void setAdministrateurDAO(AdministrateurDAO administrateurDAO) {
		this.adminDao = administrateurDAO;
	}

	public void createAdministrateur(Administrateur administrateur) {

		adminDao.create(administrateur);

	}

	public Administrateur findAdministrateur(int id) {
		return adminDao.find(id);
	}

	public Boolean delete(Administrateur administrateur) {

		try {
			adminDao.delete(administrateur);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean update(Administrateur administrateur) {

		try {
			adminDao.update(administrateur);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Administrateur> findAll() {
		try {
			return adminDao.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	public Administrateur findByLogin(String login, String pwd) {
		try {
			return ((AdministrateurDAO) adminDao).findByLogin(login, pwd);
		} catch (Exception e) {
			return null;
		}
	}

}
