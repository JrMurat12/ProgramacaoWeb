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
		Categoria categoria1 = new Categoria();
		categoria1.setCat_nome("Eletrônicos");

		Categoria categoria2 = new Categoria();
		categoria2.setCat_nome("Roupas");

		categoriaRepository.save(categoria1);
		categoriaRepository.save(categoria2);

		Produto produto1 = new Produto();
		produto1.setProd_nome("Produto 1");
		produto1.setProd_preco(10.0);
		produto1.setCategoriaProduto(categoria1);

		Produto produto2 = new Produto();
		produto2.setProd_nome("Produto 2");
		produto2.setProd_preco(20.0);
		produto2.setCategoriaProduto(categoria1);

		Produto produto3 = new Produto();
		produto3.setProd_nome("Teste 3");
		produto3.setProd_preco(30.0);
		produto3.setCategoriaProduto(categoria2);

		produtoRepository.saveAll(List.of(produto1, produto2, produto3));

		// System.out.println("Produtos com preço maior que 15:");
		// List<Produto> produtosPrecoMaiorQue15 = produtoRepository.findByprodprecoGreaterThan(15.0);
		// produtosPrecoMaiorQue15.forEach(System.out::println);

		// System.out.println("Produtos com preço menor ou igual a 25:");
		// List<Produto> produtosPrecoMenorOuIgual25 = produtoRepository.findByprodprecoLessThanEqual(25.0);
		// produtosPrecoMenorOuIgual25.forEach(System.out::println);

		// System.out.println("Produtos que o nome começa com 'Produto':");
		// List<Produto> produtosNomeComecaComProduto = produtoRepository.findByprodnomeStartingWith("Produto");
		// produtosNomeComecaComProduto.forEach(System.out::println);

		// System.out.println("Categorias que começam com 'Elet':");
		// List<Categoria> categoriasComE = categoriaRepository.findBycatnomeStartingWith("Elet");
		// categoriasComE.forEach(System.out::println);

		// System.out.println("Categoria com produtos pelo ID:");
		// Categoria categoriaComProdutos = categoriaRepository.findCategoriaWithProdutosById(1L);
		// System.out.println(categoriaComProdutos.getCat_nome());
		// categoriaComProdutos.getProdutos().forEach(produto -> System.out.println("- " + produto.getProd_nome()));
	};
}

	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);
	}

}
