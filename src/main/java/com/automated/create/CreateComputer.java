package com.automated.create;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CreateComputer {

    private final String URL = "http://computer-database.herokuapp.com/computers";

    public void createComputer(Computer computer) throws IOException {
        URL url = new URL(URL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        //add request header
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        con.setRequestProperty("User-Agent", "Java Client");
        byte[] postData = computer.toString().getBytes();

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.write(postData);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + computer.toString());
        System.out.println("Response Code : " + responseCode);

    }

}
