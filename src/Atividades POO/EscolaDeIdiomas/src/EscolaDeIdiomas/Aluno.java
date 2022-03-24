package EscolaDeIdiomas;

public class Aluno{
	
	private String nome;
	
	private float atividade1;
	private float atividade2;
	private float atividade3;
	private float atividade4;
	
	private float media;
	
	private boolean aprovado;
	
	private String codigoDaTurma;
	
	private int frequencia;
	
	Aluno(String nome,String codigoDaTurma){
		this.nome = nome;
		this.aprovado = false;
		this.codigoDaTurma = codigoDaTurma;
		this.frequencia = 100;
		this.atividade1 = 0;
		this.atividade2 = 0;
		this.atividade3 = 0;
		this.atividade4 = 0;
		this.media = 0;
	}
	
	public void cadastrarFalta() {
		if(frequencia >0) {
			this.frequencia = this.frequencia - 5;
			atualizarAprovacao();
		}
	}
	public void avaliarAtividade1(float nota) {
		if(testaNota(nota)) {
			setAtividade1(nota);
			atualizarMedia();
		}

	}
	public void avaliarAtividade2(float nota) {
		if(testaNota(nota)) {
			setAtividade2(nota);
			atualizarMedia();
		}

	}
	public void avaliarAtividade3(float nota) {
		if(testaNota(nota)) {
			setAtividade3(nota);
			atualizarMedia();
		}

	}
	public void avaliarAtividade4(float nota) {
		if(testaNota(nota)) {
			setAtividade4(nota);
			atualizarMedia();
		}

	}
	private boolean testaNota(float nota) {
		if(nota>= 0 && nota < 26) {
			return true;
		}else {
			return false;
		}
	}
	public String getNome(){
		return nome;
	}
	public int getFrequencia(){
		return frequencia;
	}
	private void setAtividade1(float nota) {
		this.atividade1 = nota;
	}
	public float getAtividade1() {
		return atividade1;
	}
	private void setAtividade2(float nota) {
		this.atividade2 = nota;
	}
	public float getAtividade2() {
		return atividade2;
	}
	private void setAtividade3(float nota) {
		this.atividade3 = nota;
	}
	public float getAtividade3() {
		return atividade3;
	}
	private void setAtividade4(float nota) {
		this.atividade4 = nota;
	}
	public float getAtividade4() {
		return atividade4;
	}
	public String getCodigoDaTurma() {
		return codigoDaTurma;
	}
	
	private void atualizarMedia() {
		this.media = (atividade1+atividade2+atividade3+atividade4)/4;
		atualizarAprovacao();
	}
	public float getMedia() {
		return media;
	}
	
	private void setAprovado(boolean aprovacao) {
		this.aprovado = aprovacao;
	}
	public boolean isAprovado() {
		return aprovado;
	}
	private void atualizarAprovacao() {
		if(media>59 && frequencia>74) {
			setAprovado(true);
		}else {
			setAprovado(false);
		}
	}
	
	
	
}