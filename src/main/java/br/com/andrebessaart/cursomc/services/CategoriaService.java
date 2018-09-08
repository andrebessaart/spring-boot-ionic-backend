package br.com.andrebessaart.cursomc.services;

import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.andrebessaart.cursomc.domain.Categoria;
import br.com.andrebessaart.cursomc.repositories.CategoriaRepository;
import br.com.andrebessaart.cursomc.services.exceptions.DateIntegrityException;
import br.com.andrebessaart.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> cat = repo.findById(id);
		return cat.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id + ", Tipo: "+Categoria.class.getName()));
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
	   find(id);
	   try {
		   repo.deleteById(id);
	   }catch(DataIntegrityViolationException e) {
		   throw new DateIntegrityException("Não é possível excluir uma categoria que possui produtos!");
	   }
	   
	}
}
