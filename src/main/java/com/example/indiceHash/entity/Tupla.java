package com.example.indiceHash.entity;

public class Tupla {
	private int chaveDeBusca;
	private String palavra;
	
	public Tupla(int chaveDeBusca, String palavra) {
		this.chaveDeBusca = chaveDeBusca;
		this.palavra = palavra;
	}
	
	public String getPalavra() {
		return palavra;
	}
	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	public int getChaveDeBusca() {
		return chaveDeBusca;
	}
	public void setChaveDeBusca(int chaveDeBusca) {
		this.chaveDeBusca = chaveDeBusca;
	}
}
