package com.eliza.nunes_sports.service;

import com.eliza.nunes_sports.dto.ProdutoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProdutoService {
    ProdutoDTO criar(ProdutoDTO produtoDTO);
    List<ProdutoDTO> buscarTodos();
    ProdutoDTO buscarPorCodigo(String codProduto);
    ProdutoDTO atualizar(String codProduto, ProdutoDTO produtoDTO);
    void deletar(String id);
}
