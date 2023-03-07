package com.target.leituras;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LeituraDoArquivoJSON {
    public static void main(String[] args) {
        try {
            //read in string
            String jsonText = new String(Files.readAllBytes(Paths.get("dados.json")));

            //read as json array
            JSONArray jsonArray = new JSONArray(jsonText);
            for (int i = 0; i < jsonArray.length(); i++) {
                //parse in json object
                //JSONObject object = jsonArray.getJSONObject(i);
                //or

                String string = jsonArray.get(i).toString();
                JSONObject object = new JSONObject(string);

                int dia = object.getInt("dia");
                double valor = object.getDouble("valor");

                System.out.println("Dia: " + dia);
                System.out.println("Valor: " + valor);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
