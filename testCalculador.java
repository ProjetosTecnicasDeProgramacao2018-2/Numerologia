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
		when(redutor.reducaoData("07/22/1975,6")).thenReturn(6);
		when(redutor.reducaoData("09/08/1999,9")).thenReturn(9);
		when(redutor.reducaoFrase("JAMES BOND,11")).thenReturn(11);
		when(redutor.reducaoFrase( "PEDRO XAVIER,11")).thenReturn(11);
		when(redutor.reducaoPalavra("PEDRO,4")).thenReturn(4);
		when(redutor.reducaoPalavra( "DOUGLAS,7")).thenReturn(7);
	}
	@Test
	public void test() {
		assertSame(6,redutor.reducaoData("07/22/1975,6"));
		assertSame(9,redutor.reducaoData("09/08/1999,9"));
		assertSame(11,redutor.reducaoFrase("JAMES BOND,11"));
		assertSame(11,redutor.reducaoFrase( "PEDRO XAVIER,11"));
		assertSame(4,redutor.reducaoPalavra("PEDRO,4"));
		assertSame(7,redutor.reducaoPalavra("DOUGLAS,7"));
	}
}
