package br.edu.fa7.service;

import java.util.List;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fa7.model.Cliente;
import br.edu.fa7.model.Endereco;
import br.edu.fa7.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository EnderecoRepository;

	public List<Endereco> findByCliente(Cliente cliente) {
		return EnderecoRepository.findByCliente(cliente);
	}

	public Endereco findByClienteAndId(Cliente cliente, Integer id) {
		Endereco endereco = EnderecoRepository.findByClienteAndId(cliente, id);
		if (endereco == null) {
			throw new NotFoundException("Endereço não encontrado");
		}
		return endereco;
	}

	public Endereco save(Endereco Endereco) {
		return EnderecoRepository.save(Endereco);
	}

	public void deleteByClienteAndId(Cliente cliente, Integer id) {
		Endereco Endereco = findByClienteAndId(cliente, id);
		EnderecoRepository.delete(Endereco);
	}
}
