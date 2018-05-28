package edu.handong.csee.java.hw3;

import java.util.ArrayList;
import java.util.HashMap;

public class FileParser {
	private HashMap<String, ArrayList<NDMdata>> messages = new HashMap<String, ArrayList<NDMdata>>();
	
	protected HashMap<String, ArrayList<NDMdata>> addUnique(HashMap<String, ArrayList<NDMdata>> hashMap, NDMdata data){
		for(String name : hashMap.keySet()) {
			for(NDMdata e: hashMap.get(name)) {
				if(e.equalsTo(data))
					return hashMap;
				
			}
		}
		hashMap.get(data.getName()).add(data);
		return hashMap; 
	}

}
