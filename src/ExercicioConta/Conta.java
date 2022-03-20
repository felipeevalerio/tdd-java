public class Conta {
    private int numeroDaConta;
    private float saldo;

    private static int contador = 0;

    public Conta() {
        contador++;    
        saldo = 0;
        numeroDaConta = contador;
    }

    public static int getContador() {
        return contador;
    }
    
    public void adicionaSaldo(int saldo) {
        
    }
}