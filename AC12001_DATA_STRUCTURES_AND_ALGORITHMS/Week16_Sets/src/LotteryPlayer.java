import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;

public class LotteryPlayer {
	
	//
	private Set<Integer> lotteryNumbers;
	private Integer lotteryMax;
	private Integer ID;
	private Integer spendings;
	private Integer winnings;
	
	
	/**
	 * initialising function for the lottery player object'
	 * sets default values for the ID, expenditures, winnings and then
	 * gets the player numbers as inputs from the user
	 * 
	 * @param lotteryMax is passed in to limit the player from using numbers outside the range
	 */
 	public LotteryPlayer(Integer lotteryMax) {
		this.lotteryMax = lotteryMax;
		this.ID = null;
		getPlayerNumbers();
		this.spendings = 0;
		this.winnings = 0;
	}

 	/**
 	 * initialising function for the lottery player object'
	 * sets default values for the ID, expenditures, winnings and then
	 * gets the player numbers as inputs from the user
	 * 
 	 * @param lotteryMax is passed in to limit the player from using numbers outside the range
 	 * @param ID is automatically passed in by the function creating these to differentiate them for the user
 	 */
	public LotteryPlayer(Integer lotteryMax, Integer ID) {
		this.lotteryMax = lotteryMax;
		this.ID = ID;
		getPlayerNumbers();
		this.spendings = 0;
		this.winnings = 0;
	}
	
	/**
	 * returns the player ID
	 * 
	 * @return the player ID
	 */
	public Integer getID() {
		return this.ID;
	}
	
	/**
	 * asks the user to enter six unique numbers between zero and the upper limit of the lottery numbers
	 * and then assigns them to the player until the end of time
	 */
	private void getPlayerNumbers() {
		//get six distinct numbers from user
		this.lotteryNumbers = new HashSet<Integer>();
		while(this.lotteryNumbers.size()<6) {
			if(this.ID != null)System.out.println("for player " + ID);
			System.out.println("\nEnter a number between 1 and " + lotteryMax + " not already entered ");
			System.out.print("Entered numbers: ");
			
			this.lotteryNumbers.forEach(new Consumer<Integer>() {
				  
	            @Override
	            public void accept(Integer t)
	            {
	                System.out.print(t + " ");
	            }
	  
	        });

			System.out.println();
			
			String userInput = takeUserInput();
			
			try {
				Integer number = Integer.parseInt(userInput);
				if(number > lotteryMax || number < 1) {
					System.out.println("value out of range, try again");
					continue;
				}
				if(!this.lotteryNumbers.add(number)) {
					System.out.println("this number is already listed");
				}
			} catch(Exception e) {
				System.out.println("try again");
			}
		}
	}

	/**
	 * returns the lottery numbers of the player 
	 * 
	 * @return the lottery numbers of the player 
	 */
	public Set<Integer> getLotteryNumbers() {
		return this.lotteryNumbers;
	}
	
	/**
	 * a nicer format for displaying the numbers of the player along with their ID
	 */
	public void displayPlayerAndNumbers() {
		//pretty sure this is mostly neglected and instead not used
		if(this.ID != null) System.out.print("player: " + ID + " are: ");
		this.lotteryNumbers.forEach(new Consumer<Integer>() {  
            @Override
            public void accept(Integer t)
            {
                System.out.print(t + " ");
            }
        });
		
	}
	
	/**
	 * 
	 * @return the input of the user as a String
	 */
  	public static String takeUserInput() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String userInput;
		while(true) {
			try {
				userInput = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("sorry, something went wrong. Try again");
				continue;
			}
		return userInput;
		}
	}

  	/**
  	 * returns the winnings of the player
  	 * 
  	 * @return the winnings of the player
  	 */
  	public Integer getWinnings() {
  		return this.winnings;
  	}
  	
  	/**
  	 * returns the spendings of the player
  	 * 
  	 * @return the spendings of the player
  	 */
  	public Integer getSpendings() {
  		return this.spendings;
  	}
  	
  	
  	/**
  	 * returns the profit the player has made (or loss)
  	 * 
  	 * @return the profit the player has made
  	 */
  	public Integer getProfit() {
  		return this.winnings - this.spendings;
  	}

  	
  	/**
  	 * compares the numbers of the player to the passed in winning values and 
  	 * evaluates whether or not the player has won any money
  	 * if he has then the sum is added to the winnings variable
  	 * aside from this each time you run this it adds two to the spendings
  	 * 
  	 * @param winningNumbers the numbers necessary to win
  	 */
  	public void runGame(Set<Integer> winningNumbers) {
  		this.spendings += 2;
  		
  		Integer matchingNumbers = 0;
  		
  		Iterator<Integer> it = winningNumbers.iterator();
  		
  		while(it.hasNext()) {
  			if(this.lotteryNumbers.contains(it.next()))matchingNumbers++;
  		}
  		
  		switch(matchingNumbers) {
  			case 3:
  				System.out.println("Player "+ this.ID +" won £25 with the numbers: " + this.lotteryNumbers);
  				this.winnings += 25;
  				break;
  			case 4:
  				System.out.println("Player "+ this.ID +" won £100 with the numbers: " + this.lotteryNumbers);
  				this.winnings += 100;
  				break;
  			case 5:
  				System.out.println("Player "+ this.ID +" won £1000 with the numbers: " + this.lotteryNumbers);
  				this.winnings += 1000;
  				break;
  			case 6:
  				System.out.println("Player "+ this.ID +" won £1000000 with the numbers: " + this.lotteryNumbers);
  				this.winnings += 1000000;
  				break;
  			default:
  				System.out.println("Player "+ this.ID +" won nothing with the numbers: " + this.lotteryNumbers);
  				break;
  		}
  	}
}
