package com.example.Autopecas.Fornecedor.Service;

import com.example.Autopecas.AplicationConfigTest;
import com.example.Autopecas.Fornecedor.Controller.Request.FornecedorPostRequest;
import com.example.Autopecas.Fornecedor.Controller.Request.FornecedorPutRequest;
import com.example.Autopecas.Fornecedor.Model.FornecedorModel;
import com.example.Autopecas.Fornecedor.Repository.FornecedorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@DisplayName("FornecedorServiceTest")
public class FornecedorServiceTest extends AplicationConfigTest {

    @Mock
    private FornecedorRepository fornecedorRepository;

    @InjectMocks
    private FornecedorService fornecedorService;

    @Test
    void buscarTodosFornecedores_deveRetornarListaVazia_quandoNaoExistemClientes() {

        Mockito.when(fornecedorRepository.findAll()).thenReturn(Collections.emptyList());

        List<FornecedorModel> clientes = fornecedorService.buscarTodosFornecedores();

        assertTrue(clientes.isEmpty());
    }

    @Test
    public void buscarClientePorId_deveRetornarClienteQuandoExistir() {
        // given
        Long id = 1L;
        FornecedorModel fornecedorModel = new FornecedorModel();
        fornecedorModel.setIdFornecedor(id);
        fornecedorModel.setNome("Fornecedor de Teste");
        fornecedorModel.setAreaProduto("Area de teste");
        fornecedorModel.setValorCompra(BigDecimal.valueOf(11));

        Mockito.when(fornecedorRepository.findById(id)).thenReturn(Optional.of(fornecedorModel));

        // when
        FornecedorModel fornecedorEncontrado = fornecedorService.buscarFornecedorPorId(id);

        // then
        Assertions.assertEquals(fornecedorModel.getIdFornecedor(), fornecedorEncontrado.getIdFornecedor());
        Assertions.assertEquals(fornecedorModel.getNome(), fornecedorEncontrado.getNome());
        Assertions.assertEquals(fornecedorModel.getAreaProduto(), fornecedorEncontrado.getAreaProduto());
        Assertions.assertEquals(fornecedorModel.getValorCompra(), fornecedorEncontrado.getValorCompra());

        Mockito.verify(fornecedorRepository, Mockito.times(1)).findById(id);
    }

    @Test
    public void salvarFornecedor_deveSalvarFornecedorNoRepositorio() {
        // given
        FornecedorPostRequest fornecedorRequest = new FornecedorPostRequest("Fornecedor de Teste", BigDecimal.valueOf(11), "Area de teste");
        FornecedorModel fornecedorSalvo = new FornecedorModel(1L, "Fornecedor de Teste", BigDecimal.valueOf(11), "Area de teste");

        Mockito.when(fornecedorRepository.save(Mockito.any(FornecedorModel.class))).thenReturn(fornecedorSalvo);

        // when
        FornecedorModel fornecedorRetornado = fornecedorService.salvarFornecedor(fornecedorRequest);

        // then
        Assertions.assertEquals(fornecedorSalvo, fornecedorRetornado);
        Mockito.verify(fornecedorRepository, Mockito.times(1)).save(Mockito.any(FornecedorModel.class));
    }

    @Test
    public void atualizarFornecedor_deveAtualizarFornecedorExistente() {
        // given
        Long id = 1L;
        FornecedorPutRequest fornecedorPutRequest = new FornecedorPutRequest();
        fornecedorPutRequest.setNome("Novo Nome");
        fornecedorPutRequest.setAreaProduto("nova area");
        fornecedorPutRequest.setValorCompra(BigDecimal.valueOf(11));

        FornecedorModel fornecedorAntigo = new FornecedorModel();
        fornecedorAntigo.setIdFornecedor(id);
        fornecedorAntigo.setNome("Nome Antigo");
        fornecedorAntigo.setAreaProduto("area antiga");
        fornecedorAntigo.setValorCompra(BigDecimal.valueOf(11));

        FornecedorModel fornecedorAtualizado = new FornecedorModel();
        fornecedorAtualizado.setIdFornecedor(id);
        fornecedorAtualizado.setNome(fornecedorPutRequest.getNome());
        fornecedorAtualizado.setAreaProduto(fornecedorPutRequest.getAreaProduto());
        fornecedorAtualizado.setValorCompra(fornecedorPutRequest.getValorCompra());

        when(fornecedorRepository.findById(id)).thenReturn(Optional.of(fornecedorAntigo));
        when(fornecedorRepository.save(Mockito.any(FornecedorModel.class))).thenReturn(fornecedorAtualizado);

        // when
        FornecedorModel fornecedorRetornado = fornecedorService.atualizarFornecedor(id, fornecedorPutRequest);

        // then
        Assertions.assertEquals(fornecedorAtualizado.getIdFornecedor(), fornecedorRetornado.getIdFornecedor());
        Assertions.assertEquals(fornecedorAtualizado.getNome(), fornecedorRetornado.getNome());
        Assertions.assertEquals(fornecedorAtualizado.getValorCompra(), fornecedorRetornado.getValorCompra());
        Assertions.assertEquals(fornecedorAtualizado.getAreaProduto(), fornecedorRetornado.getAreaProduto());

        Mockito.verify(fornecedorRepository, Mockito.times(1)).findById(id);
        Mockito.verify(fornecedorRepository, Mockito.times(1)).save(Mockito.any(FornecedorModel.class));
    }

    @Test
    public void excluirFornecedor_deveExcluirFornecedorExistente() {
        // given
        Long id = 1L;

        // when
        fornecedorService.excluirFornecedor(id);

        // then
        Mockito.verify(fornecedorRepository, Mockito.times(1)).deleteById(id);
    }
}
