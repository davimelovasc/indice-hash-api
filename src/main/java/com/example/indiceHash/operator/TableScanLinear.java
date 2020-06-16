package com.example.indiceHash.operator;

import com.example.indiceHash.entity.Tabela;
import com.example.indiceHash.util.Global;
import com.example.indiceHash.util.Utilidades;

public class TableScanLinear {
	
	public String[][] search(String[] campos, Tabela[] tabelas, String[] clausulas) {
		String[][] result = new String[campos.length][100];
		
		for(Tabela t: tabelas) {
			if(t.getNameTable().equals(Global.EMPREGADO_TABLE_NAME)) {
				Utilidades.filter(searchOnEmpregado(), campos);
			}
			
			
			
		}
		
		return null;
		
	}


	private String[][] searchOnEmpregado() {
		String[][] result = new String[1000][4];
		result[0][0] = "matricula";
		result[0][1] = "nome";
		result[0][2] = "salario";
		result[0][3] = "cod_dep";
		
		for(int i = 0; i < 1000; i++) {
			// TODO where
			result[i+1][0] = String.valueOf(Global.empregados[i].getMatri());
			result[i+1][1] = Global.empregados[i].getNome();
			result[i+1][2] = String.valueOf(Global.empregados[i].getSalario());
			result[i+1][3] = String.valueOf(Global.empregados[i].getDepartamento_cod_dep());
		}
		
		return result;
		
		
	}

}
