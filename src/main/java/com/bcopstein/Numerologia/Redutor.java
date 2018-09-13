package com.bcopstein.Numerologia;

import java.util.regex.Pattern;

// Todas as palavras so podem conter letras maiusculas nao acentudas e digitos
// Todas as frases devem ser formadas por palavras separadas por um espaco em branco cada
// As datas devem seguir o formato dd/mm/aaaa
// Qualquer quebra destas regras deve retornar "IllegalArgumentExpression"
//
// Veja os tipos de tabelas na wiki do projeto
public class Redutor{
    private TipoTabela tipoTab;

    public Redutor(){
        tipoTab = TipoTabela.PITAGORICA;
    }

    // Decodifica um caracter segundo a tabela Pitagorica
    private int tabPitagorica(char c){ //OK
        switch(c){
            case 'A':
            case 'J':
            case 'S':
                return(1);
            case 'B':
            case 'K':
            case 'T':
                return(2);
            case 'C':
            case 'L':
            case 'U':
                return(3);
            case 'D':
            case 'M':
            case 'V':
                return(4);
            case 'E':
            case 'N':
            case 'W':
                return(5);
            case 'F':
            case 'O':
            case 'X':
                return(6);
            case 'G':
            case 'P':
            case 'Y':
                return(7);
            case 'H':
            case 'Q':
            case 'Z':
                return(8);
            case 'I':
            case 'R':
                return(9);
            default:
                throw new IllegalArgumentException("Caracter: "+c);
        }
    }

    // Decodifica um caracter segundo a tabela Chaldean
    private int tabChaldean(char c){//OK
        switch(c){
            case 'A':
            case 'I':
            case 'J':
            case 'Q':
            case 'Y':
                return(1);
            case 'B':
            case 'K':
            case 'R':
                return(2);
            case 'C':
            case 'G':
            case 'L':
            case 'S':
                return(3);
            case 'D':
            case 'M':
            case 'T':
                return(4);
            case 'E':
            case 'H':
            case 'N':
            case 'X':
                return(5);
            case 'U':
            case 'V':
            case 'W':
                return(6);
            case 'O':
            case 'Z':
                return(7);
            case 'F':
            case 'P':
                return(8);
            default:
                throw new IllegalArgumentException("Caracter: "+c);
        }
    }

    // Decodifica um caracter segundo a tabela selecionada
    private int decodChar(char c){//OK
    	if(tipoTab.equals(tipoTab.PITAGORICA)) {
    		return tabPitagorica(c);
    	}
    	else {
    		return tabChaldean(c);
    	}
    }

    private int reducaoSimples(String str){
    	 String[] letras = str.split("");
         int soma=0;
         for(String letra: letras) {
        	 if(letra.matches("[AEIOU]")) {
        		 char []c=letra.toCharArray();
        		 soma+=decodChar(c[0]);
        	 }
         }
         while(soma>=10) {
         	String num=Integer.toString(soma);
         	char[] nums=num.toCharArray();
         	int novaSoma=0;
         	for(char numero: nums) {
         		novaSoma+= numero - '0';
         	}
         	soma=novaSoma;
         }
        return soma;
    }

    // Define o tipo de tabela da tabela corrente
    public void setTipoTabela(TipoTabela tipo){//OK
        tipoTab = tipo;
    }

    // Calcula a reducao de palavra usando a tabela corrente
    public int reducaoPalavra(String palavra){
        char[] letras = palavra.toCharArray();
        int soma=0;
        for(char letra: letras) {
        	soma+=decodChar(letra);
        }
        while(soma>=10) {
        	String num=Integer.toString(soma);
        	char[] nums=num.toCharArray();
        	int novaSoma=0;
        	for(char numero: nums) {
        		novaSoma+= numero - '0';
        	}
        	soma=novaSoma;
        }
        
        return soma;
    }

    // Calcula a reducao de frase usando a tabela corrente
    public int reducaoFrase(String frase){
        String[] palavras=frase.split(" ");
        int soma=0;
        for(String s: palavras) {
        	soma+=reducaoPalavra(s);
        }
        return soma;
    }

    // Calcula a reducao de uma data no formato dd/mm/aaaa
    // Se estiver fora do formato lanca IllegalArgumentException
    public int reducaoData(String data){
    	int soma=0;
    	String[] numData=data.split("");
    	for(String num:numData ) {
    		if(num.matches("[0-9]")) {
    			int conv= Integer.parseInt(num);
    			soma+=conv;
    		}
    	}
    	 while(soma>=10) {
         	String num=Integer.toString(soma);
         	char[] nums=num.toCharArray();
         	int novaSoma=0;
         	for(char numero: nums) {
         		novaSoma+= numero - '0';
         	}
         	soma=novaSoma;
         }
         return soma;
    }
}