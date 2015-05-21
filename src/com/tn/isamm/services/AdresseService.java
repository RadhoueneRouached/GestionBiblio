package com.tn.isamm.services ;

/**
 * Author Radhouene Rouached
 */
import com.tn.isamm.DAO.AdresseDAO;
import com.tn.isamm.beans.Adresse;

public interface AdresseService {


	public void setAdresseDAO(AdresseDAO adresseDAO);

	public void createAdresse(Adresse adresse);

	public Adresse findAdresse(int id);

}
