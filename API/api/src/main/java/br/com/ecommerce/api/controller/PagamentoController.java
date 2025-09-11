package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.service.PagamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController {
    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamento) {
        pagamentoService = pagamento;
    }
    @GetMapping
    public ResponseEntity<List<Pagamento>> listarPagamento() {
        List<Pagamento> pagamentos = pagamentoService.listarTodos();
        return ResponseEntity.ok().body(pagamentos);
    }

    @PostMapping
    public ResponseEntity<Pagamento> cadastrarPagamento(@RequestBody Pagamento pag) {
        pagamentoService.cadastrarPagamento(pag);
        return ResponseEntity.ok().body(pag);
    }

    //buscar pagamento por id
    @GetMapping("/{id}")
    //Path variable -> recebe um valor no link
    public ResponseEntity<?> buscarPagamento(@PathVariable Integer id) {
      //1. procurar pagamento
      Pagamento pagamento = pagamentoService.buscarPorId(id);
      //2. se eu nao encontrar, retorno erro
        if (pagamento == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente " + id + "nao encontrado!");
        }
        //3. se encontrar, retorno pagamento
        return ResponseEntity.ok(pagamento);
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPagamento(@PathVariable Integer id) {
        //1. verificar se o pagamento existe
        Pagamento pagamento = pagamentoService.buscarPorId(id);
        //2. se nao existir, retorno erro
        if (pagamento == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente " + id + "naoencontrado!");
        }
        //3. senao existir retorno ok
        return ResponseEntity.ok(pagamento);
    }
}
