package com.example.indiceHash.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.indiceHash.entity.Bucket;
import com.example.indiceHash.entity.Pagina;
import com.example.indiceHash.entity.Tupla;
import com.example.indiceHash.service.AppService;
import com.example.indiceHash.service.BucketService;
import com.example.indiceHash.service.PaginaService;
import com.example.indiceHash.service.TuplaService;

@RestController
public class AppController {
	
	@Autowired
	private TuplaService tuplaService;
	
	@Autowired
	private PaginaService paginaService;
	
	@Autowired
	private BucketService bucketService;
	
	@Autowired
	private AppService appService;
	
	
	@GetMapping("/")
	public ResponseEntity<Tupla[]> index() throws Exception {
		return new ResponseEntity<Tupla[]>(tuplaService.gerarTuplas(), HttpStatus.OK);
	}
	
	@GetMapping("/init")
	public ResponseEntity<Pagina[]> init(@RequestParam(name = "type") String tipo, @RequestParam(name = "value") Integer valor) {
		return new ResponseEntity<Pagina[]>(paginaService.gerarPaginas(tipo, valor), HttpStatus.OK);
	}
	
	@GetMapping("/generate-buckets")
	public ResponseEntity<Bucket[]> generateBuckets() {
		return new ResponseEntity<Bucket[]>(bucketService.generateBuckets(), HttpStatus.OK);
	}
	
	@GetMapping("/serch")
	public ResponseEntity<Map<String, String>> search(@RequestParam(name="term") String termo) {
		return new ResponseEntity<Map<String, String>>(appService.search(termo), HttpStatus.OK);
		
	}
	
	@GetMapping("/get-stats")
	public ResponseEntity<Map<String, String>> getStats() {
		return new ResponseEntity<Map<String, String>>(appService.getStats(), HttpStatus.OK);
	}
}
