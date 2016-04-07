package Turbopoly;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JFrame implements ActionListener
{	
	GameLogic game = new GameLogic();
	
	private JPanel 	boardPanel; 
	private JLabel 	backgroundImage, 
					computerImage, 
					humanImage, 
					diceBoxImage, 
					splashScreen; 
	
	private JButton newGame_Button, 
					quit_Button, 
					startGame_Button,	
					randomize_Button, 
					movePiece, 
					buy_Button, 
					pass_Button, 
					letComputerPlay;
		
	private ImageIcon 	humanPieceImage,
						computerPieceImage, 
						diceImage_1, 
						diceImage_2, 
						humanLose, 
						computerLose;
	
	//Used to create the random variables for the dice.		
	Random rand = new Random(); // Generates random numbers 
	
	// Used to paint the dice on the screen.
	public boolean 	loadGameBoardNow = false;
			
	//Board class constructor
	public Board ()
	{
		super( "Turbopoly 2.0" );//displays in the title bar			
		System.out.println("Welcome to Turboply 2.0");
		
		//Sets the layout for the main background image. 
		setLayout(null);	System.out.println("Loading nuts and bolts. ");
		
		//Used to setup the boardPanel
		boardPanel = new JPanel();	      
		boardPanel.setLocation( 0, -4 );
		boardPanel.setSize( 870, 600 );	
		System.out.println("Constructing JPanel.");
		
		//Adds the main background panel
		add(boardPanel);
		
		System.out.println("Loading SplashScreen....");
		loadSplashScreen();
		
	} 
	public void loadSplashScreen()
	{
		//Images which are used within the game. 
		Icon splashImage = new ImageIcon( getClass().getResource( "Images/splashScreen.png" ) );
		
		//Used to setup the splashScreen image.		
		splashScreen = new JLabel();
		splashScreen.setIcon( splashImage );
		splashScreen.setSize(870, 600);
		splashScreen.setLocation(0,0);
	    
	    //Start game button
	    startGame_Button = new JButton();
	    startGame_Button.setIcon(new ImageIcon(Board.class.getResource("images/buttons/startGame.png")));
	    startGame_Button.setSize( 150,40 );
	    startGame_Button.setLocation( 365,530 );
		
	    //Adds the splashScreen Image		
  		boardPanel.add(splashScreen);
  		splashScreen.add(startGame_Button);	
  		startGame_Button.addActionListener(this);		
	}
	public void loadBoard()	
	{
		System.out.println("Loading the board....");
		//Loads into array memory.
		game.setPropertyNames();
		game.loadComputerPieceLocations();
		game.loadPlayerPieceLocations();	
		
		Icon boardImage = new ImageIcon( getClass().getResource( "Images/background.png" ) );	      
		Icon humanBox = new ImageIcon( getClass().getResource( "Images/human.png" ) );
		Icon computerBox = new ImageIcon( getClass().getResource( "Images/computer.png" ) );
		Icon diceBox = new ImageIcon( getClass().getResource( "Images/dicebox.png" ) );	
		
		//Used to setup the background image. 
		backgroundImage = new JLabel();
		backgroundImage.setIcon( boardImage );
		backgroundImage.setSize(870, 600);
		backgroundImage.setLocation(0,0);
	  
		//Used to setup the human interface box		
		humanImage = new JLabel();
		humanImage.setLayout(new FlowLayout());
		humanImage.setSize( 219,168 );
	  	humanImage.setIcon( humanBox );
	  	humanImage.setLocation( 31,210 );
	  	  
	  	//Used to setup the computer interface box	  	
	  	computerImage = new JLabel();
	  	computerImage.setLayout(new FlowLayout());
	  	computerImage.setSize( 219,168 );
	  	computerImage.setIcon( computerBox );
	  	computerImage.setLocation(30,35);
	  
	  	//Used to setup the dice interface box	  	
	  	diceBoxImage = new JLabel();
	  	diceBoxImage.setLayout(new BorderLayout());	  	
	  	diceBoxImage.setSize( 219,90 );
	  	diceBoxImage.setIcon( diceBox );
	  	diceBoxImage.setLocation(32,390 );	  	
		
	  	//Used to setup the newGame button
	  	newGame_Button = new JButton();
	    newGame_Button.setIcon(new ImageIcon(Board.class.getResource("images/buttons/newgame.png")));
	    newGame_Button.setSize( 91,42 );
	    newGame_Button.setLocation( 50,520 );
	    
	    //Used to setup the quit game button.
	    quit_Button = new JButton();
	    quit_Button.setIcon(new ImageIcon(Board.class.getResource("images/buttons/quit.png")));
	    quit_Button.setSize( 100,42 );
	    quit_Button.setLocation( 90,520 );
		
	    randomize_Button = new JButton("Roll The Dice");	    	  
	    randomize_Button.setSize( 218,25 );
	    randomize_Button.setLocation( 32,480);
	    
	    letComputerPlay= new JButton("Let Computer Play ?");
	    letComputerPlay.setSize( 218,25 );
	    letComputerPlay.setLocation( 32,480);
	   
	    buy_Button = new JButton("Buy?");	    	  
	    buy_Button.setSize( 110,25 );
	    buy_Button.setLocation( 32,480);
	    
	    pass_Button = new JButton("Pass");	    	  
	    pass_Button.setSize( 100,25 );
	    pass_Button.setLocation( 150,480);	   
	   
	    buy_Button.addActionListener(this);
	    pass_Button.addActionListener(this);	    
	    letComputerPlay.addActionListener(this);
	    
	    movePiece = new JButton("Move Piece ?");
	    movePiece.setSize( 218,25 );
	    movePiece.setLocation( 32,480);
	    
	  	//Ads all the other elements for the game to start.
  		boardPanel.add(backgroundImage); //Adds the background image to the background panel
  				      
  		//adds the various components to the background image.
  		backgroundImage.add(humanImage);
  		backgroundImage.add(computerImage);		
  		backgroundImage.add(diceBoxImage);
  		
  		//Adds randomize button.		
  		backgroundImage.add(randomize_Button);
  				
  		//Adds the buttons to the game.
  		backgroundImage.add(quit_Button);
  		
  		//Adds Action Listeners
  		quit_Button.addActionListener(this);
  		randomize_Button.addActionListener(this); 
  		movePiece.addActionListener(this);
	}
		
	//listens for the various actions of the buttons.
	public void actionPerformed(ActionEvent e) 
	{
		Object buttonPressed = e.getSource();				
		//Start game button code
		if(buttonPressed == startGame_Button)
		{
			System.out.println("Game Started");
			
			//Tells the paint method to paint the board pieces/text
			loadGameBoardNow = true;
			
			//Loads the board objects.
			loadBoard();
			
			//removes the splashScreen stuff			
			boardPanel.remove(splashScreen);
			splashScreen.remove(startGame_Button);
		}		
		if(buttonPressed == randomize_Button)
		{	
			System.out.println("Dice Rolled");
			game.humansTurn = true;
			game.computersTurn = false;
			game.rollDice();
			System.out.println("Human player rolled a " + game.getCurrentDiceTotal());
			
			backgroundImage.add(movePiece); //adds the move piece button, 
			backgroundImage.remove(randomize_Button); //removes the randomizeButton			
		}	
		
		if(buttonPressed == movePiece)
		{							
			game.startGame();			
			System.out.println("call to startGame() method.");
			if(game.propertyIsBuyable == true)
			{
				System.out.println("The property is buyable, buttons added for input");
				backgroundImage.add(buy_Button);
			    backgroundImage.add(pass_Button);
			}
			backgroundImage.remove(movePiece);
		}
		
		if(buttonPressed == buy_Button)
		{	
			System.out.println("Buy button pressed.");
			game.buyProperty_Human();
			
			game.showDice = false;
			
			backgroundImage.remove(buy_Button);
			backgroundImage.remove(pass_Button);
			
			backgroundImage.add(letComputerPlay);			
		}
		if(buttonPressed == pass_Button)
		{	System.out.println("You've passed on buying a property.");						
			game.showDice = false;
			
			backgroundImage.remove(buy_Button);
			backgroundImage.remove(pass_Button);
			backgroundImage.add(letComputerPlay);
		}
		if(buttonPressed == letComputerPlay)
		{	System.out.println("Letting computer play.");					
			backgroundImage.remove(letComputerPlay);
			
			System.out.println("Checking if game is over. ");
			game.isGameOver();
			game.runComputer(); System.out.println("runComputer() method.");
			game.isGameOver();	System.out.println("Checking if game is over. ");
			
			//Ads another randomize button so the human can take his next turn.
			backgroundImage.add(randomize_Button);
		}		
		//Quit game button code
		if(buttonPressed == quit_Button){ this.dispose();System.out.println("quitButton pressed."); }
		
		repaint(); //refreshes the screen.
	}
	
	//Paints the various graphics to the screen, (pieces and dice)
	public void paint (Graphics g)
	{
		super.paint(g);				
		
		if(loadGameBoardNow)
		{System.out.println("Loading Game board now.");
			humanPieceImage = new ImageIcon("humanPiece.png");
			humanPieceImage.paintIcon(this, g, game.getHumanX(), game.getHumanY());
			
			computerPieceImage= new ImageIcon("computerPiece.png");
			computerPieceImage.paintIcon(this, g,  game.getComputerX(), game.getComputerY());
							
			g.setColor(Color.red);
			g.drawString("Bank = $"+ game.humanPiece.getBankValue(), 60, 155);
			g.drawString("Currently on : "+ game.humanPieceOnCurrentSquare, 60, 180);
			
			g.setColor(Color.blue);
			g.drawString("Bank = $"+ game.computerPiece.getBankValue(), 60, 325);
			g.drawString("Currently on : "+ game.computerPieceOnCurrentSquare,  60, 350);	
		}	
		
		//This is used to show the dice images if the roll dice button has been pressed.
		if(game.showDice) 
		{
			System.out.println("Showing Dice images.");		
			displayDiceImages(g);
		}	
		
		//Constantly checks to see if a property has been bought.
		humanPurchasedPropertyDrawMarkers(g);
		computerPurchasedPropertyDrawMarkers(g);
		
		//Win/Lose images.
		if(game.humanHasLostGame)
		{	System.out.println("Human has lost game");
			humanLose = new ImageIcon("youWon.png");
			humanLose.paintIcon(this, g, 0,15);
			
			//removes buttons
			backgroundImage.remove(buy_Button);
			backgroundImage.remove(randomize_Button);
			backgroundImage.remove(pass_Button);			
		}
		if(game.computerHasLostGame)
		{
			System.out.println("Computer has lost game.");
			humanLose = new ImageIcon("youWon.png");
			humanLose.paintIcon(this, g, 0,15);
						
			//removes buttons
			backgroundImage.remove(buy_Button);
			backgroundImage.remove(randomize_Button);
			backgroundImage.remove(pass_Button);			
		}
	}

	//Used to display the dice on the screen
	public void displayDiceImages(Graphics g)
	{			
		//diceImage_1
		switch(game.dice.getDie1())
		{
			case 1:	diceImage_1 = new ImageIcon("Dice_1.png"); break;
			case 2:	diceImage_1 = new ImageIcon("Dice_2.png"); break;
			case 3:	diceImage_1 = new ImageIcon("Dice_3.png"); break;
			case 4:	diceImage_1 = new ImageIcon("Dice_4.png"); break;
			case 5:	diceImage_1 = new ImageIcon("Dice_5.png"); break;
			case 6:	diceImage_1 = new ImageIcon("Dice_6.png"); break;			
			default: break;
		}		
		
		//diceImage_2
		switch(game.dice.getDie2())
		{
			case 1:	diceImage_2 = new ImageIcon("Dice_1.png"); break;
			case 2:	diceImage_2 = new ImageIcon("Dice_2.png"); break;
			case 3:	diceImage_2 = new ImageIcon("Dice_3.png"); break;
			case 4:	diceImage_2 = new ImageIcon("Dice_4.png"); break;
			case 5:	diceImage_2 = new ImageIcon("Dice_5.png"); break;
			case 6:	diceImage_2 = new ImageIcon("Dice_6.png"); break;			
			default: break;
		}
		diceImage_1.paintIcon(this, g, 75, 430); //prints dice 1 to the screen
		diceImage_2.paintIcon(this, g, 145, 430);//prints dice 2 to the screen
	}
		
	//used to display a marker for the property the human player has bought.
	public void humanPurchasedPropertyDrawMarkers(Graphics g)
	{				
		//Bottom set.
		g.setColor(Color.green);
		if (game.mediterranean_ave_Square_HumanOwned)	{g.fillOval(745, 597, 20, 20);}
		if (game.baltic_ave_Square_HumanOwned)			{g.fillOval(652, 597, 20, 20);}
		if (game.reading_RR_Square_HumanOwned)			{g.fillOval(561, 597, 20, 20);}
		if (game.oriental_ave_Square_HumanOwned)		{g.fillOval(519, 597, 20, 20);}
		if (game.vermont_ave_Square_HumanOwned)			{g.fillOval(427, 597, 20, 20);}
		if (game.connecticut_ave_Square_HumanOwned)		{g.fillOval(383, 597, 20, 20);}
				
		//Left set
		if (game.st_charles_place_Square_HumanOwned)	{g.fillOval(283, 498, 20, 20);}
		if (game.electric_company_Square_HumanOwned)	{g.fillOval(283, 450, 20, 20);}
		if (game.states_ave_Square_HumanOwned)			{g.fillOval(283, 406, 20, 20);}
		if (game.virginia_ave_Square_HumanOwned)		{g.fillOval(283, 362, 20, 20);}		
		if (game.pennsylvania_RR_Square_HumanOwned)		{g.fillOval(283, 314, 20, 20);}
		if (game.st_james_place_Square_HumanOwned)		{g.fillOval(283, 268, 20, 20);}
		if (game.tennessee_ave_Square_HumanOwned)		{g.fillOval(283, 176, 20, 20);}
		if (game.new_york_ave_Square_HumanOwned)		{g.fillOval(283, 132, 20, 20);}
				
		//Top Set
		if (game.kentucky_ave_Square_HumanOwned)		{g.fillOval(384, 28, 20, 20);}
		if (game.indiana_ave_Square_HumanOwned)			{g.fillOval(474, 28, 20, 20);}
		if (game.illinois_ave_Square_HumanOwned)		{g.fillOval(518, 28, 20, 20);}
		if (game.bo_RR_Square_HumanOwned)				{g.fillOval(564, 28, 20, 20);}
		if (game.atlantic_ave_Square_HumanOwned)		{g.fillOval(608, 28, 20, 20);}
		if (game.ventnor_ave_Square_HumanOwned)			{g.fillOval(653, 28, 20, 20);}
		if (game.water_works_Square_HumanOwned)			{g.fillOval(698, 28, 20, 20);}		
		if (game.marvin_gardens_Square_HumanOwned)		{g.fillOval(743, 28, 20, 20);}
				
		//Right set
		if (game.pacific_ave_Square_HumanOwned)			{g.fillOval(846, 130, 20, 20);}
		if (game.no_carolina_ave_Square_HumanOwned)		{g.fillOval(846, 176, 20, 20);}
		if (game.pennsylvania_ave_Square_HumanOwned)	{g.fillOval(846, 267, 20, 20);}
		if (game.short_line_RR_Square_HumanOwned)		{g.fillOval(846, 313, 20, 20);}
		if (game.park_place_Square_HumanOwned)			{g.fillOval(846, 405, 20, 20);}
		if (game.boardwalk_Square_HumanOwned)			{g.fillOval(846, 497, 20, 20);}	
	}
	//used to display a marker for the property the computer player has bought.
	public void computerPurchasedPropertyDrawMarkers(Graphics g)
	{			
		//Bottom set.
		g.setColor(Color.red);
		if (game.mediterranean_ave_Square_ComputerOwned)	{g.fillOval(745, 597, 20, 20);}
		if (game.baltic_ave_Square_ComputerOwned)			{g.fillOval(652, 597, 20, 20);}
		if (game.reading_RR_Square_ComputerOwned)			{g.fillOval(561, 597, 20, 20);}
		if (game.oriental_ave_Square_ComputerOwned)			{g.fillOval(519, 597, 20, 20);}
		if (game.vermont_ave_Square_ComputerOwned)			{g.fillOval(427, 597, 20, 20);}
		if (game.connecticut_ave_Square_ComputerOwned)		{g.fillOval(383, 597, 20, 20);}
				
		//Left set
		if (game.st_charles_place_Square_ComputerOwned)		{g.fillOval(283, 498, 20, 20);}
		if (game.electric_company_Square_ComputerOwned)		{g.fillOval(283, 450, 20, 20);}
		if (game.states_ave_Square_ComputerOwned)			{g.fillOval(283, 406, 20, 20);}
		if (game.virginia_ave_Square_ComputerOwned)			{g.fillOval(283, 362, 20, 20);}		
		if (game.pennsylvania_RR_Square_ComputerOwned)		{g.fillOval(283, 314, 20, 20);}
		if (game.st_james_place_Square_ComputerOwned)		{g.fillOval(283, 268, 20, 20);}
		if (game.tennessee_ave_Square_ComputerOwned)		{g.fillOval(283, 176, 20, 20);}
		if (game.new_york_ave_Square_ComputerOwned)			{g.fillOval(283, 132, 20, 20);}
				
		//Top Set
		if (game.kentucky_ave_Square_ComputerOwned)			{g.fillOval(384, 28, 20, 20);}
		if (game.indiana_ave_Square_ComputerOwned)			{g.fillOval(474, 28, 20, 20);}
		if (game.illinois_ave_Square_ComputerOwned)			{g.fillOval(518, 28, 20, 20);}
		if (game.bo_RR_Square_ComputerOwned)				{g.fillOval(564, 28, 20, 20);}
		if (game.atlantic_ave_Square_ComputerOwned)			{g.fillOval(608, 28, 20, 20);}
		if (game.ventnor_ave_Square_ComputerOwned)			{g.fillOval(653, 28, 20, 20);}
		if (game.water_works_Square_ComputerOwned)			{g.fillOval(698, 28, 20, 20);}		
		if (game.marvin_gardens_Square_ComputerOwned)		{g.fillOval(743, 28, 20, 20);}
				
		//Right set
		if (game.pacific_ave_Square_ComputerOwned)			{g.fillOval(846, 130, 20, 20);}
		if (game.no_carolina_ave_Square_ComputerOwned)		{g.fillOval(846, 176, 20, 20);}
		if (game.pennsylvania_ave_Square_ComputerOwned)		{g.fillOval(846, 267, 20, 20);}
		if (game.short_line_RR_Square_ComputerOwned)		{g.fillOval(846, 313, 20, 20);}
		if (game.park_place_Square_ComputerOwned)			{g.fillOval(846, 405, 20, 20);}
		if (game.boardwalk_Square_ComputerOwned)			{g.fillOval(846, 497, 20, 20);}	
	}
}