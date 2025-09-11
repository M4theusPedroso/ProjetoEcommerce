package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Pedido;
import br.com.ecommerce.api.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedido) {
        pedidoService = pedido;
    }
    @GetMapping
    public ResponseEntity<List<Pedido>> ListarPedidos() {
        List<Pedido> pedidos = pedidoService.listarTodos();
        return ResponseEntity.ok().body(pedidos);
    }

    @PostMapping
    public ResponseEntity<Pedido> cadastrarPedido(@RequestBody Pedido pedido) {
        pedidoService.cadastrarPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

    //buscar pedido por id
    @GetMapping("/{id}")
    //path variable - recebe um valor no link
    public ResponseEntity<?> buscarPedidoPorId(@PathVariable Integer id) {
        //1. procurar pedido
        Pedido pedido = pedidoService.buscarPorId(id);
        //2. se nao encontrar, retorno erro
        if (pedido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido " + id + "naoencontrado!");
        }
        //3. se encontrar, retorno o cliente
        return ResponseEntity.ok(pedido);
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPedidoPorId(@PathVariable Integer id) {
        //1. verificar se o pedido existe
        Pedido pedido = pedidoService.buscarPorId(id);
        //2. se nao existir retorno erro
        if (pedido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido " + id + "naoencontrado!");
        }
        //3. se existir retorno ok
        return ResponseEntity.ok(pedido);

    }

}
