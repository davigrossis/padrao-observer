package observer;
import org.example.Cliente;
import org.example.Entregador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ClienteTest {

    @Test
    void deveNotificarUmCliente() {
        Entregador entregador = new Entregador("Davi", "Pedido #123");
        Cliente cliente = new Cliente("Cliente 1");
        cliente.acompanhar(entregador);
        entregador.atualizarStatus("Saiu para entrega");
        assertEquals("Cliente 1, o status da entrega foi atualizado por Entregador: nome='Davi', pedido='Pedido #123', statusEntrega='Saiu para entrega'}", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes() {
        Entregador entregador = new Entregador("Davi", "Pedido #123");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.acompanhar(entregador);
        cliente2.acompanhar(entregador);
        entregador.atualizarStatus("Saiu para entrega");
        assertEquals("Cliente 1, o status da entrega foi atualizado por Entregador: nome='Davi', pedido='Pedido #123', statusEntrega='Saiu para entrega'}", cliente1.getUltimaNotificacao());
        assertEquals("Cliente 2, o status da entrega foi atualizado por Entregador: nome='Davi', pedido='Pedido #123', statusEntrega='Saiu para entrega'}", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCliente() {
        Entregador entregador = new Entregador("Davi", "Pedido #123");
        Cliente cliente = new Cliente("Cliente 1");
        entregador.atualizarStatus("Saiu para entrega");
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClienteCerto() {
        Entregador entregador1 = new Entregador("Davi", "Pedido #123");
        Entregador entregador2 = new Entregador("Wamberg", "Pedido #456");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.acompanhar(entregador1);
        cliente2.acompanhar(entregador2);
        entregador1.atualizarStatus("Saiu para entrega");
        assertEquals("Cliente 1, o status da entrega foi atualizado por Entregador: nome='Davi', pedido='Pedido #123', statusEntrega='Saiu para entrega'}", cliente1.getUltimaNotificacao());
        assertNull(cliente2.getUltimaNotificacao());
    }
}
