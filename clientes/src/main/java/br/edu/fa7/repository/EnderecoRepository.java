package br.edu.fa7.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.fa7.model.Cliente;
import br.edu.fa7.model.Endereco;

@Repository
public class EnderecoRepository {

	@Autowired
	private EntityManager em;

	public List<Endereco> findByCliente(Cliente cliente) {
		return em.createQuery("from Endereco e where e.cliente.id = :clienteId", Endereco.class)
				.setParameter("clienteId", cliente.getId()).getResultList();
	}

	public Endereco findByClienteAndId(Cliente cliente, Integer id) {
		try {
			return em.createQuery("from Endereco e where e.id = :id and e.cliente.id = :clienteId", Endereco.class)
					.setParameter("clienteId", cliente.getId()).setParameter("id", id).getSingleResult();
		} catch (NoResultException e) {
			throw new NotFoundException("Endereco não encontrado");
		}
	}

	@Transactional
	public Endereco save(Endereco Endereco) {
		if (Endereco.getId() == null) {
			em.persist(Endereco);
		} else {
			em.merge(Endereco);
		}

		return Endereco;
	}

	@Transactional
	public void delete(Endereco Endereco) {
		if (Endereco != null) {
			em.remove(Endereco);
		}
	}
}
