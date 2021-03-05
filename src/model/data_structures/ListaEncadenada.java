package model.data_structures;

import java.util.Comparator;

public class ListaEncadenada < T extends Comparable <T>> implements ILista<T>
{

	private NodoListaEncadenada<T> first;
	private NodoListaEncadenada<T> last;

	public ListaEncadenada(NodoListaEncadenada<T> primero)
	{
		first=primero;
		last=primero;
	}

	@Override
	public void addFirst(T elemento) 
	{
		NodoListaEncadenada<T> nuevo= new NodoListaEncadenada<T> (elemento);

		if(first==null)
		{
			first= nuevo;
			last = nuevo;
		} 
		else {
			nuevo.setNext(first);
			first = nuevo;
		}
	}


	public void addLast(T elemento) 
	{
		NodoListaEncadenada<T> nuevo= new NodoListaEncadenada<T> (elemento);

		if(first==null)
		{
			first= nuevo;
		} 

		else 
		{
			last.setNext(nuevo);
		}
		
		last=nuevo;


	}


	public void insertElement(T elemento, int posicion) 
	{
		NodoListaEncadenada<T> nuevo= new NodoListaEncadenada<T> (elemento);
		NodoListaEncadenada<T> actual=first;
		NodoListaEncadenada<T> momentario= null;
		
		if(posicion<=size() && posicion>0)
		{
			int i=1;
			while(i<posicion-1)
			{
				actual=actual.getNext();
				i++;
			}
			momentario= actual.getNext();
			actual.setNext(nuevo);
			nuevo.setNext(momentario);
		}
	}

	@Override
	public T removeFirst() 
	{
		T respuesta=null;
		
		if(first!=null)
		{
			respuesta= first.getInfo();
			first=first.getNext();
		} 

		return respuesta;
	}

	@Override
	public T removeLast() 
	{
		if(first==null){return null;} 


		NodoListaEncadenada<T> ultimoNodo=  first;
		NodoListaEncadenada<T> penultimoNodo=  null;

		while (ultimoNodo.getNext()!=null)
		{
			penultimoNodo=ultimoNodo;
			ultimoNodo=ultimoNodo.getNext();

		}

		last= penultimoNodo;
		penultimoNodo.setNext(null);
		
		return ultimoNodo.getInfo();
	}

	@Override
	public T deleteElement(int posicion) 
	{
		NodoListaEncadenada<T> actual=first;
		NodoListaEncadenada<T> anterior=null;
		
		if(posicion<=size()&&posicion>0)
		{
			int i=1;
			while(i<posicion)
			{
				anterior=actual;
				actual=actual.getNext();
				i++;
			}

			anterior.setNext(actual.getNext());
			
			return actual.getInfo();
		}
		else
			return null;
	}

	@Override
	public T firstElement() 
	{
		if(first==null){return null;} 
		else
			return first.getInfo();
	}

	@Override
	public T lastElement() {

		if(first==null){return null;} 

		else 
			{return last.getInfo();}
	
	}
	
	
	@Override
	public T getElement(int pos) 
	{
		NodoListaEncadenada<T> actual=first;
		if(pos<=size()&& pos>0)
		{
			int i=1;
			while(i<pos)
			{
				actual=actual.getNext();
				i++;
			}

			return actual.getInfo();
		}
		else
			return null;
	}
	
	public NodoListaEncadenada<T> getNodo(int pos)
	{
		NodoListaEncadenada<T> actual=first;
		if(pos<=size()&& pos>0)
		{
			int i=1;
			while(i<pos)
			{
				actual=actual.getNext();
				i++;
			}

			return actual;
		}
		else
			return null;
	}

	@Override
	public int size() 
	{
		int tamanho = 0;
		NodoListaEncadenada<T> actual = first;
		while(actual != null )
		{
			actual = actual.getNext();
			tamanho++;
		}
		return tamanho;
	}

	@Override
	public boolean isEmpty() 
	{
		if(first==null)
		{
			return true;
		}
		else
			return false;
	}

	@Override
	public int isPresent(T element) 
	{
		NodoListaEncadenada<T> actual = first;
		
		int respuesta=-1;
		int posicion=1;
		while(actual != null && respuesta!=-1 )
		{
			if(actual.getInfo().compareTo(element)==0)
			{
				respuesta=posicion;
			}
			actual = actual.getNext();	
			posicion++;

		}
		return posicion;

	}

	
	public void exchange(int pos1, int pos2)
	{
		if(pos1>size() || pos1<1 || pos2>size() || pos2<1 || pos1==pos2)
		{

		}
		else
		{
			T datoPos1 = getNodo(pos1).getInfo();
			T datoPos2 = getNodo(pos2).getInfo();
			getNodo(pos1).cambiarInfo(datoPos2);
			getNodo(pos2).cambiarInfo(datoPos1);
		}
	}

	@Override
	public void changeInfo(int pos, T elemento) 
	{
		NodoListaEncadenada<T> actual = first;

		if (pos<=size() && pos>0)
		{
			int i=1;
			while(i<pos)
			{
				
				actual=actual.getNext();
				i++;
			}
			actual.cambiarInfo(elemento);

		}

	}
	
	public ILista<T> sublista(int numElementos)
	{
		ILista<T> respuesta=null;
		if(numElementos<1)
		{
			System.out.println("El numero no puede ser menor que 1");
			respuesta= null;
		}
		
		else 
		{
			ListaEncadenada<T> resp = new ListaEncadenada<T>(first);
			int hastaDonde = numElementos;
			if(numElementos>size())
			{
				hastaDonde = size();
			}
			resp.getNodo(hastaDonde).setNext(null);
			respuesta= resp;
		}
		return respuesta;
	}

	@Override
	public ILista<T> subList(int posi, int numElementos) 
	{
		System.out.println(posi);
		ILista<T> respuesta=null;
		
		if(numElementos<1 || posi<1)
		{
			System.out.println("Alguno de los parametros esta mal");
			return null;
		}
		else if(posi<=size())
		{
			NodoListaEncadenada<T> actual = getNodo(posi);
			ListaEncadenada<T> resp= new ListaEncadenada<T>(null);
			for(int i = 1; i<=numElementos && actual!=null;i++)
			{
				resp.addLast(actual.getInfo());
				actual=actual.getNext();
			}
			respuesta= resp;
		}
		return respuesta;
	}

}
