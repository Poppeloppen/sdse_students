package org.nypl.journalsystem;

public class Publisher {
	String PublisherName;
	String location;
	
	Publisher(String name, String location){
		this.PublisherName = name;
		this.location = location;
	}
	
	
	@Override
	public String toString() {
		return "name: " + PublisherName + ", location: "+ location;
	}
}
