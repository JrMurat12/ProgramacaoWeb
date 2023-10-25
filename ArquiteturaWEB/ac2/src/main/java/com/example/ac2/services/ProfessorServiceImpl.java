// package com.example.ac2.services;
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;
// import java.util.stream.Collectors;
// import org.springframework.stereotype.Service;
// import com.example.ac2.dtos.CursoDTO;
// import com.example.ac2.dtos.ProfessorDTO;
// import com.example.ac2.exceptions.RegraNegocioException;
// import com.example.ac2.models.Curso;
// import com.example.ac2.models.Professor;
// import com.example.ac2.repository.CursoRepository;
// import com.example.ac2.repository.ProfessorRepository;
// import lombok.RequiredArgsConstructor;

// @Service
// public class ProfessorServiceImpl implements ProfessorService {

//     private final ProfessorRepository professorRepository;

//     public ProfessorServiceImpl(ProfessorRepository professorRepository) {
//         this.professorRepository = professorRepository;
//     }

//     @Override
//     public Professor salvar(Professor professor) {
//         return professorRepository.save(professor);
//     }

//     @Override
//     public List<Professor> listarTodos() {
//         return professorRepository.findAll();
//     }

//     @Override
//     public Professor obterPorId(Integer id) {
//         return professorRepository.findById(id).orElse(null);
//     }

//     @Override
//     public Professor editar(Integer id, Professor professor) {
//         if(professorRepository.existsById(id)){
//             professor.setId(id);
//             return professorRepository.save(professor);
//         }else {
//             return null;
//         }
//     }

//     @Override
//     public void excluir(Integer id) {
//         professorRepository.deleteById(id);
//     }
// }
