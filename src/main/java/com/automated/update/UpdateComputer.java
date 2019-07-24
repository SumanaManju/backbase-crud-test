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
		System.out.println("Endpoint: " + endpoint);
		modifyComputer(computer);
		Document doc = Jsoup.connect(endpoint)
				.data("name", computer.getName())
				.data("introduced",computer.getIntroduced().toString())
				.data("discontinued",computer.getDiscontinued().toString())
				.data("company",computer.getCompany()+"")
				.post();
				System.out.println(doc);

	}

	public static Computer modifyComputer(Computer computer) {
		// TODO Auto-generated method stub

		computer.setCompany(2);
		computer.setDiscontinued(LocalDate.of(1991, 07, 22));
		computer.setIntroduced(LocalDate.of(1992, 06, 23));
		computer.setName("Abc");

		return computer;
	}
}