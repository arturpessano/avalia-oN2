package br.com.arturpessano.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arturpessano.model.Cliente;

import br.com.arturpessano.service.ClienteServico;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	private ClienteServico clienteServico;

	@GetMapping
	public List<Cliente> findAll() {
		return clienteServico.findAll();

	}

	@GetMapping("/{nome}")
	public Optional<Cliente> findOne(@PathVariable int id) {
		return  clienteServico.findOne(id);

	}

	@PostMapping
	public Map<String, String> insert(@RequestBody Cliente cliente) {
		Map<String, String> result = new HashMap<String, String>();
		
		clienteServico.insertOrUpdate(cliente);
		
		return result;
	}

	@PutMapping
	public Map<String, String> edit(@RequestBody Cliente cliente) {
		Map<String, String> result = new HashMap<String, String>();
		cliente = clienteServico.insertOrUpdate(cliente);
		if(cliente != null)
			result.put("result", "Cliente editado com sucesso!!");
		else
			result.put("result", "Não foi possivel editar esse cliente!!");
		return result;

	}

	@DeleteMapping("{id}")
	public Map<String, String> remove(@PathVariable int id) {
		Map<String, String> result = new HashMap<String, String>();
		clienteServico.remove(id);
		
		return result;

	}

}
