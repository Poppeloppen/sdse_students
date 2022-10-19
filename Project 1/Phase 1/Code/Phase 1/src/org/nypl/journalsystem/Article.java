package org.nypl.journalsystem;

import java.util.List;

public class Article {
	String title;
	List<String> authors;
	
	Article(String title, List<String> authors){
		this.title = title;
		this.authors = authors;
	}
	
	
	
	public List<String> getAuthors() {
		return authors;
	}



	public void putAuthors(String author) {
		this.authors.add(author);
	}



	@Override
	public String toString() {
		String output = "Title: " + title + "\n\t";
		output += "Authors: \n\t";
		for (String author: authors) {
			output += "\t" + author + "\n"; 
		}
		return output;
	}
}
