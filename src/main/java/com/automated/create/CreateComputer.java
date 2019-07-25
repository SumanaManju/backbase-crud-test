package com.automated.create;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class CreateComputer {

    private final String URL = "http://computer-database.herokuapp.com/computers";

    public void createComputer(Computer computer) throws IOException {
    	
    	System.out.println("Creating computer with to URL : " + URL + "\n");
    	Document doc = Jsoup.connect(URL)
				.data("name", computer.getName())
				.data("introduced",computer.getIntroduced().toString())
				.data("discontinued",computer.getDiscontinued().toString())
				.data("company",computer.getCompany()+"")
				.post();
    }

}
