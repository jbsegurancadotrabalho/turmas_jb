
package br.com.jbst.controllers;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.jbst.DTO.GetMatriculasDTO;
import br.com.jbst.DTO.GetTurmasDTO;

import br.com.jbst.services.TurmasService;

@RestController
@RequestMapping("/api/turmas")
public class TurmasController {

    @Autowired
    TurmasService turmasService;

    @GetMapping("/consultar-todas-turmas")
    public ResponseEntity<List<GetTurmasDTO>> consultarTurmas() throws Exception {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(turmasService.consultarTodasTurmas());
    }


  
    @GetMapping("/consultar-turmas-por-mes-e-ano")
    public ResponseEntity<List<GetTurmasDTO>> consultarTurmasPorMesEAno(
            @RequestParam int mes,
            @RequestParam int ano) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(turmasService.consultarTurmasPorMesEAno(mes, ano));
    }


    @GetMapping("/consultar-turmas-data-inico-e-fim")
    public ResponseEntity<List<GetTurmasDTO>> getTurmasByDataInicioDataFimEUnidadeDeTreinamento(
            @RequestParam(name = "diaInicio") int diaInicio,
            @RequestParam(name = "mesInicio") int mesInicio,
            @RequestParam(name = "anoInicio") int anoInicio,
            @RequestParam(name = "diaFim") int diaFim,
            @RequestParam(name = "mesFim") int mesFim,
            @RequestParam(name = "anoFim") int anoFim,
            @RequestParam(name = "unidadeId") UUID unidadeId) {

        Instant dataInicio = Instant.ofEpochSecond(0)
                .atZone(ZoneOffset.UTC)
                .withYear(anoInicio)
                .withMonth(mesInicio)
                .withDayOfMonth(diaInicio)
                .toInstant();

        Instant dataFim = Instant.ofEpochSecond(0)
                .atZone(ZoneOffset.UTC)
                .withYear(anoFim)
                .withMonth(mesFim)
                .withDayOfMonth(diaFim)
                .toInstant();

        List<GetTurmasDTO> turmas = turmasService.consultarTurmasPorDataInicioDataFimEUnidadeDeTreinamento(dataInicio, dataFim, unidadeId);

        if (turmas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(turmas, HttpStatus.OK);
        }
    }

    @GetMapping("/abertas")
    public ResponseEntity<List<GetTurmasDTO>> getTurmasAbertas() {
        List<GetTurmasDTO> turmasAbertas = turmasService.consultarTurmasAbertas();
        return ResponseEntity.ok(turmasAbertas);
    }

}
