package com.example.Autopecas.Produto.Controller;

import com.example.Autopecas.Produto.Model.ProdutoModel;
import com.example.Autopecas.Produto.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoModel> buscarTodosClientes() {
        return produtoService.buscarTodosProdutos();
    }

    @GetMapping("/{id}")
    public Optional<ProdutoModel> buscarProdutoPorId(@PathVariable Long id) {
        return produtoService.buscarProdutoPorId(id);
    }

    @PostMapping
    public ProdutoModel salvarProduto(@RequestBody ProdutoModel produto) {
        return produtoService.salvarProduto(produto.toProdutoPostRequest());
    }

    @DeleteMapping("/{id}")
    public void excluirProduto(@PathVariable Long id) {
        produtoService.excluirProduto(id);
    }

}
