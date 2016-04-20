package br.edu.fa7.service;

import java.util.List;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fa7.model.Cliente;
import br.edu.fa7.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente find(Integer id) {
		return clienteRepository.find(id);
	}

	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public void delete(Integer id) {
		Cliente cliente = find(id);
		if(cliente == null) {
			throw new NotFoundException("Cliente não encontrado");
		}
		clienteRepository.delete(cliente);
	}
}
