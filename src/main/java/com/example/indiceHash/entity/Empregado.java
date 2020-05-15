package com.example.indiceHash.entity;

public class Empregado extends Tupla {

	private Integer matri;
	private String nome;
	private Double salario;
	private Integer departamento_cod_dep;
	
	
	public Empregado(int chaveDeBusca, Integer matri, String nome, Double salario, Integer departamento_cod_dep) {
		super(chaveDeBusca);
		this.matri = matri;
		this.nome = nome;
		this.salario = salario;
		this.departamento_cod_dep = departamento_cod_dep;
	}
	
	public Empregado(int chaveDeBusca) {
		super(chaveDeBusca);
	}
	
	public Integer getMatri() {
		return matri;
	}
	public void setMatri(Integer matri) {
		this.matri = matri;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Integer getDepartamento_cod_dep() {
		return departamento_cod_dep;
	}
	public void setDepartamento_cod_dep(Integer departamento_cod_dep) {
		this.departamento_cod_dep = departamento_cod_dep;
	}

	@Override
	public String toString() {
		return "Empregado [matri=" + matri + ", nome=" + nome + ", salario=" + salario + ", departamento_cod_dep="
				+ departamento_cod_dep + "]";
	}
	
	
	
}
