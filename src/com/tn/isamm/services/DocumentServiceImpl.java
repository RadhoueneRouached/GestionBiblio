package com.tn.isamm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tn.isamm.DAO.DocumentDAO;
import com.tn.isamm.beans.Document;

@Service
public class DocumentServiceImpl implements DocumentService {


	DocumentDAO documentDAO = new DocumentDAO(); 

	@Autowired
	public void setDocumentDAO(DocumentDAO documentDAO) {
		this.documentDAO = documentDAO;

	}

	public void createDocument(Document document) {
		try {
			documentDAO.create(document);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Document findDocument(int id) {
		return documentDAO.find(id);
	}

	public Boolean delete(Document document) {

		try {
			documentDAO.delete(document);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean update(Document document) {

		try {
			documentDAO.update(document);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Document> findAll() {
		try {
			return documentDAO.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	public Long nombreLivre() {
		return documentDAO.nombreLivre();
	}

	public Document findByName(String titre) {
		return documentDAO.findByName(titre);
	}

	public Boolean minusDoc(int id) {
		try {
			return documentDAO.minusDoc(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean plusDoc(int id) {
		try {
			return documentDAO.plusDoc(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public int numberExDoc(int id) {
		return documentDAO.numberExDoc(id);
	}
}
