package com.example.indiceHash.service;

import org.springframework.stereotype.Service;

import com.example.indiceHash.entity.Pagina;
import com.example.indiceHash.util.Global;
import com.example.indiceHash.util.Utilidades;

@Service
public class PaginaService {
	
	public Pagina[] gerarPaginas(String tipo, Integer valor) {
		Pagina[] paginas;
		if(tipo.equals("tamanhoPaginas")) {
			paginas = Utilidades.gerarPaginasPorTamanho(Global.tabela, valor);
		} else {
			paginas = Utilidades.gerarPaginasPorQtdPaginas(Global.tabela, valor);
		}
		Global.paginas = paginas;
		return paginas;
	}
	
}
