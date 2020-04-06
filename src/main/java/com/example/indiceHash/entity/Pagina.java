package com.example.indiceHash.entity;

public class Pagina {
	private int endereco;
	private Tupla[] tuplas;
	
	public Pagina(int endereco, int tamPag) {
		super();
		this.endereco = endereco;
		tuplas = new Tupla[tamPag];
	}

	public int getEndereco() {
		return endereco;
	}

	public void setEndereco(int endereco) {
		this.endereco = endereco;
	}

	public Tupla[] getTuplas() {
		return tuplas;
	}

	public void setTuplas(Tupla[] tuplas) {
		this.tuplas = tuplas;
	}
	
	public boolean addTupla(Tupla tupla) {
		for(int i = 0; i < tuplas.length; i++) {
			if(tuplas[i] == null) {
				tuplas[i] = tupla;
				return true;
			}
		}
		return false;
	}

}
