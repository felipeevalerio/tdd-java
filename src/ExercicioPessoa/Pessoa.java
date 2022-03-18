public class Pessoa {
    String nome;
    String cpf;
    int idade;
    String sexo;

    public Pessoa(){
        this.nome = "Larissa";
        this.cpf = "13802476836";
        this.idade = 18;
        this.sexo = "masculino";
    }
    
    public Pessoa(String nome,String cpf, int idade, String sexo){
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.sexo = sexo;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setCPF(String cpf){
        if(cpf.length() == 11){
            this.cpf = cpf;
        }
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    public void setSexo(String sexo){
        if(sexo == "masculino" || sexo == "feminino"){
            this.sexo = sexo;
        }
    }

    public String getNome(){
        return nome;
    }
    public String getCPF(){
        return cpf;
    }
    public int getIdade(){
        return idade;
    }
    public String getSexo(){
        return sexo;
    }

    public boolean eMaiorDeIdade(){
        return idade > 17;
    }
}
