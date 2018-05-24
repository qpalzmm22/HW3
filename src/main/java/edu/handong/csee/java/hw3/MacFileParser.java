package edu.handong.csee.java.hw3;


import java.io.*;
import java.lang.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class MacFileParser extends MessageParser{
	
	public MacFileParser() {
		super();
	}
	public MacFileParser(File macFile) {
		super();
	}
	public void parseCSV() {
		try {
			FileReader reader = new FileReader(fileToParse);
			//NDMarray = new CsvToBeanBuilder(reader).withType(NDMdata.class).build().parse()
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}