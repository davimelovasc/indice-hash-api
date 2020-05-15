package com.example.indiceHash.entity;

public class Dependente extends Tupla {
	
	private Integer empregado_matricula;
	private String nome;
	
	public Dependente(int chaveDeBusca, Integer empregado_matricula, String nome) {
		super(chaveDeBusca);
		this.empregado_matricula = empregado_matricula;
		this.nome = nome;
	}
	
	public Integer getEmpregado_matricula() {
		return empregado_matricula;
	}
	public void setEmpregado_matricula(Integer empregado_matricula) {
		this.empregado_matricula = empregado_matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Dependente [empregado_matricula=" + empregado_matricula + ", nome=" + nome + "]";
	}
	
	
	
	

}
