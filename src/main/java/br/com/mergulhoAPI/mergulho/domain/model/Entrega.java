package br.com.mergulhoAPI.mergulho.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// muitas entregas tem 1 cliente
	@ManyToOne
	private Cliente cliente;
	// na mesma tabela
	@Embedded
	private Destinatario destinatario;

	private BigDecimal taxa;

	@Enumerated(EnumType.STRING)
	private StatusEntrega status;

	private LocalDateTime dataPedido;

	private LocalDateTime dataFinalizacao;

}
