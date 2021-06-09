package org.GestionBiblio.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name= "user")
public class User {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userId;
	
	@Column(name="nom")
	private String nom;
	
	@Column(unique=true , name="username")
	private String username;
	
	

	@Column(name="password")
	private String password;
	
	 @ManyToMany(cascade=CascadeType.MERGE)
	 @JoinTable(name="user_role",joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="user_id")},
	       inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
	    private List<Role> roles;
	
	
	

	

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@JsonManagedReference
	@OneToMany(fetch = FetchType.EAGER, orphanRemoval= true)
    private Set<Livre> livre = new HashSet<Livre>(); 
	
	public Set<Livre> getLivre() {
		return livre;
	}

	public void setLivre(Set<Livre> livre) {
		this.livre = livre;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public User() {
		
	}

	public User(String nom, String username, String password) {
		
		this.nom = nom;
		this.username = username;
		this.password = password;
		
	}

	
	
	
	
	
	
}
