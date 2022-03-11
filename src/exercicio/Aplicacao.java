public class Aplicacao {
    public static void main(String[] args){
        Microondas microondas = new Microondas();
        microondas.ligar(1,30);
        microondas.sinalizarTempo();
        microondas.fechar();
    }
}
