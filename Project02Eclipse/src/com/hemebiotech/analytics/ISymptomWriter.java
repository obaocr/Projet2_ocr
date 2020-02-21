package com.hemebiotech.analytics;

/**
 * Read a map of symptom / occurence and write a file with symptoms and occurence per symptoms 
 */
public interface ISymptomWriter {
	/**
	 * If empty Map then write a line "Input file is empty"
	 * @return nothing
	 */
	void WriteResult();

}
