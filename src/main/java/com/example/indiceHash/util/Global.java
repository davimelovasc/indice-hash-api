package com.example.indiceHash.util;

import com.example.indiceHash.entity.Bucket;
import com.example.indiceHash.entity.Empregado;
import com.example.indiceHash.entity.Pagina;
import com.example.indiceHash.entity.Tabela;

public class Global {
	
	public static Empregado[] empregados;
	
	
	public static Tabela tabela_empregado = null;
	public static Tabela tabela_dependente = null;
	public static Tabela tabela_departamento = null;
	
	public static Pagina[] paginas;
	public static Bucket[] buckets;
	
	
	public static final String EMPREGADO_TABLE_NAME = "Empregado";
	public static final String DEPENDENTE_TABLE_NAME = "Dependente";
	public static final String DEPARTAMENTO_TABLE_NAME = "Departamento";
	
	
	// Stats
	public static double taxaColisao = 0;
	public static int qtdOverflow = 0;
	public static int qtdBuckets = 0;
	public static int tamBucket = 0;
	
	public static int acessoDisco = 0;

	public static int getChaveDeBusca(Tabela tabela, String termo) {
		for (int i = 0; i < tabela.getTuplas().length; i++) {
			if(termo.equals(tabela.getTuplas()[i].getPalavra())) {
				return tabela.getTuplas()[i].getChaveDeBusca();
			}
		}
		return -1;
	}
	
	public static void calcularColisoes() {
		double somaColisoes = 0;
		Bucket aux;
		int cont = 0;
		
		for (int i = 0; i < buckets.length; i++) {
			somaColisoes += (double) buckets[i].getSizeColisoes() / (double) buckets[0].getTamanho();
			aux = buckets[i].getBucket();
			while(aux != null) {
				somaColisoes += (double) aux.getSizeColisoes() / (double) buckets[0].getTamanho();
				cont++;
				aux = aux.getBucket();
			}
			
		}
		taxaColisao = somaColisoes/(buckets.length+cont);
	}

	public static void reset() {
		taxaColisao = 0;
		qtdOverflow = 0;
		acessoDisco = 0;
		tamBucket = 0;
		qtdBuckets = 0;
		tabela_empregado = null;
		tabela_dependente = null;
		tabela_departamento = null;
		paginas = null;
		buckets = null;
	}

}
