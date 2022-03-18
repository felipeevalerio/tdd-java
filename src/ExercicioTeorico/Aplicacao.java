public class Aplicacao {
    public static void main(String[] args) {
        Data data = new Data();
        Data dataComParametro = new Data(27,07,2021);

        System.out.println("______________________________________________");

        System.out.println("Criacao data atual:");          

        System.out.println("dia atual : " + data.getDia());
        System.out.println("mes atual: " + data.getMes());
        System.out.println("ano atual: " + data.getAno());

        System.out.println("______________________________________________");

        System.out.println("Criacao data por parametro:");

        System.out.println("dia: " + dataComParametro.getDia());
        System.out.println("mes: " + dataComParametro.getMes());
        System.out.println("ano: " + dataComParametro.getAno());

        dataComParametro.adicionarDias(100); 

        System.out.println("Data anterior + 100 dias : " + dataComParametro.porExtenso());

        System.out.println("______________________________________________");

        System.out.println("Dia da semana: " + dataComParametro.diaDaSemana());
        System.out.println("Ano é bissexto? " + (dataComParametro.eAnoBissexto(data.getAno()) ? "SIM" : "NÃO"));
        
        dataComParametro.proximoDia();

        System.out.println("Data anteriror + 1 dia : " + dataComParametro.porExtenso());
        
        System.out.println("Dia da semana : " + dataComParametro.diaDaSemana());

        System.out.println("______________________________________________");
    }   
}