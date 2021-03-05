package model.data_structures;


public class Categoria implements Comparable<Categoria> 
{
	private String id;


	public Categoria(String pId)
	{
		id = pId;
	}


	public String darId()
	{
		return id;
	}


	@Override
	public int compareTo(Categoria o) 
	{
		return this.id.compareTo(o.darId());
	}
	
}

