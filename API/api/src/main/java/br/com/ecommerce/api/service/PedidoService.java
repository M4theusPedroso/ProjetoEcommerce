package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository ped) {
        pedidoRepository = ped;
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido cadastrarPedido(Pedido p) {
        return pedidoRepository.save(p);
    }

    //buscar pedido por id
    public Pedido buscarPorId(Integer id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    //deletar pedido
    public Pedido deletarPedido(Integer id) {
        //verificar se o pedido existe
        Pedido pedido = buscarPorId(id);
        //se nao existir retorno
        if (pedido == null) {
            return null;
        }
        //se existir, excluo
        pedidoRepository.delete(pedido);
        return pedido;

    }
}
