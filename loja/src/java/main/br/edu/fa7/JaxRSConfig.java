package br.edu.fa7;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.edu.fa7.resource.CompraResource;
import br.edu.fa7.resource.ProdutoResource;

@ApplicationPath(value = "/rest/")
public class JaxRSConfig extends Application {
	
	private Set<Class<?>> classes = new HashSet<Class<?>>(); 
	private Set<Object> singletons = new HashSet<Object>();

	public JaxRSConfig() {
		classes.add( ProdutoResource.class );
		classes.add( CompraResource.class );
	}
	
	public java.util.Set<java.lang.Class<?>> getClasses() {
		return classes;
	};
	
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
