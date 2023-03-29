package com.ufcg.psoft.mercadofacil.service;

import com.ufcg.psoft.mercadofacil.model.Produto;
import com.ufcg.psoft.mercadofacil.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@DisplayName("Testes para a alteração do Produto")
public class ProdutoAlterarServiceTest {
    @Autowired
    ProdutoAlterarService driver;
    @MockBean
    ProdutoRepository<Produto, Long> produtoRepository;
    Produto produto;

    @BeforeEach
    void setup() {
        Mockito.when(produtoRepository.find(10L))
                .thenReturn(Produto.builder()
                        .id(10L)
                        .codigoBarra("7899137500104")
                        .nome("Produto Dez")
                        .fabricante("Empresa Dez")
                        .preco(450.00)
                        .build());
        produto = produtoRepository.find(10L);
        Mockito.when(produtoRepository.update(produto))
                .thenReturn(Produto.builder()
                        .id(10L)
                        .codigoBarra("7899137500104")
                        .nome("Nome Produto Alterado")
                        .fabricante("Nome Fabricante Alterado")
                        .preco(500.00)
                        .build());
    }

    @Test
    @DisplayName("Alterar nome do do produto com dados válidos")
    void alterarNomeDoProduto() {
        /* AAA Pattern */
        //Arrange
        produto.setNome("Nome Produto Alterado");
        //Act
        Produto result = driver.alterar(produto);
        //Assert
        assertEquals("Nome Produto Alterado", result.getNome());
    }

    @Test
    @DisplayName("Alterar quando o preço é menor ou igual a zero")
    void precoMenorIgualAZero() {
        produto.setPreco(0.0);
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> driver.alterar(produto));
        assertEquals("Preço inválido!", thrown.getMessage());
    }
}
