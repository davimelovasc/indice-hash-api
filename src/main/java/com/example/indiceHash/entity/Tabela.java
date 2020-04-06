package com.example.indiceHash.entity;

public class Tabela {
	
	private String nameTable;
	private Tupla[] tuplas;
	
	public Tabela(String nameTable, Tupla[] tuplas) {
		super();
		this.nameTable = nameTable;
		this.tuplas = tuplas;
	}

	public String getNameTable() {
		return nameTable;
	}

	public void setNameTable(String nameTable) {
		this.nameTable = nameTable;
	}

	public Tupla[] getTuplas() {
		return tuplas;
	}

	public void setTuplas(Tupla[] tuplas) {
		this.tuplas = tuplas;
	}
	
	public Tupla getTuplaByIndice(int i) {
		return this.tuplas[i];
	}
}
