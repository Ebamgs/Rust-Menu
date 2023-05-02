package com.example.Autopecas.ClienteConversao;

import com.example.Autopecas.Controller.Request.ClientePutRequest;
import com.example.Autopecas.Model.ClienteModel;
import org.springframework.stereotype.Component;

@Component
public class ClienteModelToPutRequestConverter {

    public ClientePutRequest convert(ClienteModel clienteModel) {
        ClientePutRequest clientePutRequest = new ClientePutRequest();
        clientePutRequest.setNome(clienteModel.getNome());
        clientePutRequest.setTelefone(clienteModel.getTelefone());
        clientePutRequest.setEmail(clienteModel.getEmail());
        return clientePutRequest;
    }
}
