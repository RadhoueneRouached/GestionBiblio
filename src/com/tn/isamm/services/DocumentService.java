package com.tn.isamm.services; 

import com.tn.isamm.DAO.DocumentDAO;
import com.tn.isamm.beans.Document;

/**
 * Author Radhouene Rouached
 */
public interface DocumentService {


	

	public void createDocument(Document document);

	public Document findDocument(int id);

	void setDocumentDAO(DocumentDAO documentDAO);

}
