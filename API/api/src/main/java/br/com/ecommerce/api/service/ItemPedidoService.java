package br.com.ecommerce.api.service;

import br.com.ecommerce.api.model.ItemPedido;
import br.com.ecommerce.api.repository.ItemPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {
    private final ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoService(ItemPedidoRepository item) {
        itemPedidoRepository = item;
    }

    public List<ItemPedido> listarTodos() {
        return itemPedidoRepository.findAll();
    }

    public ItemPedido cadastrarItemPedido(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    //1. buscar por id
    public ItemPedido buscarPorId(Integer id) {
        return itemPedidoRepository.findById(id).orElse(null);
    }
    //2. deletar cliente
    public ItemPedido deletarCliente(Integer id) {
        //1. verificar se o cliente existe
        ItemPedido itemPedido = buscarPorId(id);
        //2. se nao existir, retorno nulo
        if (itemPedido == null) {
            return null;
        }
        //3. se existir, excluo
        itemPedidoRepository.delete(itemPedido);
        return itemPedido;
    }
}

