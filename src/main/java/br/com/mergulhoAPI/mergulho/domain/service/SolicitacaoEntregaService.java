package br.com.mergulhoAPI.mergulho.domain.service;

import java.time.OffsetDateTime;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.mergulhoAPI.mergulho.domain.model.Cliente;
import br.com.mergulhoAPI.mergulho.domain.model.Entrega;
import br.com.mergulhoAPI.mergulho.domain.model.StatusEntrega;
import br.com.mergulhoAPI.mergulho.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SolicitacaoEntregaService {
	private EntregaRepository entregaRepository;
	private CatalogoClienteService catalogoClienteServive;

	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = catalogoClienteServive.buscar(entrega.getCliente().getId());
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		return entregaRepository.save(entrega);
	}
}
