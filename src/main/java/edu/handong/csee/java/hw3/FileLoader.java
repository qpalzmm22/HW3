package edu.handong.csee.java.hw3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;

 /**
  * This class gets path as a parameter and provides tools to sort them by mac file 
  * and windows file. 
  * @author qpalzmm22
  *
  */
public class FileLoader {
	private File directory = null;
	private HashMap<String, ArrayList<NDMdata>> messages = new HashMap<String, ArrayList<NDMdata>>();
	
	
	public FileLoader(String path) {
		directory = new File(path);
	}

	public HashMap<String, ArrayList<NDMdata>> getMessages() {
		return messages;
	}
	
	//public HashMap<String, Set<NDMdata>> getRidOfDuplicates(){
		//HashMap<String, Set <NDMdata>> messagesSet;
		//for(String name : messages.keySet()) {
		//	messagesSet. = messages.get(name)
		//}
	//}
	
	public void loadMacFiles() {
		for(File file: directory.listFiles()) {
			if(file.getName().contains(".csv")) {
				System.out.println("Reading csv files," + file.getName()+ "...");
				Reader in;
				try {
					in = new FileReader(file);
					Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
					for(CSVRecord record : records) {
						String time = record.get(0).substring(11,16);
						String user = record.get(1);
						String messageString = record.get(2);
					
						if(!messages.containsKey(user))
							messages.put(user, new ArrayList<NDMdata>());
					
						messages.get(user).add(new NDMdata(user, time, messageString));
					}
				}
				catch(Exception e) {
				}
			}
		} 
	}
	public void loadWindowsFiles() {
		for(File file: directory.listFiles()) {
			if(file.getName().contains(".txt")) {
				System.out.println("Reading txt files," + file.getName()+ "...");
				BufferedReader br;
				try {
					br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
					String thisLine;
					while((thisLine = br.readLine()) != null) {
						String pattern = "\\[(.+)\\] \\[(.*[0-9]+:[0-9]+.*)\\] (.+)";
						Pattern r = Pattern.compile(pattern);
						Matcher m = r.matcher(thisLine);
						
						String user = "";
						String date = "";
						String messageString = "";
						if(m.find()) {
							user = m.group(1);
							date = m.group(2);
							messageString = m.group(3);
							
							String ampmPattern = "(..)\\s([0-9]+:[0-9]+)|([0-9]+:[0-9]+)\\s(..)";
							Pattern r2 = Pattern.compile(ampmPattern);
							Matcher m2 = r2.matcher(date);
							
							String time = "";
							int hour = 0;
							if(m2.find()) {
								if(m2.group(1) != null) {
									time = m2.group(2);
									hour = Integer.parseInt(time.substring(0, time.length() - 3));
									if(m2.group(1).equals("오후"))
										hour += 12;
								}
								
								else {
									time = m2.group(3);
									hour = Integer.parseInt(time.substring(0, time.length() - 3));
									if(m2.group(4).equals("PM"))
										hour += 12;
								}
								date = hour + time.substring(time.length() - 3);
							}
							
						}
						if(!messages.containsKey(user))
							messages.put(user, new ArrayList<NDMdata>());
						
						messages.get(user).add(new NDMdata(user, date, messageString));
					}
				} catch (UnsupportedEncodingException | FileNotFoundException e) {
					//System.out.println("Error 1");
					e.printStackTrace();
				} catch (IOException e) {
					//System.out.println("Error 2");
					e.printStackTrace();
				}
			}
		}
	}

}
