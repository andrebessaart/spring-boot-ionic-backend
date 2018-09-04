package br.com.andrebessaart.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andrebessaart.cursomc.domain.Cliente;
import br.com.andrebessaart.cursomc.repositories.ClienteRepository;
import br.com.andrebessaart.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente Buscar(Integer id) {
		Optional<Cliente> cat = repo.findById(id);
		return cat.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id + ", Tipo: "+Cliente.class.getName()));
	}
}
