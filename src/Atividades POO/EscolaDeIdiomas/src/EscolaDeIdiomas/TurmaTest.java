package EscolaDeIdiomas;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TurmaTest {
	Turma turma;
	
	@BeforeEach
	public void init()
	{
		turma = new Turma(1,4,2);
		
	}
	@Test
	public void testeCriacaoDeTurma()
	{
		assertNotEquals(null, turma);
	}
	@Test
	public void testeContabilizandoQuantidade() {
		turma.cadastrarAlunoNaTurma("Thiago");
		assertEquals(1,turma.getQuantidadeDeAlunos());
		
	}
	@Test
	public void testeGerarMediaTurma() {
		turma.cadastrarAlunoNaTurma("Thiago");
		turma.cadastrarAlunoNaTurma("Marcio");
		turma.cadastrarAlunoNaTurma("Camila");
		
		turma.alunos[0].avaliarAtividade1(20);
		turma.alunos[0].avaliarAtividade2(10);
		turma.alunos[0].avaliarAtividade3(15);//16,25
		turma.alunos[0].avaliarAtividade4(20);
		
		turma.alunos[1].avaliarAtividade1(10);
		turma.alunos[1].avaliarAtividade2(10);
		turma.alunos[1].avaliarAtividade3(05);//11,25
		turma.alunos[1].avaliarAtividade4(20);
		
		turma.alunos[2].avaliarAtividade1(20);
		turma.alunos[2].avaliarAtividade2(15);
		turma.alunos[2].avaliarAtividade3(10);//13
		turma.alunos[2].avaliarAtividade4(07);
		
		assertEquals(13.5,turma.getMediaNota());
	}
	@Test
	public void testeGerarMediaFrequenciaTurma() {
		turma.cadastrarAlunoNaTurma("Thiago");//frequencia = 85
		turma.cadastrarAlunoNaTurma("Marcio");//frequencia = 90
		turma.cadastrarAlunoNaTurma("Camila");//frequencia = 95
		
		turma.alunos[0].cadastrarFalta();
		turma.alunos[0].cadastrarFalta();
		turma.alunos[0].cadastrarFalta();
		turma.alunos[1].cadastrarFalta();
		turma.alunos[1].cadastrarFalta();
		turma.alunos[2].cadastrarFalta();
		
		
		assertEquals(90,turma.getMediaFrequencia());
	}
	@Test
	public void testeDescobrirMelhorMediaFrequencia() {
		turma.cadastrarAlunoNaTurma("Thiago");//frequencia = 85
		turma.cadastrarAlunoNaTurma("Marcio");//frequencia = 90
		turma.cadastrarAlunoNaTurma("Camila");//frequencia = 95
		
		turma.alunos[0].cadastrarFalta();
		turma.alunos[0].cadastrarFalta();
		turma.alunos[0].cadastrarFalta();
		turma.alunos[1].cadastrarFalta();
		turma.alunos[1].cadastrarFalta();
		turma.alunos[2].cadastrarFalta();
		
		turma.alunos[0].avaliarAtividade1(20);
		turma.alunos[0].avaliarAtividade2(10);
		turma.alunos[0].avaliarAtividade3(15);//16,25
		turma.alunos[0].avaliarAtividade4(20);
		
		turma.alunos[1].avaliarAtividade1(10);
		turma.alunos[1].avaliarAtividade2(10);
		turma.alunos[1].avaliarAtividade3(05);//11,25
		turma.alunos[1].avaliarAtividade4(20);
		
		turma.alunos[2].avaliarAtividade1(20);
		turma.alunos[2].avaliarAtividade2(15);
		turma.alunos[2].avaliarAtividade3(10);//13
		turma.alunos[2].avaliarAtividade4(07);
		
		
		assertEquals("Thiago",turma.getMelhorAluno());
	}
	
}