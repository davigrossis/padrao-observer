package org.example;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void acompanhar(Entregador entregador) {
        entregador.addObserver(this);
    }

    @Override
    public void update(Observable entregador, Object arg1) {
        this.ultimaNotificacao = this.nome + ", o status da entrega foi atualizado por " + entregador.toString();
    }
}
