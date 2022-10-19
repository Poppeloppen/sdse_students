package org.nypl.journalsystem;


import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class LibrarySystem {
	
	Map<String, Journal> journals;
	Map<Integer, String> IDAuthorMap;
	
	public LibrarySystem() {
		//Initialize system with default journals.
		journals = new HashMap<String, Journal>();
		IDAuthorMap = new HashMap<Integer, String>();
		journals.put("0018-1560", new Journal("Higher Education", "Springer", "Germany", "0018-1560"));
		journals.put("0346-2511", new Journal("System", "Elsevier", "Netherlands", "0346-2511"));
		journals.put("2451-9294", new Journal("Chem", "Elsevier", "Netherlands", "2451-9294"));
		journals.put("1476-4687", new Journal("Nature", "Nature Research", "Great Britain", "1476-4687"));
		journals.put("0147-2011", new Journal("Society", "Springer", "Germany", "0147-2011"));
	}
	
	public void load() throws FileNotFoundException, IOException {
		loadAuthors();
		loadArticles();
	}
	
	protected void loadAuthors() throws FileNotFoundException, IOException {
		Reader in = new FileReader("data/Authors.csv");
		
		Iterable<CSVRecord> records = CSVFormat.TDF
												.withFirstRecordAsHeader()
												.withDelimiter(',')
												.parse(in);
		
		for (CSVRecord record : records) {
			String authorID = record.get("ID");
			String name = record.get("Name");
			
			this.IDAuthorMap.put(Integer.parseInt(authorID), name);
			
		}
	}
	
	protected void loadArticles() throws FileNotFoundException, IOException {
		//Load articles from file and assign them to appropriate journal
		Reader in = new FileReader("data/Articles.csv");
		
		Iterable<CSVRecord> articleRecords = CSVFormat.TDF
												.withFirstRecordAsHeader()
												.withDelimiter(',')
												.parse(in);
		
		for (CSVRecord record : articleRecords) {
			//String articleID = record.get("ID");
			String title = record.get("Title");
			String stringAuthorIDs = record.get("AuthorIDs");
			String issn = record.get("ISSN");
			
			//Get rid of square brackets and spaces in the string of AuthorIDs
			String cleanStringAuthorIDs = stringAuthorIDs.replaceAll("^\\[|]$|[\" \"]", "");
			//Convert the cleaned string of authorIDs to an arraylist
			List<String> authorIDs = new ArrayList<String>(Arrays.asList(cleanStringAuthorIDs.split(";")));
			
			List<String> authors = new ArrayList<String>();
			for (String authorID : authorIDs) {
				int authID = Integer.parseInt(authorID);
				String authorName = this.IDAuthorMap.get(authID);
				authors.add(authorName);
			}
			
			
			Article article = new Article(title, authors);
			if (journals.containsKey(issn)) {
				this.journals.get(issn).putArticle(article);
			}
			
		}

	}
	
	
	public void listContents() {
		//Print all journals with their respective articles and authors to the console.
		for (Journal journal : this.journals.values()) {
			System.out.println("--".repeat(20));
			if (!journal.fullIssue()) {
				System.out.println("WARNING, NOT FULL ISSUE");
			}
			System.out.println(journal);
		}
	}
	
	
	public static final void main(String[] args) throws Exception {
		LibrarySystem librarySystem = new LibrarySystem();
		
		librarySystem.load();
		librarySystem.listContents();
	}
}
