package bussiness;

public class Data { 
    private int dia;
    private int mes;
    private int ano;

    private final int LIMITE_MAXIMO_DIAS_FEVEREIRO_SEM_ANO_BISSEXTO = 28;
    private final int LIMITE_MAXIMO_DIAS_FEVEREIRO_ANO_BISSEXTO = 29;
    private final int LIMITE_MAXIMO_MESES = 12;

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

    public Data(int dia, int mes, int ano) {
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

    public boolean validarData(int dia, int mes, int ano) {
        return verificarSeDiaExisteAPartirDoMes(dia, mes, ano) && 
        verificarSeMesExiste(mes) &&
        verificarSeAnoExiste(ano);
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

    private boolean verificarSeEstaEmAnoBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0;    
    }

    private boolean verificarSeMesExiste(int mes) {
        return mes > 0 && mes <= LIMITE_MAXIMO_MESES;
    }

    private boolean verificarSeAnoExiste(int ano) {
        return ano > 0;
    }

    public void adicionarDias(int dias) {
        int diasSomados = this.dia + dias;
        boolean diaValido = verificarSeDiaExisteAPartirDoMes(diasSomados, this.mes, this.ano);

        if (!diaValido) {
            int diasMaximoPorMes = receberValorDeDiasAPartirDoMes(mes, ano);
            int mesAtual = this.mes;

            for (int i = mesAtual; diasSomados >  diasMaximoPorMes; i++) {
                diasSomados -= diasMaximoPorMes; 

                mesAtual = i + 1;
                diasMaximoPorMes = receberValorDeDiasAPartirDoMes(mesAtual, this.ano);
            }            

            this.dia = diasSomados;
            this.mes = mesAtual;
        }
        else {
            this.dia = diasSomados;
        }
    }

    private int receberValorDeDiasAPartirDoMes(int mes, int ano) {
        switch (mes) {
            case NUMERO_MES_FEVEREIRO:
                boolean estaEmAnoBissexto = verificarSeEstaEmAnoBissexto(ano);
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

    public Data verificarQualAMaiorData(Data data1, Data data2) {
        int anoData1 = data1.getAno();
        int anoData2 = data2.getAno();

        int mesData1 = data1.getMes();
        int mesData2 = data2.getMes();

        int diaData1 = data1.getDia();
        int diaData2 = data2.getDia();

        int maiorAno = verificarQualOMaiorNumero(anoData1, anoData2);
        
        if(anoData1 != anoData2 || mesData1 != mesData2 || diaData1 != diaData2) {
            if (maiorAno != 0) {
                return maiorAno == anoData1 ? data1 : data2;
            }
    
            int maiorMes = verificarQualOMaiorNumero(mesData1, mesData2);
    
            if (maiorMes != 0) {
                return maiorMes == mesData1 ? data1 : data2;
            }
    
            int maiorDia = verificarQualOMaiorNumero(diaData1, diaData2);
    
            if (maiorDia != 0) {
                return maiorDia == diaData1 ? data1 : data2;
            }
        }

        return data1;
    }

    private int verificarQualOMaiorNumero(int numero1, int numero2) {
        if (numero1 > numero2) {
            return numero1;
        }
        else if(numero1 < numero2) {
            return numero2;
        }
        else { 
            return 0;
        }
    }

    public void imprimirData() {
        String diaFormatado = tratarFormatoDeNumerosAbaixoDeZero(this.dia);
        String mesFormatado = tratarFormatoDeNumerosAbaixoDeZero(this.mes);

        System.out.println(diaFormatado + "/" + mesFormatado + "/" + ano);
    }

    private String tratarFormatoDeNumerosAbaixoDeZero(int numero) {
        return numero < 10 ? "0" + Integer.toString(numero) : Integer.toString(numero);
    }
}