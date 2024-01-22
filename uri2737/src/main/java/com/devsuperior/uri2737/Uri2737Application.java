package com.devsuperior.uri2737;

import com.devsuperior.uri2737.dto.LawyerMinDTO;
import com.devsuperior.uri2737.projections.LawyerMinProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2737.repositories.LawyerRepository;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2737Application implements CommandLineRunner {

	@Autowired
	private LawyerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2737Application.class, args);
	}

	@Override
	public void run(String... args) {

		List<LawyerMinProjection> list = repository.searchWithSQL();
		List<LawyerMinDTO> result = list.stream().map(x -> new LawyerMinDTO(x)).collect(Collectors.toList());

		System.out.println("\nRESULTADO SQL RAIZ: ");
		for (LawyerMinDTO obj : result) {
			System.out.println(obj);
		}
		System.out.println();

		System.out.println("\nRESULTADO JPQL: ");
		System.out.println("\nA consulta feita com JPQL parece não possuir a cláusula UNION; " +
				"Além disso, pode não compensar elaborar consultas com ela para essa situação.\n");
	}
}
