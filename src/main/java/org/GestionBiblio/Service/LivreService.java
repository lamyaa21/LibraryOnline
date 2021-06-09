package org.GestionBiblio.Service;


import java.io.IOException;
import java.util.Base64;
import java.util.List;


import org.GestionBiblio.Model.Livre;
import org.GestionBiblio.Repository.LivreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;






@Service
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;
     
    public List<Livre> listAll() {
        return livreRepository.findAll();
    }
     
    public void save(Livre livre) {
        livreRepository.save(livre);
    }
    /*public void save(Livre livre, MultipartFile filee) {
    	Livre livrel= new Livre();
    	String fileName = StringUtils.cleanPath(filee.getOriginalFilename());
    	try {
			livrel.setCover(Base64.getEncoder().encodeToString(filee.getBytes()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        livreRepository.save(livrel);
    }*/
     
    public Livre get(Long id) {
        return livreRepository.findById(id).get();
    }
     
    public void delete(Long id) {
        livreRepository.deleteById(id);
    }

}
	

