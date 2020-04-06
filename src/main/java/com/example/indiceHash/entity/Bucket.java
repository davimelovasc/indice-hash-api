package com.example.indiceHash.entity;

import java.util.HashMap;

public class Bucket {
	private int endereco;
	
	// chave_de_busca => endereco_pagina
	private HashMap<Integer, Integer> chavePagina = new HashMap<>();
	private int tamanho;
	private Bucket bucket;
	
	public Bucket(int endereco, int tamanho) {
		this.endereco = endereco;
		this.tamanho = tamanho;
	}
	
	public int getEndereco() {
		return endereco;
	}
	public void setEndereco(int endereco) {
		this.endereco = endereco;
	}

	public Bucket getBucket() {
		return bucket;
	}
	public void setBucket(Bucket bucket) {
		this.bucket = bucket;
	}
	public HashMap<Integer, Integer> getChavePagina() {
		return chavePagina;
	}
	public void setChavePagina(HashMap<Integer, Integer> chavePagina) {
		this.chavePagina = chavePagina;
	}
	public int getTamanho() {
		return tamanho;
	}
	
	// Gera as chaves das paginas
	public void insert(int chaveBusca, int enderecoPagina) {
		if(chavePagina.size() >= tamanho) {
			// OVERFLOW 
			if(this.bucket == null) {
				this.bucket = new Bucket(endereco, tamanho);
			}
			this.bucket.insert(chaveBusca, enderecoPagina);
		}else {
			chavePagina.put(chaveBusca, enderecoPagina);
		}
		
		
	}
	
	
	
	
	
}
