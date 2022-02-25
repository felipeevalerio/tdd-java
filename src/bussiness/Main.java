package bussiness;
public class Main {
    public static void main(String[] args) {
        Data d1 = new Data(30,12,2003);
        Data d2 = new Data(26,3,2004);

        d1.imprimirData();
        d1.adicionarDias(368);
        d1.imprimirData();
        Data dataFutura = d1.verificarQualAMaiorData(d1, d2);
        dataFutura.imprimirData();
    }
}