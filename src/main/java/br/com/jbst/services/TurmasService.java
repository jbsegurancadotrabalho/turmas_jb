package br.com.jbst.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.jbst.DTO.GetTurmasDTO;
import br.com.jbst.entities.Turmas;
import br.com.jbst.repositories.TurmasRepository;
@Service
public class TurmasService {

    @Autowired
    TurmasRepository turmasRepository;

    @Autowired
    ModelMapper modelMapper;
    public List<GetTurmasDTO> consultarTodasTurmas() {
        List<Turmas> turmas = turmasRepository.findAllTurmas();
        return mapToDTOList(turmas);
    }

   

    public List<GetTurmasDTO> consultarTurmasPorMesEAno(int mes, int ano) {
        List<Turmas> turmasPorMesEAno = turmasRepository.findTurmasByMesAndAno(mes, ano);
        return mapToDTOList(turmasPorMesEAno);
    }

    private List<GetTurmasDTO> mapToDTOList(List<Turmas> turmas) {
        return turmas.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private GetTurmasDTO mapToDTO(Turmas turma) {
        return modelMapper.map(turma, GetTurmasDTO.class);
    }
    
    public List<GetTurmasDTO> consultarTurmasPorDataInicioDataFimEUnidadeDeTreinamento(
            Instant inicio, Instant fim, UUID unidadeId) {
        List<Turmas> turmas = turmasRepository.findTurmasByDataInicioAndDataFimAndUnidadeDeTreinamentoId(inicio, fim, unidadeId);
        return mapToDTOList(turmas);
    }
    
    public List<GetTurmasDTO> consultarTurmasAbertas() {
        List<Turmas> turmasAbertas = turmasRepository.findTurmasByTurmaFechada(false);
        return mapToDTOList(turmasAbertas);
    }


}

