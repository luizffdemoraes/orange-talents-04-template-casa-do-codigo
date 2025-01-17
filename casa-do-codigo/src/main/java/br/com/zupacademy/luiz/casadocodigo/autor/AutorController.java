package br.com.zupacademy.luiz.casadocodigo.autor;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping
	public ResponseEntity<Autor> cadastraAutor(@RequestBody @Valid AutorRequest request) {
		System.out.println("Autor " + request);
		Autor autor = request.transformaAutor();
		Optional<Autor> emailAutor = autorRepository.findByEmail(request.getEmail());
		
		if(emailAutor.isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		
		autorRepository.save(autor);
		System.out.println("Autor cadastrado!");
		return ResponseEntity.ok().build();
	}
}
