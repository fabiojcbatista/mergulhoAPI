package br.com.mergulhoAPI.mergulho.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mergulhoAPI.mergulho.assembler.OcorrenciaAssembler;
import br.com.mergulhoAPI.mergulho.domain.model.Entrega;
import br.com.mergulhoAPI.mergulho.domain.model.Ocorrencia;
import br.com.mergulhoAPI.mergulho.domain.service.BuscaEntregaService;
import br.com.mergulhoAPI.mergulho.domain.service.RegistroOcorrenciaService;
import br.com.mergulhoAPI.mergulho.model.OcorrenciaModel;
import br.com.mergulhoAPI.mergulho.model.input.OcorrenciaInput;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

	private RegistroOcorrenciaService registroOcorrenciaService;
	private OcorrenciaAssembler ocorrenciaAssembler;
	private BuscaEntregaService buscaEntregaService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaModel registrar(@PathVariable Long entregaId,
			@Valid @RequestBody OcorrenciaInput ocorrenciaInput) {

		Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService.registrar(entregaId,
				ocorrenciaInput.getDescricao());

		return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
	}

	@GetMapping
	public List<OcorrenciaModel> listar(@PathVariable Long entregaId) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
	}
}
