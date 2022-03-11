public class Temporizador {
    private int minutos;
    private int segundos;

    private final int TEMPO_INICIAL = 0;
    private final int LIMITE_SEGUNDOS = 60;

    public Temporizador() {
        this.minutos = TEMPO_INICIAL;
        this.segundos = TEMPO_INICIAL;
    }

    public Temporizador(int minutos, int segundos) {
        this.minutos = minutos;
        this.segundos = segundos;
    }
    
    public void adicionaTempoEmSegundos(int tempoEmSegundos) {
        while(tempoEmSegundos + getSegundos() > LIMITE_SEGUNDOS) {
            setMinutos(getMinutos() + 1);
            tempoEmSegundos -= LIMITE_SEGUNDOS;
        }
        setSegundos(getSegundos() + tempoEmSegundos);
    }

    public void diminuiTempoEmUmSegundo() {
        if(getMinutos() >= TEMPO_INICIAL) {
            if(getSegundos() == TEMPO_INICIAL) {
                setMinutos(getMinutos() - 1);
                setSegundos(LIMITE_SEGUNDOS);
            }

            if(getSegundos() > TEMPO_INICIAL) {
                setSegundos(getSegundos() - 1);
            }
            else {
                setSegundos(TEMPO_INICIAL);
                setMinutos(TEMPO_INICIAL);
            }
        }
    }

    public int getSegundos() {
        return this.segundos;
    }

    public int getMinutos() {
        return this.minutos;
    }

    public String formatarTempoMinutosSegundos(int minutos, int segundos) {
        return  String.format("%02d:%02d", this.getMinutos(), this.getSegundos());
    }

    private void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    private void setMinutos(int minutos) {
        this.minutos = minutos;
    }
}