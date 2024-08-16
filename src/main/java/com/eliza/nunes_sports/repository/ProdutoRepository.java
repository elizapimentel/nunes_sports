package com.eliza.nunes_sports.repository;

import com.eliza.nunes_sports.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
    Optional<Produto> findByCodigoProduto(String codigoProduto);
}
