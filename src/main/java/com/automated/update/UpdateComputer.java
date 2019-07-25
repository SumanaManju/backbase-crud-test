package com.automated.update;

import com.automated.create.Computer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.time.LocalDate;

public class UpdateComputer {

	private final String baseUrl = "http://computer-database.herokuapp.com/computers/";

	public void updateComputer(Computer computer) throws IOException {
		System.out.println("Update computers with the query: " + computer.getId());
		
		String endpoint = baseUrl + computer.getId();
		modifyComputer(computer);
		System.out.println("Update computer endpoint: " + endpoint +  ", " + computer.getName() +  "\n");
		Document doc = Jsoup.connect(endpoint)
				.data("name", computer.getName())
				.data("introduced",computer.getIntroduced().toString())
				.data("discontinued",computer.getDiscontinued().toString())
				.data("company",computer.getCompany()+"")
				.post();
	}

	private Computer modifyComputer(Computer computer) {
		computer.setCompany(3);
		computer.setDiscontinued(LocalDate.of(2030, 07, 22));
		computer.setIntroduced(LocalDate.of(2020, 06, 23));
		computer.setName("Windows11Computer");

		return computer;
	}
}
