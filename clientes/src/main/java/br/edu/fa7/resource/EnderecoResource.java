package br.edu.fa7.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fa7.model.Cliente;
import br.edu.fa7.model.Endereco;
import br.edu.fa7.service.ClienteService;
import br.edu.fa7.service.EnderecoService;

@RestController
@RequestMapping(value = "clientes/{clienteId}/enderecos")
public class EnderecoResource {

	@Autowired
	private ClienteService clienteService;
	@Autowired
	private EnderecoService enderecoService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Endereco> findAll(@PathVariable Integer clienteId) {
		Cliente cliente = clienteService.find(clienteId);
		return enderecoService.findByCliente(cliente);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Endereco findEndereco(@PathVariable Integer clienteId, @PathVariable Integer id) {
		Cliente cliente = clienteService.find(clienteId);
		return enderecoService.findByClienteAndId(cliente, id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Endereco save(@PathVariable Integer clienteId, @RequestBody Endereco endereco) {
		Cliente cliente = clienteService.find(clienteId);
		endereco.setCliente(cliente);
		return enderecoService.save(endereco);
	}

	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public Endereco atualizar(@PathVariable Integer clienteId, @PathVariable Integer id, @RequestBody Endereco endereco) {
		Cliente cliente = clienteService.find(clienteId);
		endereco.setId(id);
		endereco.setCliente(cliente);
		return enderecoService.save(endereco);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deleteEndereco(@PathVariable Integer clienteId, @PathVariable Integer id) {
		Cliente cliente = clienteService.find(clienteId);
		enderecoService.deleteByClienteAndId(cliente, id);
	}

}
