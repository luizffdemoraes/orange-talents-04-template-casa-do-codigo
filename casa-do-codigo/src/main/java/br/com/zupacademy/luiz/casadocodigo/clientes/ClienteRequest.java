package br.com.zupacademy.luiz.casadocodigo.clientes;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.luiz.casadocodigo.estado.Estado;
import br.com.zupacademy.luiz.casadocodigo.pais.Pais;
import br.com.zupacademy.luiz.casadocodigo.validacao.CPFouCNPJ;
import br.com.zupacademy.luiz.casadocodigo.validacao.ExistsValue;
import br.com.zupacademy.luiz.casadocodigo.validacao.UniqueValue;

public class ClienteRequest {

	@NotBlank
    @Email
    @UniqueValue(domainClass = Cliente.class, fieldName = "email", message = "Email já cadastrado.")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @CPFouCNPJ(fieldName = "documento", message = "CPF ou CNPJ inválidos.")
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento", message = "CPF ou CNPJ já cadastrados")
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @ExistsValue(targetClass = Pais.class, fieldName = "id", message = "País com o id informado não encontrado.")
    private Long paisId;

    private Long estadoId;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public ClienteRequest(@NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
                          @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
                          @NotBlank String cidade, @NotNull Long paisId, Long estadoId, @NotBlank String telefone,
                          @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.estadoId = estadoId;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

  //Utilizando EntityManager
    public Cliente toModel(EntityManager manager) {
        Pais pais = manager.find(Pais.class, paisId);
        Cliente cliente = new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, telefone, cep);
        Estado estado = null;
        if (estadoId != null) {
            estado = manager.find(Estado.class, estadoId);
            cliente.setEstado(estado);
        }
        return cliente;
    }

	//Utilizando Repository
//	public Clientes converterClienteRequest(EstadoRepository estadoRepository, PaisRepository paisRepository) {
//		final Pais pais = paisRepository.findById(paisId).get();
//		final Estado estado = estadoId != null ? estadoRepository.findById(estadoId).get() : null;
//		return new Clientes(this.email, this.nome, this.sobrenome, this.documento, this.endereco, this.complemento,
//				this.cidade, pais, estado, this.telefone, this.cep);
//
//	}





}
