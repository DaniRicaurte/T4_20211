package test.Arreglo_dinamico;

import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

import model.data_structures.ArregloDinamico;
import utils.Ordenamiento;

public class test_arreglo_dinamico {
	    public static void main(String[] args) 
	    {
	        ArregloDinamico<Integer> arr = new ArregloDinamico<Integer>(500);
	        for(int i = 0; i < 500; i++)
	        {
	            arr.addLast(ThreadLocalRandom.current().nextInt(0, 900000000));
	        }
	        System.out.println("Agregó");
	        Ordenamiento<Integer> ord = new Ordenamiento<Integer>();
	        Comparator<Integer> comp = new ComparadorInteger();
	        System.out.println("Voy a ordenar");
	        ord.ordenarMerge(arr, comp, true);
	        
	        System.out.println(arr.size());
	        
	        boolean enOrden = true;
	        for(int i = 1; i < arr.size() && enOrden;i++)
	        {
	            if(comp.compare(arr.getElement(i),arr.getElement(i+1))>0)
	                    enOrden = false;
	        }
	        System.out.println(enOrden);
	    }
	    
	    
	    public static class ComparadorInteger implements Comparator<Integer>
	    {

	        @Override
	        public int compare(Integer o1, Integer o2) {
	            return o1.compareTo(o2);
	        }
	        
	    }
	    
	    

}
