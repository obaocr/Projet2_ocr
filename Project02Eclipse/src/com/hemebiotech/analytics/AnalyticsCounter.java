package com.hemebiotech.analytics;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 * Application to read a file of symptons (string) and count occurences by
 * symptoms; return a file with number of occurence by symptoms if empty file
 * return the comment "Input file is empty"
 */
public class AnalyticsCounter {

	/**
	 * Main function : call the ReadSymptomDataFromFile.GetSymptoms class.method to
	 * read the file and obtain a list Call the countBySymptom function to get the
	 * map of occurence of symptoms Call the WriteSymptomRresult.WriteResult
	 * class.method to write the file
	 * 
	 * @param optional two parameters for the main in argument : input and output
	 *                 file name with full path
	 */
	public static void main(String args[]) {

		List<String> myList = new ArrayList<>();
		String pathFileInput = manageInputFilePath(args);
		String pathFileOutput = manageOuputFilePath(args);

		// Read the file
		ISymptomReader reader = new ReadSymptomDataFromFile(pathFileInput);
		List<String> lResult = reader.GetSymptoms();

		// Count occurence of symptom
		if (lResult.size() > 0) {
			myList = countBySymptom(lResult);
		}

		// Write the rsult file
		ISymptomWriter writer = new WriteSymptomRresult(pathFileOutput, myList);
		writer.WriteResult();
	}

	/**
	 * @param args from the main
	 * @return : full path name for input file
	 */
	private static String manageInputFilePath(String[] files) {
		if (files.length == 2 && !files[0].isEmpty()) {
			return files[0];
		} else {
			return "C:/openclassrooms/projet2/symptoms.txt";
		}
	}

	/**
	 * @param args from the main
	 * @return : full path name for output file
	 */
	private static String manageOuputFilePath(String[] files) {
		if (files.length == 2 && !files[1].isEmpty()) {
			return files[1];
		} else {
			return "C:/openclassrooms/projet2/result.out";
		}
	}

	/**
	 * countBySymptom function to get the List sorted (alphabetic) of occurence of
	 * symptoms
	 * 
	 */
	// Read the list and count occurence, return a map
	private static List<String> countBySymptom(List<String> listSymptom) {
		Map<String, Integer> myMapp = new HashMap<>();
		List<String> lResultAgg = new ArrayList<>();
		for (String symptom : listSymptom) {
			if (!symptom.isEmpty()) {
				if (myMapp.get(symptom) != null) {
					myMapp.put(symptom, myMapp.get(symptom) + 1);
				} else {
					myMapp.put(symptom, 1);
				}
			}
		}

		if (myMapp.size() > 0) {
			for (Map.Entry mapentry : myMapp.entrySet()) {
				lResultAgg.add(mapentry.getKey() + ": " + mapentry.getValue());
			}
			Collections.sort(lResultAgg);
		}
		return lResultAgg;
	}
}
