package com.eliza.nunes_sports.service;

import com.eliza.nunes_sports.dto.ProdutoDTO;
import com.eliza.nunes_sports.model.Produto;
import com.eliza.nunes_sports.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    private final ProdutoRepository repo;
    private final CodigoProdutoService code;

    public ProdutoServiceImpl(ProdutoRepository repo, CodigoProdutoService code) {
        this.repo = repo;
        this.code = code;
    }

    @Override
    public ProdutoDTO criar(ProdutoDTO produtoDTO) {
        Produto produto = produtoDTO.convertToEntity();
        produto.setCodigoProduto(code.gerarCodigoProduto());
        return repo.save(produto).convertToDTO();
    }

    @Override
    public List<ProdutoDTO> buscarTodos() {
        List<Produto> produtos = repo.findAll();
        return produtos.stream()
                .map(Produto::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProdutoDTO buscarPorCodigo(String codProduto) {
        Optional<Produto> produto = repo.findByCodigoProduto(codProduto);
        return produto
                .map(Produto::convertToDTO)
                .orElse(null);
    }

    @Override
    public ProdutoDTO atualizar(String codProduto, ProdutoDTO produtoDTO) {
        Optional<Produto> produto = repo.findByCodigoProduto(codProduto);
        if (produto.isPresent()) {
            Produto produtoAtualizado = produtoDTO.convertToEntity();
            produtoAtualizado.setCodigoProduto(produto.get().getCodigoProduto());
            return repo.save(produtoAtualizado).convertToDTO();
        }
        return null;
    }

    @Override
    public void deletar(String codProduto) {
        Optional<Produto> produto = repo.findByCodigoProduto(codProduto);
        produto.ifPresent(repo::delete);
    }
}
