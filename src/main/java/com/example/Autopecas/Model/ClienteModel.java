package com.example.Autopecas.Model;

import com.example.Autopecas.Controller.Request.ClientePostRequest;

import javax.persistence.*;

@Entity(name = "cliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String email;

    public ClientePostRequest toClientePostRequest() {
        ClientePostRequest request = new ClientePostRequest();
        request.setNome(this.nome);
        request.setTelefone(this.telefone);
        request.setEmail(this.email);
        return request;
    }

    public ClienteModel toClienteModel(Long id) {
        ClienteModel cliente = new ClienteModel();
        cliente.setId_cliente(id);
        cliente.setNome(this.nome);
        cliente.setTelefone(this.telefone);
        cliente.setEmail(this.email);
        return cliente;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


