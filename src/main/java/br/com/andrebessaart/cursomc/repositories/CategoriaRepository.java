package br.com.andrebessaart.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.andrebessaart.cursomc.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
