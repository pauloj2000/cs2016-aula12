/*
 * UNIVERSIDADE FEDERAL DE GOIÁS - UFG 
 * Construção de Software - 2016/2
 * Professor: Fábio Nogueira de Lucena
 * Aluno: Paulo Junio Sales Rodrigues - 201602510
 */

package com.github.pauloj2000.ordem2;

import java.util.ArrayList;

/**
 * Classe que guarda todo o relatório gerado.
 */

public class Teste {
    
    /**
     * Tempo total gasto Durante os teste pelo Parse .
     */
    
    private long tempoTotal;
    
    /**
     * Tempo médio gasto durante os teste pelo Parse.
     */
    
    private long tempoMedio;
    
    /**
     * Memoria gasta antes de rodar o Parse.
     */
    
    private long memoriaInicio;
    
    /**
     * Memoria gasta depois de rodar o Parse.
     */
    
    private long memoriaFinal;
    
    /**
     * Numero total de testes.
     */
    
    private final int totalDeTestes;
    
    /**
     * Numero de teste com sucesso (obitido o esperado).
     */
    
    private int sucessos;
    
    /**
     * Numero de teste que falharam (Não obitido o esperado).
     */
    
    private int falhas;
    
    /**
     * Lista Contendo todos os casos de teste.
     */
    
    private final ArrayList<Calcular> testes;

    /**
     * Metodo construtor
     * 
     * @param testes - Array contendo todos os 
     * casos de testes.
     * @see com.github.pauloj2000.ordem2.Calcular
     * @see java.util.ArrayList
     */
    
    public Teste(ArrayList<Calcular> testes) {
        this.testes = testes;
        this.totalDeTestes = testes.size();
    }

    /**
     * Método que recupera o tempo total dos testes.
     * 
     * @return long - tempoTotal
     */
    
    public long getTempoTotal() {
        return tempoTotal;
    }

    /**
     * Metodo que instancia o tempo Total e o tempo médio dos testes.
     * 
     * @param tempoTotal - long
     */
    
    public void setTempo(long tempoTotal) {
        this.tempoTotal = tempoTotal;
        this.tempoMedio = tempoTotal / totalDeTestes;
    }

    /**
     * Método que recupera o tempo médio dos testes.
     * 
     * @return long - tempoMedio
     */
    
    public long getTempoMedio() {
        return tempoMedio;
    }

    /**
     * Método que recupera o número total de testes executados.
     * 
     * @return int - totalDeTestes
     */
    
    public int getTotalDeTest() {
        return totalDeTestes;
    }

    /**
     * Método que recupera o número de teste com sucesso.
     * 
     * @return int - sucessos
     */
    
    public int getSucessos() {
        return sucessos;
    }
    
    /**
     * Método que instancia o numero de teste com sucesso e o numero de teste 
     *      com fracasssos.
     * 
     * @param sucessos - int
     */
    
    public void setSucessos(int sucessos) {
        this.sucessos = sucessos;
        this.falhas = getTotalDeTest()- sucessos;
    }

    /**
     * Método que recupera o numero total de teste fracassados.
     * 
     * @return int - falhas
     */
    
    public int getFalhas() {
        return falhas;
    }

    /**
     * Método que recupea o array contendo todos os casos de testes.
     * 
     * @return O array que gerencia os testes
     * @see com.github.pauloj2000.ordem2.Calcular
     * @see java.util.ArrayList
     */
    
    public ArrayList<Calcular> getTestes() {
        return testes;
    }

    /**
     * Método que recupera o a quantidade de memoria gasta antes do inicio dos 
     * testes.
     * 
     * @return long - memoriaInicio
     */
    
    public long getMemoriaInicio() {
        return memoriaInicio;
    }

    /**
     * Método que instancia a quantidade de memoria gasta antes do inicio dos
     * testes.
     * 
     * @param memoriaInicio - long
     */
    
    public void setMemoriaInicio(long memoriaInicio) {
        this.memoriaInicio = memoriaInicio;
    }

    /**
     * Método que recupera a quantidade de memoria gasta após o fim dos testes.
     * 
     * @return long - memoriaFinal
     */
    
    public long getMemoriaFinal() {
        return memoriaFinal;
    }

    /**
     * Método que instancia a quantidade de memoria gasta após o fim dos testes.
     * @param memoriaFinal - long
     */
    
    public void setMemoriaFinal(long memoriaFinal) {
        this.memoriaFinal = memoriaFinal;
    }
}
