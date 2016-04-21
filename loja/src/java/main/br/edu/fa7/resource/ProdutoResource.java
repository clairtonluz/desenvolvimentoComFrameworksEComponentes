package br.edu.fa7.resource;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.edu.fa7.model.Produto;
import br.edu.fa7.service.ProdutoService;

@Stateless
@Path(value = "/produtos")
@Produces("application/json")
public class ProdutoResource {
	
	@EJB
	ProdutoService produtoService;
	
	@GET
	@Path("/")
	public Response produtos() {
		List<Produto> findAll = produtoService.findAll();
		return Response.status(200).entity( findAll ).build();
	}
	
	@GET
	@Path("/{id}")
	public Response produto(@PathParam("id") Integer id) {
		Produto findOne = produtoService.findOne(id);
		if(findOne != null){
			return Response.status(200).entity( findOne ).build();
		}
		return Response.status(404).build();
	}

}
