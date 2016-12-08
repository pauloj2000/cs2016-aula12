/*
 * UNIVERSIDADE FEDERAL DE GOIÁS - UFG 
 * Construção de Software - 2016/2
 * Professor: Fábio Nogueira de Lucena
 * Aluno: Paulo Junio Sales Rodrigues - 201602510
 */

package com.github.pauloj2000.ordem2;

/**
 * Classe principal.
 */

public class Main {
    
     /**
     * Metodo Principal
     *
     * @param args - Local onde está o .txt contendo os testes. Caso cotenha -h
     * antes do Local onde estão os testes, o programa retornará o relatorio em
     * HTML caso contrário será padrão e o relatório será em Json.
     */
    
    public static void main(String[] args) {
        System.exit(pseudoMain(args));
    }
}
