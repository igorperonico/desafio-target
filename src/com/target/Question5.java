package com.target;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite algo que você deseja que a ordem dos caracteres seja invertida: ");
        String string = reader.readLine();

        String reverseString = "";

        char[] chars = string.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            reverseString += chars[i];
        }

        System.out.println(reverseString);
    }
}
