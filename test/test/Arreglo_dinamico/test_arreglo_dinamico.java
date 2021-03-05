package test.Arreglo_dinamico;

import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

import model.data_structures.ArregloDinamico;
import utils.Ordenamiento;

public class test_arreglo_dinamico {
	    public static void main(String[] args) 
	    {
	        ArregloDinamico<String> arr = new ArregloDinamico<String>(500);
	        for(int i = 0; i < 18; i++)
	        {
	        	int numero = ThreadLocalRandom.current().nextInt(0, 8);
	        	String mensaje = "impar";
	        	if(numero%2==0)
	        	{
	        		mensaje = "par";
	        	}
	            arr.addLast(numero+"/"+mensaje);
	            System.out.println(arr.getElement(i+1));
	        }
	        System.out.println("Agregó");
	        String aBuscar = "6/impar";
	        Comparator<String> comp2 = new ComparadorString();
	        Ordenamiento<String> ord = new Ordenamiento<String>();
	        Comparator<String> comp = new ComparadorInteger();
	        System.out.println("Voy a ordenar");
	        ArregloDinamico<String> ord2 = arr.sublistaR1(comp, aBuscar);
	        System.out.println("Agregados");
	        ord.ordenarMerge(ord2, comp2, true);
	        for(int i = 1; i<=ord2.size();i++)
	        {
	        	System.out.println(ord2.getElement(i));
	        }
//	        System.out.println(arr.size());
	        System.out.println("Cual es el mayor?");
	        String revisar = ord2.mayorContado(comp2);
	        System.out.println(revisar);
//	        boolean enOrden = true;
//	        for(int i = 1; i < arr.size() && enOrden;i++)
//	        {
//	            if(comp.compare(arr.getElement(i),arr.getElement(i+1))>0)
//	                    enOrden = false;
//	        }
//	        System.out.println(enOrden);
	    }
	    
	    
	    public static class ComparadorInteger implements Comparator<String>
	    {

	        @Override
	        public int compare(String o1, String o2) 
	        {
	        	String[] partes1 = o1.split("/");
	        	String[] partes2 = o2.split("/");
	            return partes1[1].compareTo(partes2[1]);	        }

	    }
	    
	    public static class ComparadorString implements Comparator<String>
	    {
	    	
	    	public int compare(String o1, String o2)
	    	{
	    		String[] partes1 = o1.split("/");
	    		int n1 = Integer.parseInt(partes1[0]);
	        	String[] partes2 = o2.split("/");
	        	int n2 = Integer.parseInt(partes2[0]);
	            return n1-n2;
	    	}
	    }
	    
	    

}
