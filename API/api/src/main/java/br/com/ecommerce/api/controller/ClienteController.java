package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    // Controller -> Service
    private final ClienteService clienteService;

    public ClienteController(ClienteService service) {
        clienteService = service;
    }

    // listar todos
    @GetMapping
    public ResponseEntity<List<Cliente>> ListarClientes() {
        //1 - pegar a lista de clientes
        List<Cliente> clientes = clienteService.listarTodos();
        return ResponseEntity.ok().body(clientes);
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
        //1. tentar cadastrar o cliente
        clienteService.cadastrarCliente(cliente);

        // codigo 200 - OK
        //return ResponseEntity.ok(cliente);
        // codigo 201 - CREATED
        //return ResponseEntity.created(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }
}
