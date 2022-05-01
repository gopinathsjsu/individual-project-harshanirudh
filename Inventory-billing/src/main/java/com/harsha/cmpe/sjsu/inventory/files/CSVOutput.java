package com.harsha.cmpe.sjsu.inventory.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

public class CSVOutput implements OutputFile {

	@Override
	public void writeToFile(List<String> lines) throws FileNotFoundException {
		File dir=new File("out");
		if(!dir.exists()) {
			dir.mkdir();
		}
		File file= new File("out/output.csv");
		try(PrintWriter writer=new PrintWriter(file)){
			for(String line :lines) {
				writer.write(line);
			}
		}
		System.out.println("Finsihed writing to output.csv file in out dir");
	}

}
