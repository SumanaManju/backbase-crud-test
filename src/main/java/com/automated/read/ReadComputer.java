package com.automated.read;

import com.automated.create.Computer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ReadComputer {

	private final String baseUrl = "http://computer-database.herokuapp.com/computers?f=";

	public void readComputer(Computer computer) throws IOException {
		System.out.println("Reading computers with the query: " + computer.getName());
		String endpoint = baseUrl + computer.getName();

		Document doc = Jsoup.connect(endpoint).get();

		Elements table = doc.select("tbody");
		Elements rows = table.select("tr");
		for (int i = 0; i < rows.size(); i++) { 
			Element row = rows.get(i);
			Elements cols = row.select("td");
			String id = cols.get(0).getAllElements().get(0).child(0).attr("href").substring(11);
			computer.setId(id);
			validateComputer(cols, computer);
		}
		if (rows.size() == 0) {
			System.out.println("\nComputer " + computer.getName() + " is not found");
		}
	}

	/**
	 * Checks if the computer is the one we created
	 */
	public void validateComputer(Elements column, Computer computer) {
		String name = column.get(0).getAllElements().get(0).child(0).html();
		assert computer.getName().equals(name);
		System.out.println("Computer was read with the same name: " + computer.getName() + "\n");
	}
}
