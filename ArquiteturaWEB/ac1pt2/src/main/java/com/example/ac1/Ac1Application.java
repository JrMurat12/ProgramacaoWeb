package com.example.ac1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac1.models.Categoria;
import com.example.ac1.models.Produto;
import com.example.ac1.repository.CategoriaRepository;
import com.example.ac1.repository.ProdutoRepository;

@SpringBootApplication
public class Ac1Application {

@Bean
public CommandLineRunner init(@Autowired ProdutoRepository produtoRepository,
@Autowired CategoriaRepository categoriaRepository) {
	return args -> {
		// produtoRepository.save(
		// 			new Produto((long) 0, "teste", 2000));
		// 	produtoRepository.save(
		// 			new Produto((long) 0, "teste2", 2050));
		// 	List<Produto> listaProdutos = produtoRepository.findAll();
		// 	listaProdutos.forEach(System.out::println);

			// System.out.println("** Exemplo obter por id **");
			// // listaProdutos = produtoRepository.findById((long) 0);
			// listaProdutos.forEach(System.out::println);

			System.out.println("** Exemplo inserir categoria **");
			Categoria c1 = new Categoria(null, "TI");
			categoriaRepository.save(c1);

			// System.out.println("** Exemplo atualiza categ. produto **");
			// listaProdutos.get(0).setCategoriaProduto(c1);
			// produtoRepository.save(listaProdutos.get(0));

			// System.out.println("** Exemplo LAZY **");
			// List<CategoriaCurso> categs = categoriaCursoRepository.findAll();
			// for (CategoriaCurso ca : categs) {
			// System.out.println(ca.getId() + " - " + ca.getNome() + "qtde cursos: " +
			// ca.getCursos().size());
			// }
			// System.out.println("** Exemplo FETCH **");
			// Categoria cc = categoriaRepository
			// 		.findCategoriaCursoFetchCursos((long) 1);
			// System.out.println(cc.getCursos().size());
	};
}

	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);
	}

}
