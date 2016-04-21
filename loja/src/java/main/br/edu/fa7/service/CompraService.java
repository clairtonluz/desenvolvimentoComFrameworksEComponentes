package br.edu.fa7.service;

import java.util.List;
import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import br.edu.fa7.model.Compra;
import br.edu.fa7.model.vo.ClienteVO;

@Stateless
@LocalBean
public class CompraService {
	
	@PersistenceContext
	EntityManager em;
	

	final String CLIENT_URI = "http://localhost:8082/clientes/";
	
	public List<Compra> findAll(){
		return em.createQuery("FROM Compra a" , Compra.class).getResultList();
	}
	
	public Compra findOne(Integer id){
		TypedQuery<Compra> query = em.createQuery("From Compra a WHERE a.id = :id", Compra.class);
		query.setParameter("id", id);
		List<Compra> resultList = query.getResultList();
		return resultList.isEmpty() ? null : resultList.get(0);
	} 
	
	@Asynchronous
	public Future<Compra> preencheCliente( Compra compra ) throws Exception{
		ClientRequest request = new ClientRequest(CLIENT_URI + compra.getClienteId() );
		request.accept("application/json");
		ClientResponse<ClienteVO> clientResponse = request.get(ClienteVO.class);
		compra.setCliente( clientResponse.getEntity() );
		return new AsyncResult<Compra>(compra);
	}
	
}
