package com.example.indiceHash.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.indiceHash.entity.Bucket;
import com.example.indiceHash.util.Global;

@Service
public class AppService {

	
	public Map<String, String> search(String termo) {
		Map<String, String> result = new HashMap<String, String>();
		int cb = Global.getChaveDeBusca(termo);
		System.out.println("CHAVE DE BUSCA ---> " + cb);
		for (int i = 0; i < Global.buckets.length; i++) {
			Integer page = searchPageOnBucket(Global.buckets[i], cb);
			if(page != null) {
				result.put("bucket_number", String.valueOf(Global.buckets[i].getEndereco()));
				result.put("page_number", String.valueOf(page));
				result.put("cb", String.valueOf(cb));
				break;
			}
		}
		return result;
	}
	
	
	private Integer searchPageOnBucket(Bucket bucket, Integer cb) { //REFATOR
		Integer page_id;
		if(bucket.getBucket() != null) {
			page_id = searchPageOnBucket(bucket.getBucket(), cb);
			if(  page_id != null )
				return page_id;
		}
		page_id = bucket.getChavePagina().get(cb);
		if(page_id != null) {
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
		return stats;
	}
}
