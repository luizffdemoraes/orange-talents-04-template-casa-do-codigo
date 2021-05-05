package br.com.zupacademy.luiz.casadocodigo.autor;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

@Entity
public class Autor {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank @Length(min = 3)
	private String nome;
	
	@NotBlank 
	@Column(unique=true, nullable=false)
	private String email;
	
	@NotBlank @Length(min = 10, max = 400)
	private String descricao;
	
	@CreationTimestamp
	private LocalDateTime criacao = LocalDateTime.now(ZoneOffset.UTC);
	
	@Deprecated
	public Autor() {
	}
	
	public Autor(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	
	

	public String getNome() {
		return nome;
	}



	public String getEmail() {
		return email;
	}



	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getInstante() {
		return criacao;
	}



	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", email=" + email + ", descricao=" + descricao + ", criacao="
				+ criacao + "]";
	}

	


	
	
	

}
