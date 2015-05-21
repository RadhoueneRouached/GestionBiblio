package com.tn.isamm.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * Author Radhouene Rouached
 */
@Entity
@Proxy(lazy=false)
public class Adherent {

	private int id_adherent;
	@Range(min=8 , max=8)
	private int cin;
	private int active=0;
	@NotEmpty
	private String Nom;
	private int Avertissement=0;
	
	@NotEmpty
	private String Prenom;
	@NotEmpty
	private String pass;
	private Date dateExp = null;
	@DateTimeFormat(iso=ISO.DATE)
	private String dateNaissance;
	@NotEmpty
	private String email;
	@NotEmpty
	private Adresse adresse;
	private List<Document> documents = new ArrayList<Document>();
	private Administrateur administrateur; 

	public Adherent() {
		
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId_adherent() {
		return id_adherent;
	}

	public void setId_adherent(int idAdherent) {
		this.id_adherent = idAdherent;
	}

	@Column(nullable = false, unique = true)
	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	@Column(length = 50, nullable = false)
	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	@Column(length = 50, nullable = false)
	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	
	@Column(nullable = true)
	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Column(length = 100, nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "adresse_FK")
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@ManyToMany
	@JoinTable(name = "Emprunt", joinColumns = { @JoinColumn(name = "id_adherent") }, inverseJoinColumns = { @JoinColumn(name = "id_support") })
	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	@ManyToOne
	@JoinColumn(name="id_admin_FK" , nullable=false)
	public Administrateur getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}

	@Column
	public int getActive() {
		return active;
	}


	public void setActive(int active) {
		this.active = active;
	}

	@Column
	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}

	@Column
	public int getAvertissement() {
		return Avertissement;
	}


	public void setAvertissement(int avertissement) {
		Avertissement = avertissement;
	}

	@Column
	public Date getDateExp() {
		return dateExp;
	}


	public void setDateExp(Date dateExp) {
		this.dateExp = dateExp;
	}

}
