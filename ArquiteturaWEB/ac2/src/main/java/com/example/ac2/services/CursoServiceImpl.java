// package com.example.ac2.services;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.example.ac2.models.Curso;
// import com.example.ac2.repository.CursoRepository;

// @Service
// public class CursoServiceImpl implements CursoService {

//     private final CursoRepository cursoRepository;

//     public CursoServiceImpl(CursoRepository cursoRepository) {
//         this.cursoRepository = cursoRepository;
//     }

//     @Override
//     public Curso salvar(Curso curso) {
//         return cursoRepository.save(curso);
//     }

//     @Override
//     public List<Curso> listarTodos() {
//         return cursoRepository.findAll();
//     }

//     @Override
//     public Curso obterPorId(Integer id) {
//         return cursoRepository.findById(id).orElse(null);
//     }

//     @Override
//     public Curso editar(Integer id, Curso curso) {
//         if(cursoRepository.existsById(id)){
//             curso.setId(id);
//             return cursoRepository.save(curso);
//         }else {
//             return null;
//         }

//     }

//     @Override
//     public void excluir(Integer id) {
//         cursoRepository.deleteById(id);
//     }
// }