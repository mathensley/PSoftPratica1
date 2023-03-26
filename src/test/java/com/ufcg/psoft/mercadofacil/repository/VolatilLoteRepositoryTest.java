package com.ufcg.psoft.mercadofacil.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ufcg.psoft.mercadofacil.model.Lote;
import com.ufcg.psoft.mercadofacil.model.Produto;

class VolatilLoteRepositoryTest {
	
	@Autowired
	VolatilLoteRepository driver = new VolatilLoteRepository();
	
	Lote lote;
	Lote result;
	Produto prod;
	
	@BeforeEach
	void setup() {
		prod = Produto.builder()
				.id(1L)
				.nome("Produto Base")
				.codigoBarra("123456789")
				.fabricante("Fabricando Base")
				.preco(125.36)
				.build();
		lote = Lote.builder()
				.id(1L)
				.numeroDeItens(100)
				.produto(prod)
				.build();
	}
	
	@AfterEach
	void tearDown() {
		prod = null;
		driver.deleteAll();
	}
	
	@Test
	@DisplayName("Adicionar o primeiro Lote no repositorio de dados")
	void salvarPrimeiroLote() {
		result = driver.save(lote);
		
		assertEquals(driver.findAll().size(), 1);
		assertEquals(result.getId().longValue(), lote.getId().longValue());
		assertEquals(result.getProduto(), lote.getProduto());
	}
	
	@Test
	@DisplayName("Adicionar segundo Lote, ou posterior, no repositorio de dados")
	void salvarSegundoLoteOuPosterior() {
		Produto produtoExtra = Produto.builder()
				.id(2L)
				.nome("Produto Extra")
				.codigoBarra("987654321")
				.fabricante("Fabricante Extra")
				.preco(125.36)
				.build();
		Lote loteExtra = Lote.builder()
				.id(2L)
				.numeroDeItens(100)
				.produto(produtoExtra)
				.build();
		
		driver.save(lote);
		result = driver.save(loteExtra);
		// Só está sendo retornado o primeiro elemento salvo na lista
		assertEquals(driver.findAll().size(), 2);
		assertEquals(result.getId().longValue(), loteExtra.getId().longValue());
		assertEquals(result.getProduto(), produtoExtra);
	}
	
	@Test
	@DisplayName("Buscar um lote pelo ID no repositorio de dados")
	void findLote() {
		driver.save(lote);
		// Erro na conversão de ID para index da lista
		assertEquals(lote, driver.find(lote.getId()));
	}
	
	@Test
	@DisplayName("Buscar todos os lotes armazenados no repositorio de dados")
	void findAllLotes() {
		Produto produtoExtra = Produto.builder()
				.id(2L)
				.nome("Produto Extra")
				.codigoBarra("987654321")
				.fabricante("Fabricante Extra")
				.preco(125.36)
				.build();
		Lote loteExtra = Lote.builder()
				.id(2L)
				.numeroDeItens(100)
				.produto(produtoExtra)
				.build();
		
		driver.save(lote);
		driver.save(loteExtra);
		
		ArrayList<Lote> lotesTeste = new ArrayList<>();
		lotesTeste.add(lote);
		lotesTeste.add(loteExtra);
				
		assertEquals(lotesTeste, driver.findAll());
	}
	
	@Test
	@DisplayName("Update de lote no repositorio de dados com apenas um lote")
	void updateLote() {
		driver.save(lote);
		
		lote.setNumeroDeItens(150);
		
		assertEquals(lote, driver.update(lote));
	}
	
	@Test
	@DisplayName("Update de lote no repositorio de dados com multiplos lotes")
	void updateMultiplosLotes() {
		Produto produtoExtra = Produto.builder()
				.id(2L)
				.nome("Produto Extra")
				.codigoBarra("987654321")
				.fabricante("Fabricante Extra")
				.preco(125.36)
				.build();
		Lote loteExtra = Lote.builder()
				.id(2L)
				.numeroDeItens(100)
				.produto(produtoExtra)
				.build();
		
		driver.save(lote);
		driver.save(loteExtra);
		
		lote.setNumeroDeItens(150);
		// Update está deletando todos os outros lotes da lista
		assertEquals(lote, driver.update(lote));
		assertEquals(2, driver.findAll().size());
	}
	
	@Test
	@DisplayName("Deletar um lote do repositorio de dados")
	void deleteLote() {
		driver.save(lote);
		
		driver.delete(lote);
		
		assertEquals(0, driver.findAll().size());
	}
	
	@Test
	@DisplayName("Deletar um lote do repositorio de dados com multiplos lotes")
	void deleteLoteMultiplosLotes() {
		Produto produtoExtra = Produto.builder()
				.id(2L)
				.nome("Produto Extra")
				.codigoBarra("987654321")
				.fabricante("Fabricante Extra")
				.preco(125.36)
				.build();
		Lote loteExtra = Lote.builder()
				.id(2L)
				.numeroDeItens(100)
				.produto(produtoExtra)
				.build();
		
		driver.save(lote);
		driver.save(loteExtra);
		
		driver.delete(loteExtra);
		// Delete está deletando todos os lotes da lista
		assertEquals(1, driver.findAll().size());
	}
	
	@Test
	@DisplayName("Deletar todos os lotes do repositorio de dados")
	void deleteAllLotes() {
		Produto produtoExtra = Produto.builder()
				.id(2L)
				.nome("Produto Extra")
				.codigoBarra("987654321")
				.fabricante("Fabricante Extra")
				.preco(125.36)
				.build();
		Lote loteExtra = Lote.builder()
				.id(2L)
				.numeroDeItens(100)
				.produto(produtoExtra)
				.build();
		
		driver.save(lote);
		driver.save(loteExtra);
		
		driver.deleteAll();
		
		assertEquals(0, driver.findAll().size());
	}
	
}
