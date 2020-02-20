package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

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
	 */
	public static void main(String args[]) {

		Map<String, Integer> myMapp = new HashMap<>();
		String pathFileInput = "C:/openclassrooms/projet2/symptoms.txt";
		String pathFileOutput = "C:/openclassrooms/projet2/result.out";

		// Lecture fichier et retour dans une liste
		ISymptomReader reader = new ReadSymptomDataFromFile(pathFileInput);
		List<String> lResult = reader.GetSymptoms();

		// Si fichier non vide, compter les occurences symptomes
		if (lResult.size() > 0) {
			myMapp = countBySymptom(lResult);
		}

		// Ecriture fichier résultat depuis une Map (vide ou non vide)
		ISymptomWriter writer = new WriteSymptomRresult(pathFileOutput, myMapp);
		writer.WriteResult();
	}

	/**
	 * countBySymptom function to get the map of occurence of symptoms
	 * 
	 */
	// Lecture du fichier en entrée et compter les occurences par symptome
	private static Map<String, Integer> countBySymptom(List<String> listSymptom) {
		Map<String, Integer> myMapp = new HashMap<>();
		for (String symptom : listSymptom) {
			if (!symptom.isEmpty()) {
				if (myMapp.get(symptom) != null) {
					myMapp.put(symptom, myMapp.get(symptom) + 1);
				} else {
					myMapp.put(symptom, 1);
				}
			}
		}
		return myMapp;
	}
}
