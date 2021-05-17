package br.com.zupacademy.luiz.casadocodigo.estado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.luiz.casadocodigo.pais.Pais;
import br.com.zupacademy.luiz.casadocodigo.validacao.ExistsValue;
import br.com.zupacademy.luiz.casadocodigo.validacao.UniqueValue;

public class EstadoRequest {
	
	@NotBlank 
	@UniqueValue(fieldName = "nome", domainClass = Estado.class)
	private String nome;
	@NotNull
	@ExistsValue(fieldName = "id", targetClass = Pais.class)
	private Long idPais;
	
	public EstadoRequest(String nome, Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}


	public Estado transformaEstado(EntityManager manager) {
		Pais pais = manager.find(Pais.class, idPais);	
		return new Estado(this.nome, pais);
	}
	
}
