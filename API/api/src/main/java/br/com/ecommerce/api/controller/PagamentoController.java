package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Pagamento;
import br.com.ecommerce.api.service.PagamentoService;
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
}
