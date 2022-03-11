package br.com.mergulhoAPI.mergulho.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.mergulhoAPI.mergulho.domain.model.Entrega;
import br.com.mergulhoAPI.mergulho.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {
	private BuscaEntregaService buscaEntregaService;
	private EntregaRepository entregaRepository;

	@Transactional
	public void finalizar(Long entregaId) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		entrega.finalizar();
		entregaRepository.save(entrega);
	}
}
