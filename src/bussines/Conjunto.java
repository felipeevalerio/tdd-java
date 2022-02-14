package bussines;

import java.util.ArrayList;
import java.util.List;

public class Conjunto {
    private int tamanho = 0;
    private List<Integer> conjunto = new ArrayList<Integer>();

    public int getTamanho() {
        return tamanho;
    }

    public void adicionar(int elemento) {
        boolean valorExistente = contem(elemento);
        if (!valorExistente) {
            conjunto.add(elemento);
            tamanho++;
        }
    }

    public boolean contem(int elemento) {
        return conjunto.contains(elemento);
    }

    public boolean vazio() {
        return tamanho == 0;
    }
}
