package Turbopoly;
public class Piece 
{
	protected int locationX = 0, locationY = 0,	bankValue = 0;	
	
	//Piece class constructor
	public Piece(int setX, int setY, int setBankvalue)
	{
		//Sets the location of X and Y + the total deposited within the bank account.
		locationX = setX; 
		locationY = setY;
		bankValue = setBankvalue;
	}
	
	//These are the get and set methods for the bankValue.
	public int getBankValue()
	{
		return bankValue;
	}
	public void setBankValue(int bankValue)
	{
		this.bankValue = bankValue;
	}
	
	//The set and get methods for locationX & locationY
 	public void setLocationX(int updateX)
	{
		locationX = updateX;		
	}
	public void setLocationY(int updateY)
	{
		locationY = updateY;		
	}	
	public int getLocationX()
	{		
		return locationX;		
	}
	public int getLocationY()
	{		
		return locationY;		
	}
}