package com.example.indiceHash.service;

import org.springframework.stereotype.Service;

import com.example.indiceHash.entity.Departamento;
import com.example.indiceHash.entity.Dependente;
import com.example.indiceHash.entity.Empregado;
import com.example.indiceHash.entity.Tabela;
import com.example.indiceHash.entity.Tupla;
import com.example.indiceHash.util.Global;
import com.github.javafaker.Faker;

@Service
public class TuplaService {
	
	public Tupla[] gerarTuplas() throws Exception {
		Global.reset();
		Global.tabela_departamento = new Tabela(Global.DEPARTAMENTO_TABLE_NAME, gerarTuplasDepartamento());
		Global.tabela_empregado = new Tabela(Global.EMPREGADO_TABLE_NAME, gerarTuplasEmpregado());
		Global.tabela_dependente = new Tabela(Global.DEPENDENTE_TABLE_NAME, gerarTuplasDependente());
		//Tupla[] tuplas = Utilidades.gerarTuplas(Utilidades.trasnformarArquivoEmList("words.txt"));
		//Global.tabela.setTuplas(tuplas);
		//return tuplas;
		return null;
	}
	
	private Tupla[] gerarTuplasEmpregado() {
		Faker faker = new Faker();
		Empregado[] empregados = new Empregado[10000];
		
		for(int i = 0; i < empregados.length; i++) {
			int mat = Integer.parseInt(faker.number().digits(6));
			//TODO checar mat repetida
			empregados[i] = new Empregado(i+1, mat, faker.name().fullName(), faker.number().randomDouble(2, 1000, 15000), faker.number().numberBetween(1, Global.DEPARTAMENTO_TABLE_NAME.length()));
		}
		Global.empregados = empregados;
		
		System.out.println(empregados[0]);
		System.out.println(empregados[5000]);
		System.out.println(empregados[9882]);
		
		return empregados;
	}
	
	private Tupla[] gerarTuplasDependente() {
		Faker faker = new Faker();
		Dependente[] dependentes = new Dependente[3000];
		
		for(int i = 0; i < dependentes.length; i++) {
			dependentes[i] = new Dependente(i+1, Global.empregados[faker.number().numberBetween(1, Global.empregados.length)].getMatri(), faker.name().fullName());
		}
		System.out.println(dependentes[0]);
		System.out.println(dependentes[1000]);
		System.out.println(dependentes[2580]);
		return dependentes;
	}
	
	private Tupla[] gerarTuplasDepartamento() {
		Faker faker = new Faker();
		Departamento[] departamentos = new Departamento[20];
		
		for(int i = 0; i < departamentos.length; i++) {
			departamentos[i] = new Departamento(i+1, Integer.parseInt(faker.number().digits(4)), faker.company().name());
		}
		System.out.println(departamentos[0]);
		System.out.println(departamentos[10]);
		System.out.println(departamentos[15]);
		return departamentos;
	}

}
