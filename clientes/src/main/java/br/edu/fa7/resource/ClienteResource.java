package br.edu.fa7.resource;

import java.util.List;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fa7.model.Cliente;
import br.edu.fa7.service.ClienteService;

@RestController
@RequestMapping(value = "clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(method=RequestMethod.GET)
	public List<Cliente> findAll() {
		return clienteService.findAll();
	}

	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public Cliente find(@PathVariable Integer id) {
		Cliente cliente = clienteService.find(id);
		if(cliente == null) {
			throw new NotFoundException("Cliente não encontrado");
		}
		return cliente;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Cliente save(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}

	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public Cliente atualizar(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		clienteService.delete(id);
	}

}
