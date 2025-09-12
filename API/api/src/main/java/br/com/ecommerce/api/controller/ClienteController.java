package br.com.ecommerce.api.controller;

import br.com.ecommerce.api.model.Cliente;
import br.com.ecommerce.api.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@Tag(name = "Controller de Cliente", description = "Metodos de Clientes")
public class ClienteController {
    // Controller -> Service
    private final ClienteService clienteService;

    public ClienteController(ClienteService service) {
        clienteService = service;
    }

    // listar todos
    @GetMapping
    @Operation(
            summary = "Lista todos os clientes",
            description = "Lista todos os clientes sem nenhuma restricao"
    )
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

    //buscar cliente por id
    @GetMapping("/{id}")
    //Path Variable -> recebe um valor no link
    public ResponseEntity<?> buscarClientePorId(@PathVariable Integer id) {
        //1. procurar o cliente
        Cliente cliente = clienteService.buscarPorId(id);
        //2. se eu nao encontrar, retorno erro
        if (cliente == null) {
            //mais simples:
            //return ResponseEntity.notFound().build();
            //mais detalhes:
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente " + id + "nao encontrado!");
        }

        //3. se encontrar, retorno o cliente
        return ResponseEntity.ok(cliente);
    }

    // get, post, put, delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable Integer id) {
        //1. verificar se o cliente existe
        Cliente cliente = clienteService.deletarCliente(id);
        //2. se nao existir  retorno erro
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente " + id + "naoencontrado!");
        }
        //3. se existir retorno ok
        return ResponseEntity.ok(cliente);
    }

    //CADASTRAR
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCliente(@PathVariable Integer id, @RequestBody Cliente clienteNovo) {
        //1. procuro o cliente, tento atualizar o cliente
        Cliente cl = clienteService.atualizarCliente(id, clienteNovo);
        //2. se nao achar o cliente, mostro erro
        if (cl == null) {
            return ResponseEntity.status(404).body("Cliente nao encontrado!");
        }
        //3. se achar retorno ok
        return ResponseEntity.ok(cl);
    }
}
