/*
 * UNIVERSIDADE FEDERAL DE GOIÁS - UFG 
 * Construção de Software - 2016/2
 * Professor: Fábio Nogueira de Lucena
 * Aluno: Paulo Junio Sales Rodrigues - 201602510
 */

package com.github.pauloj2000.ordem2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe que tem como função apoiar a classe QP.
 */

public class ApoioQP {

    /**
     * Separador padrão de string
     */
    private final String COMAN = ";";
    
    /**
     * Relatório
     * 
     * @see com.github.pauloj2000.ordem2.Teste
     */
    private Teste teste;

    /**
     * Método que lê as linhas do arquivo .txt de testes.
     *
     * @return lines - ArrayList -> retorna um array contendo todas as linhas do
     * arquivo txt.
     * @throws IOException - caso não exista o arquivo txt;
     * 
     * @see java.util.ArrayList
     * @see import java.io.IOException
     */
    private ArrayList<String> getLinhas() throws IOException {

        ArrayList<String> linhas = new ArrayList<>();

        FileReader arq = new FileReader(QP.localFile);
        BufferedReader bufferedReader = new BufferedReader(arq);

        String line = bufferedReader.readLine();
        linhas.add(line);

        while (line != null) {
            line = bufferedReader.readLine();
            linhas.add(line);

        }
        linhas.remove(linhas.size() - 1);

        return linhas;

    }

    /**
     * Método que Transforma os teste do arquivo .txt em objetos Calcular;
     *
     * @throws IOException - caso os testes não estiverem o formato correto.
     * @throws NumberFormatException - caso os caso de test apresente algum erro
     * no formato padrão.
     * 
     * @see import java.io.IOException
     */
    public void toExpression() throws IOException, NumberFormatException {
        ArrayList<String> lines = getLinhas();
        ArrayList<Calcular> test = new ArrayList<>();

        for (String line : lines) {
            String[] content = line.split(COMAN);
            String expressao = content[0].replaceAll(" ", "");
            float esperado = Float.parseFloat(content[2]);
            if (!content[1].isEmpty()) {
                String[] variables = content[1].split(",");
                HashMap<String, Float> variaveis = new HashMap<>();
                for (String var : variables) {
                    String[] v = var.split("=");
                    String nome = v[0];
                    Float valor;
                    valor = Float.parseFloat(v[1]);
                    variaveis.put(nome, valor);
                }
                test.add(new Calcular(expressao, esperado, variaveis));
            } else {
                test.add(new Calcular(expressao, esperado));
            }

        }
        teste = new Teste(test);
    }

    /**
     * Método que popula a arrayList de testes;
     *
     * @throws IOException - caso nao exista o arquivo .txt ou o dos testes
     * estajam incorreto.
     * @throws NumberFormatException - caso nao alguma instanciação de um número
     * não seja possivel
     * @see import java.io.IOException
     */
    
    public void popularTeste() throws IOException, NumberFormatException {
        toExpression();
        Valor valor = new Valor();
        teste = valor.testerExecuter(teste);
    }

    /**
     * Metodo que retorna o arryList teste;
     *
     * @return teste - ArrayList -> retorna o ArrayList Contendo os resultados e
     * os testes que foram executados
     * @see com.github.pauloj2000.ordem2.Teste
     */
    public Teste getTeste() {
        return teste;
    }
}
