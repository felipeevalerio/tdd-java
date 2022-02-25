package bussiness;

public class Data { 
    private int dia;
    private int mes;
    private int ano;

    private final int LIMITE_MAXIMO_DIAS_FEVEREIRO_SEM_ANO_BISSEXTO = 28;
    private final int LIMITE_MAXIMO_DIAS_FEVEREIRO_ANO_BISSEXTO = 29;
    private final int LIMITE_MAXIMO_MESES = 12;

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
            return dia <= diasAPartirDoMes;
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
            case 2:
                boolean estaEmAnoBissexto = verificarSeEstaEmAnoBissexto(ano);
                return estaEmAnoBissexto ? LIMITE_MAXIMO_DIAS_FEVEREIRO_ANO_BISSEXTO : LIMITE_MAXIMO_DIAS_FEVEREIRO_SEM_ANO_BISSEXTO;

            case 4:
            case 6:
            case 9:
            case 11:
                return 30;

            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
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