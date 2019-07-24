package com.automated.read;

import com.automated.create.Computer;
//import com.sun.tools.javac.util.Assert;

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
			String name = cols.get(0).getAllElements().get(0).child(0).html();
			//Assert.assertEquals(computer.getName(), name);
			System.out.println("Computer id: " + id + "name: " + name);

			computer.setId(id);
		}
	}
}
