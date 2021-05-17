package br.com.zupacademy.luiz.casadocodigo.clientes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.util.Assert;

import br.com.zupacademy.luiz.casadocodigo.estado.Estado;
import br.com.zupacademy.luiz.casadocodigo.pais.Pais;

@Entity
public class Cliente {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(unique = true, nullable = false)
    private String documento;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String complemento;

    @Column(nullable = false)
    private String cidade;

    @ManyToOne(optional = false)
    private Pais pais;

    @ManyToOne
    private Estado estado;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String cep;

    @Deprecated
    public Cliente() {}

    public Cliente(String email, String nome, String sobrenome, String documento, String endereco, String complemento,
                   String cidade, Pais pais, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }


	/// Captuar uma possivel IllegalStateException lá no exception handler
	public void setEstado(Estado estado) {
		Assert.state(pais.equals(estado.getPais()),
				"O estado " + estado.getNome() + " não pertence ao país " + this.pais.getNome());
		this.estado = estado;
	}

}
