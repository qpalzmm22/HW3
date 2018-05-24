package edu.handong.csee.java.hw3;

import java.util.*;
import java.io.*;

public class MessageParser{
	protected  File fileToParse;
	
	// Name, Date, Message
	protected class NDMdata{
		private String name;
		private String date;
		private String message;
		
		protected NDMdata(String name, String date, String message) {
			this.name = name;
			this.date = date;
			this.message = message;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
	}
	List<NDMdata> NDMarray  = new ArrayList<NDMdata>();
	
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
