package bussiness;

import bussiness.enums.Mes;

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

    private boolean validarData(int dia, int mes, int ano) {
        return verificarSeDiaExisteAPartirDoMes(dia, mes, ano) && 
        verificarSeMesExiste(mes) &&
        verificarSeAnoExiste(ano);
    }

    private boolean verificarSeDiaExisteAPartirDoMes(int dia, int mes, int ano) {
        if (dia > 0) {
            switch (mes) {
                case Mes.FEVEREIRO.getCodigoMes():
                    return dia <= receberValorDeDiasAPartirDoMes(Mes.FEVEREIRO, ano)

                case Mes.ABRIL.getCodigoMes():
                case Mes.JUNHO.getCodigoMes():
                case Mes.SETEMBRO.getCodigoMes():
                case Mes.NOVEMBRO.getCodigoMes():
                    return dia <= receberValorDeDiasAPartirDoMes(Mes.ABRIL, ano);

                case Mes.JANEIRO.getCodigoMes():
                case Mes.MARCO.getCodigoMes():
                case Mes.MAIO.getCodigoMes():
                case Mes.JULHO.getCodigoMes():
                case Mes.AGOSTO.getCodigoMes():
                case Mes.OUTUBRO.getCodigoMes():
                case Mes.DEZEMBRO.getCodigoMes():
                    return dia <= receberValorDeDiasAPartirDoMes(Mes.JANEIRO, ano);
            }
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
        int diasSomados = this.dias + dias;
        boolean diaValido = verificarSeDiaExisteAPartirDoMes(diasSomados, this.mes, this.ano);

        if (!diaValido) {
            int diasMaximoPorMes = receberValorDeDiasAPartirDoMes(mes);
            int mesAtual = this.mes;

            for (int i = mesAtual; diasSomados < diasMaximoPorMes; i++) {
                diasSomados -= diasMaximoPorMes; 

                mesAtual = i;
                diasMaximoPorMes = receberValorDeDiasAPartirDoMes(i, this.ano);
            }            

            this.dia = diasSomados;
            this.mes = mesAtual;
            this.ano = ano
        }
        else {
            this.dia = dias;
        }
    }

    private int receberValorDeDiasAPartirDoMes(int mes, int ano) {
        switch (mes) {
            case Mes.FEVEREIRO.getCodigoMes():
                boolean estaEmAnoBissexto = verificarSeEstaEmAnoBissexto(ano);
                return estaEmAnoBissexto ? LIMITE_MAXIMO_DIAS_FEVEREIRO_ANO_BISSEXTO : LIMITE_MAXIMO_DIAS_FEVEREIRO_SEM_ANO_BISSEXTO;

            case Mes.ABRIL.getCodigoMes():
            case Mes.JUNHO.getCodigoMes():
            case Mes.SETEMBRO.getCodigoMes():
            case Mes.NOVEMBRO.getCodigoMes():
                return 30;

            case Mes.JANEIRO.getCodigoMes():
            case Mes.MARCO.getCodigoMes():
            case Mes.MAIO.getCodigoMes():
            case Mes.JULHO.getCodigoMes():
            case Mes.AGOSTO.getCodigoMes():
            case Mes.OUTUBRO.getCodigoMes():
            case Mes.DEZEMBRO.getCodigoMes():
                return 31;
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
        
        if (maiorAno) {
            return maiorAno == anoData1 ? data1 : data2;
        }

        int maiorMes = verificarQualOMaiorNumero(mesData1, mesData2);

        if (maiorMes) {
            return maiorMes == mesData1 ? data1 : data2;
        }

        int maiorDia = verificarQualOMaiorNumero(diaData1, diaData2);

        if (maiorDia) {
            return maiorDia == diaData1 ? data1 : data2;
        }

    }

    private int verificarQualOMaiorNumero(int numero1, int numero2) {
        if (numero1 > numero2) {
            return numero1;
        }
        else if(numero1 < numero2) {
            return numero2;
        }
        else {
            return null;
        }
    }

    public void imprimirData() {
        String diaFormatado = tratarFormatoDeNumerosAbaixoDeZero(this.dia);
        String mesFormatado = tratarFormatoDeNumerosAbaixoDeZero(this.mes);

        System.out.println(diaFormatado + "/" + mesFormatado + "/" + ano);
    }

    private String tratarFormatoDeNumerosAbaixoDeZero(int numero) {
        return numero < 10 ? "0" + numero.toString() : numero.toString();
    }
}