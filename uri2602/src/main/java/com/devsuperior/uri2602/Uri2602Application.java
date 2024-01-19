package com.devsuperior.uri2602;

import com.devsuperior.uri2602.dto.CustomerMinDTO;
import com.devsuperior.uri2602.projections.CustomerMinProjection;
import com.devsuperior.uri2602.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}

	@Override
	public void run(String... args) {

		List<CustomerMinProjection> list = repository.searchWithSQL("RS");
		List<CustomerMinDTO> result = list.stream().map(x -> new CustomerMinDTO(x)).collect(Collectors.toList());

		System.out.println("\nLISTA DE CUSTOMERS NO ESTADO 'RS': \n");
		for (CustomerMinDTO obj : result) {
			System.out.println(obj);
		}
	}
}
