package com.example.Autopecas.Produto.Controller.Request;

import com.example.Autopecas.Fornecedor.Model.FornecedorModel;

import java.math.BigDecimal;

public class ProdutoPostRequest {

    private String descricao;

    private BigDecimal valorVenda;

    private int quantidade;

    private FornecedorModel fornecedor;

    public ProdutoPostRequest(String descricao, BigDecimal valorVenda, int quantidade, FornecedorModel fornecedor) {
        this.descricao = descricao;
        this.valorVenda = valorVenda;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
    }

    public ProdutoPostRequest() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public FornecedorModel getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(FornecedorModel fornecedor) {
        this.fornecedor = fornecedor;
    }
}