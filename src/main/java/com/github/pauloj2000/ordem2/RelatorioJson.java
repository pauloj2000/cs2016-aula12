/*
 * UNIVERSIDADE FEDERAL DE GOIÁS - UFG 
 * Construção de Software - 2016/2
 * Professor: Fábio Nogueira de Lucena
 * Aluno: Paulo Junio Sales Rodrigues - 201602510
 */

package com.github.pauloj2000.ordem2;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Classe que escreve o relatório em Json.
 */

public class RelatorioJson {
    
    /**
     * Construtor do Json.
     * 
     * @see com.google.gson.Gson
     */
    
    private final Gson gson = new Gson();
    
    /**
     * Codigo Json
     */
    
    private String json;
    
    /**
     * Gerador do arquivo.json.
     */
    
    private final FileWriter fileWriter;
    
    /**
     * Escritor do arquivo.json.
     */
    
    private final PrintWriter printWriter;

    /**
     * Construtor do DAOJson, instacia o PrintWriter e o FileWrite e cria
     * o arquivo.json.
     * 
     * @param localFile
     * @throws IOException
     * @see java.io.IOException
     */
    
    public RelatorioJson(String localFile) throws IOException {
        fileWriter = new FileWriter(localFile.replaceAll(".txt",".json"));
        printWriter = new PrintWriter(fileWriter);
    }

    /**
     * Instancia o arquivo.json.
     * 
     * @param test - resultados dos testes executados
     * @throws IOException
     * @see java.io.IOException
     * @see com.github.pauloj2000.ordem2.Teste
     */
    public void add(Teste test) throws IOException {
        json = gson.toJson(test);
        printWriter.write(json);
        fileWriter.close();
        printWriter.close();
    }
}
