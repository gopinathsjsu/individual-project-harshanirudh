package com.harsha.cmpe.sjsu.inventory.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

	public List<String> readFile(String location) throws IOException {
		List<String> fileContent=new ArrayList<>();
		String line;
		try(BufferedReader br= new BufferedReader(new FileReader(location))){
			line=br.readLine() ;
			while(line!= null) {
				fileContent.add(line);
				line=br.readLine();
			}
		}
		return fileContent;
	}

	public List<String> readFileFromResources(String location) throws IOException {
		List<String> fileContent=new ArrayList<>();
		String line;
		InputStream is=getClass().getClassLoader().getResourceAsStream(location);
		try(BufferedReader br= new BufferedReader(new InputStreamReader(is))){
			line=br.readLine() ;
			while(line!= null) {
				fileContent.add(line);
				line=br.readLine();
			}
		}
		return fileContent;
	}
}
