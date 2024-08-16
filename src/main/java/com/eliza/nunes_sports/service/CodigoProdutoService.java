package com.eliza.nunes_sports.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CodigoProdutoService {
    public String gerarCodigoProduto() {
        return "PROD-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
