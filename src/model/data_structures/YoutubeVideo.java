package model.data_structures;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;


public class YoutubeVideo implements Comparable<YoutubeVideo>
{
	private String id;
	
	private String trending;
	
	private String title;
	
	private String channel;

	private String categoria;
	
	private String published;
	
	private String tags;
	
	private String views;
	
	private String likes;
	
	private String dislikes;
	
	private String comments;
	
	private String link;
	
	private String comEnabled;
	
	private String ratEnabled;
	
	private String errorRemoved;
	
	private String description;
	
	private String pais;
	
	
	public YoutubeVideo(String pId, String pTrending, String pTitle, String pChannel, String pCategoria, String pPublished, String pTags, String pViews, String pLikes, String pDislikes, String pComments, String pLink, String pComEnabled, String pRatEnabled, String pErrorRemoved, String pDescription, String pPais)
	{
		id = pId;
		trending = pTrending;
		title = pTitle;
		channel = pChannel;
		categoria = pCategoria;
		published = pPublished;
		tags = pTags;
		views = pViews;
		likes = pLikes;
		dislikes = pDislikes;
		comments = pComments;
		link = pLink;
		comEnabled = pComEnabled;
		ratEnabled = pRatEnabled;
		errorRemoved = pErrorRemoved;
		description = pDescription;
		pais = pPais;
		
	}
	
	public String darLikes()
	{
		return likes;
	}
	
	public String darTrending()
	{
		return trending;
	}
	
	public int compareTo(YoutubeVideo otro)
	{
		int rta = 0;
		try
		{
			Date fechaEste = new SimpleDateFormat("yy.dd.MM").parse(trending);
			Date fechaOtro = new SimpleDateFormat("yy.dd.MM").parse(otro.darTrending());
			rta = fechaEste.compareTo(fechaOtro);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		return rta;
	}
	
	public static class ComparadorXLikes implements Comparator<YoutubeVideo>
	{
		public int compare(YoutubeVideo video1, YoutubeVideo video2)
		{
			int likes1 = Integer.parseInt(video1.darLikes());
			int likes2 = Integer.parseInt(video2.darLikes());
			return likes1-likes2;
		}
	}
	
	
	public String darTitulo()
	{
		return title;
	}
	public String darCanal()
	{
		return channel;
	}
	
	public int darCategoria()
	{
		return Integer.parseInt(categoria);
	}
	public String darPais()
	{
		return pais;
	}
	public String darPublishTime()
	{
		return published;
	}
	public String darViews()
	{
		return views;
	}
	public String darDilikes()
	{
		return dislikes;
	}
	
	public String darTags()
	{
		return tags;
	}
	
}
