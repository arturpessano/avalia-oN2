package br.com.arturpessano.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.arturpessano.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

}
