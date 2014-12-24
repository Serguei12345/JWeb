package com.sdzee.bdd;

public class Article
{
	private String title;
	private String text;
	private java.sql.Date dateOfEdition;
	private java.sql.Time timeOfEdition;
	private String author;
	
	public Article() {};
	
	public Article(String titleToSet, String textToSet, java.sql.Date dateOfEditionToSet,
			java.sql.Time timeOfEditionToSet, String authorToSet)
	{
		this.title = titleToSet;
		this.text = textToSet;
		this.dateOfEdition = dateOfEditionToSet;
		this.timeOfEdition = timeOfEditionToSet;
		this.author = authorToSet;
	}

	public String getTitle()
	{
		return (this.title);
	}
	
	public String getText()
	{
		return (this.text);
	}
	
	public java.sql.Date getDateOfEdition()
	{
		return (this.dateOfEdition);
	}
	
	public java.sql.Time getTimeOfEdition()
	{
		return (this.timeOfEdition);
	}
	
	public String getAuthor()
	{
		return (this.author);
	}
}
