package br.com.jbst.DTO;

import java.time.Instant;
import java.util.UUID;

import lombok.Data;


@Data
public class GetInstrutorDTO {
	private UUID idinstrutor;
	private Instant dataHoraCriacao;
	private String instrutor;
	private String rg;
	private String cpf;



}
