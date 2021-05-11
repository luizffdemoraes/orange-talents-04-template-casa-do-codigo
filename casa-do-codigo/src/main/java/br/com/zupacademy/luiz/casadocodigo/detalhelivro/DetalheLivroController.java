package br.com.zupacademy.luiz.casadocodigo.detalhelivro;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.luiz.casadocodigo.livro.Livro;

@RestController
@RequestMapping("/livrosDetalhes")
public class DetalheLivroController {
	
	
	@Autowired
	private DetalhesLivroRepository livroRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> detalhesLivro(@PathVariable("id") Long idLivro){
		Optional<Livro> livro = livroRepository.findById(idLivro);
		
		if (livro.isPresent()) {
			return ResponseEntity.ok(new DetalhesLivroResponse(livro.get()));
		}

		return ResponseEntity.notFound().build();
	}


}
