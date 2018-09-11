package com.bcopstein.Numerologia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class testFormatador {
	private static Formatador formatador;

	// EXECUTA ANTES DE TODOS TESTES
	@BeforeEach
	public void setUp() {
		formatador = new Formatador();
	}

	// ----------------- INICIO formataPalavra -----------------

	@ParameterizedTest
	@CsvSource({"Abcd96,ABCD96"})
	void testFormataPalavra(String palavraInput, String palavraOutput) {
		assertEquals(palavraOutput, formatador.formataPalavra(palavraInput));
	}

	@ParameterizedTest
	@CsvSource({"''","@douglas&Pedro"})
	public void testExceptionFormataPalavra(String palavra) {
		assertThrows(IllegalArgumentException.class, () -> formatador.formataPalavra(palavra));
	}

	// ----------------- FIM formataPalavra -----------------

	// ----------------- INICIO formataPalavraPlus -----------------
	@ParameterizedTest
	@CsvSource({"Ab96,AB96"})
	void testFormataPalavraPlus(String palavraInput, String palavraOutput) {
		assertEquals(palavraOutput, formatador.formataPalavraPlus(palavraInput));
	}

	@ParameterizedTest
	@CsvSource({"''","@douglas&Pedro","9douglas"})
	void testExceptionFormataPalavraPlus(String palavraInput) {
		assertThrows(IllegalArgumentException.class, () -> formatador.formataPalavraPlus(palavraInput));
	}
	// ----------------- FIM formataPalavraPlus -----------------

	// ----------------- INICIO formataFrase -----------------
	@ParameterizedTest
	@CsvSource({"'abcd 15 10 hsu9', 'ABCD 15 10 HSU9'"})
	void testFormataFrase(String fraseInput, String fraseOutput) {
		System.out.println(formatador.formataFrase(fraseInput));
		assertEquals(fraseOutput, formatador.formataFrase(fraseInput));
	}

	@ParameterizedTest
	@CsvSource({"''","'douglas@op  ,  ;   pedr0M1lel&1'"})
	void testExceptionFormataFrase(String fraseInput) {
		assertThrows(IllegalArgumentException.class, () -> formatador.formataFrase(fraseInput));
	}
	// ----------------- FIM formataFrase -----------------
}
