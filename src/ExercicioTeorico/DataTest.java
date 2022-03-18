import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class DataTest {
    Data data;
    Data dataComParametro;
    
    @BeforeEach
    public void inicializar() {
        data = new Data();
    }

    @Test
    public void instanciandoClasseSemParametros() {
        assertNotEquals(null, data);
    }

    @Test
    public void instanciandoClasseComParametros() {
        dataComParametro = new Data(1,2,2020);
        assertNotEquals(null, dataComParametro);
    }

    @Test
    public void testandoValidarDataDiaInvalido(){
        assertFalse(data.validarData(50,02,2000));
    }

    @Test
    public void testandoValidarDataMesInvalido(){
        assertFalse(data.validarData(20,20,2000));
    }

    @Test
    public void testandoValidarDataAnoInvalido(){
        assertFalse(data.validarData(20,03,0));
    }

    @Test
    public void testandoEAnoBissexto(){
        assertTrue(data.eAnoBissexto(2020));
    }

    @Test
    public void testandoNaoEAnoBissexto(){
        assertFalse(data.eAnoBissexto(2022));
    }

    @Test
    public void testandoCriacaoDeDataComParametro(){
        dataComParametro = new Data(12,05,2020);

        assertEquals(12, dataComParametro.getDia());
        assertEquals(05, dataComParametro.getMes());
        assertEquals(2020, dataComParametro.getAno());
    }

    @Test
    public void testandoReceberDataPorextenso(){
        dataComParametro = new Data(27,07,2021);

        assertEquals("27/07/2021", dataComParametro.porExtenso());
    }

    @Test 
    public void testandoAdicionarDias(){
        data.adicionarDias(100);
        assertEquals(25, data.getDia());
        assertEquals(06, data.getMes());
        assertEquals(2022, data.getAno());
    }

    @Test
    public void testandoDiasNoMes(){
        dataComParametro = new Data(20,02,2000);
        assertEquals(29, dataComParametro.diasNoMes());
    }
    
    @Test
    public void testandoPassarUmDia(){
        dataComParametro = new Data(31,07,2021);
        dataComParametro.proximoDia();

        assertEquals(01, dataComParametro.getDia());
        assertEquals(8, dataComParametro.getMes());
        assertEquals(2021, dataComParametro.getAno());
    }    

    @Test
    public void testandoDiaDaSemana(){
        dataComParametro = new Data(18,03,2022);
        assertEquals("Sexta-feira", dataComParametro.diaDaSemana());
    }
}