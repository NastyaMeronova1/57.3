package com.company;

import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Main main = new Main();
        main.getResponse();
        String host;
        Scanner input = new Scanner(System.in);
        System.out.println("Введите имя хоста -----------------------------------------------");

        host = input.next();
        try{
            InetAddress address = InetAddress.getByName(host);
            System.out.println("The Ip address " + address.toString());
        }catch (UnknownHostException x){
            x.printStackTrace();
        }
    }

    public void getResponse() {
        try {
            String url = "http://www.geoplugin.net/xml.gp?base_currency=USD";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            int responseCode = con.getResponseCode();
            System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println("Получить java класс из xml по пути : http://www.geoplugin.net/xml.gp?base_currency=USD '----------------------------------------'");
            System.out.println(response.toString());
            System.out.println("XML в Jackson -----------------------------------------------------------------------------------------------------------------");
            String xmlToJson = String.valueOf(response);
            JSONObject json = XML.toJSONObject(xmlToJson);
            System.out.println(json);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
