package br.com.arturpessano.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.arturpessano.model.Cliente;
import br.com.arturpessano.repository.ClienteRepository;

@Service
public class ClienteServico {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente insertOrUpdate(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public List<Cliente> findAll() {
		List<Cliente> clientes = new ArrayList<>();
		clienteRepository.findAll().forEach(clientes::add);
		return clientes;
	}

	public Optional<Cliente> findOne(Integer id) {
		return clienteRepository.findById(id);
	}

	public void remove(Integer id) {
		clienteRepository.deleteById(id);
	}
	
}
