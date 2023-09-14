package com.example.Autopecas.Fornecedor.Controller;

import com.example.Autopecas.FunctionsConversao.ToPutRequestConverter;
import com.example.Autopecas.Fornecedor.Controller.Request.FornecedorPutRequest;
import com.example.Autopecas.Fornecedor.Model.FornecedorModel;
import com.example.Autopecas.Fornecedor.Service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @Autowired
    private ToPutRequestConverter fornecedorModelToPutRequestConverter;

    @GetMapping
    public List<FornecedorModel> buscarTodosFornecedores() {
        return fornecedorService.buscarTodosFornecedores();
    }

    @GetMapping("/{id}")
    public FornecedorModel buscarFornecedorPorId(@PathVariable Long id) {
        return fornecedorService.buscarFornecedorPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FornecedorModel adicionarFornecedor(@RequestBody FornecedorModel fornecedor) {
        return fornecedorService.salvarFornecedor(fornecedor.toFornecedorPostRequest());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarCliente(@PathVariable Long id, @RequestBody FornecedorModel fornecedorModel) {
        FornecedorPutRequest fornecedorPutRequest = fornecedorModelToPutRequestConverter.convert(fornecedorModel);
        fornecedorService.atualizarFornecedor(id, fornecedorPutRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  excluirFornecedor(@PathVariable Long id){
        fornecedorService.excluirFornecedor(id);
    }


}
