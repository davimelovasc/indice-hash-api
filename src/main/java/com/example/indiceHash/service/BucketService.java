package com.example.indiceHash.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.indiceHash.entity.Bucket;
import com.example.indiceHash.entity.Pagina;
import com.example.indiceHash.entity.Tupla;
import com.example.indiceHash.util.FuncaoHash;
import com.example.indiceHash.util.Global;

@Service
public class BucketService {

	public Bucket[] generateBuckets() {
		Set<Integer> colecaoSet = new HashSet<Integer>(); 
		System.out.println("Tuplas length: " + Global.tabela.getTuplas().length);
		for(int i = 0; i < Global.tabela.getTuplas().length; i++) {
			int bucketId = FuncaoHash.getBuketId(Global.tabela.getTuplas()[i].getChaveDeBusca());
			colecaoSet.add(bucketId);
		}
		
		int qtdeBuckets = colecaoSet.size();
		int tamanhoBucket = Global.tabela.getTuplas().length/qtdeBuckets;
		System.out.println("qtdeBuckets: " + qtdeBuckets);
		System.out.println("tamanhoBucket: " + tamanhoBucket);
		Global.buckets = new Bucket[qtdeBuckets];
		for (Integer bucketId : colecaoSet) {
			Global.buckets[bucketId] = new Bucket(bucketId, tamanhoBucket);
		}
		
		// Insere as tuplas nos buckets
		for(Pagina p : Global.paginas) {
			for(Tupla t : p.getTuplas()) {
				if( t != null) {
					Integer bId = FuncaoHash.getBuketId(t.getChaveDeBusca());
					Global.buckets[bId].insert(t.getChaveDeBusca(), p.getEndereco());
				}
			}
		}
		
		return Global.buckets;
	}
}
