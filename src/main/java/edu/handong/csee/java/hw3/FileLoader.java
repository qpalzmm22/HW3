package edu.handong.csee.java.hw3;

import java.util.*;
import java.io.*;

 /**
  * This class gets path as a parameter and provides tools to sort them by mac file 
  * and windows file. 
  * @author qpalzmm22
  *
  */
public class FileLoader {
	private File directory = null;
	
	public FileLoader(String path) {
		File directory = new File(path);
	}
	
	
	public void loadMacFiles(ArrayList<File> macFileList) {
		for(File file: directory.listFiles()) {
			if(file.getName().contains(".csv"))
				macFileList.add(file);
		}
	}
	public void loadWindowsFiles(ArrayList<File> windowsFileList) {
		for(File file: directory.listFiles()) {
			if(file.getName().contains(".txt"))
				windowsFileList.add(file);
		}
	}

}
