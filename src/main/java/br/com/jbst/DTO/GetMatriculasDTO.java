package br.com.jbst.DTO;

import java.time.Instant;
import java.util.UUID;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import br.com.jbst.config.InstantSerializer;
import lombok.Data;

@Data
public class GetMatriculasDTO {
	private UUID idMatricula;
    private Integer numeroMatricula;
    private String observacoes;
    private String venda;
    private String status;
    private String valor;
	@JsonSerialize(using = InstantSerializer.class)
	private Instant dataHoraCriacao;
	private GetFuncionarioDTO funcionario;
	private GetPessoaFisicaDTO pessoafisica;

}
