package Turbopoly;
import java.util.Random;
public class GameLogic 
{	
	Dice dice = new Dice();
	Random rand = new Random(); // Generates random numbers 		
	Piece humanPiece = new Piece(0, 0, 2000);
	Piece computerPiece = new Piece(0, 0, 2000);
	
	public int [] 	humanPiceLocationsX = new  int [40],
					humanPiceLocationsY = new  int [40],
					computerPiceLocationsX = new  int [40],
					computerPiceLocationsY = new  int [40];
	
	private int taxesCollected = 500,
				moveHumanPiece = 0,
				moveComputerPiece = 0,
				humanX = 804, //default x location 815 
				humanY = 578, //default y location 578
				computerX = 804,
				computerY = 578-50, 
				currentDiceTotal;	
	
	public String [] propertyNames = new String [40];
	
	public String humanPieceOnCurrentSquare = "Go", computerPieceOnCurrentSquare = "Go";	
	
	
	// Human Owned Land booleans
	// Boolean "top" group location switches (These booleans will be used in conjunction with movement adjustment and the buying of land)	
	public boolean 	computersTurn = false, 	humansTurn = false,	kentucky_ave_Square_HumanOwned = false,	indiana_ave_Square_HumanOwned = false,	illinois_ave_Square_HumanOwned = false,
					bo_RR_Square_HumanOwned = false, atlantic_ave_Square_HumanOwned = false, ventnor_ave_Square_HumanOwned = false, 	water_works_Square_HumanOwned = false,
					marvin_gardens_Square_HumanOwned = false,				
					
					// Boolean "left" group location switches (These booleans will be used in conjunction with movement adgjustment and the buying of land)	
					st_charles_place_Square_HumanOwned = false,	electric_company_Square_HumanOwned = false,	states_ave_Square_HumanOwned = false,
					virginia_ave_Square_HumanOwned = false,		pennsylvania_RR_Square_HumanOwned = false,	st_james_place_Square_HumanOwned = false,
					tennessee_ave_Square_HumanOwned = false,	new_york_ave_Square_HumanOwned = false,
				
					
					// Boolean "right" group location switches (These booleans will be used in conjunction with movement adgjustment and the buying of land)
					pacific_ave_Square_HumanOwned = false,		no_carolina_ave_Square_HumanOwned = false,	pennsylvania_ave_Square_HumanOwned = false,
					short_line_RR_Square_HumanOwned = false,	park_place_Square_HumanOwned = false,		boardwalk_Square_HumanOwned = false,
					
					// Boolean "bottom" group location switches (These booleans will be used in conjunction with movement adgjustment and the buying of land)
					mediterranean_ave_Square_HumanOwned = false,baltic_ave_Square_HumanOwned = false,		reading_RR_Square_HumanOwned = false,	
					oriental_ave_Square_HumanOwned = false,		vermont_ave_Square_HumanOwned = false,		connecticut_ave_Square_HumanOwned = false,
					
					// Boolean "top" group location switches (These booleans will be used in conjunction with movement adgjustment and the buying of land)	
					kentucky_ave_Square_ComputerOwned = false,	indiana_ave_Square_ComputerOwned = false,	illinois_ave_Square_ComputerOwned = false,
					bo_RR_Square_ComputerOwned = false,			atlantic_ave_Square_ComputerOwned = false,	ventnor_ave_Square_ComputerOwned = false,
					water_works_Square_ComputerOwned = false,	marvin_gardens_Square_ComputerOwned = false,
					
					// Computer Owned Land booleans
					// Boolean "left" group location switches (These booleans will be used in conjunction with movement adgjustment and the buying of land)	
					st_charles_place_Square_ComputerOwned = false,	electric_company_Square_ComputerOwned = false,	states_ave_Square_ComputerOwned = false,
					virginia_ave_Square_ComputerOwned = false,		pennsylvania_RR_Square_ComputerOwned = false,	st_james_place_Square_ComputerOwned = false,
					tennessee_ave_Square_ComputerOwned = false,		new_york_ave_Square_ComputerOwned = false,
					
					// Boolean "right" group location switches (These booleans will be used in conjunction with movement adgjustment and the buying of land)			
					pacific_ave_Square_ComputerOwned = false,		no_carolina_ave_Square_ComputerOwned = false,	pennsylvania_ave_Square_ComputerOwned = false,
					short_line_RR_Square_ComputerOwned = false,		park_place_Square_ComputerOwned = false,		boardwalk_Square_ComputerOwned = false,
					
					// Boolean "bottom" group location switches (These booleans will be used in conjunction with movement adgjustment and the buying of land)
					mediterranean_ave_Square_ComputerOwned = false,	baltic_ave_Square_ComputerOwned = false,		reading_RR_Square_ComputerOwned = false,	
					oriental_ave_Square_ComputerOwned = false,		vermont_ave_Square_ComputerOwned = false,		connecticut_ave_Square_ComputerOwned = false,
					
					placeDiceOnScreen = false,	showDice = false, propertyIsBuyable = false, desireToBuy = false, humanHasLostGame = false, computerHasLostGame = false;
		
	//This method starts the game, and is first triggered from the "move piece button in he Board class.
	public void startGame()
	{	
		System.out.println("Loading Piece mover");
		pieceMover();	
		
		System.out.println("Loading sortProperty() method.");
		sortProperty();	
	}	
	public void swapPlayersTurn()
	{
		//This swaps the current players turn with the other. 
		if(humansTurn) 
		{
			humansTurn = false;
			computersTurn = true;
		}
		else if(computersTurn)
		{			
			computersTurn = false;
			humansTurn = true;
		}		
	}
		
	public void rollDice()
	{
		System.out.println("Rolling Dice. ");
		//Roll dice
		currentDiceTotal = dice.roll_Dice();
		showDice = true;
	}
	
	//Loads the player piece locations into the array
	//Fills the x and y locations for the humanPiece
	public void loadPlayerPieceLocations()
	{System.out.println("Loading humanPlayer piecce locations into array memory.");
		//Bottom Rows				
		//Square Medatrain Ave.		
		humanPiceLocationsX[0] = 741; 
		humanPiceLocationsY[0] = 578; 		
		//Square Community Chest.
		humanPiceLocationsX[1] = 697; 
		humanPiceLocationsY[1] = 578; 
		//Square Baltic ave.
		humanPiceLocationsX[2] = 650; 
		humanPiceLocationsY[2] = 578; 
		//Square Income Tax.
		humanPiceLocationsX[3] = 606; 
		humanPiceLocationsY[3] = 578; 
		//Square Reading RR.
		humanPiceLocationsX[4] = 562; 
		humanPiceLocationsY[4] = 578; 
		//Square Central Ave.
		humanPiceLocationsX[5] = 517; 
		humanPiceLocationsY[5] = 578; 
		//Square Oriental Ave.
		humanPiceLocationsX[6] = 471; 
		humanPiceLocationsY[6] = 578; 
		//Square Chance.
		humanPiceLocationsX[7] = 426; 
		humanPiceLocationsY[7] = 578;
		//Square Conn ave.
		humanPiceLocationsX[8] = 382; 
		humanPiceLocationsY[8] = 578;
		//Square Visiting Jail.
		humanPiceLocationsX[9] = 305; 
		humanPiceLocationsY[9] = 578;
	
		//Left rows
		//Square St Charles Place
		humanPiceLocationsX[10] = 307; 
		humanPiceLocationsY[10] = 503;
		//Square Eletric Company
		humanPiceLocationsX[11] = 307; 
		humanPiceLocationsY[11] = 453;
		//Square States Ave
		humanPiceLocationsX[12] = 307; 
		humanPiceLocationsY[12] = 409;
		//Square Virgina ave
		humanPiceLocationsX[13] = 307; 
		humanPiceLocationsY[13] = 367;
		//Square PA RR
		humanPiceLocationsX[14] = 307; 
		humanPiceLocationsY[14] = 321;
		//Square St James Place
		humanPiceLocationsX[15] = 307; 
		humanPiceLocationsY[15] = 274;
		//Square Community Chest
		humanPiceLocationsX[16] = 307; 
		humanPiceLocationsY[16] = 227;
		//Square Tennes Ave
		humanPiceLocationsX[17] = 307; 
		humanPiceLocationsY[17] = 183;
		//Square New York Ave
		humanPiceLocationsX[18] = 307; 
		humanPiceLocationsY[18] = 137;
		//Square Free Parking
		humanPiceLocationsX[19] = 307; 
		humanPiceLocationsY[19] = 82;
				
		//Top rows
		//Square Kentucky Ave
		humanPiceLocationsX[20] = 382; 
		humanPiceLocationsY[20] = 55;
		//Square Chance
		humanPiceLocationsX[21] = 425; 
		humanPiceLocationsY[21] = 55;
		//Square Indian Ave
		humanPiceLocationsX[22] = 472; 
		humanPiceLocationsY[22] = 55;
		//Square Illinios ave
		humanPiceLocationsX[23] = 515; 
		humanPiceLocationsY[23] = 55;
		//Square B & O RailRoad
		humanPiceLocationsX[24] = 560; 
		humanPiceLocationsY[24] = 55;
		//Square Atlantic Ave
		humanPiceLocationsX[25] = 605; 
		humanPiceLocationsY[25] = 55;
		//Square Ventor Ave
		humanPiceLocationsX[26] = 652; 
		humanPiceLocationsY[26] = 55;
		//Square water works
		humanPiceLocationsX[27] = 694; 
		humanPiceLocationsY[27] = 55;
		//Square Marvin Gardens
		humanPiceLocationsX[28] = 741; 
		humanPiceLocationsY[28] = 55;
		//Square Go to Jail
		humanPiceLocationsX[29] = 801; 
		humanPiceLocationsY[29] = 55;
				
		//Right Rows
		//Square Pacific Ave
		humanPiceLocationsX[30] = 814; 
		humanPiceLocationsY[30] = 136;
		//Square North Caroline Ave
		humanPiceLocationsX[31] = 814; 
		humanPiceLocationsY[31] = 181;
		//Square Community Chest
		humanPiceLocationsX[32] = 814; 
		humanPiceLocationsY[32] = 228;
		//Square Pennsylvania Ave
		humanPiceLocationsX[33] = 814; 
		humanPiceLocationsY[33] = 275;
		//Square Short Line RailRoad
		humanPiceLocationsX[34] = 814; 
		humanPiceLocationsY[34] = 319;
		//Square Chance
		humanPiceLocationsX[35] = 814; 
		humanPiceLocationsY[35] = 365;
		//Square Park Place
		humanPiceLocationsX[36] = 814; 
		humanPiceLocationsY[36] = 409;
		//Square Luxury tax
		humanPiceLocationsX[37] = 814; 
		humanPiceLocationsY[37] = 458;
		//Square BoardWalk
		humanPiceLocationsX[38] = 814; 
		humanPiceLocationsY[38] = 501;		
		//Square GO.
		humanPiceLocationsX[39] = 804; 
		humanPiceLocationsY[39] = 580; 			
	}	
	//Fills the x and y locations for the Computer Piece
	public void loadComputerPieceLocations()
	{System.out.println("Loading computer piece x and y locations into array memory.");
		//Bottom Rows					
		//Square Medatrain Ave.		
		computerPiceLocationsX[0] = 741; 
		computerPiceLocationsY[0] = 583-50; 		
		//Square Community Chest.
		computerPiceLocationsX[1] = 697; 
		computerPiceLocationsY[1] = 583-50; 
		//Square Baltic ave.
		computerPiceLocationsX[2] = 650; 
		computerPiceLocationsY[2] = 583-50; 
		//Square Income Tax.
		computerPiceLocationsX[3] = 606; 
		computerPiceLocationsY[3] = 583-50; 
		//Square Reading RR.
		computerPiceLocationsX[4] = 562; 
		computerPiceLocationsY[4] = 583-50; 
		//Square Central Ave.
		computerPiceLocationsX[5] = 517; 
		computerPiceLocationsY[5] = 583-50; 
		//Square Oriental Ave.
		computerPiceLocationsX[6] = 471; 
		computerPiceLocationsY[6] = 583-50; 
		//Square Chance.
		computerPiceLocationsX[7] = 426; 
		computerPiceLocationsY[7] = 583-50;
		//Square Conn ave.
		computerPiceLocationsX[8] = 382; 
		computerPiceLocationsY[8] = 583-50;
		//Square Visiting Jail.
		computerPiceLocationsX[9] = 305; 
		computerPiceLocationsY[9] = 583-50;
	
		//Left rows
		//Square St Charles Place
		computerPiceLocationsX[10] = 307+35; 
		computerPiceLocationsY[10] = 503-23;
		//Square Eletric Company
		computerPiceLocationsX[11] = 307+35; 
		computerPiceLocationsY[11] = 453-23;
		//Square States Ave
		computerPiceLocationsX[12] = 307+35; 
		computerPiceLocationsY[12] = 409-23;
		//Square Virgina ave
		computerPiceLocationsX[13] = 307+35; 
		computerPiceLocationsY[13] = 367-23;
		//Square PA RR
		computerPiceLocationsX[14] = 307+35; 
		computerPiceLocationsY[14] = 321-23;
		//Square St James Place
		computerPiceLocationsX[15] = 307+35; 
		computerPiceLocationsY[15] = 274-23;
		//Square Community Chest
		computerPiceLocationsX[16] = 307+35; 
		computerPiceLocationsY[16] = 227-23;
		//Square Tennes Ave
		computerPiceLocationsX[17] = 307+35; 
		computerPiceLocationsY[17] = 183-23;
		//Square New York Ave
		computerPiceLocationsX[18] = 307+35; 
		computerPiceLocationsY[18] = 137-23;
		//Square Free Parking
		computerPiceLocationsX[19] = 307+35; 
		computerPiceLocationsY[19] = 82-23;		
		
		//Top rows
		//Square Kenticky Ave
		computerPiceLocationsX[20] = 382; 
		computerPiceLocationsY[20] = 55+20;
		//Square Chance
		computerPiceLocationsX[21] = 425; 
		computerPiceLocationsY[21] = 55+20;
		//Square Indian Ave
		computerPiceLocationsX[22] = 472; 
		computerPiceLocationsY[22] = 55+20;
		//Square Illinios ave
		computerPiceLocationsX[23] = 515; 
		computerPiceLocationsY[23] = 55+20;
		//Square B & O RailRoad
		computerPiceLocationsX[24] = 560; 
		computerPiceLocationsY[24] = 55+20;
		//Square Atlantic Ave
		computerPiceLocationsX[25] = 605; 
		computerPiceLocationsY[25] = 55+20;
		//Square Ventor Ave
		computerPiceLocationsX[26] = 652; 
		computerPiceLocationsY[26] = 55+20;
		//Square water works
		computerPiceLocationsX[27] = 694; 
		computerPiceLocationsY[27] = 55+20;
		//Square Marvin Gardens
		computerPiceLocationsX[28] = 741; 
		computerPiceLocationsY[28] = 55+20;
		//Square Go to Jail
		computerPiceLocationsX[29] = 801; 
		computerPiceLocationsY[29] = 55+20;		
		
		//Right Rows
		//Square Pacific Ave
		computerPiceLocationsX[30] = 814-35; 
		computerPiceLocationsY[30] = 136-23;
		//Square North Caroline Ave
		computerPiceLocationsX[31] = 814-35; 
		computerPiceLocationsY[31] = 181-23;
		//Square Community Chest
		computerPiceLocationsX[32] = 814-35; 
		computerPiceLocationsY[32] = 228-23;
		//Square Pennsylvania Ave
		computerPiceLocationsX[33] = 814-35; 
		computerPiceLocationsY[33] = 275-23;
		//Square Short Line RailRoad
		computerPiceLocationsX[34] = 814-35; 
		computerPiceLocationsY[34] = 319-23;
		//Square Chance
		computerPiceLocationsX[35] = 814-35; 
		computerPiceLocationsY[35] = 365-23;
		//Square Park Place
		computerPiceLocationsX[36] = 814-35; 
		computerPiceLocationsY[36] = 409-23;
		//Square Luxury tax
		computerPiceLocationsX[37] = 814-35; 
		computerPiceLocationsY[37] = 458-23;
		//Square BoardWalk
		computerPiceLocationsX[38] = 814-35; 
		computerPiceLocationsY[38] = 501-23;
		//Square GO.
		computerPiceLocationsX[39] = 804; 
		computerPiceLocationsY[39] = 578-50; 
		
	}
	
	//Loads the property names an array.
	//String Array with the names of every property 
	public void setPropertyNames()
	{	System.out.println("Setting property names.");		
		propertyNames[0] = "Mediterranean Ave";
		propertyNames[1] = "Community Chest";
		propertyNames[2] = "Baltic Ave";
		propertyNames[3] = "Income Tax";
		propertyNames[4] = "Reading RR";
		propertyNames[5] = "Oriental Ave";
		propertyNames[6] = "Chance";
		propertyNames[7] = "Vermont Ave";		
		propertyNames[8] = "Connecticut Ave";
		propertyNames[9] = "Visiting Jail";
		propertyNames[10] = "St Charles Place";
		propertyNames[11] = "Eletric Company";
		propertyNames[12] = "States Ave";
		propertyNames[13] = "Virginia Ave";
		propertyNames[14] = "Pennsylvnia RR";
		propertyNames[15] = "St James Place";
		propertyNames[16] = "Community Chest";
		propertyNames[17] = "Tennesse Ave";
		propertyNames[18] = "New York Ave";
		propertyNames[19] = "Free Parking";
		propertyNames[20] = "Kentucky Ave";
		propertyNames[21] = "Chance";
		propertyNames[22] = "Indiana Ave";
		propertyNames[23] = "Illionis Ave";
		propertyNames[24] = "B & O RR";
		propertyNames[25] = "Atlantic Ave";
		propertyNames[26] = "Ventnor Ave";
		propertyNames[27] = "Water Works";
		propertyNames[28] = "Marvin Gardens";
		propertyNames[29] = "Go to Jail";
		propertyNames[30] = "Pacific Ave";
		propertyNames[31] = "North Carolina Ave";
		propertyNames[32] = "Community Chest";
		propertyNames[33] = "Pennsylvania Ave";
		propertyNames[34] = "Short Line RR";
		propertyNames[35] = "Chance";
		propertyNames[36] = "Park Place";
		propertyNames[37] = "Luxury Tax";
		propertyNames[38] = "Boardwalk";
		propertyNames[39] = "Go";
	}
	
	//This method moves both human or computer pieces, depending upon who's turn it is. 
	public void pieceMover()
	{	System.out.println("pieceMover() called");	
		if(humansTurn) //Checks to see if it's the human's turn. 
		{
			for(int x=0; x < currentDiceTotal; x++) //Calls the movePiece_Human method till the loop finishes. 
			{					
				movePiece_Human(); //moves the human piece one square every time the method is called.
				
				//Increments the move variable by one.
				moveHumanPiece++;
			}
			moveHumanPiece--;	//an odd subtraction to place the correct xy location of a property being bought. 		
		}
		else if(computersTurn)
		{
			for(int x=0; x < currentDiceTotal; x++) //Calls the movePiece_Computer method till the loop finishes.
			{ 
				currentDiceTotal = rand.nextInt(12); //rolls the dice for the computer.
				if(currentDiceTotal == 0) currentDiceTotal++;
				movePiece_Computer(); //moves the computer piece one square every time the method is called.	
				
				//Increments the move variable by one. 
				moveComputerPiece++;	
			}
			moveComputerPiece--;
		}
	}
	
	//Human movement method.	
	public void movePiece_Human()
	{			
		//This if check is used to catch the out of bounds error  with the array, and resets the element to 0. 
		if(moveHumanPiece > 39)	{ moveHumanPiece = 0; }
		
		//updates the value of humanX to the current element of the array humanPiceLocationsX[]
		humanX =  humanPiceLocationsX[moveHumanPiece]; 
		
		//updates the value of humanY to the current element of the array humanPiceLocationsY[]		
		humanY = humanPiceLocationsY[moveHumanPiece]; 		
		
		//Displays the name of the square the computer piece is on.
		humanPieceOnCurrentSquare = propertyNames[moveHumanPiece];		
	}
	
	//Human movement method.
	public void movePiece_Computer()
	{	
		//This if check is used to catch the out of bounds error  with the array, and resets the element to 0. 
		if(moveComputerPiece > 39)	{	moveComputerPiece = 0; }
		
		//updates the value of humanX to the current element of the array humanPiceLocationsX[]		
		computerX = computerPiceLocationsX[moveComputerPiece]; 
		
		//updates the value of humanY to the current element of the array humanPiceLocationsY[]
		computerY = computerPiceLocationsY[moveComputerPiece]; 		
		
		//Displays the name of the square the computer piece is on.
		computerPieceOnCurrentSquare = propertyNames[moveComputerPiece]; 
	}
	
	//This sorts the square a piece lands upon, and figures if you can buy it or something happens.
	public void sortProperty()
	{System.out.println("Sorting propertys based on player's turn.");
		if(humansTurn) //Checks to see if it's the human's turn. 
		{
			isPropertyBuyable();			
		}
		else if(computersTurn)
		{
			buyProperty_Computer();
			nonBuyableProperty_Computer();
		}
	}	
		
	public void isPropertyBuyable()
	{System.out.println("Checking if properties are buyable.");
		switch(moveHumanPiece)
		{
			//Bottom set
			case 0: propertyIsBuyable = true;	break;
			case 2: propertyIsBuyable = true; 	break;
			case 4: propertyIsBuyable = true; 	break;
			case 5:	propertyIsBuyable = true;	break;
			case 6:	propertyIsBuyable = true;	break;
			case 8: propertyIsBuyable = true; 	break;
			
			//Left set
			case 10: propertyIsBuyable = true; 	break;
			case 11: propertyIsBuyable = true; 	break;
			case 12: propertyIsBuyable = true; 	break;
			case 13: propertyIsBuyable = true; 	break;			
			case 14: propertyIsBuyable = true; 	break;
			case 15: propertyIsBuyable = true; 	break;
			case 17: propertyIsBuyable = true; 	break;
			case 18: propertyIsBuyable = true;	break;
			
			//Top Set
			case 20: propertyIsBuyable = true;	break;
			case 22: propertyIsBuyable = true; 	break;
			case 23: propertyIsBuyable = true;	break;
			case 24: propertyIsBuyable = true; 	break;
			case 25: propertyIsBuyable = true;	break;			
			case 26: propertyIsBuyable = true; 	break;
			case 27: propertyIsBuyable = true;	break;
			case 28: propertyIsBuyable = true; 	break;
			
			//Right set
			case 30: propertyIsBuyable = true; 	break;
			case 31: propertyIsBuyable = true; 	break;
			case 33: propertyIsBuyable = true;	break;
			case 34: propertyIsBuyable = true; 	break;
			case 36: propertyIsBuyable = true; 	break;
			case 38: propertyIsBuyable = true; 	break;			
						
			default: 	if(humansTurn)
						{
							nonBuyableProperty_Human();							
						}
						else
						{
							nonBuyableProperty_Computer();
						}
		}
	}
	
	//Properties that you or the computer can buy 
	public void buyProperty_Human()
	{	System.out.println("loading buyProperty_Human()");	
		switch(moveHumanPiece)
		{
			//Bottom set
			case 0: mediterranean_ave_Square_HumanOwned = true;	humanPiece.setBankValue(humanPiece.getBankValue() - 50); 	break;
			case 2: baltic_ave_Square_HumanOwned = true; 		humanPiece.setBankValue(humanPiece.getBankValue() - 50);	break;
			case 4: reading_RR_Square_HumanOwned = true; 		humanPiece.setBankValue(humanPiece.getBankValue() - 50);	break;
			case 5:	oriental_ave_Square_HumanOwned = true;		humanPiece.setBankValue(humanPiece.getBankValue() - 50);	break;
			case 6:	vermont_ave_Square_HumanOwned = true;		humanPiece.setBankValue(humanPiece.getBankValue() - 50);	break;
			case 8: connecticut_ave_Square_HumanOwned = true;	humanPiece.setBankValue(humanPiece.getBankValue() - 50); 	break;
			
			//Left set
			case 10: st_charles_place_Square_HumanOwned = true; humanPiece.setBankValue(humanPiece.getBankValue() - 100);	break;
			case 11: electric_company_Square_HumanOwned = true;	humanPiece.setBankValue(humanPiece.getBankValue() - 100); 	break;
			case 12: states_ave_Square_HumanOwned = true; 		humanPiece.setBankValue(humanPiece.getBankValue() - 100);	break;
			case 13: virginia_ave_Square_HumanOwned = true; 	humanPiece.setBankValue(humanPiece.getBankValue() - 100);	break;			
			case 14: pennsylvania_RR_Square_HumanOwned = true; 	humanPiece.setBankValue(humanPiece.getBankValue() - 100);	break;
			case 15: st_james_place_Square_HumanOwned = true; 	humanPiece.setBankValue(humanPiece.getBankValue() - 100);	break;
			case 17: tennessee_ave_Square_HumanOwned = true; 	humanPiece.setBankValue(humanPiece.getBankValue() - 100);	break;
			case 18: new_york_ave_Square_HumanOwned = true;		humanPiece.setBankValue(humanPiece.getBankValue() - 100);	break;
			
			//Top Set
			case 20: kentucky_ave_Square_HumanOwned = true;		humanPiece.setBankValue(humanPiece.getBankValue() - 200);	break;
			case 22: indiana_ave_Square_HumanOwned = true; 		humanPiece.setBankValue(humanPiece.getBankValue() - 200);	break;
			case 23: illinois_ave_Square_HumanOwned = true;		humanPiece.setBankValue(humanPiece.getBankValue() - 250);	break;
			case 24: bo_RR_Square_HumanOwned = true; 			humanPiece.setBankValue(humanPiece.getBankValue() - 250);	break;
			case 25: atlantic_ave_Square_HumanOwned = true;		humanPiece.setBankValue(humanPiece.getBankValue() - 250);	break;			
			case 26: ventnor_ave_Square_HumanOwned = true; 		humanPiece.setBankValue(humanPiece.getBankValue() - 250);	break;
			case 27: water_works_Square_HumanOwned = true;		humanPiece.setBankValue(humanPiece.getBankValue() - 250);	break;
			case 28: marvin_gardens_Square_HumanOwned = true; 	humanPiece.setBankValue(humanPiece.getBankValue() - 300);	break;
			
			//Right set
			case 30: pacific_ave_Square_HumanOwned = true; 		humanPiece.setBankValue(humanPiece.getBankValue() - 300);	break;
			case 31: no_carolina_ave_Square_HumanOwned = true; 	humanPiece.setBankValue(humanPiece.getBankValue() - 300);	break;
			case 33: pennsylvania_ave_Square_HumanOwned = true;	humanPiece.setBankValue(humanPiece.getBankValue() - 300);	break;
			case 34: short_line_RR_Square_HumanOwned = true; 	humanPiece.setBankValue(humanPiece.getBankValue() - 350);	break;
			case 36: park_place_Square_HumanOwned = true; 		humanPiece.setBankValue(humanPiece.getBankValue() - 350);	break;
			case 38: boardwalk_Square_HumanOwned = true; 		humanPiece.setBankValue(humanPiece.getBankValue() - 350);	break;			
			default: break;
		}
	}
	public void buyProperty_Computer()
	{		System.out.println("Loading buyProperty_Computer()");
		switch(moveComputerPiece)
		{
			//Bottom set
			case 0: mediterranean_ave_Square_ComputerOwned = true;	computerPiece.setBankValue(computerPiece.getBankValue() - 50);	break;
			case 2: baltic_ave_Square_ComputerOwned = true; 		computerPiece.setBankValue(computerPiece.getBankValue() - 50);	break;
			case 4: reading_RR_Square_ComputerOwned = true; 		computerPiece.setBankValue(computerPiece.getBankValue() - 50);	break;
			case 5:	oriental_ave_Square_ComputerOwned = true;		computerPiece.setBankValue(computerPiece.getBankValue() - 50);	break;
			case 6:	vermont_ave_Square_ComputerOwned = true;		computerPiece.setBankValue(computerPiece.getBankValue() - 50);	break;
			case 8: connecticut_ave_Square_ComputerOwned = true; 	computerPiece.setBankValue(computerPiece.getBankValue() - 50);	break;
			
			//Left set
			case 10: st_charles_place_Square_ComputerOwned = true;	computerPiece.setBankValue(computerPiece.getBankValue() - 100);	break;
			case 11: electric_company_Square_ComputerOwned = true; 	computerPiece.setBankValue(computerPiece.getBankValue() - 100);	break;
			case 12: states_ave_Square_ComputerOwned = true; 		computerPiece.setBankValue(computerPiece.getBankValue() - 100);	break;
			case 13: virginia_ave_Square_ComputerOwned = true; 		computerPiece.setBankValue(computerPiece.getBankValue() - 100);	break;			
			case 14: pennsylvania_RR_Square_ComputerOwned = true; 	computerPiece.setBankValue(computerPiece.getBankValue() - 100);	break;
			case 15: st_james_place_Square_ComputerOwned = true; 	computerPiece.setBankValue(computerPiece.getBankValue() - 100);	break;
			case 17: tennessee_ave_Square_ComputerOwned = true; 	computerPiece.setBankValue(computerPiece.getBankValue() - 100);	break;
			case 18: new_york_ave_Square_ComputerOwned = true;		computerPiece.setBankValue(computerPiece.getBankValue() - 100);	break;
			
			//Top Set
			case 20: kentucky_ave_Square_ComputerOwned = true;		computerPiece.setBankValue(computerPiece.getBankValue() - 200);	break;
			case 22: indiana_ave_Square_ComputerOwned = true; 		computerPiece.setBankValue(computerPiece.getBankValue() - 200);	break;
			case 23: illinois_ave_Square_ComputerOwned = true;		computerPiece.setBankValue(computerPiece.getBankValue() - 250);	break;
			case 24: bo_RR_Square_HumanOwned = true; 				computerPiece.setBankValue(computerPiece.getBankValue() - 250);	break;
			case 25: atlantic_ave_Square_ComputerOwned = true;		computerPiece.setBankValue(computerPiece.getBankValue() - 250);	break;			
			case 26: ventnor_ave_Square_ComputerOwned = true; 		computerPiece.setBankValue(computerPiece.getBankValue() - 250);	break;
			case 27: water_works_Square_ComputerOwned = true;		computerPiece.setBankValue(computerPiece.getBankValue() - 250);	break;
			case 28: marvin_gardens_Square_ComputerOwned = true; 	computerPiece.setBankValue(computerPiece.getBankValue() - 300);	break;
			
			//Right set
			case 30: pacific_ave_Square_ComputerOwned = true; 		computerPiece.setBankValue(computerPiece.getBankValue() - 300);	break;
			case 31: no_carolina_ave_Square_ComputerOwned = true; 	computerPiece.setBankValue(computerPiece.getBankValue() - 300);	break;
			case 33: pennsylvania_ave_Square_ComputerOwned = true;	computerPiece.setBankValue(computerPiece.getBankValue() - 300);	break;
			case 34: short_line_RR_Square_ComputerOwned = true; 	computerPiece.setBankValue(computerPiece.getBankValue() - 350);	break;
			case 36: park_place_Square_ComputerOwned = true; 		computerPiece.setBankValue(computerPiece.getBankValue() - 350);	break;
			case 38: boardwalk_Square_ComputerOwned = true; 		computerPiece.setBankValue(computerPiece.getBankValue() - 350);	break;			
			default: break;
		}
	}
	
	//Properties that you or the computer can't buy, and the effects they cause. 
	public void nonBuyableProperty_Human()
	{System.out.println("Loading non buyable propertsy for human");
		switch(moveHumanPiece)
		{
			//bottom set
			case 1: 	communityChest_Human();	
						break; //Community Chest					
			case 3: 	humanPiece.setBankValue(humanPiece.getBankValue() - 200); 
						taxesCollected +=200;	
						break; //Income Tax					
			case 7: 	chance_Human();
						break; //Chance					
			case 9: 	break; //Visiting Jail			
			
			//left set
			case 16:	communityChest_Human();
					 	break; //Community Chest
					 
			case 19: 	humanPiece.setBankValue(humanPiece.getBankValue() + taxesCollected);
						taxesCollected = 0;
						break; //Free parking			
			
			//top set
			case 21: 	chance_Human();				
						break; //Chance						
			case 29: 	break; //Go to jail			
			
			
			//right set
			case 32: 	communityChest_Human();		
						break; //Community Chest						
			case 35: 	chance_Human();				
						break; //Chance						
			case 37: 	humanPiece.setBankValue(humanPiece.getBankValue() - 1000); 
						taxesCollected +=1000;
						break; //Luxury  Tax						
			case 39: 	humanPiece.setBankValue(humanPiece.getBankValue() + 400);
						break; //Go			
			default: 	break;
		}
	}
	public void nonBuyableProperty_Computer()
	{System.out.println("Loading non buyable properties for computer.");
		switch(moveComputerPiece)
		{
			//bottom set
			case 1: 	communityChest_Computer();	
						break; //Community Chest					
			case 3: 	computerPiece.setBankValue(computerPiece.getBankValue() - 200); 
						taxesCollected +=200;	
						break; //Income Tax					
			case 7: 	chance_Computer();
						break; //Chance					
			case 9: 	break; //Visiting Jail			
			
			//left set
			case 16:	communityChest_Computer();
					 	break; //Community Chest
					 
			case 19: 	computerPiece.setBankValue(computerPiece.getBankValue() + taxesCollected);
						taxesCollected = 0;
						break; //Free parking			
			
			//top set
			case 21: 	chance_Computer();				
						break; //Chance						
			case 29: 	break; //Go to jail			
			
			
			//right set
			case 32: 	communityChest_Computer();		
						break; //Community Chest						
			case 35: 	chance_Computer();				
						break; //Chance						
			case 37: 	computerPiece.setBankValue(computerPiece.getBankValue() - 1000); 
						taxesCollected +=1000;
						break; //Luxury  Tax						
			case 39: 	computerPiece.setBankValue(computerPiece.getBankValue() + 400);
						break; //Go			
			default: 	break;
		}
	}
		
	//Player loses money
	public void communityChest_Human()
	{System.out.println("Loading Community chest for human. ");
		int random = rand.nextInt(9);		
		switch(random)
		{
			case 0: humanPiece.setBankValue(humanPiece.getBankValue() - 1);		break;
			case 1: humanPiece.setBankValue(humanPiece.getBankValue() - 50);	break;
			case 2: humanPiece.setBankValue(humanPiece.getBankValue() - 75);	break;
			case 3: humanPiece.setBankValue(humanPiece.getBankValue() - 100);	break;
			case 4: humanPiece.setBankValue(humanPiece.getBankValue() - 150);	break;
			case 5: humanPiece.setBankValue(humanPiece.getBankValue() - 300);	break;
			case 6: humanPiece.setBankValue(humanPiece.getBankValue() - 350);	break;
			case 7: humanPiece.setBankValue(humanPiece.getBankValue() - 500);	break;
			case 8: humanPiece.setBankValue(humanPiece.getBankValue() - 1000);	break;			
			default: break;
		}
	}
	//Player gains money
	public void chance_Human()
	{System.out.println("Loading chance for human. ");
		int random = rand.nextInt(9);		
		switch(random)
		{
			case 0: humanPiece.setBankValue(humanPiece.getBankValue() + 1);		break;
			case 1: humanPiece.setBankValue(humanPiece.getBankValue() + 50);	break;
			case 2: humanPiece.setBankValue(humanPiece.getBankValue() + 75);	break;
			case 3: humanPiece.setBankValue(humanPiece.getBankValue() + 100);	break;
			case 4: humanPiece.setBankValue(humanPiece.getBankValue() + 150);	break;
			case 5: humanPiece.setBankValue(humanPiece.getBankValue() + 300);	break;
			case 6: humanPiece.setBankValue(humanPiece.getBankValue() + 350);	break;
			case 7: humanPiece.setBankValue(humanPiece.getBankValue() + 500);	break;
			case 8: humanPiece.setBankValue(humanPiece.getBankValue() + 1000);	break;			
			default: break;
		}
	}
	
	//Player loses money
	public void communityChest_Computer()
	{System.out.println("Loading Community Chest for Computer ");
		int random = rand.nextInt(9);		
		switch(random)
		{
			case 0: computerPiece.setBankValue(computerPiece.getBankValue() - 1);		break;
			case 1: computerPiece.setBankValue(computerPiece.getBankValue() - 50);		break;
			case 2: computerPiece.setBankValue(computerPiece.getBankValue() - 75);		break;
			case 3: computerPiece.setBankValue(computerPiece.getBankValue() - 100);		break;
			case 4: computerPiece.setBankValue(computerPiece.getBankValue() - 150);		break;
			case 5: computerPiece.setBankValue(computerPiece.getBankValue() - 300);		break;
			case 6: computerPiece.setBankValue(computerPiece.getBankValue() - 350);		break;
			case 7: computerPiece.setBankValue(computerPiece.getBankValue() - 500);		break;
			case 8: computerPiece.setBankValue(computerPiece.getBankValue() - 1000);	break;			
			default: break;
		}
	}
	//Player gains money
	public void chance_Computer()
	{System.out.println("Loading Chance for Computer");
		int random = rand.nextInt(9);		
		switch(random)
		{
			case 0: computerPiece.setBankValue(computerPiece.getBankValue() + 1);		break;
			case 1: computerPiece.setBankValue(computerPiece.getBankValue() + 50);		break;
			case 2: computerPiece.setBankValue(computerPiece.getBankValue() + 75);		break;
			case 3: computerPiece.setBankValue(computerPiece.getBankValue() + 100);		break;
			case 4: computerPiece.setBankValue(computerPiece.getBankValue() + 150);		break;
			case 5: computerPiece.setBankValue(computerPiece.getBankValue() + 300);		break;
			case 6: computerPiece.setBankValue(computerPiece.getBankValue() + 350);		break;
			case 7: computerPiece.setBankValue(computerPiece.getBankValue() + 500);		break;
			case 8: computerPiece.setBankValue(computerPiece.getBankValue() + 1000);	break;			
			default: break;
		}
	}

	public void runComputer()
	{	System.out.println("Loading runComputer() method ");
		swapPlayersTurn(); //Chances the players turn
		
		pieceMover(); //moves the computer piece
		
		buyProperty_Computer(); //checks to buy a property
		nonBuyableProperty_Computer(); //checks for a property effect.		
	}	
		
	public void isGameOver()
	{System.out.println("Loading isGameOver() method");
		if(humanPiece.getBankValue() < 1)		
		{
			humanHasLostGame = true;			
		}
		else if(computerPiece.getBankValue() < 1)
		{
			computerHasLostGame = true;
		}
	}
	
	//Misc set and get methods auto generated.
	public int getCurrentDiceTotal() {
		return currentDiceTotal;
	}
	public void setCurrentDiceTotal(int currentDiceTotal) 
	{
		this.currentDiceTotal = currentDiceTotal;
	}
	public int getHumanX() 
	{
		return humanX;
	}
	public void setHumanX(int humanX)
	{
		this.humanX = humanX;
	}
	public int getHumanY() 
	{
		return humanY;
	}
	public void setHumanY(int humanY) 
	{
		this.humanY = humanY;
	}
	public int getComputerX() 
	{
		return computerX;
	}
	public void setComputerX(int computerX) 
	{
		this.computerX = computerX;
	}
	public int getComputerY() 
	{
		return computerY;
	}
	public void setComputerY(int computerY)
	{
		this.computerY = computerY;
	}	
	public int 	getMoveHumanPiece() 
	{
		return moveHumanPiece;
	}
	public void setMoveHumanPiece(int moveHumanPiece) 
	{
		this.moveHumanPiece = moveHumanPiece;
	}
	public int 	getMoveComputerPiece() 
	{
		return moveComputerPiece;
	}
	public void setMoveComputerPiece(int moveComputerPiece) 
	{
		this.moveComputerPiece = moveComputerPiece;
	}
}
