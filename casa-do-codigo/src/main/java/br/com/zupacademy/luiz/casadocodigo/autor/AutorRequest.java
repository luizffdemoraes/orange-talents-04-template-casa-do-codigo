package br.com.zupacademy.luiz.casadocodigo.autor;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.luiz.casadocodigo.validacao.UniqueValue;

public class AutorRequest {
		
		@NotBlank
		@Length(min = 3)
		private String nome;
		
		@NotBlank 
		@Email
		@UniqueValue(fieldName = "email", domainClass = Autor.class, message = "Já existe um E-mail cadastrado.")
		private String email;
		
		@NotBlank 
		@Length(min = 10, max = 400)
		private String descricao;


		public AutorRequest(String nome, String email, String descricao) {
			this.nome = nome;
			this.email = email;
			this.descricao = descricao;
		}

		public Autor transformaAutor() {
			return new Autor(this.nome, this.email, this.descricao);
		}

		@Override
		public String toString() {
			return "AutorRequest [nome=" + nome + ", email=" + email + ", descricao=" + descricao + "]";
		}

		public String getEmail() {
			return email;
		}

		
	
}
