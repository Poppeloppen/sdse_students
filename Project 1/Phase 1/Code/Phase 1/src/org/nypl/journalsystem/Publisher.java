package org.nypl.journalsystem;

public class Publisher {
	String publisherName;
	String location;
	
	Publisher(String name, String location){
		this.publisherName = name;
		this.location = location;
	}
	
	
	@Override
	public String toString() {
		return "name: " + publisherName + ", location: "+ location;
	}
}
