package org.nypl.journalsystem;

import java.util.ArrayList;
import java.util.List;

public class Journal {
	private String name;
	private String publisher;
	private String location;
	private String ISSN;
	private List<Article> articles;
	
	Journal(String name, String publisher, String location, String ISSN){
		this.name = name;
		this.publisher = publisher;
		this.location = location;
		this.ISSN = ISSN;
		this.articles = new ArrayList<Article>();
	}
	
	
	@Override
	public String toString() {
		String output = "name: " + name + "\n";
		output += "publisher: " + publisher + "\n";
		output += "location: " + location + "\n";
		output += "ISSN: " + ISSN + "\n";
		output += "Articles in this journal: \n\t";
		for (Article article: articles) {
			output += article.toString();
			output += "\t";
		}
		return output; 
	}
	
}
