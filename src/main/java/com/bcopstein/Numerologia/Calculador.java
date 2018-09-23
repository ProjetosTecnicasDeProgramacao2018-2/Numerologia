package com.bcopstein.Numerologia;

// Todos os metodos geram IllegalArgumentException em caso de caracter ilegal
public class Calculador{
    private Formatador formatador;
    private Redutor reducao;

    // Recebe o redutor e o formatador a serem usados em todos os calculos
    // por injecao de dependencia
    public Calculador(Redutor reducao, Formatador formatador){
        this.reducao = reducao;
        this.formatador = formatador;
    }

    public int calculaNumeroDaVida(String data){
        return this.reducao.reducaoData(data);
    }

    public int calculaNumeroDestino(String nomeCompleto){
    	return this.reducao.reducaoFrase(this.formatador.formataFrase(nomeCompleto));
    }

    public int calculaNumeroDesejosDaAlma(String nomeCompleto){
    	nomeCompleto = nomeCompleto.replaceAll("[^aeiou ]", "");
        return this.reducao.reducaoFrase(this.formatador.formataFrase(nomeCompleto));
    }
    
}