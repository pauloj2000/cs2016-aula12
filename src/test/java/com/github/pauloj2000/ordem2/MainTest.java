/*
 * UNIVERSIDADE FEDERAL DE GOIÁS - UFG 
 * Construção de Software - 2016/2
 * Professor: Fábio Nogueira de Lucena
 * Aluno: Paulo Junio Sales Rodrigues - 201602510
 */

package com.github.pauloj2000.ordem2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Classe que testa o QualidadeParser(QP).
 * 
 */

public class MainTest {
    
    @Test
    public void testMain() {
        String[] args = new String[2];
        String local = "test01.txt";
        String tipo = "-h";
        args[0] = local;
        args[1] = tipo;
        int expResult = 0;
        int result = Main.pseudoMain(args);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMain02() {
        String[] args = new String[2];
        String local = "teste.txt";
        String tipo = "-h";
        args[0] = local;
        args[1] = tipo;
        int expResult = 1;
        int result = Main.pseudoMain(args);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMain03() {
       String[] args = new String[2];
        String local = "test01.txt";
        String tipo = "-j";
        args[0] = local;
        args[1] = tipo;
        int expResult = 0;
        int result = Main.pseudoMain(args);
        assertEquals(expResult, result);
    }

    @Test
    public void testMain04() {
        String[] args = new String[2];
        String local = "test01.txt";
        String tipo = "-h";
        args[0] = local;
        args[1] = tipo;
        int expResult = 0;
        int result = Main.pseudoMain(args);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMain05() {
        String[] args = new String[1];
        String local = "test01.txt";
        args[0] = local;
        int expResult = 0;
        int result = Main.pseudoMain(args);
        assertEquals(expResult, result);
    }
    @Test
    public void testMain06() {
        String[] args = new String[1];
        String local = "test03.txt";
        args[0] = local;
        int expResult = 0;
        int result = Main.pseudoMain(args);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMain07() {
        String[] args = new String[1];
        String local = "test02.txt";
        args[0] = local;
        int expResult = 1;
        int result = Main.pseudoMain(args);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMain08() {
        String[] args = new String[1];
        int expResult = 1;
        int result = Main.pseudoMain(args);
        assertEquals(expResult, result);
    }  
}
