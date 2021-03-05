package model.logic;

import java.io.File;
import java.io.Reader;
import java.lang.Object;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import model.data_structures.ArregloDinamico;
import model.data_structures.Categoria;
import model.data_structures.IArregloDinamico;
import model.data_structures.ILista;
import model.data_structures.ListaEncadenada;
import model.data_structures.YoutubeVideo;


/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo 
{

	/**
	 * Atributos del modelo del mundo
	 */
	private ILista<YoutubeVideo> datos;
	private ILista<Categoria> categorias;
	

	public Modelo()
	{
		categorias = new ArregloDinamico<Categoria>(50);
		try 
		{
			cargarCategorias();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo(int opcion)
	{
		if (opcion==1)
		{
			datos= new ListaEncadenada<YoutubeVideo>(null) ;
		}
		else
		{
			datos = new ArregloDinamico<YoutubeVideo>(7);
		}
		try
		{
		cargarDatos();
		}
		
		catch(Exception e)
		{
			System.out.println("No se pudieron subir los datos");
		}

	}


	public YoutubeVideo getFirst()
	{
		return datos.firstElement();
	}
	
	public YoutubeVideo getLast()
	{
		return datos.lastElement();
	}
	
	public YoutubeVideo getElement(int pos)
	{
		return datos.getElement(pos);
	}
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.size();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(YoutubeVideo dato)
	{	
		datos.addLast(dato);
	}

	/**
	 * Retorna la suublista con la cantidad de datos entregada en el parametro
	 * @param dato
	 */
	public ILista<YoutubeVideo> sublista(int dato)
	{
		return datos.sublista(dato);
	}
	
	public ILista<Categoria> darCategorias()
	{
		return categorias;
	}
	public void cargarCategorias() throws Exception
	{

		final Reader lector = new InputStreamReader (new FileInputStream(new File("./data/caterory_id.csv")),"UTF-8");
		final CSVParser parser = new CSVParser(lector, CSVFormat.EXCEL.withFirstRecordAsHeader().withDelimiter(','));
		

		try
		{
			for(final CSVRecord record : parser)
			{
				
				String id = record.get("video_id"); 
				Categoria nueva = new Categoria(id);
				categorias.addLast(nueva); 
			}
		}
		catch(Exception e) {System.out.println("algo");}
		finally
		{
			lector.close();
			parser.close();
		}
	}
	public void cargarDatos() throws Exception
	{
		final Reader lector = new InputStreamReader (new FileInputStream(new File("./data/videos-all.csv")),"UTF-8");
		final CSVParser parser = new CSVParser(lector, CSVFormat.EXCEL.withFirstRecordAsHeader().withDelimiter(','));
		
		
		try
		{
			for(final CSVRecord record : parser)
			{
				
				String id = record.get("video_id");
				String fechaTrending = record.get("trending_date");		
				String titulo = record.get("title");
				String canal = record.get("channel_title");
				String categoria = record.get("category_id");
				String publicacion = record.get("publish_time");
				String tageados = record.get("tags");
				String vistas = record.get("views");
				String likes =record.get("likes");
				String dislikes = record.get("dislikes");
				String comentarios = ("comment_count");
				String url = record.get("thumbnail_link");
				String comentariosEnabled = record.get("comments_disabled");
				String ratingsEnabled = record.get("ratings_disabled");
				String erorPosible = record.get("video_error_or_removed");
				String descrip = record.get("description");
				String pais = record.get("country");

				YoutubeVideo nuevo = new YoutubeVideo(id, fechaTrending, titulo, canal, categoria, publicacion, tageados, vistas, likes, dislikes, comentarios, url, comentariosEnabled, ratingsEnabled, erorPosible, descrip, pais);
				datos.addLast(nuevo); 
			}
		}
		catch(Exception e) {System.out.println("algo");}
		finally
		{
			lector.close();
			parser.close();
		}
	}


}
