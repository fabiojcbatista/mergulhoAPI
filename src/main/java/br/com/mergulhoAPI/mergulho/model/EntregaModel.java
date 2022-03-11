package br.com.mergulhoAPI.mergulho.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import br.com.mergulhoAPI.mergulho.domain.model.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaModel {
	private long id;
	private ClienteResumoModel cliente;
	private String NomeCliente;
	private DestinatarioModel destinatario;
	private BigDecimal taxa;
	private StatusEntrega status;
	private OffsetDateTime dataPedido;
	private OffsetDateTime dataFinalizacao;

}
