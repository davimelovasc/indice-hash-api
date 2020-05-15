package com.example.indiceHash.entity;

public class Departamento extends Tupla {
	
	private Integer codigo;
	private String nome;
	
	public Departamento(int chaveDeBusca, Integer codigo, String nome) {
		super(chaveDeBusca);
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Departamento [codigo=" + codigo + ", nome=" + nome + "]";
	}
	
	

}
