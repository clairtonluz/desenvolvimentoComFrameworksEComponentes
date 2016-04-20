package br.edu.fa7.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.fa7.model.Cliente;

@Repository
public class ClienteRepository {

	@Autowired
	private EntityManager em;

	public List<Cliente> findAll() {
		return em.createQuery("from Cliente c", Cliente.class).getResultList();
	}

	public Cliente find(Integer id) {
		return em.find(Cliente.class, id);
	}

	@Transactional
	public Cliente save(Cliente cliente) {
		if (cliente.getId() == null) {
			em.persist(cliente);
		} else {
			em.merge(cliente);
		}

		return cliente;
	}

	@Transactional
	public void delete(Cliente cliente) {
		if (cliente != null) {
			em.remove(cliente);
		}
	}
}
