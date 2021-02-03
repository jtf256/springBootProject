package org.jtf256.entity;



public class Card 
{


	private String name;
	private int quantity;
	
	public Card( String name, int quantity) 
	{

		this.name = name;
		this.quantity = quantity;
	}
	
	public Card( String name)
	{
		this.name = name;
		this.quantity = 1;
	}
	
	public Card()
	{

		this.name  = "";
		this.quantity = -1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Card [name= " + name + ", quantity= " + quantity + "]";
	}


	

}
