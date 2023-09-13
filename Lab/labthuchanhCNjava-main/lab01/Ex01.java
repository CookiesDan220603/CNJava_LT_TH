class Ex01{
    static String calculator(double a,double b, String operator){
        if(operator .equals( "+")){
            return String.valueOf(a + b);
        }
        else if(operator .equals( "-")){
            return String.valueOf(a - b);
        }
        else if(operator .equals( "x")){
            return String.valueOf(a * b);
        }
        else if(operator .equals( "/")){
            return String.valueOf(a / b);
        }
            return "Unsported operator";
    }
    public static void main(String[] args) {
        if(args.length!=3){
            System.out.println("Invalid expression");
        }
        else{
            Double a = Double.parseDouble(args[0]);
            Double b = Double.parseDouble(args[2]);
            String operator = args[1];
            System.out.println(calculator(a, b , operator));
        }
    }
}