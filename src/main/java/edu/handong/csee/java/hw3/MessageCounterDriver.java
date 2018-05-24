package edu.handong.csee.java.hw3;

import java.util.*;

public class MessageCounterDriver {

	public static void main(String[] args) {
		MessageCounterDriver main = new MessageCounterDriver();
		main.run();
	}

	private void run() {
		System.out.println("Start!");
		
		FileLoader fileLoader = new FileLoader("C:\\Users\\qpalz\\Desktop\\HW3_data");
		
		fileLoader.loadMacFiles();
		fileLoader.loadWindowsFiles();
		
		HashMap<String, ArrayList<NDMdata>> NMmap = fileLoader.getMessages(); 
	
		for(String name : NMmap.keySet()) {
			for(NDMdata ndm : NMmap.get(name)) {
				System.out.println(name+ " " + ndm.getDate() + " " + ndm.getMessage());
			}
		}
	}
}
