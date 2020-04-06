package com.example.indiceHash.util;

import com.example.indiceHash.entity.Bucket;
import com.example.indiceHash.entity.Pagina;
import com.example.indiceHash.entity.Tabela;

public class Global {
	
	public static Tabela tabela = new Tabela("tabela01", null);
	public static Pagina[] paginas;
	public static Bucket[] buckets;

	public static int getChaveDeBusca(String termo) {
		for (int i = 0; i < tabela.getTuplas().length; i++) {
			if(termo.equals(tabela.getTuplas()[i].getPalavra())) {
				return tabela.getTuplas()[i].getChaveDeBusca();
			}
		}
		return -1;
	}
}
