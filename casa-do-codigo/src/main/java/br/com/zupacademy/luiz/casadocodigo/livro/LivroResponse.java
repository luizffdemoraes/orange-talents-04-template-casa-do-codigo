package br.com.zupacademy.luiz.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import br.com.zupacademy.luiz.casadocodigo.autor.Autor;
import br.com.zupacademy.luiz.casadocodigo.categoria.Categoria;

public class LivroResponse {

	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer numPaginas;
	private String isbn;
	private String dataPublicacao;
	private Categoria categoria;
	private Autor autor;

	public LivroResponse(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numPaginas = livro.getNumPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.categoria = livro.getCategoria();
		this.autor = livro.getAutor();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumPaginas() {
		return numPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}

	public static List<LivroResponse> converter(List<Livro> livros) {
		return livros.stream().map(LivroResponse::new).collect(Collectors.toList());
	}

}
