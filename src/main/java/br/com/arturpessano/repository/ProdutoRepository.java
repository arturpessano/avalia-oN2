package br.com.arturpessano.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.arturpessano.model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto,Integer>{

}
