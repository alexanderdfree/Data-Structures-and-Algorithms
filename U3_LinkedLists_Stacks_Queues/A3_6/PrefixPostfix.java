/*
A class for evaluating expressions in prefix and postfix notation
*/

public class PrefixPostfix{
   public static LQueue tokenize(String exp){
      /*Split a String containing mathematical expressions into
      a series of tokens. All operators and operands must be separated
      by whitespace.
      Input:
         String exp: a String representing a mathematical expression
      Output:
         return: a Queue containing the split tokens
      Ex.
      tokenize("+ 3 4") -> ["+", "3", "4"]
      tokenize("* -2.5 - 4.13 9") -> ["*", "-2.5", "-", "4.13", "9"]
      */
      LQueue tokens = new LQueue();
      String token = "";
      boolean inToken = true; //flag to delete whitespace
      for(int i = 0; i < exp.length(); i++){
         char c = exp.charAt(i);
         if(inToken == true){ //currently reading a token
            if(c == ' '){
               inToken = false;
               tokens.add(token);
               token = "";
            }
            else{
               token += c;
            }
         }
         else{//skipping white space
            if(c != ' '){
               inToken = true;
               token += c;
            }
         }
      }
      if(token.equals("") == false){//if the string ended on a token
         tokens.add(token);
      }
      return tokens;
   }
   
   public static boolean isOperator(String token){
      /*Check if the given token is a valid arithmetic operator
      Input:
         String token: the token to check
      Output:
         return: true if token is a valid arithmetic operator
      Ex.
      isOperator("*") -> true
      isOperator("^") -> true
      isOperator("1.5") -> false
      */
      if(token.equals("+")){
         return true;
      }
      if(token.equals("-")){
         return true;
      }
      if(token.equals("*")){
         return true;
      }
      if(token.equals("/")){
         return true;
      }
      if(token.equals("^")){
         return true;
      }
      return false;
   }
   
   public static double arithmetic(String operator, double operand1, double operand2){
      /*Evaluate basic arithmetic operations
      Input:
         String operator: a String representing a supported 
                          arithmetic operation:
                          +: addition
                          -: subtraction
                          *: multiplication
                          /: division
                          ^: power
         double operand1: the 1st operand
         double operand2: the 2nd operand
      Output:
         return: the result of the operation
      Ex.
      arithmetic("+", 1, 2) -> 3.0
      arithmetic("-", 7, 6) -> 1.0
      arithmetic("*", 1.5, 2) -> 3.0
      arithmetic("/", 4, 5) -> 0.8
      arithmetic("^", 2, 3) -> 8.0
      */
      if(operator.equals("+")){
         return operand1 + operand2;
      }
      else if(operator.equals("-")){
         return operand1 - operand2;
      }
      else if(operator.equals("*")){
         return operand1 * operand2;
      }
      else if(operator.equals("/")){
         return operand1 / operand2;
      }
      else if(operator.equals("^")){
         return Math.pow(operand1, operand2);
      }
      else{
         throw new IllegalArgumentException("unsupported operator: "+operator);
      }
   }
   public static double evalPrefix(String exp){
      /*Evaluate an expression written in prefix notation
      Input:
         String exp: an arithmetic expression in prefix notation
      Output:
         return: the calculated value of the expression
      Ex.
      evalPrefix("+ 1 2") -> 3.0
      evalPrefix("- 3 4") -> -1.0
      evalPrefix("* 2 - 3 4) -> -2.0
      evalPrefix("* + 8 3 / 5 - 7 2") -> 11.0
      */
      LQueue t = tokenize(exp);
      LStack s = new LStack();
      while(t.size() > 0 || s.size() > 1){
         if (!t.isEmpty()){
            s.push(t.remove());
         }
         if (s.size() >= 3){
            Object o1 = s.pop();
            Object o2 = s.pop();
            Object o3 = s.pop();
            if (isOperator((String)o3) && !isOperator((String)o2) && !isOperator((String)o1)){
               //if ()
               
               
               
               
               double o22 = Double.parseDouble((String)o2);
               double o11 = Double.parseDouble((String)o1);
               double ans = arithmetic((String)o3, o22, o11);
               s.push(Double.toString(ans));
            }
            else{
               s.push(o3);
               s.push(o2);
               s.push(o1);
            }            
         }
      }
      return Double.parseDouble((String)s.pop());
   }
   public static double evalPostfix(String exp){
      /*Evaluate an expression written in postfix notation
      Input:
         String exp: an expression in postfix notation
      Output:
         return: the calculated value of the expression
      Ex.
      evalPostfix("2 1 +") -> 3.0
      evalPostfix("3 4 -") -> -1.0
      evalPostfix("2 3 4 - *) -> -2.0
      evalPostfix("8 3 + 5 7 2 - / *") -> 11.0
      */
      LQueue t = tokenize(exp);
      LStack s = new LStack();
      while(t.size() > 0 || s.size() > 1){
         if (!t.isEmpty()){
            s.push(t.remove());
         }
         if (s.size() >= 3){
            Object o1 = s.pop();
            Object o2 = s.pop();
            Object o3 = s.pop();
            if (isOperator((String)o1) && !isOperator((String)o2) && !isOperator((String)o3)){
               //if ()
               
               
               
               
               double o22 = Double.parseDouble((String)o2);
               double o33 = Double.parseDouble((String)o3);
               double ans = arithmetic((String)o1, o33, o22);
               s.push(Double.toString(ans));
            }
            else{
               s.push(o3);
               s.push(o2);
               s.push(o1);
            }            
         }
      }
      return Double.parseDouble((String)s.pop());
   }
   public static void main(String args[]){
      StdOut.println(evalPrefix("+ 1 2"));
      StdOut.println(evalPrefix("- 3 4"));
      StdOut.println(evalPrefix("* 2 - 3 4"));
      StdOut.println(evalPrefix("* + 8 3 / 5 - 7 2"));
      
      StdOut.println(evalPostfix("2 1 +"));
      StdOut.println(evalPostfix("3 4 -"));
      StdOut.println(evalPostfix("2 3 4 - *"));
      StdOut.println(evalPostfix("8 3 + 5 7 2 - / *"));

   
   }
}

