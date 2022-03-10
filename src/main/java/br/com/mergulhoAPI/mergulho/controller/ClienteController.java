package br.com.mergulhoAPI.mergulho.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mergulhoAPI.mergulho.domain.model.Cliente;
import br.com.mergulhoAPI.mergulho.domain.repository.ClienteRepository;
import br.com.mergulhoAPI.mergulho.domain.service.CatalogoClienteService;
import lombok.AllArgsConstructor;

//gera construtor da class - lombok
@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private ClienteRepository clienteRepository;
	private CatalogoClienteService catalogoClienteService;

	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
		// return clienteRepository.findByNome("Fabio");
		// return clienteRepository.findByNomeContaining("Ma");

//		return manager.createQuery("from Cliente", Cliente.class)
//				.getResultList();

//		Cliente cliente1 = new Cliente();
//		Cliente cliente2 = new Cliente();
//
//		cliente1.setId(1l);
//		cliente1.setNome("Mergulhinho");
//		cliente1.setEmail("1234@mudar.com.br");
//		cliente1.setTelefone("992982828");
//
//		cliente2.setId(2l);
//		cliente2.setNome("Mergu");
//		cliente2.setEmail("1234@mudar.com.br");
//		cliente2.setTelefone("992982828");
//
//		return Arrays.asList(cliente1, cliente2);
	}

	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {

		return clienteRepository.findById(clienteId)
				// .map(cliente -> ResponseEntity.ok(cliente))
				.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

//		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
//		if (cliente.isPresent()) {
//			return ResponseEntity.ok(cliente.get());
//		}
//
//		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
		return catalogoClienteService.salvar(cliente);
		//return clienteRepository.save(cliente);
	}

	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long clienteId, @RequestBody Cliente cliente) {
		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}

		cliente.setId(clienteId);
		cliente = catalogoClienteService.salvar(cliente);
		//cliente = clienteRepository.save(cliente);

		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> remover(@PathVariable Long clienteId) {
		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}

		//clienteRepository.deleteById(clienteId);
		catalogoClienteService.excluir(clienteId);
		return ResponseEntity.noContent().build();
	}

}
