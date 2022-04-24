package com.harsha.cmpe.sjsu.inventory.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
}
