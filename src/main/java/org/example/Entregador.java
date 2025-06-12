package org.example;

import java.util.Observable;

public class Entregador extends Observable {

    private String nome;
    private String pedido;
    private String statusEntrega;

    public Entregador(String nome, String pedido) {
        this.nome = nome;
        this.pedido = pedido;
        this.statusEntrega = "Preparando para entrega";
    }

    public void atualizarStatus(String novoStatus) {
        this.statusEntrega = novoStatus;
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Entregador: " + "nome='" + nome + '\'' + ", pedido='" + pedido + '\'' + ", statusEntrega='" + statusEntrega + '\'' + '}';
    }
}
