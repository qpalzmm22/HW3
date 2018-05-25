package edu.handong.csee.java.hw3;

public class NDMdata {
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
	public boolean equalsTo(NDMdata compare) {
		if((compare.getDate().equals(this.date) && compare.getName().equals(this.name)) && compare.getMessage().equals(this.message))
			return true;
		return false;
	}
	
}
