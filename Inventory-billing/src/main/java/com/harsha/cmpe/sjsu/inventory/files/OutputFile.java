package com.harsha.cmpe.sjsu.inventory.files;

import java.io.FileNotFoundException;
import java.util.List;

public interface OutputFile {

	public void writeToFile(List<String> lines) throws FileNotFoundException;
}
