package org.GestionBiblio.Repository;

import org.GestionBiblio.Model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{
	
	Categorie findBynom(String nom);
	

}
