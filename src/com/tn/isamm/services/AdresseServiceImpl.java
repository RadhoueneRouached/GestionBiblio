package com.tn.isamm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.isamm.DAO.AbstarctDAOFactory;
import com.tn.isamm.DAO.AdresseDAO;
import com.tn.isamm.beans.Adresse;

@Service
public class AdresseServiceImpl implements AdresseService {

	private AdresseDAO adresseDao ; 
	
	@Autowired
	public void setAdresseDAO(AdresseDAO adresseDAO) {
		this.adresseDao = adresseDAO;
	}

	public void createAdresse(Adresse adresse) {

		adresseDao.create(adresse);

	}

	public Adresse findAdresse(int id) {
		return adresseDao.find(id);
	}

	public Boolean delete(Adresse adresse) {

		try {
			adresseDao.delete(adresse);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean update(Adresse adresse) {

		try {
			adresseDao.update(adresse);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Adresse> findAll() {
		try {
			return adresseDao.findAll();
		} catch (Exception e) {
			return null;
		}
	}

}
