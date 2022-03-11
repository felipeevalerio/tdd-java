import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MicroondasTest {
    
    Microondas microondas;
    private final int MINUTOS_INICIAIS_MICROONDAS = 1;
    private final int SEGUNDOS_INICIAIS_MICROONDAS = 30;

    @BeforeEach
    public void inicializar() {
        microondas = new Microondas();
        microondas.ligar(MINUTOS_INICIAIS_MICROONDAS, SEGUNDOS_INICIAIS_MICROONDAS);
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
    public void passarTempoEmUmSegundo() {
        int segundosEsperados = SEGUNDOS_INICIAIS_MICROONDAS - 1;
        microondas.passarTempoEmUmSegundo();
        
        assertEquals(segundosEsperados, microondas.obterTempoSegundos());
        assertEquals(MINUTOS_INICIAIS_MICROONDAS, microondas.obterTempoMinutos());
    }
    
    @Test
    public void passarTempoEmUmSegundoUltrapassandoOMinuto() {
        int minutosEsperados = MINUTOS_INICIAIS_MICROONDAS - 1;
        int segundosEsperados = 59;
        int i = 0;

        while(i <= SEGUNDOS_INICIAIS_MICROONDAS) {
            microondas.passarTempoEmUmSegundo();
            i++;
        }

        assertEquals(segundosEsperados, microondas.obterTempoSegundos());
        assertEquals(minutosEsperados, microondas.obterTempoMinutos());
    }
}