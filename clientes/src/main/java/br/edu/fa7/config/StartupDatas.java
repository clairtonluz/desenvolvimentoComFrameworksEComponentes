package br.edu.fa7.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.fa7.model.Cliente;
import br.edu.fa7.model.Endereco;
import br.edu.fa7.service.ClienteService;
import br.edu.fa7.service.EnderecoService;

@Component
public class StartupDatas {

	
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private EnderecoService enderecoService;
	
	@PostConstruct
	public void start(){
		Cliente c1 = new Cliente();
		c1.setEmail("clairton@gmail.com");
		c1.setLogin("clairton");
		c1.setNome("Clairton Luz");
		
		Cliente c2 = new Cliente();
		c2.setEmail("efraim@gmail.com");
		c2.setLogin("efraim");
		c2.setNome("Efraim Gentil");
		
		clienteService.save(c1);
		clienteService.save(c2);
		
		Endereco e1 = new Endereco();
		Endereco e2 = new Endereco();

		e1.setCep("61607045");
		e2.setCep("61607123");
		e1.setCliente(c1);
		e2.setCliente(c2);
		e1.setComplemento("Altos");
		e2.setComplemento("B");
		e1.setLogradouro("Rua 124");
		e2.setLogradouro("Rua 1");
		
		enderecoService.save(e1);
		enderecoService.save(e2);
	}
}
