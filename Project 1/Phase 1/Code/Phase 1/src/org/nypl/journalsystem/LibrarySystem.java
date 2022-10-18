package org.nypl.journalsystem;



import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class LibrarySystem {
	
	//Map<String, Journal> journals = new HashMap<>();
	Map<Integer, String> IDAuthorMap = new HashMap<Integer, String>();
	
	public LibrarySystem() {
		
		//TODO: Initialize system with default journals.
	}
	
	public void load() throws FileNotFoundException, IOException {
		loadAuthors();
		loadArticles();
	}
	
	protected void loadAuthors() throws FileNotFoundException, IOException {
		//File file = new File("data/Authors.csv");

		Reader in = new FileReader("data/Authors.csv");
		
		Iterable<CSVRecord> records = CSVFormat.TDF
												.withFirstRecordAsHeader()
												.withDelimiter(',')
												.parse(in);
		
		for (CSVRecord record : records) {
			String id = record.get("ID");
			String name = record.get("Name");
			//System.out.println("id: " + id + ", name: " + name);
			
			this.IDAuthorMap.put(Integer.parseInt(id), name);
		}
		
		System.out.println(IDAuthorMap);
	}
	
	protected void loadArticles() throws FileNotFoundException, IOException {
		File file = new File("data/Articles.csv");

		//TODO: Load articles from file and assign them to appropriate journal
	}
	
	
	public void listContents() {
		//TODO: Print all journals with their respective articles and authors to the console.
	}
	
	public static final void main(String[] args) throws Exception {
		LibrarySystem librarySystem = new LibrarySystem();
		
		librarySystem.loadAuthors();
		//librarySystem.load();
		//librarySystem.listContents();
	}
}
