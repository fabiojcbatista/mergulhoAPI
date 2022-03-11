package br.com.mergulhoAPI.mergulho.domain.service;

import org.springframework.stereotype.Service;

import br.com.mergulhoAPI.mergulho.domain.exception.EntidadeNaoEncontradaException;
import br.com.mergulhoAPI.mergulho.domain.model.Entrega;
import br.com.mergulhoAPI.mergulho.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscaEntregaService {
	private EntregaRepository entregaRepository;
	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada!!!"));
	}
}
