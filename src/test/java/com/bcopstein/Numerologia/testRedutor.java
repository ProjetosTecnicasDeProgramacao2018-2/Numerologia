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
	public void redTest(String input,int expect) {
		assertEquals(r.reducaoPalavra(input),expect);
	}
	
	
}
