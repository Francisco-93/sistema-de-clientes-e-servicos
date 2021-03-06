package br.com.basis.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.basis.model.Cliente;
import br.com.basis.repository.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@GetMapping(value = "/{id}")
	public Cliente findById(@PathVariable Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não econtrado."));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente insert(@RequestBody @Valid Cliente cliente) {
		return repository.save(cliente);
	}
	
	@PutMapping(value = "/{id}")
	public Cliente updateCliente(@PathVariable Integer id, @RequestBody @Valid Cliente cliente) {
		Cliente obj = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não econtrado."));
		cliente.setId(obj.getId());
		cliente.setDataCadastro(obj.getDataCadastro());
		return repository.save(cliente);
	}
	
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Integer id) {
		Cliente obj = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não econtrado."));
		if(obj != null) {
			repository.delete(obj);
		}
	}
	
}
