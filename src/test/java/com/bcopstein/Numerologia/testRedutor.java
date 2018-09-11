package com.bcopstein.Numerologia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class testRedutor {
	private Redutor r=new Redutor();
	@ParameterizedTest
	@CsvSource({ "PEDRO,4",
				 "DOUGLAS,7"
				})
	public void redTest(String input,int expect) {
		assertEquals(r.reducaoPalavra(input),expect);
	}
	/*
	@Test
	public void testRedutor01() {
		Redutor r=new Redutor();
		int resp=r.reducaoPalavra("PEDRO");
		assertEquals(4,resp);
	}
	@Test
	public void testRedutor02() {
		Redutor r=new Redutor();
		int resp=r.reducaoPalavra("DOUGLAS");
		assertEquals(7,resp);
	}
	@Test
	public void testRedutor03() {
		Redutor r=new Redutor();
		int resp=r.reducaoFrase("TRABALHO DE PROG");
		assertEquals(7,resp);
	}
	@Test
	public void testRedutor04() {
		Redutor r=new Redutor();
		int resp=r.reducaoData("09/08/1999");
		assertEquals(9,resp);
	}
	*/
}
