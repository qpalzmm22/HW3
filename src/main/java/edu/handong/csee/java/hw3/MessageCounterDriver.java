package edu.handong.csee.java.hw3;

import java.util.*;

public class MessageCounterDriver {

	public static void main(String[] args) {
		MessageCounterDriver main = new MessageCounterDriver();
		main.run(args[1], args[3]);
	}

	private void run(String inputPath, String outputPath) {
		System.out.println("Start!");
		
		FileLoader fileLoader = new FileLoader(inputPath);
		
		fileLoader.loadMacFiles();
		fileLoader.loadWindowsFiles();
		System.out.println("------Loading Complete------");
		
		
		HashMap<String, ArrayList<NDMdata>> NMlist = fileLoader.getMessages();
		List<NMcount> ncList = new ArrayList<NMcount>();

		for(String name : NMlist.keySet()) {
			if(!name.equals(""))
				ncList.add(new NMcount(name, NMlist.get(name).size()));	
		}
		Collections.sort(ncList);
		
		FileExporter fileExporter = new FileExporter(outputPath);
		fileExporter.makeItCSVFile(ncList);
		System.out.println("------Exporting Complete------");
	}
}
