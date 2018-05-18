package edu.handong.csee.java.hw3;

import java.io.*;

public class MessageParser implements MessageCounter{
	private File fileToParse;
	private String name;
	private int count;
	
	public String getName(String line) {
		return this.name;
	}
	
	public int getCount(String line) {
		return this.count;
	}
}
