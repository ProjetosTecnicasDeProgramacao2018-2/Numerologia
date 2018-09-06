package com.bcopstein.Numerologia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testRedutor {

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

}
