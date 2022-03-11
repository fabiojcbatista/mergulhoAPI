package br.com.mergulhoAPI.mergulho.model.input;


import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteIdInput {
	@NotNull
	private Long id;
}
