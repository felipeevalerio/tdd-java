package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bussines.Conjunto;

public class ConjuntoTest {
    
    @Test
    @DisplayName("Deve retornar o tamanho do conjunto como vazio")
    void testConjuntoDeveEstarVazio() {
        Conjunto c = new Conjunto();
        assertEquals(0, c.getTamanho());
        assertTrue(c.vazio());
    }

    @Test
    @DisplayName("Deve adicionar um elemento ao conjunto")
    void testAdicionarUm() {
        // Arrange
        Conjunto c = new Conjunto();
        
        // Act
        c.adicionar(5);
        
        // Assert
        assertEquals(1, c.getTamanho());
    }

    @Test 
    void testAdicionarNumeroRepetido() {
        // Arrange
        Conjunto c = new Conjunto();
        // Act
        c.adicionar(5);
        c.adicionar(5);
        // Assert
        assertEquals(1, c.getTamanho());
    }

    @Test
    void testContem() {
        Conjunto c = new Conjunto();
        c.adicionar(5);
        boolean valorExiste = c.contem(5);
        assertTrue(valorExiste);
    }
}
