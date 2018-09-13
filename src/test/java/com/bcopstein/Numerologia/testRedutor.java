package com.bcopstein.Numerologia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
//kkkeaeman
@RunWith(JUnitParamsRunner.class)
public class testRedutor {
	private Redutor r=new Redutor();
	@ParameterizedTest
	@CsvSource({ "PEDRO,4",
				 "DOUGLAS,7"
				})
	public void redTest01(String input,int expect) {
		assertEquals(r.reducaoPalavra(input),expect);
	}
	@ParameterizedTest
	@CsvSource({ "JAMES BOND,11",
				 "PEDRO XAVIER,11"
				})
	public void redTest02(String input,int expect) {
		assertEquals(r.reducaoFrase(input),expect);
	}
	@ParameterizedTest
	@CsvSource({ "07/22/1975,6",
				 "09/08/1999,9"
				})
	public void redTest03(String input,int expect) {
		assertEquals(r.reducaoData(input),expect);
	}	
}
