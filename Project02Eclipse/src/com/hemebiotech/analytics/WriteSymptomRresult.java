package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * class that implements ISymptomWriter Interface
 * the method "WriteSymptomRresult" read the Map of symptoms and occurrence and write the result file 
 */
public class WriteSymptomRresult implements ISymptomWriter {

	private String filepath;
	private List<String> symptomList;


	public WriteSymptomRresult(String filepath, List<String> resultList) {
		this.filepath = filepath;
		this.symptomList = resultList;
	}

	@Override
	public void WriteResult() {
		try (FileWriter writer = new FileWriter(filepath)){
			if (symptomList.size() == 0) {
				writer.write("Input file is empty" + "\n");
			} else {
				for (String sLine : symptomList) {
					writer.write(sLine + "\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
