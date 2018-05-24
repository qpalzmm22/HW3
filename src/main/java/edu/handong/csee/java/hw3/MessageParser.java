package edu.handong.csee.java.hw3;

import java.util.*;
import java.io.*;

public class MessageParser{
	protected  File fileToParse;
	
	ArrayList<NDMdata> NDMarray  = new ArrayList<NDMdata>();
	
	// Name, Count table
	HashMap<String, Integer> NCtable= new HashMap<String, Integer>();
	
	public MessageParser() {
		System.out.println("No File is found to parse");
	}
	public MessageParser(File file) {
		fileToParse = file;
	}
	
	public void setFileToParse(File file) {
		fileToParse = file;
	}

	public Set<NDMdata> getRidOfDuplicateMessage() {
		Set<NDMdata> NDMset = new LinkedHashSet<NDMdata>(NDMarray);
		System.out.println("The list is now Set");
		return (NDMset);
	}
	
	public int countNumOfMesasages(){
		return getRidOfDuplicateMessage().size();
	}
}
