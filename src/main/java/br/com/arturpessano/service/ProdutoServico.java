package br.com.arturpessano.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.arturpessano.model.Produto;
import br.com.arturpessano.repository.ProdutoRepository;

@Service
public class ProdutoServico {
	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto insertOrUpdate(Produto produto) {
		return produtoRepository.save(produto);
	}
	public List<Produto> findAll() {
		List<Produto> produtos = new ArrayList<>();
		produtoRepository.findAll().forEach(produtos::add);
		return produtos;
	}

	public Optional<Produto> findOne(Integer id) {
		return produtoRepository.findById(id);
	}

	public void remove(Integer id) {
		produtoRepository.deleteById(id);
	}
}
