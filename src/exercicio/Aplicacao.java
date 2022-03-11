public class Aplicacao {
    public static void main(String[] args){
        Microondas microondas = new Microondas();
        microondas.ligar();
        microondas.fechar();
        microondas.iniciarMicroondas(1, 30);
    }
}
