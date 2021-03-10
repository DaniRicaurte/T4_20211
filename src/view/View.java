package view;

import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
	    public void printMenu()
		{
			System.out.println("Se carga la información de todos los archivos de videos y de categorias:");
		}
	    
	    public void printMenu2()
		{
			System.out.println("1. Se desea concocer los n videos con más views que son tendencia en un determinado país, dada una categoria especifica");
			System.out.println("2. Se desea conocer cual es el video que más días ha sido trending para un país especifico");
			System.out.println("3. Se desea conocer cual es el video que mas dias ha sido trending una categoria especifica");
			System.out.println("4. Se desea conocer cuales con los n videos diferentes con mas likes en un paid con un tag especifico");
			System.out.println("0. Exit");
			System.out.println("Dar un número mayor a cero para el tamaño de la lista de la muestra de videos cargada, teclear 0 si quiere exit , luego oprimir tecla Return: (e.g., 135):");		
		}
	    
	    public void printMenu1_1()
		{
			System.out.println("Escriba la siguiente infoermacion separada por comas, sin espacios y en el mismo orden, y luego oprima enter");
			System.out.println("- Numero de videos (debe de ser mayor a 0)");
			System.out.println("- Pais de los videos");
			System.out.println("- Categoria de los videos");
					
		}
	    
	    public void printMenu1_2()
	    {
	    	System.out.println("Escriba el nombre del pais, y luego oprima enter");
			
	    }
	    
	    public void printMenu1_3()
	    {
	    	System.out.println("Escriba el numero de la categoria, y luego oprima enter");
			
	    }

	    public void printMenu1_4()
	    {
	    	System.out.println("Escriba la siguiente infoermacion separada por comas, sin espacios y en el mismo orden, y luego oprima enter");
	    	System.out.println("- Numero de videos (debe de ser mayor a 0)");
			System.out.println("- Pais de los videos");
			System.out.println("- Un tag de los videos");
	    }
	    

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(Modelo modelo)
		{
			System.out.println(modelo);
			// TODO implementar
		}
}
