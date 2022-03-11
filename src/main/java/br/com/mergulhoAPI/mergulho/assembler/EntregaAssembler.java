package br.com.mergulhoAPI.mergulho.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.mergulhoAPI.mergulho.domain.model.Entrega;
import br.com.mergulhoAPI.mergulho.model.EntregaModel;
import br.com.mergulhoAPI.mergulho.model.input.EntregaInput;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EntregaAssembler {
	private ModelMapper modelMapper;

	public EntregaModel toModel(Entrega entrega) {
		return modelMapper.map(entrega, EntregaModel.class);
	}

	public List<EntregaModel> toCollectionModel(List<Entrega> entregas) {
		return entregas.stream().map(this::toModel).collect(Collectors.toList());

	}

	public Entrega toEntity(EntregaInput entregaInput) {
		return modelMapper.map(entregaInput, Entrega.class);
	}
}
