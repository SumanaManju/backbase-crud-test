package com.automated.create;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CreateComputer {

    private final String URL = "http://computer-database.herokuapp.com/computers";

    public void createComputer(Computer computer) throws IOException {
    	
    	System.out.println("\nSending 'POST' request to URL : " + URL);
    	Document doc = Jsoup.connect(URL)
				.data("name", computer.getName())
				.data("introduced",computer.getIntroduced().toString())
				.data("discontinued",computer.getDiscontinued().toString())
				.data("company",computer.getCompany()+"")
				.post();
				//System.out.println(doc);

    	
    	
        
        

    }

}
