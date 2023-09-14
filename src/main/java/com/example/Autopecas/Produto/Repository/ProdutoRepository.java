package com.example.Autopecas.Produto.Repository;

import com.example.Autopecas.Produto.Model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long > {
}
