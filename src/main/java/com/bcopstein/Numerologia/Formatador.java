package com.bcopstein.Numerologia;

import java.util.regex.Pattern;

public class Formatador{
    // Formata uma palavra da lingua inglesa
    // A palavra recebida so pode conter letras ou digitos
    // Se a palavra contiver qualquer outro tipo de simbolo deve retornar IllegalArgumentException
    // Se a palavra estiver vazia tambem retorna a excecao
    // Retorna a palavra em maiusculas 
    public String formataPalavra(String palavra){
    	if(palavra.length() == 0) {
    		throw new IllegalArgumentException();
    	}
    	
    	if(palavra.matches("[a-zA-Z0-9]*")) {
        	return palavra.toUpperCase();	
    	}
		throw new IllegalArgumentException();
    }

    // Utiliza o metodo formataPalavra e confere se a primeira letra nao e numerica
    public String formataPalavraPlus(String palavra) {
    	palavra = this.formataPalavra(palavra);
    	String primeiro = palavra.charAt(0)+"";
    	if(primeiro.matches("[0-9]")) {
    		throw new IllegalArgumentException();
    	}
        return palavra;
    }

    // Formata frases compostas por palavras separadas por espacos em branco e/ou simbolos de pontuacao
    // Frases vazias geram IllegalArgumentException
    // As palavras da frase devem ser convertidas pelo metodo formataPalavra
    // Qualquer outro simbolo gera IllegalArgumentException
    // Retorna um array de palavras validas 
    // PROFESSOR DISSE PARA RETORNAR COM ESPAÇO COMO SEPARADOR
    public String formataFrase(String frase){
    	if(frase.length() == 0) {
    		throw new IllegalArgumentException();
    	}
    	
    	String[] listaPalavras = frase.split("[ ,.;]");
    	String fraseRetornada = "";
    	for(int i = 0; i < listaPalavras.length; i++) {
    		String palavra = listaPalavras[i];
			fraseRetornada += this.formataPalavra(palavra);
			if(i < listaPalavras.length-1) {
				fraseRetornada += " ";	
			}
    	}
    	
    	return fraseRetornada;
    }
    
    public static void main(String[] args) {
    	Formatador f = new Formatador();
    	System.out.println(f.formataPalavraPlus("Aha0s"));
    }
}
