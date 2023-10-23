package com.example.ac2.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ac2.dtos.DadosProfessorDTO;
import com.example.ac2.dtos.ProfessorDTO;
import com.example.ac2.models.Professor;
import com.example.ac2.repository.ProfessorRepository;

@Service
public class ProfessorService {
    
    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    // public List<ProfessorDTO> listarPorCategorias(List<Integer> cursoProfessorId) {
    // List<ProfessorDTO> professores = professorRepository.findAll().stream()
    //         .filter(p -> cursoProfessorId.contains(
    //                 p.getCursos() == null ? 0 : p.getCursos().getId()))
    //         .map((Professor p) -> {
    //             return ProfessorDTO.builder()
    //                     .id(p.getId())
    //                     .nome(p.getNome())
    //                     .rg(p.getRg())
    //                     .cursoProfessorId(
    //                             p.getCursos() == null ? 0
    //                                     : p.getCursos())
    //                     .build();
    //         })
    //         .collect(Collectors.toList());
    // return professores;
// }


    public Optional<Professor> getProfessorById(Integer id) {
        return professorRepository.findById(id);
    }

    public Professor saveProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor updateProfessor(Integer id, Professor professor) {
        if (professorRepository.existsById(id)) {
            professor.setId(id);
            return professorRepository.save(professor);
        } else {
            return null;
        }
    }

    public void deleteProfessor(Integer id) {
        professorRepository.deleteById(id);
    }
    
    // Professor salvar(ProfessorDTO professorDTO);

    // List<ProfessorDTO> listarTodos();

    // DadosProfessorDTO obterPorId(Integer id);

    // void excluir(Integer id);

    // void editar(Integer id, ProfessorDTO dto);
}

