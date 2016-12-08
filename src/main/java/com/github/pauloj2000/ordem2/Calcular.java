/*
 * UNIVERSIDADE FEDERAL DE GOIÁS - UFG 
 * Construção de Software - 2016/2
 * Professor: Fábio Nogueira de Lucena
 * Aluno: Paulo Junio Sales Rodrigues - 201602510
 */

package com.github.pauloj2000.ordem2;

import java.util.HashMap;


/**
 * Classe que guarda os valores referente à 
 * expressão teste.
 */
public class Calcular {
    
    /**
     * Valor esperado
     */
    private final float esperado;
    
    /**
     * Valor obtido
     */
    
    private float obtido;
    
    /**
     * Expressão Matematica
     */
    
    private final String expressao;
    
    /**
     * Valor das variaveis.
     * 
     * @see java.util.HashMap
     */
    
    private HashMap<String, Float> variaveis;
    
    /**
     * Método construtor do Objeto Calcular quando não se á variaveis para serem instanciadas.
     * @param expressao - String
     * @param esperado - float
     */
    
    public Calcular(String expressao, float esperado) {
        this.expressao = expressao;
        this.esperado = esperado;
    }
    
    /**
     * Método construtor do Objeto Calcular quando se tem variaveis
     * para serem instanciadas.
     * 
     * @param expressao - String
     * @param esperado - float
     * @param variaveis - HashMap<String, Float>
     * 
     * @see java.util.HashMap
     */
    
    public Calcular(String expressao, float esperado, HashMap<String, Float> variaveis) {
        this.expressao = expressao;
        this.esperado = esperado;
        this.variaveis = variaveis;
    }

    /**
     * Método que recupera a expressão.
     * @return String - expressao
     */
    
    public String getExpressao() {
        return expressao;
    }

    /**
     * Método que recupera o valor esperado pelo teste.
     * 
     * @return float - esperado
     */
    
    public float getEsperado() {
        return esperado;
    }

    /**
     * Método que retorna os valores das variaveis.
     * @return HashMap - variaveis
     * 
     * @see java.util.HashMap
     */
    
    public HashMap<String, Float> getVariaveis() {
        return variaveis;
    }

    /**
     * Método que recupera o valor obtido pelo teste.
     * 
     * @return float - obtido
     */
    
    public float getObtido() {
        return obtido;
    }

    /**
     * Método que instancia o valor obtido.
     * 
     * @param obtido - float
     */
    
    public void setObtido(Float obtido) {
        this.obtido = obtido;
    }

    /**
     * Metodo que verifica se os teste estão corretos.
     * 
     * @return boolean - true caso tenha sucesso e False caso tenha falhado. 
     */
    
    public boolean testePrecisao() {
        return esperado == obtido;
    }
}
