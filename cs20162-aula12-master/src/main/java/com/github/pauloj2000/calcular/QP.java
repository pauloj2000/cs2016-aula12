/*
 * UNIVERSIDADE FEDERAL DE GOIÁS - UFG 
 * Construção de Software - 2016/2
 * Professor: Fábio Nogueira de Lucena
 * Aluno: Paulo Junio Sales Rodrigues - 201602510
 */

package com.github.pauloj2000.calcular;

import com.github.kyriosdata.parser.Lexer;
import com.github.kyriosdata.parser.Parser;
import com.github.kyriosdata.parser.Token;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.regex.Pattern;

public class QP {

    public static void main(String[] args) throws FileNotFoundException,
            IOException{
        String auxiliar = "testes.txt";
//        if (args[1].compareTo("-h") == 0) {
//            auxiliar = args[2];
//        } else {
//            auxiliar = args[1];
//        }
        gerarHTML(lerArquivo(auxiliar));
        gerarJSON(lerArquivo(auxiliar));
    }

    /**
     * Método que lê arquivo txt.
     *
     * @param caminho O caminho do local do arquivo.
     * @return Uma lista com as linhas do arquivo.
     */
    public static ArrayList<String> lerArquivo(String caminho) {
        String testes;
        ArrayList<String> linhas = new ArrayList();
        FileReader arq;
        try {
            arq = new FileReader(caminho);
            BufferedReader ler = new BufferedReader(arq);
            testes = ler.readLine();
            while (testes != null) {
              linhas.add(testes);
              testes = ler.readLine();
            }
            arq.close();
        } catch (IOException excecao) {
            System.err.println("Erro ao ler o arquivo.");
            System.exit(1);
        }

        return linhas;
    }

    /**
     * Método que gera arquivo em HTML.
     *
     * @param linhas ArrayList com as linhas do arquivo txt.
     */
    public static void gerarHTML(ArrayList linhas){
        Formatter arquivo;
        int numLinhas = linhas.size();
        try {            
            arquivo = new Formatter("target/relatorioH.html");
            arquivo.format(html(numLinhas, linhas));
            arquivo.close();
        } catch(Exception excecao){
            System.out.println("Erro ao gerar arquivo HTML.");
            System.exit(1);
        }
    }

    /**
     * Método que gera um arquivo com extensão .JSON.
     *
     * @param linhas ArrayList com as linhas lidas pelo arquivo txt.
     */
    public static void gerarJSON(ArrayList linhas){
        Formatter arquivo;
        int numLinhas = linhas.size();
        try {
            arquivo = new Formatter("target/relatorioJ.json");
            arquivo.format(json(numLinhas, linhas));
            arquivo.close();
        } catch(Exception excecao){
            System.out.println("Erro ao gerar arquivo JSON.");
            System.exit(1);
        }
    }

    /**
     * Método que contém o parser.
     *
     * @param expressao A expressão retirada da linha do arquivo.
     * @return O reultado da expressão.
     */
    public static float parser(String expressao) {
        if (expressao.length() < 1) {
            System.exit(1);
        }
        List<Token> tokens = new Lexer(expressao).tokenize();
        Parser parser = new Parser(tokens);
        float resultado = parser.expressao().valor();

        return resultado;
    }

    /**
     * Método que contém a String a ser enviada ao arquivo html.
     *
     * @param numLinhas O número de linhas de testes.
     * @param linhas As linhas do arquivo.
     * @return A String correspondente ao código html.
     */
    public static String html(int numLinhas, ArrayList linhas) {
        String parte1, parte2, parte3, parte4, parte5, parte6, parte7 = "",
                total, expressao;
        float tempoTotal = 0, tempoMedio = 0, esperado, obtido;
        int totalTestes = numLinhas, corretos = 0, falhas = 0;

        for (int cont = 0; cont < numLinhas; cont++) {
            String aux = (String)linhas.get(cont);
            String[] parsers = aux.split(Pattern.quote(";"));
            expressao = parsers[0];
            esperado = Float.parseFloat(parsers[2]);
            obtido = parser(expressao);
            if (esperado == obtido) {
                corretos++;
            } else {
                falhas++;
            }
            parte7 += "<tr>" + "\n" + "<td>" + expressao + "</td>\n" +
                    "<td>" + esperado + "</td>\n" +
                    "<td>" + obtido + "</td>\n"
                    + "</tr>\n<tr>";
        }

        parte1 = "<!DOCTYPE html>\n" + "<html>\n" + "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>Relatório de Testes</title>\n" + "</head>\n" +
                "<body>\n" + "<h1>Resultado geral</h1>\n" + "<table>\n" +
                "<tr>\n" + "<td><b>Tempo total</b></td>\n" + "<td>";
        parte2 = "</td>\n" + "</tr>\n" + "<tr>\n" +
                "<td><b>Tempo médio</b></td>\n" + "<td>";
        parte3 = "</td>\n" + "</tr>\n" + "<tr>\n" +
                "<td><b>Total de testes</b></td>\n" + "<td>";
        parte4 = "</td>\n" + "</tr>\n" + "<tr>\n" +
                "<td><b>Corretos</b></td>\n" + "<td>";
        parte5 = "</td>\n" + "</tr>\n" + "<tr>\n" + "<td><b>Falhas</b></td>\n" +
                "<td>";
        parte6 = "</td>\n" + "</tr>\n" + "</table>\n" + "\n" +
                "<h1>Relatório detalhado dos testes</h1>\n" + "<table>\n" +
                "<tr>\n" + "<th>Expressão</th>\n" + "<th>Esperado</th>\n" +
                "<th>Obtido</th>\n" + "</tr>\n";
        total = parte1 + tempoTotal + parte2 + tempoMedio + parte3 +
                totalTestes + parte4 + corretos + parte5 + falhas + parte6 +
                parte7;
        
        total += "</tr>\n" + "</table>\n" + "</body>\n" + "\n" + "</html>";

        return total;
    }

    /**
     * Método que converte os dados do arquivo de testes em um JSON.
     *
     * @param numLinhas O número de linhas do arquivo txt.
     * @param linhas A lista com as linhas do arquivo txt.
     * @return A String no formato JSON.
     */
    public static String json(int numLinhas, ArrayList<String> linhas) {
        String total, parte1, parte2 = "", expressao;
        float tempoTotal = 0, tempoMedio = 0, esperado, obtido;
        int totalTestes = numLinhas, sucesso = 0, falha = 0;

        for (int cont = 0; cont < numLinhas; cont++) {

            String aux = (String)linhas.get(cont);
            String[] parsers = aux.split(Pattern.quote(";"));
            expressao = parsers[0];
            esperado = Float.parseFloat(parsers[2]);
            obtido = parser(expressao);

            if (esperado == obtido) {
                sucesso++;
            } else {
                falha++;
            }

            parte2 += "{\"expressao\": \"" + expressao + "\",\n"
                    + "\"esperado\": " + esperado + ",\n" + "\"obtido\": " 
                    + obtido + "" + "}\n";
            if (cont < numLinhas - 1) {
                parte2 += ",\n";
            }
        }

        parte1 = "\"tempoTotal\": " + tempoTotal + ",\n\"tempoMedio\": " +
                tempoMedio + ",\n\"total\": " + totalTestes + ",\n\"sucesso\": "
                + sucesso + ",\n\"falha\": " + falha + ",\n\"testes\": [\n";

        total = parte1 + parte2 + "]";

        return total;
    }

}
