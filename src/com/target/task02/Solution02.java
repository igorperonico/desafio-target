package com.target.task02;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite um número inteiro para verificar se pertence ou não a sequência de Fibonacci: ");
        try {
            int input = Integer.parseInt(reader.readLine());
            int[] fibonacci = fibonacci(input);
            verifyNumber(input, fibonacci);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O número não é válido!");
        }

    }

    public static int[] fibonacci(int number) {
        int[] fibonacci = new int[number + 2];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        return fibonacci;
    }

    public static void verifyNumber(int number, int[] fibonacci) {
        boolean found = false;

        for (int i = 0; i < fibonacci.length; i++) {
            if (number == fibonacci[i]) {
                found = true;
                break;
            }
        }
        if (found) System.out.println(number + " pertence a sequência de Fibonacci.");
        else System.out.println(number + " não pertence a sequência de Fibonacci.");
    }
}
