package com.example.Autopecas.Fornecedor.Controller.Request;

import javax.persistence.Column;
import java.math.BigDecimal;

public class FornecedorPutRequest {

    private Long idFornecedor;

    private String nome;

    private BigDecimal valorCompra;

    private String areaProduto;

    public Long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
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
