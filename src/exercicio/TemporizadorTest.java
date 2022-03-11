import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TemporizadorTest {
    
    Temporizador temporizador;
    private final int MINUTOS_INICIAIS_TEMPORIZADOR = 1;
    private final int SEGUNDOS_INICIAIS_TEMPORIZADOR = 30;

    @BeforeEach
    public void inicializar() {
        temporizador = new Temporizador(1, 30);
    }
    
    @Test 
    public void adicionaTempoEmSegundosSemAumentarOMinuto() {
        int segundosAdicionados = 20;
        int segundosEsperados = SEGUNDOS_INICIAIS_TEMPORIZADOR + 20;

        temporizador.adicionaTempoEmSegundos(segundosAdicionados);
        
        int segundosAtual = temporizador.getSegundos();
        int minutosAtual = temporizador.getMinutos();

        assertEquals(segundosEsperados, segundosAtual);
        assertEquals(MINUTOS_INICIAIS_TEMPORIZADOR, minutosAtual);
    }

    @Test
    public void adicionaTempoEmSegundosAumentandoOsMinutos() {
        int segundosAdicionados = 40;
        int segundosEsperados = 10;
        int minutosEsperados = MINUTOS_INICIAIS_TEMPORIZADOR + 1;

        temporizador.adicionaTempoEmSegundos(segundosAdicionados);
        
        int segundosAtual = temporizador.getSegundos();
        int minutosAtual = temporizador.getMinutos();

        assertEquals(segundosEsperados, segundosAtual);
        assertEquals(minutosEsperados, minutosAtual);
    }

    @Test
    public void diminuiTempoEmUmSegundo() {
        int segundosEsperados = SEGUNDOS_INICIAIS_TEMPORIZADOR - 1;

        temporizador.diminuiTempoEmUmSegundo();

        int segundosAtual = temporizador.getSegundos();
        int minutosAtual = temporizador.getMinutos();

        assertEquals(MINUTOS_INICIAIS_TEMPORIZADOR, minutosAtual);
        assertEquals(segundosEsperados, segundosAtual);
    }

    @Test
    public void diminuiTempoEmUmSegundoAlterandoOMinuto() {
        int minutosEsperados = MINUTOS_INICIAIS_TEMPORIZADOR - 1;
        int segundosEsperados = 59;
        int i = 0;

        while(i <= SEGUNDOS_INICIAIS_TEMPORIZADOR) {
            temporizador.diminuiTempoEmUmSegundo();
            i++;
        }

        int segundosAtual = temporizador.getSegundos();
        int minutosAtual = temporizador.getMinutos();

        assertEquals(minutosEsperados, minutosAtual);
        assertEquals(segundosEsperados, segundosAtual);
    }
    
    public void formatarTempoMinutosSegundos() {
        String tempoFormatado = temporizador.formatarTempoMinutosSegundos(MINUTOS_INICIAIS_TEMPORIZADOR, SEGUNDOS_INICIAIS_TEMPORIZADOR);
        String resultadoEsperado = "01:30";

        assertEquals(resultadoEsperado, tempoFormatado);
    }
}
