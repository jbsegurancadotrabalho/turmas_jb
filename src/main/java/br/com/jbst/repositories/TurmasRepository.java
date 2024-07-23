package br.com.jbst.repositories;


import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.jbst.entities.Turmas;

public interface TurmasRepository extends JpaRepository<Turmas, UUID >{

	@Query(
			"select t from Turmas t "

	)
	List<Turmas> findAllByDescricao();
	
	
	@Query(
			"select t from Turmas t "
		  + "left join t.instrutores i "
		  + "where t.id = :id "
	)
	Turmas find(@Param("id") UUID id);
	
	
	@Query("select t from Turmas t where t.id = :id ")
	Turmas findIdTurmas(@Param("id") UUID id);
	
	@Query("SELECT MAX(t.numeroTurma) FROM Turmas t")
    Integer findMaxNumeroTurmas();
	
	

    @Query("SELECT t FROM Turmas t")
	List<Turmas> findAllTurmas();
    
    @Query("SELECT t FROM Turmas t WHERE EXTRACT(MONTH FROM t.datainicio) = :mes AND EXTRACT(YEAR FROM t.datainicio) = :ano")
    List<Turmas> findTurmasByMesAndAno(@Param("mes") int mes, @Param("ano") int ano);

    @Query("SELECT t FROM Turmas t WHERE t.datainicio BETWEEN :dataInicio AND :dataFim AND t.unidadeDeTreinamento.idUnidadedetreinamento = :unidadeId")
    List<Turmas> findTurmasByDataInicioAndDataFimAndUnidadeDeTreinamentoId(
            @Param("dataInicio") Instant inicio,
            @Param("dataFim") Instant fim,
            @Param("unidadeId") UUID unidadeId
    );
    
    @Query("SELECT t FROM Turmas t WHERE t.turmaFechada = :turmaFechada")
    List<Turmas> findTurmasByTurmaFechada(@Param("turmaFechada") boolean turmaFechada);


}