package com.target.task04;

import java.text.DecimalFormat;

public class Solution04 {
    public static void main(String[] args) {
        double SP = 67836.43;
        double RJ = 36678.66;
        double MG = 29229.88;
        double ES = 27165.48;
        double outros = 19849.53;

        double faturamentoTotal = SP + RJ + MG + ES + outros;

        double percentualMensalSP = SP / faturamentoTotal;
        double percentualMensalRJ = RJ / faturamentoTotal;
        double percentualMensalMG = MG / faturamentoTotal;
        double percentualMensalES = ES / faturamentoTotal;
        double percentualMensalOutros = outros / faturamentoTotal;

        System.out.println("Percentual de representação do valor total mensal da distribuidora por estado: ");

        System.out.println("São Paulo: " + formatarPercentual(percentualMensalSP));
        System.out.println("Rio de Janeiro: " + formatarPercentual(percentualMensalRJ));
        System.out.println("Minas Gerais: " + formatarPercentual(percentualMensalMG));
        System.out.println("Espírito Santo: " + formatarPercentual(percentualMensalES));
        System.out.println("Outros Estados: " + formatarPercentual(percentualMensalOutros));
    }

    public static String formatarPercentual(double valor) {
        DecimalFormat fmt = new DecimalFormat("0.00%");
        String string = fmt.format(valor);

        return string;
    }
}
