package com.example.Autopecas.Fornecedor.Model;

import com.example.Autopecas.Fornecedor.Controller.Request.FornecedorPostRequest;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "fornecedor")
public class FornecedorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFornecedor;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private BigDecimal valorCompra;

    @Column(nullable = false)
    private String areaProduto;

    public FornecedorModel() {
    }

    public FornecedorModel(Long idFornecedor, String nome, BigDecimal valorCompra, String areaProduto) {
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this.valorCompra = valorCompra;
        this.areaProduto = areaProduto;
    }

    public FornecedorPostRequest toFornecedorPostRequest(){
        FornecedorPostRequest request = new FornecedorPostRequest();
        request.setNome(this.nome);
        request.setValorCompra(this.valorCompra);
        request.setAreaProduto(this.areaProduto);
        return request;
    }

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
