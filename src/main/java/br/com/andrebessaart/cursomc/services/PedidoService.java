package br.com.andrebessaart.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andrebessaart.cursomc.domain.Pedido;
import br.com.andrebessaart.cursomc.repositories.PedidoRepository;
import br.com.andrebessaart.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido Buscar(Integer id) {
		Optional<Pedido> cat = repo.findById(id);
		return cat.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id + ", Tipo: "+Pedido.class.getName()));
	}
}
