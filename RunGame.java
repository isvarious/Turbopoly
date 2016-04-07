package Turbopoly;
import javax.swing.JFrame;
public class RunGame 
{	
	public static void main(String[] args)
	{		
		Board board = new Board(); 		// creates Board object. 		
		board.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		board.setSize( 875, 625 ); 		// set frame size
		board.setVisible( true ); 		// display frame
		board.setResizable(false);
		board.setAlwaysOnTop(true);	
	}
}