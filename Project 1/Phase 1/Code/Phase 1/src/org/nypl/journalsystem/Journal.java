package org.nypl.journalsystem;

public class Journal {
	private String name;
	private Publisher publisher;
	private String ISSN;
	private List<Articles> articles = new ArrayList<Articles>();
	
	Journal(String name, Publisher publisher, String ISSN){
		this.name = name;
		this.publisher = publisher;
		this.ISSN = ISSN;
	}
	
	
	@Override
	public String toString() {
		String output = "name: " + name + "\n";
		output += "publisher: " + publisher + "\n";
		output += "ISSN: " + ISSN + "\n";
		output += "Articles in this journal: \n\t";
		for (Articel article: articles) {
			output += article.toString();
			output += "\t";
		}
		return output; 
	}
	
}
