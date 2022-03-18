public class Aplicacao {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        Pessoa pessoaComParametros = new Pessoa("Jorge", "13159320930", 36, "masculino");

        System.out.println("Pessoa padrão: ");
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("CPF: " + pessoa.getCPF());
        System.out.println("Idade: " + pessoa.getIdade());
        System.out.println("Sexo: " + pessoa.getSexo());
        System.out.println("É maior de idade? " + (pessoa.eMaiorDeIdade() ? "SIM" : "NÃO"));

        System.out.println("______________________________________________");

        System.out.println("Pessoa com parâmetros: ");
        System.out.println("Nome: " + pessoaComParametros.getNome());
        System.out.println("CPF: " + pessoaComParametros.getCPF());
        System.out.println("Idade: " + pessoaComParametros.getIdade());
        System.out.println("Sexo: " + pessoaComParametros.getSexo());
        System.out.println("É maior de idade? " + (pessoa.eMaiorDeIdade() ? "SIM" : "NÃO"));

        System.out.println("______________________________________________");

        pessoa.setNome("Laura");
        pessoa.setCPF("32103210392");
        pessoa.setIdade(14);
        pessoa.setSexo("feminino");

        System.out.println("Nova pessoa com parâmetros: ");
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("CPF: " + pessoa.getCPF());
        System.out.println("Idade: " + pessoa.getIdade());
        System.out.println("Sexo: " + pessoa.getSexo());
        System.out.println("É maior de idade? " + (pessoa.eMaiorDeIdade() ? "SIM" : "NÃO"));
    }
}
