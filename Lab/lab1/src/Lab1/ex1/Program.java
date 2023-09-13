package Lab1.ex1;

public class Program {
	public static  void main(String[] args) {
		if (args.length == 3) {
			int firstOperand = Integer.parseInt(args[0]);
			int secondOperand = Integer.parseInt(args[2]);
			
			String operator = args[1];
			mathOperation(firstOperand, secondOperand, operator);
			
		} else if (args.length == 1){
			String[] expression = args[0].split(" ");
			
			if(expression.length != 3) {
				System.out.println("Invalid expression");
				return;
			}
			
			int firstOperand = Integer.parseInt(args[0]);
			int secondOperand = Integer.parseInt(args[2]);
			
			String operator = args[1];
			mathOperation(firstOperand, secondOperand, operator);
		} else {
			System.out.println("Invalid expression");
		}
	}
	
	public static void mathOperation(int firstOperand, int secondOperand, String operator) {
		switch (operator){
			case "+" -> System.out.println(add(firstOperand, secondOperand));
			case "-" -> System.out.println(subtract(firstOperand, secondOperand));
			case "*" -> System.out.println(multiply(firstOperand, secondOperand));
			case "/" -> System.out.println(divide(firstOperand, secondOperand));
			case "^" -> System.out.println(exponent(firstOperand, secondOperand));
			default -> System.out.println("Unsupported operator");
		}
	}
		
	public static int add(int firstOperand, int secondOperand) {
		return firstOperand + secondOperand;
	}
	
	public static int subtract(int firstOperand, int secondOperand) {
		return firstOperand - secondOperand;
	}
	
	public static int multiply(int firstOperand, int secondOperand) {
		return firstOperand * secondOperand;
	}
	
	public static double divide(int firstOperand, int secondOperand) {
		return firstOperand*1.0 / secondOperand;
	}
	
	public static double exponent(int firstOperand, int secondOperand) {
		return Math.pow(firstOperand, secondOperand);
	}
}
