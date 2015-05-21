package com.tn.isamm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tn.isamm.DAO.ClientDAO;
import com.tn.isamm.beans.Client;

/**
 * Author Radhouene Rouached
 */

@Service
public class ClientService {
	private ClientDAO clientDAO;
	
	@Autowired
	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}

	public boolean enregistrerClient(Client m){
		return clientDAO.create(m);
	}
	
	public boolean mettreAJourClient(Client m){
		return clientDAO.update(m);
	}
	
	public boolean supprimerClient(int id){
		Client client= clientDAO.findById(id);
		
		return clientDAO.delete(client);
	}
	
	public Client rechercherClient(int id){
		return clientDAO.findById(id);
	}
	

	
	public List<Client> rechercherTous(){
		return clientDAO.findByAll();
	}
	

}
