

/**
 *
 */
public class Program {
	public static  void main(String[] args) {
		if (args.length == 3) {
			double firstOperand = Double.parseDouble(args[0]);
			double secondOperand = Double.parseDouble(args[2]);
			
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
	
	public static void mathOperation(double firstOperand, double secondOperand, String operator) {
		switch (operator){
			case "+" -> System.out.println(firstOperand + secondOperand);
			case "-" -> System.out.println(firstOperand - secondOperand);
			case "*" -> System.out.println(firstOperand * secondOperand);
			case "/" -> System.out.println(firstOperand / secondOperand);
			case "^" -> System.out.println(Math.pow(firstOperand,secondOperand));
			default -> System.out.println("Unsupported operator");
		}
	}

}
