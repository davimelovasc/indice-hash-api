package com.example.indiceHash.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
	
	private final String SELECT_PATTERN = "select\\s+(.*?)\\s*from\\s+(.*?)\\s*(where\\s(.*?)\\s*)?;";
	
	public List<String> parse(String instructionSQL) {
		List<String> parts = new ArrayList<>();
		
		if(instructionSQL.matches(SELECT_PATTERN)) {
			Pattern r = Pattern.compile(SELECT_PATTERN);
			Matcher m =  r.matcher(instructionSQL);
			if(m.find()) {
				//parts[1] campos(nome, cidade)
				//parts[2] tabelas(departamento)
				//parts[4] clausulas (a.a = b.a AND a.b = a.a)
				parts.addAll(Arrays.asList(m.group(0), m.group(1), m.group(2), m.group(4)));
			}
			
		}
		return parts;
		
	}

}
