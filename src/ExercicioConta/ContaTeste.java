public class ContaTeste {

    @BeforeEach
    public void inicializar() {
        Conta conta = new Conta(); 
    }

    @Test
    public void criarConta() {
        conta.getContador();
    }
}