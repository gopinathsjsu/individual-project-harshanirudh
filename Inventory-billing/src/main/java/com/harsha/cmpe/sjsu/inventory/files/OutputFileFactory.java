package com.harsha.cmpe.sjsu.inventory.files;

public class OutputFileFactory {

	public OutputFile getOutputFile(String type) {
		if(type.equals("OUTPUT")) {
			return new CSVOutput();
		}else if(type.equals("ERROR")) {
			return new ErrorFile();
		}
		return null;
	}
}
