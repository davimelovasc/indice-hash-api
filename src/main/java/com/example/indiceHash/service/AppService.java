package com.example.indiceHash.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.indiceHash.entity.Bucket;
import com.example.indiceHash.entity.Tabela;
import com.example.indiceHash.util.FuncaoHash;
import com.example.indiceHash.util.Global;
import com.example.indiceHash.util.Utilidades;

@Service
public class AppService {

	
	public Map<String, String> search(String termo) {
		Map<String, String> result = new HashMap<String, String>();
		int cb = Global.getChaveDeBusca(termo);
		System.out.println("CHAVE DE BUSCA ---> " + cb);
		int bucketEnd = FuncaoHash.getBuketEnd(cb);
		Bucket bucket = Utilidades.getBucketByEndereco(bucketEnd);
		Integer page = searchPageOnBucket(bucket, cb);
		if(page != null) {
			result.put("bucket_number", String.valueOf(bucket.getEndereco()));
			result.put("page_number", String.valueOf(page));
			result.put("cb", String.valueOf(cb));
			result.put("acesso_disco", String.valueOf(Global.acessoDisco+1));
		}
		Global.acessoDisco = 0;
		return result;
	}
	
	public Tabela getTable(String tableName) {
		switch (tableName) {
		case "Empregado":
			return Global.tabela_empregado;
		case "departamento":
			return Global.tabela_departamento;
		case "dependente":
			return Global.tabela_dependente;
		default:
			return null;
		}
	}
	
	
	private Integer searchPageOnBucket(Bucket bucket, Integer cb) { //REFATOR
		Global.acessoDisco += 1;
		Integer page_id;
		
		page_id = bucket.getChavePagina().get(cb);
		if(page_id != null) {
			return page_id;
		}
		
		
		if(bucket.getBucket() != null) {
			page_id = searchPageOnBucket(bucket.getBucket(), cb);
			if(  page_id != null )
				return page_id;
		}
		
		return null;
	}


	public Map<String, String> getStats() {
		Map<String, String> stats = new HashMap<>();
		double taxaOverflow = (double) Global.qtdOverflow / (double) Global.buckets.length;
		taxaOverflow *= 100;
		
		double taxaColisao = Global.taxaColisao * 100;
		
		stats.put("taxaColisao", String.valueOf((int) taxaColisao));
		stats.put("taxaOverflow", String.valueOf((int)taxaOverflow));
		stats.put("qtdBuckets", String.valueOf(Global.qtdBuckets + Global.qtdOverflow));
		stats.put("tamBucket", String.valueOf(Global.tamBucket));
		
		return stats;
	}
}
