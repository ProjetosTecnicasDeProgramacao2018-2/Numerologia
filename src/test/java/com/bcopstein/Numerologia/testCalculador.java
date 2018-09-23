package com.bcopstein.Numerologia;

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


public class testCalculador {
	private Redutor redutor;
	private Formatador formatador;
	private Calculador calculador;
	
	@BeforeEach
	public void inicializa() {
		this.redutor = mock(Redutor.class);
		this.formatador = mock(Formatador.class);
		this.calculador = new Calculador(redutor, formatador);
	}
	
	@ParameterizedTest
	@CsvSource({ "'09/02/1998',38"})
	public void testCalculoDaVida(String entrada, String saidaEsperada) {
		assertEquals(saidaEsperada, this.calculador.calculaNumeroDaVida(entrada));
	}

	@ParameterizedTest
	@CsvSource({ "PEDRO,4",
				 "DOUGLAS,7"
				})
	public void testCalculoDoDestino(String entrada, String saidaEsperada) {
		assertEquals(saidaEsperada, this.calculador.calculaNumeroDestino(entrada));
	}

	@ParameterizedTest
	@CsvSource({ "PEDRO,4",
				 "DOUGLAS,7"
				})
	public void testNumeroDesejosDaAlma(String entrada, String saidaEsperada) {
		assertEquals(saidaEsperada, this.calculador.calculaNumeroDesejosDaAlma(entrada));
	}
}
