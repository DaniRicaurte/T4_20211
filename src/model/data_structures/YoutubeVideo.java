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
	
	/**
	 * Clase con comparador para likes
	 * @author Juanse
	 *
	 */
	public static class ComparadorXLikes implements Comparator<YoutubeVideo>
	{
		/**
		 * Retorna cual de los dos videos tiene mas likes. 
		 * @return <0 si el video1 tiene menos likes que el video2. <0 si el video1 tiene mas likes que el video2. 0 si los dos videos tienen los mismos likes
		 */
		public int compare(YoutubeVideo video1, YoutubeVideo video2)
		{
			int likes1 = Integer.parseInt(video1.darLikes());
			int likes2 = Integer.parseInt(video2.darLikes());
			return likes1-likes2;
		}
	}
	
	/**
	 * Clase con comparador de Pais y Categoria
	 * @author Juanse
	 *
	 */
	public static class ComparadorPaisyCategoria implements Comparator<YoutubeVideo>
	{
		/**
		 * Verifica si los dos videos son del mismo pais y categoria
		 * @return 0 si los dos videos son del mismo pais y categoria. 1 de lo contrario
		 */
		public int compare(YoutubeVideo o1, YoutubeVideo o2)
	 	{
	 		int rta = 1;
	 		int condicion1 = o1.darPais().compareToIgnoreCase(o2.darPais());
	 		int condicion2 = o1.darCategoria()-o2.darCategoria();
			if(condicion1 == 0 && condicion2 == 0 )
			{
				rta = 0;
			}
			return 1;	
	 	} 		
	}	
	
	
	/**
	 * Clase con comparador de categoria
	 * @author Juanse
	 *
	 */
	public static class ComparadorCategoria implements Comparator<YoutubeVideo>
	{
		/**
		 * Verifica si los dos videos son de la misma categoria.
		 * @return 0 si los dos videos son de la misma categoria. Cualquier otro numero de lo contrario
		 */
		public int compare (YoutubeVideo o1, YoutubeVideo o2)
		{
			return o1.darCategoria()-o2.darCategoria();
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
	public String darDislikes()
	{
		return dislikes;
	}
	
	public String darTags()
	{
		return tags;
	}
	
	public String toString()
	{
		return title+":::"+channel+":::"+published+":::"+views+":::"+likes+":::"+dislikes+tags+":::"+id;
	}
	
}
