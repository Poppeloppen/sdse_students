package org.nypl.journalsystem;



import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class LibrarySystem {
	
	List<Journal> journals;
	Map<Integer, String> IDAuthorMap;
	
	
	
	public LibrarySystem() {
		//TODO: Initialize system with default journals.
		journals = new ArrayList<Journal>();
		IDAuthorMap = new HashMap<Integer, String>();
		journals.add(new Journal("Higher Education", "Springer", "Germany", "0018-1560"));
		
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
			
			this.IDAuthorMap.put(Integer.parseInt(id), name);
		}
		
		//System.out.println(IDAuthorMap);
		System.out.println(journals.get(0));
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
