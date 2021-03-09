package controller;

import java.util.Comparator;
import java.util.Scanner;

import model.data_structures.ArregloDinamico;
import model.data_structures.ILista;
import model.data_structures.YoutubeVideo;
import model.logic.Cronometro;
import model.logic.Modelo;
import utils.Ordenamiento;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";
		Ordenamiento<YoutubeVideo> ordenador = new Ordenamiento<YoutubeVideo>();
		Comparator<YoutubeVideo> criterio = new YoutubeVideo.ComparadorXLikes();
		Comparator<YoutubeVideo> criterio2 = new YoutubeVideo.ComparadorXViews();
		Comparator<YoutubeVideo> criterio3 = new YoutubeVideo.ComparadorNombre();
		ILista<YoutubeVideo> sub = null;
		ArregloDinamico<YoutubeVideo> lista0 = null;
		ArregloDinamico<YoutubeVideo> lista1= null;
		ArregloDinamico<YoutubeVideo> lista2 = null;

		while( !fin ){


			view.printMenu();
			modelo=new Modelo();
			lista0 = modelo.darDatos();
			view.printMessage("cargo l0");
			lista1 = modelo.darDatos();
			view.printMessage("cargo l1");
			lista2 = modelo.darDatos();
			view.printMessage("Cargo l2");
			ordenador.ordenarMerge(lista1, criterio2, false);
			ordenador.ordenarMerge(lista2, criterio, false);
			ordenador.ordenarMerge(lista0, criterio3, true);
			

			int tamanho= modelo.darTamano();	
			YoutubeVideo primero = modelo.getFirst();

			view.printMessage("El número de videos subidos es: "+ tamanho);
			view.printMessage("");
			view.printMessage("La informacion del primer video es: ");
			view.printMessage("Titulo: "+ primero.darTitulo()+ "Canal: "+ primero.darCanal()+"Dia que fue trending: "+ primero.darTrending()+"Pais: "+primero.darPais()+"Numero de views: "+primero.darViews()+"Numero de likes: "+ primero.darLikes()+ "Numero de dislikes: "+ primero.darDislikes()); 
			view.printMessage("");
			view.printMessage("La lista de las categorias cargadas es:");
			for (int i=1; i<modelo.darNumeroDeCategorias();i++)
			{
				String buscar =modelo.darCategorias().getElement(i).darId();
				view.printMessage(buscar);
			}

			view.printMenu2();

			int opcion = lector.nextInt();
			switch (opcion)
			{
			case 1:
				view.printMenu1_1();
				String opcion1= lector.next();
				String[] retornado = opcion1.split(",");
				view.printMessage("Se desea conocer cuales son los " + retornado[0] + "videos con mas views que son tendencia en el pais "+ retornado[1]+ " en la categoria numero "+ retornado[2]);
				YoutubeVideo videoComparar= new YoutubeVideo (retornado[2],"" ,"" ,"" ,"" ,"" ,"" , "","" ,"" ,"" ,"" ,"" ,"" ,"" ,"" , retornado[1]);
				Comparator<YoutubeVideo> comparadorR1 = new YoutubeVideo.ComparadorPaisYCategoria();
				ArregloDinamico<YoutubeVideo> rta = lista1.sublistaR1(comparadorR1,videoComparar);
				view.printMessage("Los videos son: ");
				for(int i=0;i<Integer.parseInt(retornado[0]); i++)
				{
					view.printMessage("   La fecha trending es: "+ rta.getElement(i).darTrending());
					view.printMessage("   El titulo es: "+rta.getElement(i).darTitulo());
					view.printMessage("   El canal es: " + rta.getElement(i).darCanal());
					view.printMessage("   La fecha de publicacion es: " + rta.getElement(i).darPublishTime());
					view.printMessage("   El numero de views es: "+ rta.getElement(i).darViews());
					view.printMessage("   El numero de likes es: "+ rta.getElement(i).darLikes());
					view.printMessage("   El numero de dislikes es:" + rta.getElement(i).darDislikes());
				}

			case 2:
				view.printMenu1_2();
				String opcion2= lector.nextLine().trim();
				view.printMessage("Se quiere conocer cual es el video que mas dias ha sido trending para el pais: " + opcion2);
				YoutubeVideo aComparar = new YoutubeVideo("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", opcion2);
				Comparator<YoutubeVideo> comparadorR2 = new YoutubeVideo.ComparadorPais();
				ArregloDinamico<YoutubeVideo> listaRta = lista0.sublistaR1(comparadorR2, aComparar);
				String rtaLarga = listaRta.mayorContado(criterio3);
				String[] partes1 = rtaLarga.split("///");
				String[] partes2 = partes1[0].split(":::");
				String titu = partes2[0];
				String canal = partes2[1];
				String pais = partes2[2];
				view.printMessage("El video es: " );
				view.printMessage("   Titulo: "+ titu);
				view.printMessage("   Canal: " + canal);
				view.printMessage("   Pais: " + pais);
				view.printMessage("   El numero de dias que fue trending es: "+ partes1[1] );

			case 3:
				view.printMenu1_3();
				String opcion3=lector.nextLine().trim();
				view.printMessage("Se quiere conocer cual es el video que mas dias ha sido trending para la categoria: " + opcion3);
				YoutubeVideo ejemplo = new YoutubeVideo(opcion3, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
				Comparator<YoutubeVideo> comparadorR3 = new YoutubeVideo.ComparadorCategoria();
				ArregloDinamico<YoutubeVideo> listaRta3 = lista0.sublistaR1(comparadorR3, ejemplo);
				String todaRespuesta = listaRta3.mayorContado(criterio3);
				String[] partesReq1 = todaRespuesta.split("///");
				String[] partesReq2 = todaRespuesta.split(":::");
				String title = partesReq2[0];
				String channel = partesReq2[1];
				String id = partesReq2[3];
				view.printMessage("El video es: ");
				view.printMessage("   Titulo: "+ title);
				view.printMessage("   Canal: " +channel);
				view.printMessage("   Id de categoria: " + id);
				view.printMessage("   El numero de dias que fue trending es: "+ partesReq1[1]);

			case 4:
				view.printMenu1_4();
				String opcion4= lector.nextLine();
				String[] retornado1 = opcion4.split(",");
				view.printMessage("Se desea conocer cuales son los " + retornado1[0] + "videos con mas likes en el pais"+ retornado1[1]+ ", con el tag"+ retornado1[2]);
				YoutubeVideo example = new YoutubeVideo("", "", "", "", "", "", retornado1[2], "", "", "", "", "", "", "", "", "", retornado1[1]);
				Comparator<YoutubeVideo> comparadorR4 = new YoutubeVideo.ComparadorContieneTagYPais();
				ArregloDinamico<YoutubeVideo> listaR4 = lista2.sublistaR1(comparadorR4, example);
				view.printMessage("Los videos son: ");
				for(int i=0;i<Integer.parseInt(retornado1[0]); i++)
				{
					view.printMessage("   El titulo es: "+ listaR4.getElement(i).darTitulo());
					view.printMessage("   El canal es: " + listaR4.getElement(i).darCanal());
					view.printMessage("   La fecha de publicacion es: " + listaR4.getElement(i).darPublishTime());
					view.printMessage("   El numero de views es: "+ listaR4.getElement(i).darViews() );
					view.printMessage("   El numero de likes es: "+ listaR4.getElement(i).darLikes());
					view.printMessage("   El numeor de dislikes es:" + listaR4.getElement(i).darDislikes());
					view.printMessage("   Los tags del video son: " + listaR4.getElement(i).darTags());
				}


			case 0:
				view.printMessage("-------------------- \n Hasta pronto !! \n--------------------"); 
				lector.close();
				fin = true;
				break;

			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}


		}


	}
}