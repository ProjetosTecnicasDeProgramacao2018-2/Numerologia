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
	public void create() {
		when(calculador.calculaNumeroDaVida("07/22/1975,6")).thenReturn(6);
		when(calculador.calculaNumeroDaVida("09/08/1999,9")).thenReturn(9);
		when(calculador.calculaNumeroDestino("JAMES BOND,11")).thenReturn(11);
		when(calculador.calculaNumeroDestino( "PEDRO XAVIER,11")).thenReturn(11);
		when(calculador.calculaNumeroDesejosDaAlma("PEDRO,2")).thenReturn(2);
		when(calculador.calculaNumeroDesejosDaAlma( "DOUGLAS,1")).thenReturn(1);
	}
	@Test
	public void test() {
		assertSame(6,calculador.calculaNumeroDaVida("07/22/1975,6"));
		assertSame(9,calculador.calculaNumeroDaVida("09/08/1999,9"));
		assertSame(11,calculador.calculaNumeroDestino("JAMES BOND,11"));
		assertSame(11,calculador.calculaNumeroDestino( "PEDRO XAVIER,11"));
		assertSame(2,calculador.calculaNumeroDesejosDaAlma("PEDRO,2"));
		assertSame(1,calculador.calculaNumeroDesejosDaAlma( "DOUGLAS,1"));
	}
}
