package com.eliza.nunes_sports.controller;

import com.eliza.nunes_sports.dto.ProdutoDTO;
import com.eliza.nunes_sports.service.ProdutoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    private final ProdutoServiceImpl service;

    public ProdutoController(ProdutoServiceImpl service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<ProdutoDTO> criar(@RequestBody ProdutoDTO produtoDTO) {
        return ResponseEntity.status(201).body(service.criar(produtoDTO));
    }

    @GetMapping()
    public ResponseEntity<List<ProdutoDTO>> buscarTodos() {
        return ResponseEntity.status(200).body(service.buscarTodos());
    }

    @GetMapping("/{cod_produto}")
    public ResponseEntity<ProdutoDTO> buscarPorCodigo(@PathVariable String cod_produto) {
        return ResponseEntity.status(200).body(service.buscarPorCodigo(cod_produto));
    }

    @PutMapping("/{cod_produto}")
    public ResponseEntity<ProdutoDTO> atualizar(@PathVariable String cod_produto, @RequestBody ProdutoDTO produtoDTO) {
        return ResponseEntity.status(200).body(service.atualizar(cod_produto, produtoDTO));
    }

    @DeleteMapping("/{cod_produto}")
    public ResponseEntity<Void> deletar(String codProduto) {
        service.deletar(codProduto);
        return ResponseEntity.status(204).build();
    }

}
