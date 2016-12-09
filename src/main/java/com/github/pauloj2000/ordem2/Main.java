/*
 * UNIVERSIDADE FEDERAL DE GOIÁS - UFG 
 * Construção de Software - 2016/2
 * Professor: Fábio Nogueira de Lucena
 * Aluno: Paulo Junio Sales Rodrigues - 201602510
 */

package com.github.pauloj2000.ordem2;

import java.io.IOException;

/**
 * Classe Principal.
 */

public class Main {

    /**
     * String que guarda o diretório do arquivo.txt
     */
    static 
            String localFile;

    /**
     * Objeto construtor da classe de apoio ao Main
     */
    
    static ApoioQP apoioqp = new ApoioQP();

    
    /**
     * Metodo referente ao Main
     *
     * @param args - Local onde está o .txt contendo os testes. Caso cotenha -h
     * antes do Local onde estão os testes, o programa retornará o relatorio em
     * HTML caso contrário será padrão e o relatório será em Json.
     * @return int - o retorno do valor 0 ou o valor 1. O valor 0 indica
     * sucesso, enquanto o valor 1 indica a ocorrência de situação excepcional.
     */
    
    public static int pseudoMain(String[] args) {
        try {
            localFile = args[0];
            try {
                apoioqp.popularTeste();
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace(System.out);
                return 1;
            }
            if (args.length > 1) {
                String op = args[1];
                if (op.equals("-h")) {
                    return opcaoHtml();
                } else {
                    return opcaoJson();
                }
            } else {
                return opcaoJson();
            }

        } catch (NullPointerException | IOException e) {
            e.printStackTrace(System.out);
            return 1;
        }
    }
    
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

    /**
     * Método que chama o construtor de HTML e executa os testes
     *
     * @return int - o retorno do valor 0 ou o valor 1. O valor 0 indica
     * sucesso, enquanto o valor 1 indica a ocorrência de uma situação
     * de exceção.
     */
    
    private static int opcaoHtml() throws IOException {
        RelatorioHtml dao = new RelatorioHtml(localFile);
        dao.criadorHTML(apoioqp.getTeste());
        return 0;
    }

    /**
     * Metodo que chama o construtor de Json e executa os testes
     *
     * @return int - o retorno do valor 0 ou o valor 1. O valor 0 indica
     * sucesso, enquanto o valor 1 indica a ocorrência de uma situação
     * de exceção.
     */
    
    private static int opcaoJson() throws IOException {
        RelatorioJson dao = new RelatorioJson(localFile);
        dao.add(apoioqp.getTeste());

        return 0;
    }
}