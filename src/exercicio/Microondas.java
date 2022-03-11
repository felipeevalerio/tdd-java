public class Microondas {
    private boolean estaAberto;
    private boolean estaLigado;
    private Temporizador temporizador;

    private int minutosIniciais;
    private int segundosIniciais; 

    public Microondas() {
        estaAberto = false;
        estaLigado = false;
    }

    public void abrir() {
        if(isEstaLigado() && !isEstaAberto()) {
            setEstaAberto(true);
        } 
    }

    public void fechar() {
        if(isEstaLigado() && isEstaAberto()) {
            setEstaAberto(false);
        } 
    }
    
    public void ligar(int minutos, int segundos) {
        if(!isEstaAberto() && !isEstaLigado()) {
            this.minutosIniciais = minutos;
            this.segundosIniciais = segundos;

            temporizador = new Temporizador(minutos, segundos);
            setEstaLigado(true);
        }
    }

    public void desligar() {
        if(!isEstaAberto() && isEstaLigado()) {
            setEstaLigado(false);
        } 
    }
    
    public void passarTempoEmUmSegundo() {
        if((!isEstaAberto() && isEstaLigado()) && (temporizador.getMinutos() >= 0 || temporizador.getSegundos() > 0)) {
            temporizador.diminuiTempoEmUmSegundo();
        } else {
            this.desligar();
        }
    }

    public int obterTempoSegundos() {
        return temporizador.getSegundos();
    }

    public int obterTempoMinutos() {
        return temporizador.getMinutos();
    }

    public void reiniciarMicroondas() {
        this.desligar();
        this.ligar(minutosIniciais, segundosIniciais);
    }

    public void sinalizarTempo() {
        String tempoFormatado = temporizador.formatarTempoMinutosSegundos(temporizador.getMinutos(), temporizador.getSegundos());
        System.out.println(tempoFormatado);
    }

    public boolean isEstaLigado() {
        return this.estaLigado;
    }

    private void setEstaLigado(boolean estaLigado) {
        this.estaLigado = estaLigado;
    }

    public boolean isEstaAberto() {
        return estaAberto;
    }

    private void setEstaAberto(boolean estaAberto) {
        this.estaAberto = estaAberto;
    }
}