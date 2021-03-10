package model.data_structures;

import java.util.Comparator;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 * @param <T>
 *
 */

public class ArregloDinamico<T extends Comparable<T>> implements ILista<T> {
	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private T[] elementos;

	
	private T mayorContado;
	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	@SuppressWarnings("unchecked")
	public ArregloDinamico( int max )
	{
		elementos = (T[]) new Comparable[max];
		tamanoMax = max;
		tamanoAct = 0;
	}


	public T darMayorContado()
	{
		return mayorContado;
	}
	
	public void addLast( T dato )
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T[ ] copia = elementos;
			elementos = (T[]) new Comparable[tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 

		}
		elementos[tamanoAct] = dato;
		tamanoAct++;

	}	



	/**
	 * Retorna el elemento recibido por parametro
	 * @param el elemento a buscar
	 * @return el elemento buscado, null de lo contrario
	 */
	public T buscar(T dato) {

		// TODO implementar
		T rta = null;
		boolean encontrado = false;
		for(int i = 0 ; i< tamanoAct && !encontrado; i++)
		{
			if(elementos[i].equals(dato))
			{
				rta = elementos[i];
			}
		}
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
		return rta;
	}

	/**
	 * Elimina el elemento recibido por parametro y reorganiza el arreglo
	 * @param dato a eliminar
	 * @return elemento eliminado, null de lo contrario
	 */
	public T eliminar(T dato) {

		// TODO implementar
		T rta = null;
		int pos = 0;
		for(int i = 0;i<tamanoAct;i++)
		{
			if(elementos[i].compareTo(dato)==0)
			{
				pos = i;
				rta = elementos[i];
				elementos[i]=null;
			}
		}
		//Una vez se encuentra la posicion, se desfaza todo el arreglo a partir del eliminado
		for(int j = pos; j<tamanoAct;j++)
		{
			if(j==tamanoAct-1)
			{
				elementos[j]=null;
			}
			else
			{
				elementos[j]=elementos[j+1];
			}
			tamanoAct = tamanoAct-1;

		}
		return rta;

	}



	/**
	 * Da la capacidad
	 */
	public int darCapacidad()
	{
		return tamanoMax;
	}

	/**
	 * Da el tamano actual
	 */
	public int size() 
	{
		return tamanoAct;
	}

	/** 
	 * Da el elemento en la posicion recibida por parametro
	 * @param posicion
	 * @return elemento en la posicion recibida por parametro. Null si la posicion es mayor a al tamanho actual, o s es menor a 0
	 */
	public T getElement(int i)
	{
		// TODO implementar

		if(i > tamanoAct || i<1)
		{
			return null;
		}
		else
		{
			return elementos[i-1];
		}

	}


	/**
	 * Invierte los elementos del arreglo
	 */
	public void invertir()
	{
		T[] copia = elementos; 
		T[] nuevo = (T[]) new Object[tamanoMax]; 
		for(int i = 0; i<tamanoAct;i++) 
		{
			int i_final = tamanoAct - 1 - i; 
			nuevo[i] = elementos[i_final]; 
		}
		elementos = nuevo; 
	}



	@Override
	public void addFirst(T elemento) 
	{
		tamanoAct++;
		if(tamanoAct == tamanoMax)
		{
			tamanoMax = tamanoMax*2;
			T[] copia = elementos;
			elementos = (T[]) new Object[tamanoMax];
			elementos[0]=elemento;
			for(int i = 0;i<tamanoAct;i++)
			{
				elementos[i+1]=copia[i];;
			}
		}
		else
		{
			T[] copia = elementos;
			elementos = (T[]) new Object[tamanoMax];
			elementos[0]=elemento;
			for(int i = 0;i<tamanoAct;i++)
			{
				elementos[i+1]=copia[i];;
			}
		}
		
		// TODO Auto-generated method stub

	}



	@Override
	public void insertElement(T elemento, int puesto) 
	{
		int posicion = puesto-1;
		if(posicion<tamanoAct && 0<=posicion)
		{
			if(tamanoAct==tamanoMax)
			{
				tamanoMax = tamanoMax*2;
				T[] copia = elementos;
				elementos = (T[]) new Comparable[tamanoMax];
				for(int i = 0;i<posicion;i++)
				{
					elementos[i]=copia[i];
				}
				elementos[posicion]=elemento;
				for(int j = posicion;j<tamanoAct;j++)
				{
					elementos[j+1]=copia[j];
				}
			}
			else
			{
				T[] copia = elementos;
				elementos = (T[]) new Comparable[tamanoMax];
				for(int i = 0;i<posicion;i++)
				{
					elementos[i]=copia[i];
				}
				elementos[posicion]=elemento;
				for(int j = posicion;j<tamanoAct;j++)
				{
					elementos[j+1]=copia[j];
				}
			}
			tamanoAct++;
		}

	}



	@Override
	public T removeFirst() 
	{
		T rta = null;
		if(tamanoAct!=0)
		{
			rta = elementos[0];
			T[] copia = elementos;
			elementos = (T[]) new Object[tamanoAct-1];
			for(int i = 1;i<tamanoAct;i++)
			{
				elementos[i-1]=copia[i];
			}
			tamanoAct--;
		}
		return rta;
	}



	@Override
	public T removeLast() 
	{
		T rta =null;
		if(tamanoAct!=0)
		{
			rta = elementos[tamanoAct-1];
			elementos[tamanoAct-1]=null;
			tamanoAct--;
		}
		return rta;
	}



	@Override
	public T deleteElement(int puesto) 
	{
		int posicion = puesto -1;
		T rta = null;
		if(posicion==0)
		{
			rta = removeFirst();
		}
		else if(posicion ==tamanoAct-1)
		{
			rta = removeLast();
		}
		else if(posicion<tamanoAct && 0<posicion)
		{
			rta = elementos[posicion];
			T[] copia = elementos;
			elementos = (T[]) new Object[tamanoMax];
			for(int i = 0; i<posicion;i++)
			{
				elementos[i] = copia[i];
			}
			for(int j = posicion; j<tamanoAct-1;j++)
			{
				elementos[j] = copia[j+1];
			}
			tamanoAct--;
		}
		// TODO Auto-generated method stub
		return rta;
	}



	@Override
	public T firstElement() 
	{
		if(tamanoAct==0)
		{
			return null;
		}
		else
		{
			return elementos[0];
		}
	}



	@Override
	public T lastElement() {
		if(tamanoAct==0)
		{
			return null;
		}
		else
		{
			return elementos[tamanoAct-1];
		}
	}


	@Override
	public boolean isEmpty() {
		if(tamanoAct==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}



	@Override
	public int isPresent(T element) 
	{
		int rta = -1;
		for(int i = 0; i<tamanoAct;i++)
		{
			if(elementos[i].compareTo(element)==0)
			{
				rta = i+1;
			}
		}
		return rta;
	}



	@Override
	public void exchange(int posicion1, int posicion2) 
	{
		int pos1 = posicion1-1;
		int pos2 = posicion2-1;
		if(pos1<tamanoAct && 0<=pos1 && pos2<tamanoAct && 0<=pos2)
		{
			T ele1 = elementos[pos1];
			T ele2 = elementos[pos2];
			elementos[pos1]=ele2;
			elementos[pos2]=ele1;
		}
		// TODO Auto-generated method stub

	}

	/**
	 * Crea una sublista con todos los elementos que sean "iguales" al elemento recibido parametro
	 * @param comparador que revisa si el elemento actual contiene los atributos deseados del elemento recibido por parametro
	 * @param elemento con los elementos con los que se quiere hacer la sublista
	 * @return la sublista con todos los elementos que contienen los elementos deseados, que estan incluidos en el elemento recibido por parametro. 
	 */

	public ArregloDinamico<T> sublistaR1(Comparator<T> comparador, T elemento)
	{
		ArregloDinamico<T> resp = new ArregloDinamico<T>(380000);
		for(int i = 0; i<tamanoAct;i++)
		{
			int comparacion = comparador.compare(elementos[i], elemento);
			if(comparacion==0)
			{
				T act = elementos[i];
				resp.addLast(act);
			}
		}
		
		return resp;
	}

	
	
	/**
	 * Retorna el elemento con mas ocurrencias en una lista ordenada y la cantidad de veces que aparece en la lista
	 * @param comparador que se usa para contar si un elemento cuenta como repetido o no
	 * @return el toString() del elemento con mas ocurrencias unido a la cantidad de veces que aparece en la lista usando "///". Si el tamanoAct del arreglo es 0 retorna un mensaje vacio
	 */
	public String mayorContado(Comparator<T> comparador)
	{
		String respuesta ="";
		if(tamanoAct != 0)
		{
			T elementoAct = elementos[0];
			T elementoMayor = elementoAct;
			int cantAct = 1;
			int cantMayor = cantAct;
			for(int i = 1; i<tamanoAct; i++)
			{
				if(comparador.compare(elementoAct,elementos[i])==0)
				{
					cantAct++;
					
				}
				else
				{
					if(cantAct>cantMayor)
					{
						cantMayor = cantAct;
						elementoMayor = elementoAct;
					}
					cantAct = 1;
					elementoAct = elementos[i];
				}
			}
			if(cantAct>cantMayor)
			{
				cantMayor = cantAct;
				elementoMayor = elementoAct;
			}
			respuesta = elementoMayor.toString()+"///"+cantMayor;
		}
		return respuesta;
	}
	
	
	

	@Override
	public void changeInfo(int pos, T elemento) 
	{
		int posicion = pos-1;
		if(posicion<tamanoAct && 0<=posicion)
		{
			elementos[posicion] = elemento;
		}

	}
	
	public ILista<T> sublista(int numElementos)
	{
		if(numElementos<1)
		{
			System.out.println("El numero no puede ser negativo");
			return null;
		}
		else
		{
			ArregloDinamico<T> resp = new ArregloDinamico<T>(numElementos);
			if(numElementos>=tamanoAct)
			{
				resp = this;
			}
			else
			{
				for(int i = 0; i<numElementos;i++)
				{
					resp.addLast(elementos[i]);;
				}
			}
			return resp;
		}
	}
	


	public ILista<T> subList(int posi, int numElementos) 
	{
		ILista<T> respuesta=null;
		if(numElementos <1 || posi<1 || posi > tamanoAct)
		{
			System.out.println("Uno de los parametros esta mal");
			respuesta= null;
		}
		else 
		{
			ArregloDinamico<T> resp = new ArregloDinamico<T>(numElementos);
			int total=0;
	
			
			for(int i = posi-1; total<numElementos&& i<tamanoAct;i++)
			{
				resp.addLast(elementos[i]);
				total++;
			}
			respuesta= resp;
		}
		return respuesta;
	}

	

}
