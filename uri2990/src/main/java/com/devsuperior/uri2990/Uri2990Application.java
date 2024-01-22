package com.devsuperior.uri2990;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2990.repositories.EmpregadoRepository;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2990Application implements CommandLineRunner {

	@Autowired
	private EmpregadoRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2990Application.class, args);
	}

	@Override
	public void run(String... args) {

		List<EmpregadoDeptProjection> list1 = repository.searchWithSQLNotIN();
		List<EmpregadoDeptDTO> result1 = list1.stream().map(x -> new EmpregadoDeptDTO(x)).collect(Collectors.toList());

		System.out.println("\nRESULTADO SQL RAIZ (NOT IN): ");
		for (EmpregadoDeptDTO obj : result1) {
			System.out.println(obj);
		}
		System.out.println();

		List<EmpregadoDeptProjection> list2 = repository.searchWithSQLLeftJoin();
		List<EmpregadoDeptDTO> result2 = list2.stream().map(x -> new EmpregadoDeptDTO(x)).collect(Collectors.toList());

		System.out.println("\nRESULTADO SQL RAIZ (LEFT JOIN): ");
		for (EmpregadoDeptDTO obj : result2) {
			System.out.println(obj);
		}
		System.out.println();

		List<EmpregadoDeptDTO> result3 = repository.searchWithJPQL();

		System.out.println("\nRESULTADO JPQL: ");
		for (EmpregadoDeptDTO obj : result3) {
			System.out.println(obj);
		}
	}
}
