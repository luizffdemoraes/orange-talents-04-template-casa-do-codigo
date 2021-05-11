package br.com.zupacademy.luiz.casadocodigo.detalhelivro;

import java.math.BigDecimal;

import br.com.zupacademy.luiz.casadocodigo.autor.Autor;
import br.com.zupacademy.luiz.casadocodigo.livro.Livro;

public class DetalhesLivroResponse {
	
	private Autor autor;
	private String titulo;
	private String isbn;
	private Integer numeroPaginas;
	private BigDecimal preco;
	private String resumo;
	private String sumario;
	
	
	public Autor getAutor() {
		return autor;
	}


	public String getTitulo() {
		return titulo;
	}


	public String getIsbn() {
		return isbn;
	}


	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}


	public BigDecimal getPreco() {
		return preco;
	}


	public String getResumo() {
		return resumo;
	}


	public String getSumario() {
		return sumario;
	}


	public DetalhesLivroResponse(Livro livro) {
		this.autor = livro.getAutor();
		this.titulo = livro.getTitulo();
		this.isbn = livro.getIsbn();
		this.numeroPaginas = livro.getNumPaginas();
		this.preco = livro.getPreco();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
	}
	
	
	
}
