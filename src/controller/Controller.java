package controller;

import java.util.Comparator;
import java.util.Scanner;

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
		ILista<YoutubeVideo> sub = null;

		while( !fin ){


			view.printMenu();
			modelo=new Modelo();
			modelo = new Modelo(2);

			int tamanho= modelo.darTamano();	
			YoutubeVideo primero=modelo.getFirst();

			view.printMessage("El número de videos subidos es: "+ tamanho);
			view.printMessage("");
			view.printMessage("La informacion del primer video es: ");
			view.printMessage("Titulo: "+ primero.darTitulo()+ "Canal: "+ primero.darCanal()+"Dia que fue trending: "+ primero.darTrending()+"Pais: "+primero.darPais()+"Numero de views: "+primero.darViews()+"Numero de likes"+ primero.darLikes()+ "Numero de dislikes: " primero.darDislikes()); 
			view.printMessage("");
			view.printMessage("La lista de las categorias cargadas es:");
			for (int i=0; i<modelo.darNumeroDeCategorias();i++)
			{
				view.printMessage(modelo.darCategorias().getElement(i).darId());
			}

			view.printMenu2();

			int opcion = lector.nextInt();
			switch (opcion)
			{
			case 1:
				String opcion1= lector.nextLine();
				String[] retornado = opcion1.split(",");
				view.printMessage("Se desea conocer cuales son los " + retornado[0] + "viedeos con mas views que son tendencia en el pais"+ retornado[1]+ "en la categoria numero "+ retornado[2]);
				ILista<YoutubeVideo> lista1 =modelo.videosConMasViewsEnTendenciaDeUnPaisDadaUnaCategoria(retornado[0], retornado[2], retornado[2]);
				view.printMessage("Los videos son: ");
				for(int i=0;i<Integer.parseInt(retornado[0]); i++)
				{
					view.printMessage("   La fecha trending es: "+ lista1.getElement(i).darTrending());
					view.printMessage("   El titulo es: "+lista1.getElement(i).darTitulo());
					view.printMessage("   El canal es: " + lista1.getElement(i).darCanal());
					view.printMessage("   La fecha de publicacion es: " + lista1.getElement(i).darPublishTime());
					view.printMessage("   El numero de views es: "+ lista1.getElement(i).darViews());
					view.printMessage("   El numero de likes es: "+ lista1.getElement(i).darLikes());
					view.printMessage("   El numeor de dislikes es:" + lista1.getElement(i).darDislikes());
				}

			case 2:
				String opcion2= lector.nextLine().trim();
				view.printMessage("Se quiere conocer cual es el video que mas dias ha sido trending para el pais: " + opcion2);
				String cantidad= modelo.diasTrendingPais(opcion2);
				YoutubeVideo video2= modelo.videoTrendingParaUnPais();
			
				
				view.printMessage("El video es: " );
				view.printMessage("   Titulo: "+ video2.darTitulo());
				view.printMessage("   Canal: " + video2.darCanal());
				view.printMessage("   Pais: " + video2.darPais());
				view.printMessage("   El numero de dias que fue trending es: "+ cantidad );

			case 3:
				String opcion3=lector.nextLine().trim();
				view.printMessage("Se quiere conocer cual es el video que mas dias ha sido trending para la categoria: " + opcion3);
				String video3= modelo.diasTrendingPais(opcion3);
				YoutubeVideo videos3 =modelo.videoTrendingCategoria();
				view.printMessage("El video es: ");
				view.printMessage("   Titulo: "+ videos3.darTitulo());
				view.printMessage("   Canal: " +videos3.darCanal());
				view.printMessage("   Id de categoria: " + videos3.darCategoria());
				view.printMessage("   El numero de dias que fue trending es: "+ video3);

			case 4:
				String opcion4= lector.nextLine();
				String[] retornado1 = opcion4.split(",");
				view.printMessage("Se desea conocer cuales son los " + retornado1[0] + "videos con mas likes en el pais"+ retornado1[1]+ ", con el tag"+ retornado1[2]);
				ILista<YoutubeVideo> lista4 =modelo.videosConMasLikesEnUnPaisConUnTag(retornado[0], retornado[2], retornado[2]);
				view.printMessage("Los videos son: ");
				for(int i=0;i<Integer.parseInt(retornado1[0]); i++)
				{
					view.printMessage("   El titulo es: "+ lista4.getElement(i).darTitulo());
					view.printMessage("   El canal es: " + lista4.getElement(i).darCanal());
					view.printMessage("   La fecha de publicacion es: " + lista4.getElement(i).darPublishTime());
					view.printMessage("   El numero de views es: "+ lista4.getElement(i).darViews() );
					view.printMessage("   El numero de likes es: "+ lista4.getElement(i).darLikes());
					view.printMessage("   El numeor de dislikes es:" + lista4.getElement(i).darDislikes());
					view.printMessage("   Los tags del video son: " + lista4.getElement(i).darTags());
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