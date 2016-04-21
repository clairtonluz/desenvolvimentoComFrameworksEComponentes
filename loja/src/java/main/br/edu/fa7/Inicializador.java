package br.edu.fa7;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.fa7.model.Compra;
import br.edu.fa7.model.Produto;

@Startup
@Singleton
public class Inicializador {
	
	@PersistenceContext
	EntityManager em;
	
	/**
	 * Popular banco com alguns registros
	 */
	@PostConstruct
	public void init(){
		criarProdutos();
		criarCompras();
	}

	public void criarProdutos(){
		Produto p = new Produto("Água" , 2.0);
		em.persist( p );
		p = new Produto("Lapiz" , 1.0);
		em.persist( p );
		p = new Produto("Caneta" , 1.5);
		em.persist( p );
	}
	
	public void criarCompras(){
		Produto produto1 = (Produto) em.createQuery("FROM Produto a WHERE a.id = 1").getSingleResult();
		Produto produto2 = (Produto) em.createQuery("FROM Produto a WHERE a.id = 2").getSingleResult();
		
		Compra compra = new Compra();
		compra.setClienteId( 1 );
		compra.setProduto( produto1 );
		compra.setValor( produto1.getPreco() );
		em.persist( compra );
		
		compra = new Compra();
		compra.setClienteId( 2 );
		compra.setProduto( produto1 );
		compra.setValor( produto1.getPreco() );
		em.persist( compra );
		
		compra = new Compra();
		compra.setClienteId( 2 );
		compra.setProduto( produto2 );
		compra.setValor( produto2.getPreco() );
		em.persist( compra );
    }
	
}
