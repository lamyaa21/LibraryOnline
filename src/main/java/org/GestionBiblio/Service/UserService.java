package org.GestionBiblio.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.GestionBiblio.Model.Role;
import org.GestionBiblio.Model.User;
import org.GestionBiblio.Repository.RoleRepository;
import org.GestionBiblio.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	NoOpPasswordEncoder bCryptPasswordEncoder;
	//BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public List<User> listAll(){
		return userRepository.findAll();
		
	}
	
	 @Autowired
	    public UserService(UserRepository userRepository,
	                       RoleRepository roleRepository,
	                       NoOpPasswordEncoder bCryptPasswordEncoder) {
	        this.userRepository = userRepository;
	        this.roleRepository = roleRepository;
	        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	    }
	
	 public User saveUser(User user) {
	        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	        
	        Role userRole = roleRepository.findBynom("ADMIN");
	        
	        return userRepository.save(user);
	    }
	 public User saver(User user) {
	        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	        
	        Role userRole = roleRepository.findBynom("ADMIN");
	        
	        return userRepository.save(user);
	    }
	
	 
	 public User findUserByUserName(String userName) {
	        return userRepository.findByUsername(userName);
	    }
	public User get(Long id) {
		return userRepository.findById(id).get();
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
	
	
	
	
	
	
	
	

}
