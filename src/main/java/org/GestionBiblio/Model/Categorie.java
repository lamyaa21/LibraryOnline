package org.GestionBiblio.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Categorie")
public class Categorie {
	
	@Id
	@Column(name = "categorie_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categorieId;
	
	@Column(name = "nom")
	private String nom;

	 @OneToMany(mappedBy = "categorie")
	 @JsonIgnore
	 private List<Livre> livre;
	
	public List<Livre> getLivre() {
		return livre;
	}

	public void setLivre(List<Livre> livre) {
		this.livre = livre;
	}

	public Long getCategorieId() {
		return categorieId;
	}

	public void setCategorieId(Long categorieId) {
		this.categorieId = categorieId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Categorie() {
	
	}

	public Categorie(String nom) {
		
		this.nom = nom;
	}
	
	
	
	
	
   
}
