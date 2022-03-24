package EscolaDeIdiomas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AlunoTest {
	
	Aluno aluno;
	
	@BeforeEach
	public void init()
	{
		aluno = new Aluno("placeholder","142");
		
	}
	@Test
	public void testeCriacaoAluno()
	{
		assertNotEquals(null, aluno);
	}
	@Test
	public void testeCadastrarFalta() {
		aluno.cadastrarFalta();
		assertEquals(95,aluno.getFrequencia());
	}
	@Test
	public void testeFrequenciaNegativa() {
		for(int i = 1; i<=21; i++) {
			aluno.cadastrarFalta();
		}
		assertEquals(0,aluno.getFrequencia());
	}
	@Test
	public void testeAvaliarAtividades() {
		aluno.avaliarAtividade1(15);
		aluno.avaliarAtividade2(20);
		aluno.avaliarAtividade3(10);
		aluno.avaliarAtividade4(0);
		
		assertEquals(15,aluno.getAtividade1());
		assertEquals(20,aluno.getAtividade2());
		assertEquals(10,aluno.getAtividade3());
		assertEquals(0,aluno.getAtividade4());
	}
	@Test
	public void testeLimiteNota() {
		aluno.avaliarAtividade1(-50);
		aluno.avaliarAtividade2(200);
		aluno.avaliarAtividade3(-1);
		aluno.avaliarAtividade4(4000);
		
		assertEquals(0,aluno.getAtividade1());
		assertEquals(0,aluno.getAtividade2());
		assertEquals(0,aluno.getAtividade3());
		assertEquals(0,aluno.getAtividade4());
	}
	public void testeReceberMedia() {
		aluno.avaliarAtividade1(50);
		aluno.avaliarAtividade2(30);
		aluno.avaliarAtividade3(100);
		aluno.avaliarAtividade4(60);
		
		assertEquals(60,aluno.getMedia());
	}
	public void testeCalculoDeAprovacao() {
		aluno.avaliarAtividade1(50);
		aluno.avaliarAtividade2(30);
		aluno.avaliarAtividade3(100);
		aluno.avaliarAtividade4(60);
		
		assertTrue(aluno.isAprovado());
	}
	public void testeReprovacaoPorMedia() {
		aluno.avaliarAtividade1(10);
		aluno.avaliarAtividade2(20);
		aluno.avaliarAtividade3(30);
		aluno.avaliarAtividade4(60);
		
		assertFalse(aluno.isAprovado());
	}
	public void testeReprovacaoPorFrequencia() {
		for(int i = 1; i <= 6; i++) {
			aluno.cadastrarFalta();
		}
		assertFalse(aluno.isAprovado());
	}
}