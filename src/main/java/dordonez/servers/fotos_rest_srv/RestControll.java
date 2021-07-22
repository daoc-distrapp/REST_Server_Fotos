package dordonez.servers.fotos_rest_srv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControll {

	@Autowired
	FotoRepository repository;
	
	@GetMapping("/fotos/{id}")
	public Foto getDato(@PathVariable("id") long id) {
		return repository.findById(id).orElse(null);
	}
	
	@GetMapping("/fotos")
	public List<Foto> getFotos() {
		return repository.findAll();
	}	
	
	@GetMapping("/fotos/list")
	public List<Object[]> getList() {
		return repository.getList();
	}	
	
	@PostMapping("/create")
	public ResponseEntity<?> postDato(@RequestBody Foto foto) {
		if(!repository.existsById(foto.getId())) {
			repository.save(foto);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
	}

	@PutMapping("/update")
	public ResponseEntity<?> putDato(@RequestBody Foto foto) {
		repository.save(foto);
		return ResponseEntity.ok().build();
	}	
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteDato(@RequestBody Foto foto) {
		repository.delete(foto);
		return ResponseEntity.ok().build();
	}
	
}
