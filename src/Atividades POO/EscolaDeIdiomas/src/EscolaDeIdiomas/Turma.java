package EscolaDeIdiomas;

import java.util.Arrays;

public class Turma{
	private static final int MAX_ALUNOS = 20;
	
	private int nivel;
	private int diaDaSemana;
	private int turno;
	
	private String codigoDaTurma;
	private int quantidadeDeAlunos;
	
	private float mediaNota;
	private float mediaFrequencia;
	
	private float melhorMediaFrequencia;
	private String nomeMelhorMediaFrequencia;
	
	Aluno[] alunos;
	
	Turma(int nivel, int diaDaSemana, int turno){
		this.nivel = nivel;
		this.diaDaSemana = diaDaSemana;
		this.turno = turno;
		this.codigoDaTurma = String.valueOf(nivel+diaDaSemana+turno);
		this.mediaNota = 0;
		this.mediaFrequencia = 0;
		this.quantidadeDeAlunos = 0;
		alunos = new Aluno[MAX_ALUNOS];
		melhorMediaFrequencia = 0;
		
	}
	
	public void cadastrarAlunoNaTurma(String nomeDoAluno) {
		this.alunos[this.quantidadeDeAlunos] = new Aluno(nomeDoAluno,this.codigoDaTurma);
		this.quantidadeDeAlunos++;
	}
	
	public int getQuantidadeDeAlunos() {
		return quantidadeDeAlunos;
	}
	public Object getUltimoAlunoCadastrado() {
		return alunos[this.quantidadeDeAlunos-1].getNome();
	}
	public float getMediaNota() {
		for(int i = 0; i<quantidadeDeAlunos;i++) {
			this.mediaNota = alunos[i].getMedia() + mediaNota;
		}
		
		mediaNota = mediaNota/quantidadeDeAlunos;
		
		System.out.println(mediaNota);
		
		return mediaNota;
	}
	public float getMediaFrequencia() {
		for(int i = 0; i<quantidadeDeAlunos;i++) {
			this.mediaFrequencia = alunos[i].getFrequencia() + mediaFrequencia;
		}
		mediaFrequencia = mediaFrequencia/quantidadeDeAlunos;
		
		System.out.println(mediaFrequencia);
		
		return mediaFrequencia;
	}
	public String getMelhorAluno() {
		
		double mediaFrequencia;
			
		for(int i = 0; i<quantidadeDeAlunos;i++) {
			
			mediaFrequencia = alunos[i].getMedia()*0.8 + alunos[i].getFrequencia()*0.2;
			
			
			if(mediaFrequencia > melhorMediaFrequencia ) {
				
				mediaFrequencia = melhorMediaFrequencia;
				nomeMelhorMediaFrequencia = alunos[i].getNome();
			}
		}
		
		
		return nomeMelhorMediaFrequencia;
	}

	private String obterNomePorOrdemAlfabetica(String nome1, String nome2) {
        for(int i = 0; i < nome1.length() && i < nome2.length(); i++) {
            if(nome1.charAt(i) < nome2.charAt(i)) {
                return nome1;
            }
            else if (nome1.charAt(i) > nome2.charAt(i)) { 
                return nome2;
            }
        }

        return "";
    }

	private Aluno[] ordenarNomesPorOrdemAlfabetica(Aluno[] alunos) {
		for(int i = 0; i < this.quantidadeDeAlunos; i++) {
            for(int j = 0; j< this.quantidadeDeAlunos - 1; j++) {
                String menorNome = obterNomePorOrdemAlfabetica(alunos[j].getNome(), alunos[j + 1].getNome());
                if (menorNome.equals(alunos[j + 1].getNome())) {
                    Aluno aux = alunos[j];
                    alunos[j] = alunos[j + 1];
                    alunos[j + 1] = aux;
                }
            }
        }

		return alunos;
	}

	public void gerarRelatorioDaTurma() {
		Aluno[] alunos = ordenarNomesPorOrdemAlfabetica(this.alunos);
		for(int i = 0; i < this.quantidadeDeAlunos; i++) {
			System.out.println(alunos[i].getNome());
		}
	}
}

