/*
 * UNIVERSIDADE FEDERAL DE GOIÁS - UFG 
 * Construção de Software - 2016/2
 * Professor: Fábio Nogueira de Lucena
 * Aluno: Paulo Junio Sales Rodrigues - 201602510
 */

package com.github.pauloj2000.ordem2;

import com.github.kyriosdata.parser.*;
import java.util.HashMap;
import java.util.List;

/**
 * Classe que executa métodos do Parser 
 */
public class Valor {

    /**
     * Método que executa uma expressão matematica e retorna o resultado.
     * @param expression - String -> expressão matemática
     * @return - float - resultado da expressão
     */
    
    private float executaExpressao(String expression) {
        List<Token> tokens = new Lexer(expression).tokenize();
        Parser parser = new Parser(tokens);
        float resultado = parser.expressao().valor();
        return resultado;
    }

    /**
     * Método que executa uma expressão matematica e retorna o resultado.
     * @param expression - String -> expressão Matemática
     * @param variables - HashMap -> variaveis e seus respectivos Valores.
     * @return - float - resultado da expressão
     * 
     * @see java.util.HashMap
     */
    
    private float executaExpressao(String expression, HashMap<String, Float> variables) {
        List<Token> tokens = new Lexer(expression).tokenize();
        Parser parser = new Parser(tokens);
        float resultado = parser.expressao().valor(variables);
        return resultado;
    }

    /**
     * Executa os casos de testes do arquivo .txt e guarda seus resultados
     * @param teste - Teste - casos de testes
     * @return - Teste - Resultados
     * 
     * @see com.github.pauloj2000.ordem2.Teste
     */
    public Teste testeExec(Teste teste) {
        int contSuccess = 0;
        long time = 0;
        long memoriaInicial = Runtime.getRuntime().totalMemory() 
                - Runtime.getRuntime().freeMemory();
        for(Calcular exp : teste.getTestes()) {
            float obtido;
            try {
                long startTime = System.nanoTime();
                obtido = executaExpressao(exp.getExpressao(), exp.getVariaveis());
                time += System.nanoTime() - startTime;
            } catch (NullPointerException npe) {
                long startTime = System.nanoTime();
                obtido = Valor.this.executaExpressao(exp.getExpressao());
                time += System.nanoTime() - startTime;
            }
            exp.setObtido(obtido);
            if(exp.testePrecisao()) {
                contSuccess++;
            }
        }
        long memoriaFinal = Runtime.getRuntime().totalMemory() 
                - Runtime.getRuntime().freeMemory();
        teste.setTempo(time);
        teste.setMemoriaInicio(memoriaInicial);
        teste.setMemoriaFinal(memoriaFinal);
        teste.setSucessos(contSuccess);
        return teste;
    }


}

