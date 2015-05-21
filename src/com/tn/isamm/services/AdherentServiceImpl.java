package com.tn.isamm.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.isamm.DAO.AbstarctDAOFactory;
import com.tn.isamm.DAO.AdherentDAO;
import com.tn.isamm.DAO.DAO;
import com.tn.isamm.beans.Adherent;

@Service
public class AdherentServiceImpl implements AdherentService {

	private AdherentDAO adherentDao ;
	
	@Autowired
	public void setAdherentDAO(AdherentDAO adherentDAO) {
		this.adherentDao = adherentDAO;
	}

	public void createAdherent(Adherent adherent) {

		adherentDao.create(adherent);

	}

	public Adherent findAdherent(int id) {
		return adherentDao.find(id);
	}

	public Boolean delete(Adherent adherent) {

		try {
			adherentDao.delete(adherent);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean update(Adherent adherent) {

		try {
			adherentDao.update(adherent);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Adherent> findAll() {
		try {

			List l = new ArrayList<Adherent>();
			l = adherentDao.findAll();
			Iterator i = l.iterator();

			while (i.hasNext()) {
				Adherent ad = (Adherent) i.next();
				System.out.println("ID :" + ad.getId_adherent() + " Nom :"
						+ ad.getNom() + " Prenom : " + ad.getPrenom() + " Cin:"
						+ ad.getCin() + " " + ad.getAdresse().getCite());
			}
			return l;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Long nombreTotalAdherent() {
		// try {
		// return adherentDao.nombreTotalAdherent();
		// } catch (Exception e) {
		return (long) 0;
		// }
	}

	public Adherent findByLogin(String login, String pwd) {
		try {
			return ((AdherentDAO) adherentDao).findByLogin(login, pwd);
		} catch (Exception e) {
			return null;
		}
	}
}
