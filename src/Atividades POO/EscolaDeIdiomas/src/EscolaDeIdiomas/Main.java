package EscolaDeIdiomas;

public class Main{
	public static void main(String[] args){
		Turma turma = new Turma(1,2,4);

		turma.cadastrarAlunoNaTurma("Thiago b");
		turma.cadastrarAlunoNaTurma("Camila");
		turma.cadastrarAlunoNaTurma("Jorge");
		turma.cadastrarAlunoNaTurma("Thiago a");
		
		turma.gerarRelatorioDaTurma();
	}
}