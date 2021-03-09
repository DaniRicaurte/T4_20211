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
	public static class ComparadorPaisYCategoria implements Comparator<YoutubeVideo>
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
	 * 
	 * Clase comparador por views
	 *
	 */
	
	public static class ComparadorXViews implements Comparaator <YoutubeVideo>
	{
		/**
		 * Retorna cual de los dos videos tiene mas vies. 
		 * @return <0 si el o1 tiene menos likes que el o2. La repsuesta es mayor que 0 si el o1 tiene mas views que o2. 0 si los dos videos tienen los mismos views
		 */
		public int compare(YoutubeVideo o1, YoutubeVideo o2)
	 	{
			int likes1 = Integer.parseInt(o1.darViews());
			int likes2 = Integer.parseInt(o2.darViews());
			return likes1-likes2;
	 	}
	}
	
	public static class ComparadorPais implements Comparator<YoutubeVideo>
	{
		/**
		 * Verifica si los dos videos son del mismo pais.
		 * @retun 0 si los dos videos son del mismo pais. Cualquier otro numero de lo contrario
		 */
		public int compare (YoutubeVideo o1, YoutubeVideo o2)
		{
			return o1.darPais().compareToIgnoreCase(o2.darPais());
		}
	}
	
	public static class ComparadorNombre implements Comparator<YoutubeVideo>
	{
		/**
		 * Verifica si los dos videos son del mismo pais.
		 * @retun 0 si los dos videos son del mismo pais. Cualquier otro numero de lo contrario
		 */
		public int compare (YoutubeVideo o1, YoutubeVideo o2)
		{
			return o1.darTitulo().compareToIgnoreCase(o1.darTitulo());
		}
	}
	
	public static class ComparadorContieneTagYPais implements Comparator<YoutubeVideo>
	{
		/**
		 * Verifica si el video actual (izquierda) contiene el tag del video a comparar (derecha)
		 * @return 0 si el video actual (izquierda) contiene el tag del video a comparar (derecha). 1 de lo cotrario
		 */
		public int compare (YoutubeVideo actual, YoutubeVideo aComparar)
		{
			int rta = 1;
			boolean req1 = actual.darTags().contains(aComparar.darTags());
			boolean req2 = actual.darPais().equalsIgnoreCase(aComparar.darPais());
			if(req1 == true && req2 == true)
			{
				rta = 0;
			}
			return rta;
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
