package org.GestionBiblio.Model;

import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name = "Livre")
public class Livre {
	
	@Id
	@Column(name = "livre_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long livreId;
	
	@Lob
    @Column(name = "cover", length = Integer.MAX_VALUE, nullable = true)
    private String cover;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "auteur")
	private String auteur;
	
	@CreationTimestamp
	@Column(name = "Ajout_date", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date dateAjout;
	
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "categorie_id", nullable = false)
	private Categorie categorie;
	
	@Column(name="file")
	private String file;
	


	public String getFile() {
		return file;
	}


	public void setFile(String file) {
		this.file = file;
	}


	@Column(name = "description")
	private String description;
     
	
	//default constructor
	public Livre() {
		
	}


	public Livre(String nom, String auteur, Categorie categorie, String description, String cover, String file) {
		
		this.nom = nom;
		this.auteur = auteur;
		this.categorie = categorie;
		this.description = description;
		this.cover = cover;
		this.file= file;
	}


	public Long getLivreId() {
		return livreId;
	}


	public void setLivreId(Long livreId) {
		this.livreId = livreId;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getAuteur() {
		return auteur;
	}


	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}


	public Date getDateAjout() {
		return dateAjout;
	}


	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCover() {
		return cover;
	}


	public void setCover(String cover) {
		this.cover = cover;
	}


	
	
	//getters and setters
	
	
	
	
	
	
	
	
	
	

}
