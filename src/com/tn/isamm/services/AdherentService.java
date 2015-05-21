package com.tn.isamm.services ;

/**
 * Author Radhouene Rouached
 */
import com.tn.isamm.DAO.AdherentDAO;
import com.tn.isamm.beans.Adherent;

public interface AdherentService {


	public void setAdherentDAO(AdherentDAO adherentDAO);

	public void createAdherent(Adherent adherent);

	public Adherent findAdherent(int id);

}
