package com.eliza.nunes_sports.dto;

import com.eliza.nunes_sports.model.Produto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProdutoDTO {
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private String codigoProduto;

    public Produto convertToEntity() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Produto.class);
    }
}
