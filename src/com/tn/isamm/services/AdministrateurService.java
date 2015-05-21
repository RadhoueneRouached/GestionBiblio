package com.tn.isamm.services;

/**
 * Author Radhouene Rouached
 */
import com.tn.isamm.DAO.AdministrateurDAO;
import com.tn.isamm.beans.Administrateur;

 interface AdministrateurService {


		public void setAdministrateurDAO(AdministrateurDAO administrateurDAO);

		public void createAdministrateur(Administrateur administrateur);

		public Administrateur findAdministrateur(int id);

	}
