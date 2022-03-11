public class Microondas {
    private boolean estaAberto;
    private boolean estaLigado;

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

    public void ligar() {
        if(!isEstaAberto() && !isEstaLigado()) {
            setEstaLigado(true);
        }
    }

    public void desligar() {
        if(!isEstaAberto() && isEstaLigado()) {
            setEstaLigado(false);
        }
    }

    public void iniciarMicroondas(int minutos, int segundos) {
        if(!isEstaAberto() && isEstaLigado()) {
            Temporizador temporizador = new Temporizador(minutos, segundos);
            while(temporizador.getSegundos() > 0 || temporizador.getMinutos() >= 0) {
                temporizador.diminuiTempoEmUmSegundo();
            }
        }
    }

    public void reiniciarMicroondas() {

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