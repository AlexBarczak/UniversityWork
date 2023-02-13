import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Random;
import java.util.LinkedList;

public class Lottery {
	
	
	private int lotteryMax;
	private LinkedList<LotteryPlayer> players;

	public static void main(String[] args) {
		Lottery myLottery = new Lottery();		
		myLottery.menu();
	}
	
	
	/**
	 * Initialising method for the Lottery object
	 * 
	 * sets range of lottery numbers to 10 and creates an empty players list by default
	 */
	public Lottery() {
		this.lotteryMax = 10;
		this.players = new LinkedList<LotteryPlayer>();
	}
	
	/**
	 * method for the user to have access to a menu where he can choose what to do in the program
	 * be it adding players, changing the range, or leaving, it's all from here
	 */
	public void menu() {
		System.out.println("\n\nWelcome to the most (or least) generous lottery there is ~it's variable~");

		System.out.println("what would you like to do?\n");
		System.out.println("1. run the lottery once");
		System.out.println("2. change the max number in the lottery");
		System.out.println("3. add a player to the weekly lottery");
		System.out.println("4. run the weekly lottery for a number of weeks");
		System.out.println("5. clear the weekly lottery of players");
		System.out.println("6. leave");
		
		String input = takeUserInput();
		if(input.equals("1")) {
			runOnce();
			menu();
		}else if(input.equals("2")) {
			changeMax();
			menu();
		}else if(input.equals("3")) {
			addPlayer();
			menu();
		}else if(input.equals("4")) {
			runLottery();
			menu();
		}else if(input.equals("5")) {
			clearPlayers();
			menu();
		}else if(input.equals("6")) {
			System.exit(0);
		}else {
			System.out.println("Sorry, I didn't catch that, try again.");
			menu();
		}
		
	}

	
	/**
	 * runs a single lottery ticket instance where the player is asked to enter six numbers and then six random numbers are generated to see what winnings are earned
	 */
	private void runOnce() {
		//create a player for one round
		LotteryPlayer player = new LotteryPlayer(lotteryMax);
		
		Set<Integer> winningNumbers = generateWinningNumbers();
		
		while(winningNumbers.size()<6) {
			Random rng = new Random();
			
			winningNumbers.add(rng.nextInt(lotteryMax)+1);
		}
		
		player.runGame(winningNumbers);
		
	}
	
	
	/**
	 * allows the user to change the range of the lottery numbers
	 */
	private void changeMax() {
		System.out.println("Warning, doing this will clear te players in the weekly lottery to keep things working properly (it would work fine anyways)");
		System.out.println("do you want to proceed? Y/N");
		
		String input = takeUserInput().toUpperCase();
		
		if (input.equals("Y")) {
			System.out.println("Cool");
			clearPlayers();
			
			while (true) {
				System.out.println("Enter the new max value: ");
				try {
					Integer newMax = Integer.parseInt(takeUserInput()); 
					if(newMax <= 6) {
						System.out.println("the lottery needs at least values to run!");
						continue;
					}
					this.lotteryMax = newMax;
				} catch (Exception e) {
					System.out.println("I don't understand. Try again.");
				}
				break;
			}
			
		} else if (input.equals("N")) {
			System.out.println("OK");
		} else {
			System.out.println("Sorry, I can't understand that, I'll return you to the menu");
		}
		menu();
	}

	
	/**
	 * clears the weekly players LinkedList to allow the creation of a completely separate bunch of players
	 */
	private void clearPlayers() {
		this.players = new LinkedList<LotteryPlayer>();
	}
	
	private Set<Integer> generateWinningNumbers() {
		
		Set<Integer> winningNumbers = new HashSet<Integer>();
		while(winningNumbers.size()<6) {
			Random rng = new Random();
			
			winningNumbers.add(rng.nextInt(lotteryMax)+1);
		}
		return winningNumbers;
	}

	private void addPlayer() {
		this.players.add(new LotteryPlayer(this.lotteryMax, this.players.size()));
	}
	
	
	/**
	 * Method for running the weekly lottery for a user chosen number of weeks, 
	 * will display each individual week's winning numbers, the weekly players with their numbers
	 * and what they may have won
	 */
	private void runLottery() {
		Integer weeks;
		while(true) {
			System.out.println("how many weeks would you like to run the lottery for?");	
			try {
				weeks = Integer.parseInt(takeUserInput());
			}catch(Exception e) {
				System.out.println("something went wrong. try again.");
				continue;
			}
			if(weeks < 1) {
				System.out.println("cannot run lottery for less than a single week. AGAIN");
				continue;
			}
			break;
		}
		
		for(int i = 0; i < weeks; i++) {			
			Set<Integer> winningNumbersForWeek = generateWinningNumbers();
			
			System.out.println("\nweek " + i + " winning numbers: "+winningNumbersForWeek+"\n");
			
			Iterator<LotteryPlayer> playerLoop = players.iterator();
			
			while(playerLoop.hasNext()) {
				playerLoop.next().runGame(winningNumbersForWeek);
			}
		}
		
		Iterator<LotteryPlayer> playerLoop = players.iterator();
		
		System.out.println("\n\n");
		
		while(playerLoop.hasNext()) {
			LotteryPlayer player = playerLoop.next();
			
			System.out.println("player " + player.getID() + " spent £" + player.getSpendings() + " and won £" + player.getWinnings() + " for a profit of £" + player.getProfit());
		}
		
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
	
}
