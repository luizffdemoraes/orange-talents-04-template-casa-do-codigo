package br.com.zupacademy.luiz.casadocodigo.validacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.luiz.casadocodigo.clientes.ClienteRequest;
import br.com.zupacademy.luiz.casadocodigo.estado.Estado;
import br.com.zupacademy.luiz.casadocodigo.estado.EstadoRepository;

@Component
public class RequererEstadoEmPaisValidator implements Validator {

	@Autowired
	EstadoRepository estadoRepository;

	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean supports(Class<?> clazz) {
		return ClienteRequest.class.isAssignableFrom(clazz);
	}

	// Utilizando Entity Manager fazendo um query buscando id utilizando estado
	@Override
	public void validate(Object o, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		ClienteRequest clienteRequest = (ClienteRequest) o;
		TypedQuery<Estado> query = manager.createQuery("SELECT e FROM Estado e where e.pais.id =:paisId", Estado.class);
		query.setParameter("paisId", clienteRequest.getPaisId());
		List<Estado> estados = query.getResultList();
		if (!estados.isEmpty() && clienteRequest.getEstadoId() == null) {
			errors.rejectValue("estadoId", null, "Necessário informar o seu estado");
		}
	}

}
