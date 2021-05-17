package br.com.zupacademy.luiz.casadocodigo.clientes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.luiz.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.luiz.casadocodigo.pais.PaisRepository;
import br.com.zupacademy.luiz.casadocodigo.validacao.RequererEstadoEmPaisValidator;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private RequererEstadoEmPaisValidator requererEstadoEmPaisValidator;


	@PersistenceContext
	private EntityManager manager;

	@InitBinder
	public void Init(WebDataBinder binder) {
		binder.addValidators(requererEstadoEmPaisValidator);
	}



	// Utilizando EntityManaget
	@PostMapping
	@Transactional
	public ResponseEntity<ClienteResponse> salvar(@RequestBody @Valid ClienteRequest form) {
		Cliente cliente = form.toModel(manager);
		manager.persist(cliente);
		return ResponseEntity.ok(new ClienteResponse(cliente));
	}

	// Utilizando Repository
//	@PostMapping
//	@Transactional
//	public ResponseEntity<ClienteResponse> cadastrar(@RequestBody @Valid ClienteRequest request) {
//		Clientes novoCliente = request.converterClienteRequest(estadoRepository, paisRepository);
//		clienteRepository.save(novoCliente);
//		return ResponseEntity.ok(new ClienteResponse(novoCliente));
//
//	}


}
