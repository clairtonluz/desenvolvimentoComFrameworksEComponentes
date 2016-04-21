package br.edu.fa7.resource;

import java.util.List;
import java.util.concurrent.Future;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.edu.fa7.model.Compra;
import br.edu.fa7.service.CompraService;

@Stateless
@Path(value = "/compra")
@Produces("application/json")
public class CompraResource {
	
	@EJB
	CompraService service;
	
	
	@GET
	@Path("/")
	public Response produtos() {
		List<Compra> findAll = service.findAll();
		return Response.status(200).entity( findAll ).build();
	}
	
	@GET
	@Path("/{id}")
	public Response produto(@PathParam("id") Integer id) throws Exception  {
		Compra compra = service.findOne(id);
		if(compra != null){
			Future<Compra> futureCompra = service.preencheCliente(compra);
			return Response.status(200).entity( futureCompra.get() ).build();
		}
		return Response.status(404).build();
	}

}
