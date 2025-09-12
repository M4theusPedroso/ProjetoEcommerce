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

    @GetMapping("/{id}")
    //Path variable -> recebe um valor no link
    public ResponseEntity<?> buscarClientePorId(@PathVariable Integer id) {
        //1. procurar o cliente
        ItemPedido itemPedido = itemPedidoService.buscarPorId(id);
        //2. se eu nao encontrar, retorno erro
        if (itemPedido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item Pedido " + id + "nao encontrado!");
        }

        //3. se encontrar, retorno o cliente
        return ResponseEntity.ok(itemPedido);

        }

        //get, post, put, delete
        @DeleteMapping("/{id}")
        public ResponseEntity<?> deletarItemPedido(@PathVariable Integer id) {
        //1. verificar se o item existe
        ItemPedido itemPedido = itemPedidoService.buscarPorId(id);
        //2. se nao existir, retorno erro
        if (itemPedido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item Pedido " + id + "nao encontrado!");
        }
        //3. se existir retorno ok
            return ResponseEntity.ok(itemPedido);

        }

        //CADASTRAR
        @PutMapping("/{id}")
        public ResponseEntity<?> atualizarItemPedido(@PathVariable Integer id, @RequestBody ItemPedido novoItemPedido) {
            //1. procuro cliente, tento atualizar
            ItemPedido item1 = itemPedidoService.atualizarItemPedido(id, novoItemPedido);
            //2. se nao achar o item, mostro erro
            if (item1 == null) {
                return ResponseEntity.status(404).body("Pedido nao encontrado!");
            }
            //3. se achar retorno ok
            return ResponseEntity.ok(item1);
        }
}
