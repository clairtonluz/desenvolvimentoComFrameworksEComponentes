package br.edu.fa7.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.edu.fa7.model.Produto;

@Stateless
@LocalBean
public class ProdutoService {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Produto> findAll(){
		return em.createQuery("FROM Produto a" , Produto.class).getResultList();
	}
	
	public Produto findOne(Integer id){
		TypedQuery<Produto> query = em.createQuery("From Produto a WHERE a.id = :id", Produto.class);
		query.setParameter("id", id);
		List<Produto> resultList = query.getResultList();
		return resultList.isEmpty() ? null : resultList.get(0);
	} 
	
}
