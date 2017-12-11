/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cesi.BasicWebServiceSpring.api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author Numalama
 */
public class DistanceMatrixAPI {

    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {

    }

    // HTTP GET request
    public String sendGet(String origine, String destination, String mode) throws Exception {

        System.out.println("sendGet");
        System.out.println("origine");
        System.out.println(origine);
        System.out.println("destination");
        System.out.println(destination);
        System.out.println("mode");
        System.out.println(mode);
        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + origine + "&destinations=" + destination + "&mode=" + mode + "&language=fr-FR&&key=AIzaSyCwf2t39qtEn4ljYB0Xm9vHBqZb-lU3EBE";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        return response.toString();

    }

    // HTTP POST request
    public String sendPost(String origine, String destination, String mode) throws Exception {

        System.out.println("sendPost");
        System.out.println("origine");
        System.out.println(origine);
        System.out.println("destination");
        System.out.println(destination);
        System.out.println("mode");
        System.out.println(mode);
        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + origine + "&destinations=" + destination + "&mode=" + mode + "&language=fr-FR&key=AIzaSyCwf2t39qtEn4ljYB0Xm9vHBqZb-lU3EBE";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        return response.toString();

    }
}
