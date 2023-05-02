package com.example.Autopecas.Controller;


import com.example.Autopecas.ClienteConversao.ClienteModelToPutRequestConverter;
import com.example.Autopecas.Controller.Request.ClientePutRequest;
import com.example.Autopecas.Model.ClienteModel;
import com.example.Autopecas.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ClienteModelToPutRequestConverter clienteModelToPutRequestConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteModel adicionarCliente(@RequestBody ClienteModel cliente) {
        return clienteService.salvarCliente(cliente.toClientePostRequest());
    }

    @GetMapping("/{id}")
    public ClienteModel buscarClientePorId(@PathVariable Long id) {
        return clienteService.buscarClientePorId(id);
    }

    @GetMapping
    public List<ClienteModel> buscarTodosClientes() {
        return clienteService.buscarTodosClientes();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarCliente(@PathVariable Long id, @RequestBody ClienteModel clienteModel) {
        ClientePutRequest clientePutRequest = clienteModelToPutRequestConverter.convert(clienteModel);
        clienteService.atualizarCliente(id, clientePutRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirCliente(@PathVariable Long id) {
        clienteService.excluirCliente(id);
    }
}
