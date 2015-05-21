package com.tn.isamm.services; 

import com.tn.isamm.DAO.EmpruntDAO;
import com.tn.isamm.beans.Emprunt;

/**
 * Author Radhouene Rouached
 */

public interface EmpruntService {


	public void setEmprunt (EmpruntDAO empruntDAO);

	public void createEmprunt(Emprunt emprunt);

	public Emprunt findEmprunt(int id);

}
