package com.example.Autopecas.Produto.Service;

import com.example.Autopecas.Produto.Controller.Request.ProdutoPostRequest;
import com.example.Autopecas.Produto.Model.ProdutoModel;
import com.example.Autopecas.Produto.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoModel> buscarTodosProdutos(){
        return produtoRepository.findAll();
    }

    public Optional<ProdutoModel> buscarProdutoPorId(Long id) {
        return  produtoRepository.findById(id);
    }

    public ProdutoModel salvarProduto(ProdutoPostRequest produtoPostRequest) {
        ProdutoModel produto = new ProdutoModel();
        produto.setDescricao(produtoPostRequest.getDescricao());
        produto.setValorVenda(produtoPostRequest.getValorVenda());
        produto.setQuantidade(produtoPostRequest.getQuantidade());
        produto.setFornecedor(produtoPostRequest.getFornecedor());

        return produtoRepository.save(produto);
    }

    public ProdutoModel atualizarProduto(){
        return null;
    }

    public void excluirProduto(Long id) {
    }
}
