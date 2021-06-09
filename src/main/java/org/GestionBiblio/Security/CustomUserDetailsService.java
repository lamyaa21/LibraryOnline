package org.GestionBiblio.Security;

import java.util.Collection;

import org.GestionBiblio.Model.User;
import org.GestionBiblio.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userR;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userR.findByUsername(username);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
		
	}
	
	
	 private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
	        String[] userRoles = user.getRoles().stream().map((role) -> role.getNom()).toArray(String[]::new);
	        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
	        return authorities;
	    }
	
	

}
