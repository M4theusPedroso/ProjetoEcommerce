package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.ItemPedido;
import br.com.ecommerce.api.service.ItemPedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itempedido")
public class ItemPedidoController {
    private final ItemPedidoService itemPedidoService;

    public ItemPedidoController(ItemPedidoService service) {
        itemPedidoService = service;
    }

    @GetMapping
    public ResponseEntity<List<ItemPedido>> ListarItemPedido() {
        List<ItemPedido> itemPedidos = itemPedidoService.listarTodos();
        return ResponseEntity.ok().body(itemPedidos);
    }

    @PostMapping
    public ResponseEntity<ItemPedido> cadastrarItemPedido(@RequestBody ItemPedido itemPedido) {
        itemPedidoService.cadastrarItemPedido(itemPedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(itemPedido);
    }
}
