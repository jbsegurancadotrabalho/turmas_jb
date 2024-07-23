package br.com.jbst.DTO;

import java.time.Instant;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.jbst.config.InstantSerializer;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class GetTurmasDTO {

    private UUID idTurmas;
    @JsonProperty("numeroTurma")
    private Integer numeroTurma;
    @JsonSerialize(using = InstantSerializer.class)
    private Instant datainicio;
    @JsonSerialize(using = InstantSerializer.class)
    private Instant datafim;
    private String cargahoraria;
    private String modalidade;
    private String status;
    private String nivel;
    private String validade;
    private String validadedocurso;
    private String instrutor;
    private String tipo;
	private String observacoes;
	private boolean turmaFechada;
    @JsonProperty("curso")
    private GetCursoDTO curso;
    @JsonProperty("unidadeDeTreinamento") // ajuste de nome
    private GetUnidadeDeTreinamentoDTO unidadeDeTreinamento;
    private List<GetInstrutorDTO> instrutores;
    private List<GetMatriculasDTO> matricula;
}
