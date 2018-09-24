package com.bcopstein.Numerologia;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

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
		this.create();
	}
	public void create() {
		when(calculador.calculaNumeroDaVida("07/22/1975,6")).thenReturn(6);
		when(calculador.calculaNumeroDaVida("09/08/1999,9")).thenReturn(9);
		when(calculador.calculaNumeroDestino("JAMES BOND,11")).thenReturn(11);
		when(calculador.calculaNumeroDestino( "PEDRO XAVIER,11")).thenReturn(11);
		when(calculador.calculaNumeroDesejosDaAlma("PEDRO,2")).thenReturn(2);
		when(calculador.calculaNumeroDesejosDaAlma( "DOUGLAS,1")).thenReturn(1);
	}
	
	@ParameterizedTest
	@CsvSource({ "'07/22/1975,6',6","'09/08/1999,9',9"})
	public void testCalculoDaVida(String entrada, int saidaEsperada) {
		assertSame(saidaEsperada, this.calculador.calculaNumeroDaVida(entrada));
	}

	@ParameterizedTest
	@CsvSource({ "'JAMES BOND,11',11", "'PEDRO XAVIER',11"})
	public void testCalculoDoDestino(String entrada, int saidaEsperada) {
		assertSame(saidaEsperada, this.calculador.calculaNumeroDestino(entrada));
	}

	@ParameterizedTest
	@CsvSource({ "'PEDRO,2',2","'DOUGLAS,1',1"})
	public void testNumeroDesejosDaAlma(String entrada, int saidaEsperada) {
		assertSame(saidaEsperada, this.calculador.calculaNumeroDesejosDaAlma(entrada));
	}
}
