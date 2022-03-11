import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MicroondasTest {
    
    Microondas microondas;

    @BeforeEach
    public void inicializar() {
        microondas = new Microondas();
        microondas.ligar();
    }

    @Test 
    public void verificarSePortaEstaAberta() {
        microondas.abrir();
        boolean estaAberto = microondas.isEstaAberto();
        assertTrue(estaAberto);
    }

    @Test
    public void verificarSePortaEstaFechada() {
        microondas.fechar();
        boolean estaAberto = microondas.isEstaAberto();
        assertFalse(estaAberto);
    }
    
    @Test
    public void verificarSeEstaLigado() {
        microondas.fechar();
        boolean estaLigado = microondas.isEstaLigado();
        assertTrue(estaLigado);
    }

    @Test
    public void verificarSeEstaDesligado() {
        microondas.desligar();
        microondas.fechar();
        boolean estaLigado = microondas.isEstaLigado();
        assertFalse(estaLigado);
    }

    @Test
    public void iniciarMicroondas() {
        microondas.iniciarMicroondas(1, 20);
        
    }

    
}
