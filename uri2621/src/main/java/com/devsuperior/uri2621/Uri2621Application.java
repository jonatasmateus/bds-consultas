package com.devsuperior.uri2621;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.projection.ProductMinProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2621.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Override
	public void run(String... args) {

		List<ProductMinProjection> list = repository.searchWithSQL(10, 20, "P");
		List<ProductMinDTO> result1 = list.stream().map(x -> new ProductMinDTO(x)).collect(Collectors.toList());

		System.out.println("\nRESULTADO SQL RAIZ: ");
		for (ProductMinDTO obj : result1) {
			System.out.println(obj);
		}
		System.out.println();

		List<ProductMinDTO> result2 = repository.searchWithJPQL(10, 20, "P");

		System.out.println("\nRESULTADO JPQL: ");
		for (ProductMinDTO obj : result2) {
			System.out.println(obj);
		}
	}
}
