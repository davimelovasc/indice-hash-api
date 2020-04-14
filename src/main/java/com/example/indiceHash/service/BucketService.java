package com.example.indiceHash.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.indiceHash.entity.Bucket;
import com.example.indiceHash.entity.Pagina;
import com.example.indiceHash.entity.Tupla;
import com.example.indiceHash.util.FuncaoHash;
import com.example.indiceHash.util.Global;
import com.example.indiceHash.util.Utilidades;

@Service
public class BucketService {

	public Bucket[] generateBuckets() {
		Set<Integer> colecaoSet = new HashSet<Integer>(); 
		System.out.println("Tuplas length: " + Global.tabela.getTuplas().length);
		for(int i = 0; i < Global.tabela.getTuplas().length; i++) {
			int bucketId = FuncaoHash.getBuketEnd(Global.tabela.getTuplas()[i].getChaveDeBusca());
			colecaoSet.add(bucketId);
		}
		Global.qtdBuckets = colecaoSet.size();
		Global.tamBucket = Global.tabela.getTuplas().length/Global.qtdBuckets;
		System.out.println("qtdeBuckets: " + Global.qtdBuckets);
		System.out.println("tamanhoBucket: " + Global.tamBucket);
		Global.buckets = new Bucket[Global.qtdBuckets];
		int aux =0;
		for (Integer bucketId : colecaoSet) {
			Global.buckets[aux] = new Bucket(bucketId, Global.tamBucket);
			aux++;
		}
		
		// Insere as tuplas nos buckets
		for(Pagina p : Global.paginas) {
			for(Tupla t : p.getTuplas()) {
				if( t != null) {
					Integer bEnd = FuncaoHash.getBuketEnd(t.getChaveDeBusca());
					Utilidades.getBucketByEndereco(bEnd).insert(t.getChaveDeBusca(), p.getEndereco());
				}
			}
		}
		Global.calcularColisoes();
		return Global.buckets;
	}
}
