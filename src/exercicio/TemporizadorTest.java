import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TemporizadorTest {
    
    Temporizador temporizador;
    private final int MINUTOS_TEMPORIZADOR = 1;
    private final int SEGUNDOS_TEMPORIZADOR = 30;

    @BeforeEach
    public void inicializar() {
        temporizador = new Temporizador(1, 30);
    }

    @Test 
    public void adicionaTempoEmSegundosSemAumentarOMinuto() {
        int segundosAdicionados = 20;
        int segundosEsperados = SEGUNDOS_TEMPORIZADOR + 20;

        temporizador.adicionaTempoEmSegundos(segundosAdicionados);
        
        int segundosAtual = temporizador.getSegundos();
        int minutosAtual = temporizador.getMinutos();

        assertEquals(segundosEsperados, segundosAtual);
        assertEquals(MINUTOS_TEMPORIZADOR, minutosAtual);
    }

    @Test
    public void adicionaTempoEmSegundosAumentandoOsMinutos() {
        int segundosAdicionados = 40;
        int segundosEsperados = 10;
        int minutosEsperados = MINUTOS_TEMPORIZADOR + 1;

        temporizador.adicionaTempoEmSegundos(segundosAdicionados);
        
        int segundosAtual = temporizador.getSegundos();
        int minutosAtual = temporizador.getMinutos();

        assertEquals(segundosEsperados, segundosAtual);
        assertEquals(minutosEsperados, minutosAtual);
    }

    @Test
    public void diminuiTempoEmUmSegundo() {
        int segundosEsperados = SEGUNDOS_TEMPORIZADOR - 1;

        temporizador.diminuiTempoEmUmSegundo();

        int segundosAtual = temporizador.getSegundos();
        int minutosAtual = temporizador.getMinutos();

        assertEquals(MINUTOS_TEMPORIZADOR, minutosAtual);
        assertEquals(segundosEsperados, segundosAtual);
    }

    @Test
    public void diminuiTempoEmUmSegundoAlterandoOMinuto() {
        int minutosEsperados = MINUTOS_TEMPORIZADOR - 1;
        int segundosEsperados = 59;
        int i = 0;

        while(i <= SEGUNDOS_TEMPORIZADOR) {
            temporizador.diminuiTempoEmUmSegundo();
            i++;
        }

        int segundosAtual = temporizador.getSegundos();
        int minutosAtual = temporizador.getMinutos();

        assertEquals(minutosEsperados, minutosAtual);
        assertEquals(segundosEsperados, segundosAtual);
    }    
}
