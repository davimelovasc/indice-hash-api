package com.example.indiceHash.util;

public class FuncaoHash {
	// Aplicar para todas as chaves de busca(palavras).
	// Ap�s isso, inserir em um conjunto que implementa a interface(interface Set do Java).
	// Gerado todos os ids dos buckets, aplicar fun��o de lenght. No max buckets de tamanho 1000;
	public static int getBuketEnd(int chaveBusca) {
		//String s = String.valueOf(chaveBusca);
		//return (s.hashCode()) ^ (chaveBusca >>> 16);
		int test = chaveBusca ^ "abc".hashCode();
		return test % Global.paginas[0].getTuplas().length; // TODO
	}

//	// Test hash
//	public static int hash(String term) {
//		return term.hashCode() ^ 11;
//	}
}
