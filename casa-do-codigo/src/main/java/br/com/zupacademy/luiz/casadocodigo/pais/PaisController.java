package br.com.zupacademy.luiz.casadocodigo.pais;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pais")
public class PaisController {
	
	@Autowired
	EntityManager manager;

	@PostMapping
	@Transactional
	public String cadastrar(@RequestBody @Valid PaisRequest paisRequest ) {
		Pais pais = paisRequest.toModel();
		manager.persist(pais);
		return pais.toString();
	}
}
