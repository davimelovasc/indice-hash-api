package com.example.indiceHash.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.indiceHash.entity.Pagina;
import com.example.indiceHash.entity.Tabela;
import com.example.indiceHash.entity.Tupla;


public class Utilidades {

	public static List<String> trasnformarArquivoEmList(String arquivo) throws Exception {
		List<String> palavras = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(arquivo));
		String linha;
		while (br.ready()) {
			linha = br.readLine();
			palavras.add(linha);
		}
		br.close();
		return palavras;
	}


	public static Tupla[] gerarTuplas(List<String> palavras) {
		Random rand = new Random();
		List<Integer> idsDisponiveis = new ArrayList<Integer>();
		for(int i = 1; i <= palavras.size(); i++) {
			idsDisponiveis.add(i);
        }
		
		Tupla[] tuplas = new Tupla[palavras.size()];
		for(int i = 0; i < tuplas.length; i++) {
			int id = rand.nextInt(idsDisponiveis.size());
			tuplas[i] = new Tupla(idsDisponiveis.remove(id), palavras.get(i));
        }

		return tuplas;
	}
	
//	
//	public static void printBuckets(Bucket[] buckets) {
//		System.out.println("Tamanho buckets: " + buckets[0].getTamanho());
//		System.out.println("Qtde buckets: " + buckets.length);
//		for (int i = 0; i < buckets.length; i++) {
//			System.out.println("--------------------------------------------");
//			System.out.println(buckets[i].getEndereco());
//			System.out.println(buckets[i].getChavePagina());
//			System.out.println(buckets[i].getTamanho());
//		}
//	}
//	
//	public static Bucket getBucketByEndereco(Bucket[] buckets, int endereco) {
//		for (int i = 0; i < buckets.length; i++) {
//			if(buckets[i].getEndereco() == endereco) {
//				return buckets[i];
//			}
//		}
//		
//		return null;
//	}
//	
//	


	public static Pagina[] gerarPaginasPorTamanho(Tabela tabela, Integer qtdTuplasPagina) {
		Pagina[] paginas;
		
		int qtd_paginas = tabela.getTuplas().length/qtdTuplasPagina;
		if(tabela.getTuplas().length%qtdTuplasPagina != 0) {
			qtd_paginas++;
		}
		
		int j = 0;
		paginas = new Pagina[qtd_paginas];
		paginas[j] = new Pagina(j, qtdTuplasPagina);
		for(int i = 0; i < tabela.getTuplas().length; i++) {
			if(! paginas[j].addTupla(tabela.getTuplaByIndice(i))) {
				j++;
				paginas[j] = new Pagina(j, qtdTuplasPagina);
				paginas[j].addTupla(tabela.getTuplaByIndice(i));
			}
		}
		System.out.println(paginas.length);
		return paginas;
	}
	
	public static Pagina[] gerarPaginasPorQtdPaginas(Tabela tabela, Integer qtdPaginas) {
		Pagina[] paginas;
		
		int qtd_tuplas_pagina = tabela.getTuplas().length/qtdPaginas;
		
		// TODO
		return null;
	}
	
	


}
