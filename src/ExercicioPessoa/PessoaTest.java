import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PessoaTest {
    Pessoa pessoa;
    Pessoa pessoaComParametros;

    String nome = "Lucas";
    String cpf = "13212519423";
    int idade = 18;
    String sexo = "masculino";

    @BeforeEach
    public void inicializar() {
        pessoa = new Pessoa();
        pessoaComParametros = new Pessoa(nome, cpf, idade, sexo);
    }

    @Test
    public void instanciandoClasseSemParametros() {
        assertNotEquals(null, pessoa);
    }

    @Test
    public void instanciandoClasseComParametros() {
        assertNotEquals(null, pessoaComParametros);
        assertEquals(nome, pessoaComParametros.getNome());
        assertEquals(cpf, pessoaComParametros.getCPF());
        assertEquals(idade, pessoaComParametros.getIdade());
        assertEquals(sexo, pessoaComParametros.getSexo());
    }

    @Test
    public void alterarNomePessoa() {
        String novoNome = "Leonardo";

        pessoaComParametros.setNome(novoNome);
        assertEquals(novoNome, pessoaComParametros.getNome());
    }

    @Test
    public void alterarIdadePessoa() {
        int novaIdade = 21;

        pessoaComParametros.setIdade(novaIdade);
        assertEquals(novaIdade, pessoaComParametros.getIdade());
    }

    @Test
    public void alterarCPFPessoaValido() {
        String novoCpf = "21910394504";

        pessoaComParametros.setCPF(novoCpf);
        assertEquals(novoCpf, pessoaComParametros.getCPF());
    }

    @Test
    public void alterarCPFPessoaInvalido() {
        String novoCpf = "1231";

        pessoaComParametros.setCPF(novoCpf);
        assertNotEquals(novoCpf, pessoaComParametros.getCPF());
        assertEquals(cpf, pessoaComParametros.getCPF());
    }

    @Test
    public void alterarSexoPessoaValido() {
        String novoSexo = "feminino";

        pessoaComParametros.setSexo(novoSexo);
        assertEquals(novoSexo, pessoaComParametros.getSexo());
    }

    @Test
    public void alterarSexoPessoaInvalido() {
        String novoSexo = "Cachorro";

        pessoaComParametros.setSexo(novoSexo);
        assertNotEquals(novoSexo, pessoaComParametros.getSexo());
        assertEquals(sexo, pessoaComParametros.getSexo());
    }

    @Test
    public void pessoaMaiorDeIdade() {
        assertTrue(pessoaComParametros.eMaiorDeIdade());
    }

    @Test
    public void pessoaMenorDeIdade() {
        pessoaComParametros.setIdade(14);
        assertFalse(pessoaComParametros.eMaiorDeIdade());
    }
}