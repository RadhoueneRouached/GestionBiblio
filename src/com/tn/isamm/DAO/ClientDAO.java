package com.tn.isamm.DAO;
import java.util.List;

import com.tn.isamm.beans.Client;

public interface ClientDAO {
	public boolean create(Client m);
	public boolean update(Client m);
	public boolean delete(Client m);
	public Client findById(int id);
	public List<Client>findByAll();
	
	
}
