package com.sdzee.bdd;

public class Article
{
	protected int idArticle;
	protected String title;
	protected String text;
	protected String image;
	protected java.sql.Date dateOfEdition;
	protected java.sql.Time timeOfEdition;
	protected String author;
	
	public Article() {};
	
	public Article(int idArticleToSet, String titleToSet, String textToSet, String imageToSet, java.sql.Date dateOfEditionToSet,
			java.sql.Time timeOfEditionToSet, String authorToSet)
	{
		this.idArticle = idArticleToSet;
		this.title = titleToSet;
		this.text = textToSet;
		this.image = imageToSet;
		this.dateOfEdition = dateOfEditionToSet;
		this.timeOfEdition = timeOfEditionToSet;
		this.author = authorToSet;
	}

	public String getImage()
	{
		return (this.image);
	}
	
	public int getIdArticle()
	{
		return (this.idArticle);
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
