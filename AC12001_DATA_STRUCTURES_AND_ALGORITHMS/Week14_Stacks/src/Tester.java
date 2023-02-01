import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tester {

	public static void main(String[] args) {
		menu();
	}
	
	
/**
 * Opens the menu from where the user can select from a range of options
 */
	private static void menu() {
		
		System.out.println("\n\nWhat would you like to do with my RPN calculator?\n");
		
		System.out.println("1. Explain RPN");
		System.out.println("2. Use Calculator");
		System.out.println("3. Quit");
		
		String input = takeUserInput();
		
		if (input.equals("1")) {
			explainRPN();
			menu();
		} else if (input.equals("2")) {
			runCalculator();
			menu();
		} else if (input.equals("3")) {
			System.exit(0);
		}else {
			System.out.println("Sorry, I don't understand the input, enter in either '1', '2' or '3'\n");
			menu();
		}
		
	}
	
	/**
	 * Asks the user to enter a mathematical expression and then calculates the result of said expression
	 */
	private static void runCalculator() {
		System.out.println("\n\nEnter the expression you wish to calculate using spaces between each operator and operand (or enter 'exit' to return to the menu)");
		
		String expression = takeUserInput();
		
		if(expression.equals("exit")) return;
		
		// take the expression and split it into operands and operators by separating each one with a space
		String[] expressionElements = expression.split(" ");
		
		// an expression needs to have at least the elements in it
		if(expressionElements.length < 3) {
			System.out.println("Sorry, that's either not long enough to be an expression or you've not spaced your elements");
			System.out.println("You can try again");
			return;
		}
		
		Stack<Double> testerStack = new Stack<Double>();
		Stack<String> infixConversionStack = new Stack<String>();
		
		try {
		
		//for every element in the expression
		for(int i = 0; i < expressionElements.length; i++) {
			//figure out whether it is an operand or an operator
			//i.e check whether it is a '+', '-', '*', '/' or a number
			// then we take two elements from the stack perform an operation on them and return the result to the stack
			
			if (expressionElements[i].equals("+")){
				testerStack.push(testerStack.pop()+testerStack.pop());
				infixConversionStack.push("(" + infixConversionStack.pop() + " + " + infixConversionStack.pop() + ")");
			} else if (expressionElements[i].equals("-")){
				testerStack.push(testerStack.pop()-testerStack.pop());
				infixConversionStack.push("(" + infixConversionStack.pop() + " - " + infixConversionStack.pop() + ")");
			} else if (expressionElements[i].equals("*")){
				testerStack.push(testerStack.pop()*testerStack.pop());
				infixConversionStack.push("(" + infixConversionStack.pop() + " * " + infixConversionStack.pop() + ")");
			} else if (expressionElements[i].equals("/")){
				testerStack.push(testerStack.pop()/testerStack.pop());
				infixConversionStack.push("(" + infixConversionStack.pop() + " / " + infixConversionStack.pop() + ")");
			} else {
				//or if the the token is a number we add it to the stack
				testerStack.push(Double.parseDouble(expressionElements[i]));
				infixConversionStack.push(expressionElements[i]);
			}
		}

		//print the result
		Double result = testerStack.pop();
		
		//there should be nothing left in the stack except the result
		if (!testerStack.isEmpty()) {
			System.out.println("Invalid RPN Expression");
			return;
		}
		
		System.out.println(result);
		System.out.println("Infix version: " + infixConversionStack.pop());
		
		} catch(EmptyStackException e) {
			System.out.println("Invalid RPN Expression");
		} catch(NumberFormatException e) {
			System.out.println("Invalid RPN Expression");
		}
	}

	/**
	 * provides a basic explanation of RPN notation in the console
	 */
	private static void explainRPN() {
		System.out.println("\n\nRPN is an acronym for Reverse Polish Notation and it represents a way of writing mathematical expressions without brackets\n");
		System.out.println("to do this, the notation places operators after the two of its operands instead of between them");
		System.out.println("you read the expression left to right and every time you encounter an operator you use it on the two operands before it\n\n");
		
		System.out.println("using RPN notation converts '(3 + 4) * 5' to '3 4 + 5 *'");	
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
