package org.GestionBiblio.Repository;

import org.GestionBiblio.Model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepository extends JpaRepository<Livre, Long>{

}
