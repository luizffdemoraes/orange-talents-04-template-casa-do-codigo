package br.com.zupacademy.luiz.casadocodigo.categoria;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping
	public ResponseEntity<Categoria> cadastrarCategoria(@RequestBody @Valid CategoriaRequest request){
		System.out.println("Categoria " + request);
		Categoria categoria = request.transformaCategoria();
		Optional<Categoria> nomeCategoria = categoriaRepository.findByNome(request.getNome());
		
		if(nomeCategoria.isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		
		categoriaRepository.save(categoria);
		System.out.println("Categoria cadastrada!");
		return ResponseEntity.ok().build();
	}

}
