package com.example.indiceHash.util;

import com.example.indiceHash.entity.Bucket;
import com.example.indiceHash.entity.Pagina;
import com.example.indiceHash.entity.Tabela;

public class Global {
	
	public static Tabela tabela = new Tabela("tabela01", null);
	public static Pagina[] paginas;
	public static Bucket[] buckets;
	
	
	// Stats
	public static double taxaColisao = 0;
	public static int qtdOverflow = 0;

	public static int getChaveDeBusca(String termo) {
		for (int i = 0; i < tabela.getTuplas().length; i++) {
			if(termo.equals(tabela.getTuplas()[i].getPalavra())) {
				return tabela.getTuplas()[i].getChaveDeBusca();
			}
		}
		return -1;
	}
	
	public static void calcularColisoes() {
		double somaColisoes = 0;
		for (int i = 0; i < buckets.length; i++) {
			somaColisoes += (double) buckets[i].getSizeColisoes() / (double) buckets[i].getTamanho();
		}
		taxaColisao = somaColisoes/buckets.length;
	}

	public static void reset() {
		taxaColisao = 0;
		qtdOverflow = 0;
		tabela = new Tabela("tabela01", null);
		paginas = null;
		buckets = null;
	}

}
