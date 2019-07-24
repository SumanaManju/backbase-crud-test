package com.automated.delete;

import com.automated.create.Computer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class DeleteComputer {

    private final String URL = "http://computer-database.herokuapp.com/computers/";

    public void deleteComputer(Computer computer) throws IOException {
        String endpoint = URL + computer.getId() + "/delete";
        System.out.println("Calling delete endpoint: " +endpoint);
        Document doc = Jsoup.connect(endpoint).post();

    }

}
