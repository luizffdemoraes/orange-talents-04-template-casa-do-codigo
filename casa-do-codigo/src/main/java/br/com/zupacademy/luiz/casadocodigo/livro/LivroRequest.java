package br.com.zupacademy.luiz.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.util.Assert;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.luiz.casadocodigo.autor.Autor;
import br.com.zupacademy.luiz.casadocodigo.categoria.Categoria;
import br.com.zupacademy.luiz.casadocodigo.validacao.ExistsValue;
import br.com.zupacademy.luiz.casadocodigo.validacao.UniqueValue;

public class LivroRequest {

	@NotBlank
	@UniqueValue(fieldName = "titulo", domainClass = Livro.class, message = "titulo deve ser único")
	private String titulo;

	@NotBlank
	@Length(max = 500)
	private String resumo;

	private String sumario;

	@NotNull
	@Min(20)
	private BigDecimal preco;

	@NotNull
	@Min(100)
	private Integer numeroPaginas;

	@NotBlank
	private String isbn;

	@Future @JsonFormat(pattern = "yyyy-MM-d", shape = JsonFormat.Shape.STRING)
	private LocalDate dataPublicacao;

	@NotNull
	@ExistsValue(fieldName = "id", targetClass = Categoria.class, message = "Categoria deve existir")
	private Long categoriaId;

	@NotNull
	@ExistsValue(fieldName = "id", targetClass = Autor.class, message = "Autor deve existir")
	private Long autorId;

	public LivroRequest(String titulo, String resumo, String sumario, BigDecimal preco, Integer numPaginas, String isbn,
			LocalDate dataPublicacao, Long categoriaId, Long autorId) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoriaId = categoriaId;
		this.autorId = autorId;
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

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public Long getAutorId() {
		return autorId;
	}

	public Livro transformaLivro(EntityManager manager) {
		Categoria categoria = manager.find(Categoria.class, categoriaId);
		Autor autor = manager.find(Autor.class, autorId);

		Assert.state(autor != null, "Autor não encontrado");
		Assert.state(categoria != null, "Categoria não encontrada");

		return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroPaginas, this.isbn,
				this.dataPublicacao, categoria, autor);
	}

}
