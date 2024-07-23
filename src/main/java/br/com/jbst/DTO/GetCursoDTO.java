package br.com.jbst.DTO;


import java.util.UUID;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class GetCursoDTO {
    private UUID idcurso;
	private Integer codigo;
	private String curso;
	private String modelo_certificado;
	private String descricao;
	private String conteudo;
	private String valorFormacao;
	private String valorReciclagem;
}
