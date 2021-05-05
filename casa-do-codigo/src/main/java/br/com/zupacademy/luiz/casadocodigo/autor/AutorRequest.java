package br.com.zupacademy.luiz.casadocodigo.autor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class AutorRequest {
		
		@NotBlank @Length(min = 3)
		private String nome;
		
		@NotBlank @Email
		private String email;
		
		@NotBlank @Length(min = 10, max = 400)
		private String descricao;


		public AutorRequest(String nome, String email, String descricao) {
			this.nome = nome;
			this.email = email;
			this.descricao = descricao;
		}

		public Autor transformaAutor() {
			return new Autor(this.nome, this.descricao, this.email);
		}

		@Override
		public String toString() {
			return "AutorRequest [nome=" + nome + ", email=" + email + ", descricao=" + descricao + "]";
		}

		public String getEmail() {
			return email;
		}

		
	
}
