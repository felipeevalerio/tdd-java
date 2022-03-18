import java.time.LocalDate;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    private final int LIMITE_MINIMO = 0;
    private final int LIMITE_MAXIMO_MESES = 12;

    private final int LIMITE_MAXIMO_DIAS_FEVEREIRO_SEM_ANO_BISSEXTO = 28;
    private final int LIMITE_MAXIMO_DIAS_FEVEREIRO_ANO_BISSEXTO = 29;

    private final int NUMERO_MES_JANEIRO = 1;
    private final int NUMERO_MES_FEVEREIRO = 2;
    private final int NUMERO_MES_MARCO = 3;
    private final int NUMERO_MES_ABRIL = 4;
    private final int NUMERO_MES_MAIO = 5;
    private final int NUMERO_MES_JUNHO = 6;
    private final int NUMERO_MES_JULHO = 7;
    private final int NUMERO_MES_AGOSTO = 8;
    private final int NUMERO_MES_SETEMBRO = 9;
    private final int NUMERO_MES_OUTUBRO = 10;
    private final int NUMERO_MES_NOVEMBRO = 11;
    private final int NUMERO_MES_DEZEMBRO = 12;

    Data() {
        LocalDate dataAtual = LocalDate.now();
        this.dia = dataAtual.getDayOfMonth();
        this.mes = dataAtual.getMonthValue();
        this.ano = dataAtual.getYear();
    }

    Data(int dia, int mes, int ano) {
        boolean dataValida = validarData(dia, mes, ano);
        if (dataValida) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }
    }

    public int getDia() {
        return this.dia;
    }

    public int getMes() {
        return this.mes;
    }

    public int getAno() {
        return this.ano;
    }

    public void adicionarDias(int dias) {
        passarDias(dias);
    }
    
    public void proximoDia() {
        passarDias(1);
    }

    public int diasNoMes() {
        return receberValorDeDiasAPartirDoMes(mes, ano);
    }

    public String diaDaSemana() {
        LocalDate diaDaSemana = LocalDate.of(ano, mes, dia);
        
        switch(diaDaSemana.getDayOfWeek()) {
            case SUNDAY: 
                return "Domingo";
            case MONDAY:
                return "Segunda-feira";
            case TUESDAY:
                return "Terça-feira";
            case WEDNESDAY:
                return "Quarta-feira";
            case THURSDAY:
                return "Quinta-feira";
            case FRIDAY:
                return "Sexta-feira";
            case SATURDAY:
                return "Sábado";
            default:
                return "";
        }
    }

    public boolean validarData(int dia, int mes, int ano) {
        return verificarSeDiaExisteAPartirDoMes(dia, mes, ano) && 
        verificarSeMesExiste(mes) &&
        verificarSeAnoExiste(ano);
    }
    
    public String porExtenso() {
        String diaFormatado = tratarFormatoDeNumerosComUmaCasaDecimal(this.dia);
        String mesFormatado = tratarFormatoDeNumerosComUmaCasaDecimal(this.mes);

        return diaFormatado + "/" + mesFormatado + "/" + ano;
    }

    public boolean eAnoBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0;    
    }

    private void passarDias(int dias) {
        int diasSomados = getDia() + dias;
        boolean diaExiste = verificarSeDiaExisteAPartirDoMes(diasSomados, getMes(), getAno());

        if (!diaExiste) {
            int diasMaximoPorMes = receberValorDeDiasAPartirDoMes(mes, ano);
            int mesAtual = getMes();

            for (int i = mesAtual; diasSomados >  diasMaximoPorMes; i++) {
                diasSomados -= diasMaximoPorMes; 
                
                mesAtual = i + 1;

                if (mesAtual > LIMITE_MAXIMO_MESES) {
                    setAno(getAno() + 1);
                    i = 1;
                    mesAtual = 1;
                }

                diasMaximoPorMes = receberValorDeDiasAPartirDoMes(mesAtual, getAno());
            }            
            setMes(mesAtual);
        }
        setDia(diasSomados);
    }

    private String tratarFormatoDeNumerosComUmaCasaDecimal(int numero) {
        return numero < 10 ? "0" + Integer.toString(numero) : Integer.toString(numero);
    }

    private boolean verificarSeDiaExisteAPartirDoMes(int dia, int mes, int ano) {
        if (dia > 0) {
            int diasAPartirDoMes = receberValorDeDiasAPartirDoMes(mes, ano);
            return (diasAPartirDoMes != 0) && (dia <= diasAPartirDoMes);
        }
        else {
            return false;
        }
    }

    private int receberValorDeDiasAPartirDoMes(int mes, int ano) {
        switch (mes) {
            case NUMERO_MES_FEVEREIRO:
                boolean estaEmAnoBissexto = eAnoBissexto(ano);
                return estaEmAnoBissexto ? LIMITE_MAXIMO_DIAS_FEVEREIRO_ANO_BISSEXTO : LIMITE_MAXIMO_DIAS_FEVEREIRO_SEM_ANO_BISSEXTO;

            case NUMERO_MES_ABRIL:
            case NUMERO_MES_JUNHO:
            case NUMERO_MES_SETEMBRO:
            case NUMERO_MES_NOVEMBRO:
                return 30;

            case NUMERO_MES_JANEIRO:
            case NUMERO_MES_MARCO:
            case NUMERO_MES_MAIO:
            case NUMERO_MES_JULHO:
            case NUMERO_MES_AGOSTO:
            case NUMERO_MES_OUTUBRO:
            case NUMERO_MES_DEZEMBRO: 
                return 31;

            default:
                return 0;
        }
    }

    private boolean verificarSeMesExiste(int mes) {
        return mes > LIMITE_MINIMO && mes <= LIMITE_MAXIMO_MESES;
    }

    private boolean verificarSeAnoExiste(int ano) {
        return ano > LIMITE_MINIMO;
    }
    
    private void setDia(int dia) {
        this.dia = dia;
    }

    private void setMes(int mes) {
        this.mes = mes;
    }

    private void setAno(int ano) {
        this.ano = ano;
    }

}