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
		
		
		HashMap<String, ArrayList<NDMdata>> NMlist = fileLoader.getMessages();
		List<NMcount> nmCount = new ArrayList<NMcount>();

		for(String name : NMlist.keySet()) {
			
			nmCount.add(new NMcount(name, NMlist.get(name).size()));
			
			//System.out.println(name + " " + NMlist.get(name).size());
			//for(NDMdata ndm : NMlist.get(name)) {
				//System.out.println(name+ " " + ndm.getDate() + " " + ndm.getMessage());
			//}
		}
		
		Collections.sort(nmCount);
		
		for(NMcount e : nmCount) {
			e.print();
		}
	}
}
