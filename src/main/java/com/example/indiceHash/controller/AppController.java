package com.example.indiceHash.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.indiceHash.entity.Bucket;
import com.example.indiceHash.entity.Pagina;
import com.example.indiceHash.entity.Parser;
import com.example.indiceHash.entity.Tabela;
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
		Parser p = new Parser();
		p.parse("select nome, idade from funcionario where idade > 20 and idade < 59;");
		return new ResponseEntity<Tupla[]>(tuplaService.gerarTuplas(), HttpStatus.OK);
	}
	
	@PostMapping("/execute-sql")
	public ResponseEntity<List<String>> executeSql(@RequestBody(required = true) String query) {
		System.out.println(query);
		Parser p = new Parser();
		return new ResponseEntity<>(p.parse(query), HttpStatus.OK);
	}
	
	@GetMapping("/init")
	public ResponseEntity<Pagina[]> init(@RequestParam(name = "type") String tipo, @RequestParam(name = "value") Integer valor) {
		return new ResponseEntity<Pagina[]>(paginaService.gerarPaginas(tipo, valor), HttpStatus.OK);
	}
	
	@GetMapping("/generate-buckets")
	public ResponseEntity<Bucket[]> generateBuckets() {
		return new ResponseEntity<Bucket[]>(bucketService.generateBuckets(), HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity<Map<String, String>> search(@RequestParam(name="term") String termo) {
		return new ResponseEntity<Map<String, String>>(appService.search(termo), HttpStatus.OK);
		
	}
	
	@GetMapping("/get-stats")
	public ResponseEntity<Map<String, String>> getStats() {
		return new ResponseEntity<Map<String, String>>(appService.getStats(), HttpStatus.OK);
	}
}
