package bussiness;

import enum.Mes; 

public class Data { 
    private int dia;
    private int mes;
    private int ano;

    private final int LIMITE_MAXIMO_DIAS_FEVEREIRO_SEM_ANO_BISSEXTO = 28;
    private final int LIMITE_MAXIMO_DIAS_FEVEREIRO_ANO_BISSEXTO = 29;
    private final int LIMITE_MAXIMO_MESES = 12;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    private boolean validarData(int dia, int mes, int ano) {
        return verificarSeDiaExisteAPartirDoMes(dia, mes) && 
        verificarSeMesExiste(mes) &&
        verificarSeAnoExiste(ano);
    }

    private boolean verificarSeDiaExisteAPartirDoMes(int dia, int mes) {
        if (dia > 0) {
            switch (mes) {
                case Mes.FEVEREIRO.getCodigoMes():
                    boolean estaEmAnoBissexto = verificarSeEstaEmAnoBissexto(ano);
                    
                    boolean diaValidoEmAnoBissexto = estaEmAnoBissexto && dia <= LIMITE_MAXIMO_DIAS_FEVEREIRO_ANO_BISSEXTO;
                    boolean diaValidoSemAnoBissexto = !estaEmAnoBissexto && dia <= LIMITE_MAXIMO_DIAS_FEVEREIRO_SEM_ANO_BISSEXTO;

                    return diaValidoEmAnoBissexto || diaValidoSemAnoBissexto;

                case Mes.ABRIL.getCodigoMes():
                case Mes.JUNHO.getCodigoMes():
                case Mes.SETEMBRO.getCodigoMes():
                case Mes.NOVEMBRO.getCodigoMes():
                    return dia <= 30;

                case Mes.JANEIRO.getCodigoMes():
                case Mes.MARCO.getCodigoMes():
                case Mes.MAIO.getCodigoMes():
                case Mes.JULHO.getCodigoMes():
                case Mes.AGOSTO.getCodigoMes():
                case Mes.OUTUBRO.getCodigoMes():
                case Mes.DEZEMBRO.getCodigoMes():
                    return dia <= 31;
            }
        }
        else {
            return false;
        }
    }

    private boolean verificarSeEstaEmAnoBissexto(int ano) {
        if (ano % 4 == 0 &&
            ano % 100 != 0 && 
        )    
        {

        }
    }

    private boolean verificarSeMesExiste(int mes) {
        return mes > 0 && mes <= LIMITE_MAXIMO_MESES;
    }

    private boolean verificarSeAnoExiste(int ano) {
        return ano > 0;
    }

    public void imprimirData() {
        
    }

}