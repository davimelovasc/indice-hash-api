package com.example.indiceHash.service;

import org.springframework.stereotype.Service;

import com.example.indiceHash.entity.Tupla;
import com.example.indiceHash.util.Global;
import com.example.indiceHash.util.Utilidades;

@Service
public class TuplaService {
	

	public Tupla[] gerarTuplas() throws Exception {
		Tupla[] tuplas = Utilidades.gerarTuplas(Utilidades.trasnformarArquivoEmList("words.txt"));
		Global.tabela.setTuplas(tuplas);
		return tuplas;
	}

}
