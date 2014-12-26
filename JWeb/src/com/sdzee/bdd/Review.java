package com.sdzee.bdd;

public class Review extends Article
{
	private String objectName;
	
	public Review()
	{
		
	}
	
	public	Review(int idArticleToSet, String titleToSet, String textToSet, String imageToSet, java.sql.Date dateOfEditionToSet,
			java.sql.Time timeOfEditionToSet, String authorToSet, String objectNameToSet)
	{
		this.idArticle = idArticleToSet;
		this.title = titleToSet;
		this.text = textToSet;
		this.image = imageToSet;
		this.dateOfEdition = dateOfEditionToSet;
		this.timeOfEdition = timeOfEditionToSet;
		this.author = authorToSet;
		this.objectName = objectNameToSet;
	}
	
	public String getObjectName()
	{
		return (this.objectName);
	}
}
