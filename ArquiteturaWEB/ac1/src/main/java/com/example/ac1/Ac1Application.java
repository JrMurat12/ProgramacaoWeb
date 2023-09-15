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
		System.out.println("EXEMPLO INSERIR CATEGORIA...!");
		Categoria c1 = new Categoria(0, "TESTES", "PRODUTOS DE TESTES", null);
		categoriaRepository.inserir(c1);

		System.out.println("EXEMPLO INSERIR CATEGORIA...!");
		Categoria c2 = new Categoria(0, "FINAL", "PRODUTOS FINAIS", null);
		categoriaRepository.inserir(c2);

		produtoRepository.inserir(
			new Produto((long)0, "produto1", 2050, c1));
		produtoRepository.inserir(
			new Produto((long)0, "produto2", 1960, c2));
		
		List<Produto> listaProdutos = produtoRepository.obterTodos();
		System.out.println("EXEMPLO OBTER POR NOME...!");
		listaProdutos = produtoRepository.obterPorId(1);
		listaProdutos.forEach(System.out::println);

		System.out.println("EXEMPLO ATUALIZAR CATEGORIA PRODUTO...!");
		listaProdutos.get(0).setCategoriaProduto(c1);
		produtoRepository.inserir(listaProdutos.get(0));

	};
}

	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);
	}

}
