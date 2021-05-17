package br.com.zupacademy.luiz.casadocodigo.pais;

import br.com.zupacademy.luiz.casadocodigo.validacao.UniqueValue;

public class PaisRequest {

	@UniqueValue(fieldName = "nome", domainClass = Pais.class)
	private String nome;

	@Deprecated
	public PaisRequest() {
	}

	public PaisRequest(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Pais toModel() {
		return new Pais(this.nome);
	}

}
