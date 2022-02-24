package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bussines.Conjunto;

public class ConjuntoTest {
    Conjunto c;

    @BeforeEach
    void setUp() throws Exception {
        c = new Conjunto();
    }
    
    @Test
    void testConjuntoDeveEstarVazio() {
        assertEquals(0, c.getTamanho());
        assertTrue(c.vazio());
    }

    @Test
    void testAdicionarUm() {
        // Arrange
        int tamanho = c.getTamanho();
        // Act
        c.adicionar(5);
        
        // Assert
        assertEquals(tamanho + 1, c.getTamanho());
    }

    @Test 
    void testAdicionarNumeroRepetido() {
        // Arrange
        int tamanho = c.getTamanho();

        // Act
        c.adicionar(5);
        c.adicionar(5);
        // Assert
        assertEquals(tamanho + 1, c.getTamanho());
    }

    @Test
    void testContem() {
        c.adicionar(5);
        boolean valorExiste = c.contem(5);
        assertTrue(valorExiste);
    }
}
