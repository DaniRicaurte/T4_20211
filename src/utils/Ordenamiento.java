package utils;

import java.util.Comparator;


import model.data_structures.ILista;

public class Ordenamiento<T extends Comparable<T>>
{

	public void ordenarInsecion(ILista<T> lista, Comparator<T> criterio, boolean ascendente)
	{
		for(int i = 2; i<=lista.size();i++)
		{
			boolean enPosicion = false;
			for(int j = i; j>1 && !enPosicion; j--)
			{
				int comparacion = (ascendente?1:-1)*criterio.compare(lista.getElement(j), lista.getElement(j-1));
				if(comparacion<0)
				{
					lista.exchange(j, j-1);
				}
				else
				{
					enPosicion = true;
				}
			}
		}
	}
	
	public void ordenarShell(ILista<T> lista, Comparator<T> criterio, boolean ascendente)
	{
		int n = lista.size();
		int h = 1;
		
		while(h<(n/3))
		{
			h=3*h+1;
		}
		
		while(h>=1)
		{
			for(int i = h+1;i<n;i++)
			{
				boolean enPosicion = false;
				for(int j = i;j>h && !enPosicion; j-=h)
				{
					int comparacion = (ascendente?1:-1)* criterio.compare(lista.getElement(j), lista.getElement(j-h));
					if(comparacion<0)
					{
						lista.exchange(j, j-h);
					}
					else
					{
						enPosicion = true;
					}
				}
			}
			h/=3;
		}
	}
	
	public void ordenarQuickSort(ILista<T> lista, Comparator<T> criterio, boolean ascendente)
	{
		sort(lista, criterio, ascendente, 1, lista.size());
	}
	
	private void sort(ILista<T> lista, Comparator<T> criterio, boolean ascendente, int lo, int hi)
	{
		if(lo>=hi)
		{
			return;
		}
		int pivot = partition(lista,criterio,ascendente,lo,hi);
		sort(lista, criterio, ascendente, lo, pivot-1);
		sort(lista, criterio, ascendente, pivot+1, hi);
	}
	
	private final int partition(ILista<T> lista, Comparator<T> criterio, boolean ascendente, int lo, int hi)
	{
		int follower = lo;
		int leader = lo;
		while(leader<hi)
		{
			int comparacion = (ascendente?1:-1)*criterio.compare(lista.getElement(leader), lista.getElement(hi));
			if(comparacion<0)
			{
				lista.exchange(follower, leader);
				follower++;
			}
			leader++;
		}
		lista.exchange(follower, hi);
		return follower;
	}
	
	public void ordenarMerge(ILista<T> lista, Comparator<T> criterio, boolean ascendente)
	{
		int size = lista.size();
		if(size>1)
		{
			int mid = size/2;
			
			ILista<T> leftList = lista.subList(1, mid);
			ILista<T> rightList = lista.subList(mid+1, size-mid);
			
			ordenarMerge(leftList, criterio, ascendente);
			ordenarMerge(rightList, criterio, ascendente);
			
			int i = 1;
			int j = 1;
			int k = 1;
			
			int leftElements = leftList.size();
			int rightElements = rightList.size();
			
			while(i<=leftElements && j<=rightElements)
			{
				T elemi = leftList.getElement(i);
				T elemj = rightList.getElement(j);
				
				int comparacion = (ascendente?1:-1)*criterio.compare(elemi, elemj);
				if(comparacion<=0)
				{
					lista.changeInfo(k, elemi);	
					i++;
				}
				else
				{
					lista.changeInfo(k, elemj);
					j++;
				}
				k++;
			}
			
			while(i<=leftElements)
			{
				lista.changeInfo(k, leftList.getElement(i));
				i++;
				k++;
			}
			
			while(j<=rightElements)
			{
				lista.changeInfo(k, rightList.getElement(j));
				j++;
				k++;
			}
		}
	}
}
