/*
 * UNIVERSIDADE FEDERAL DE GOIÁS - UFG 
 * Construção de Software - 2016/2
 * Professor: Fábio Nogueira de Lucena
 * Aluno: Paulo Junio Sales Rodrigues - 201602510
 */

package com.github.pauloj2000.ordem2;

import org.junit.Test;

/**
 * Classe que testa o QualidadeParser(QP).
 * 
 */

public class QPTest {
    
    @Test
    public void testQP() {
        String[] args = new String[2];
        String local = "test01.txt";
        String tipo = "-h";
        args[0] = local;
        args[1] = tipo;
        int expResult = 0;
        int result = qp.pseudoMain(args);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testQP02() {
        String[] args = new String[2];
        String local = "teste.txt";
        String tipo = "-h";
        args[0] = local;
        args[1] = tipo;
        int expResult = 1;
        int result = qp.pseudoMain(args);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testQP03() {
       String[] args = new String[2];
        String local = "test01.txt";
        String tipo = "-j";
        args[0] = local;
        args[1] = tipo;
        int expResult = 0;
        int result = qp.pseudoMain(args);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testQP04() {
       String[] args = new String[1];
        String local = "teste.txt";
        args[0] = local;
        int expResult = 1;
        int result = qp.pseudoMain(args);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testQP05() {
        String[] args = new String[1];
        String local = "test01.txt";
        args[0] = local;
        int expResult = 0;
        int result = qp.pseudoMain(args);
        assertEquals(expResult, result);
    }
    @Test
    public void testQP06() {
        String[] args = new String[1];
        int expResult = 1;
        int result = qp.pseudoMain(args);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testQP07() {
        String[] args = new String[1];
        String local = "test02.txt";
        args[0] = local;
        int expResult = 1;
        int result = qp.pseudoMain(args);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testQP08() {
        String[] args = new String[1];
        String local = "test03.txt";
        args[0] = local;
        int expResult = 0;
        int result = qp.pseudoMain(args);
        assertEquals(expResult, result);
    }
    
      
}
