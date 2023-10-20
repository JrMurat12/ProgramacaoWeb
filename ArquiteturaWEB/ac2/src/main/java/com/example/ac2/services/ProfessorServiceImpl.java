package com.example.ac2.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ac2.dtos.CursoDTO;
import com.example.ac2.dtos.ProfessorDTO;
import com.example.ac2.exceptions.RegraNegocioException;
import com.example.ac2.models.Curso;
import com.example.ac2.models.Professor;
import com.example.ac2.repository.CursoRepository;
import com.example.ac2.repository.ProfessorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;
    private final CursoRepository cursoRepository;

    @Override
    public Professor salvar(ProfessorDTO professorDTO) {
        // List<Curso> curso = cursoRepository.findById(
        //                 professorDTO.getCursoProfessorId()).orElseThrow(
        //                                 () -> new RegraNegocioException("Código do Curso não encontrado!"));

        Professor p = new Professor();
        p.setNome(professorDTO.getNome());
        p.setCpf(professorDTO.getCpf());
        p.setRg(professorDTO.getRg());
        p.setEndereco(professorDTO.getEndereco());
        p.setCelular(professorDTO.getCelular());
        // Obtenha a lista de IDs dos cursos associados ao professor
        List<Integer> cursoIds = professorDTO.getCursoProfessorId();

        if (cursoIds != null && !cursoIds.isEmpty()) {
        // Consulte o banco de dados para obter os cursos correspondentes aos IDs
        List<Curso> cursos = cursoRepository.findAllById(cursoIds);

        // Defina a lista de cursos no professor
        p.setCursos(cursos);
        } else {
        // Se nenhum curso foi fornecido, você pode optar por definir uma lista vazia de cursos
        p.setCursos(new ArrayList<>());
        }
        return professorRepository.save(p);
    }

    public List<ProfessorDTO> listarTodos() {
        List<ProfessorDTO> professores = professorRepository.findAll().stream().map(
                        (Professor p) -> {
                            ProfessorDTO professorDTO = ProfessorDTO.builder()
                                                .id(p.getId())
                                                .nome(p.getNome())
                                                .cpf(p.getCpf())
                                                .rg(p.getRg())
                                                .endereco(p.getEndereco())
                                                .celular(p.getCelular())
                                                .build();

                                                if (p.getCursos() != null) {
                                                    List<Integer> cursoIds = p.getCursos().stream()
                                                            .map(curso -> curso.getId())
                                                            .collect(Collectors.toList());
                                                    professorDTO.setCursoProfessorId(cursoIds);
                                                } else {
                                                    professorDTO.setCursoProfessorId(Collections.emptyList());
                                                }

                                                return professorDTO;             
                        }).collect(Collectors.toList());
        return professores;
    }
}
