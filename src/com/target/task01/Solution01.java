package com.target.task01;

public class Solution01 {
    public static void main(String[] args) {
        int indice = 13;
        int soma = 0;
        int k = 0;

        while (k < indice) {
            k++;
            soma += k;
        }

        System.out.println(soma);
    }
}
