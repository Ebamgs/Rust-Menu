package com.example.Autopecas.Fornecedor.Repository;

import com.example.Autopecas.Fornecedor.Model.FornecedorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<FornecedorModel, Long> {
}
