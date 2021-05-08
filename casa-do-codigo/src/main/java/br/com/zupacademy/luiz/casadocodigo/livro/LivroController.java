package br.com.zupacademy.luiz.casadocodigo.livro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	 @PersistenceContext
	 EntityManager manager;
	
	
	@PostMapping
    @Transactional
    public String cadastrarLivro(@RequestBody @Valid LivroRequest request){
		Livro novoLivro = request.transformaLivro(manager);
		manager.persist(novoLivro);
        return novoLivro.toString();
    }
	
	

}
