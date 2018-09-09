package com.bcopstein.Numerologia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class testFormatador {
	private Formatador formatador;
	
	//EXECUTA ANTES DE TODOS TESTES
	@BeforeEach
	public void setUp() {
		this.formatador = new Formatador();
	}

	// ----------------- INICIO formataPalavra -----------------
	@Test
	void testFormataPalavra() { 
		assertEquals("ABCD96", this.formatador.formataPalavra("Abcd96"));
	}
	@Test
	void testExceptionFormataPalavraNulo() {
		assertThrows(IllegalArgumentException.class, () -> this.formatador.formataPalavra(""));
	}
	@Test
	void testExceptionFormataPalavraComCaracteresEspeciais() {
		assertThrows(IllegalArgumentException.class, () -> this.formatador.formataPalavra("@douglas&Pedro"));
	}
	// ----------------- FIM formataPalavra -----------------
	
	// ----------------- INICIO formataPalavraPlus -----------------
	@Test
	void testFormataPalavraPlus() {
		assertEquals("AB96", this.formatador.formataPalavraPlus("Ab96"));
	}
	@Test
	void testExceptionFormataPalavraPlusNulo() {
		assertThrows(IllegalArgumentException.class, () -> this.formatador.formataPalavraPlus(""));
	}
	@Test
	void testExceptionFormataPalavraPlusComCaracteresEspeciais() {
		assertThrows(IllegalArgumentException.class, () -> this.formatador.formataPalavraPlus("@douglas&Pedro"));
	}
	@Test
	void testExceptionFormataPalavraPlusComNumeroNoInicio() {
		assertThrows(IllegalArgumentException.class, () -> this.formatador.formataPalavraPlus("9douglas"));
	}
	// ----------------- FIM formataPalavraPlus -----------------
	

	// ----------------- INICIO formataFrase -----------------
	@Test
	void testFormataFrase() {
		assertEquals("ABCD 96 54 HSU", this.formatador.formataFrase("abcd 96 54 hsu"));
	}
	@Test
	void testExceptionFormataFraseNulo() {
		assertThrows(IllegalArgumentException.class, () -> this.formatador.formataFrase(""));
	}
	@Test
	void testExceptionFormataFraseComCaracteresEspeciais() {
		assertThrows(IllegalArgumentException.class, () -> this.formatador.formataFrase("douglas@op  ,  ;   pedr0M1lel&1"));
	}
	// ----------------- FIM formataFrase -----------------
}
