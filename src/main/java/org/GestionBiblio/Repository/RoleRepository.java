package org.GestionBiblio.Repository;

import org.GestionBiblio.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findBynom(String nom);

}
