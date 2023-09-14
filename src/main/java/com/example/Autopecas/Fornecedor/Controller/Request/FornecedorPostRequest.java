package com.example.Autopecas.Fornecedor.Controller.Request;

import java.math.BigDecimal;

public class FornecedorPostRequest {

    private String nome;

    private BigDecimal valorCompra;

    private String areaProduto;

    public FornecedorPostRequest(){}

    public FornecedorPostRequest(String nome, BigDecimal valorCompra, String areaProduto) {
        this.nome = nome;
        this.valorCompra = valorCompra;
        this.areaProduto = areaProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getAreaProduto() {
        return areaProduto;
    }

    public void setAreaProduto(String areaProduto) {
        this.areaProduto = areaProduto;
    }
}
