package br.com.zupacademy.luiz.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class CategoriaRequest {
	
	@NotBlank @Length(min = 3)
	private String nome;

	public String getNome() {
		return nome;
	}
	
	
	@Deprecated
	public CategoriaRequest() {
	}



	public CategoriaRequest(String nome) {
		this.nome = nome;
	}
	
	public Categoria transformaCategoria() {
		return new Categoria(this.nome);
		
	}

	@Override
	public String toString() {
		return "CategoriaRequest [nome=" + nome + "]";
	}
	
	
}
