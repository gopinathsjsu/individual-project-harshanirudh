package com.harsha.cmpe.sjsu.inventory.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class ErrorFile implements OutputFile {

	@Override
	public void writeToFile(List<String> lines) throws FileNotFoundException {
		File dir=new File("out");
		if(!dir.exists()) {
			dir.mkdir();
		}
		File file= new File("out/Error.txt");
		try(PrintWriter writer=new PrintWriter(file)){
			for(String line :lines) {
				writer.write(line);
			}
		}
		System.out.println("Finsihed writing to Error.txt file in out dir");
	}


}
