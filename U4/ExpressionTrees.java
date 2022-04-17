public class ExpressionTrees{

   public static BTNode makeTree1(){
      /*Make a binary tree representing the expression:
      3.0*2.0 - 6.0/3.0
      */
      //your code goes here
      
      BTNode minus = new BTNode("-");
      BTNode multiply = new BTNode("*");
      BTNode divide = new BTNode("/");
      
      BTNode three1 = new BTNode(3.0);
      BTNode two = new BTNode(2.0);
      
      BTNode six = new BTNode(6.0);
      BTNode three2 = new BTNode(3.0);
      
      minus.setLeft(multiply);
      minus.setRight(divide);
      
      multiply.setLeft(three1);
      multiply.setRight(two);
      
      divide.setLeft(six);
      divide.setRight(three2);
      
      return minus;
   }
   
   public static BTNode makeTree2(){
      /*Make a binary tree representing the expression:
      0.75*(5.5 - 1.5) + 2.0*4.0
      */
      //your code goes here
      
      BTNode minus = new BTNode("-");
      BTNode multiply1 = new BTNode("*");
      BTNode multiply2 = new BTNode("*");
      BTNode plus = new BTNode("+");
      
      BTNode zero = new BTNode(0.75);
      
      BTNode five = new BTNode(5.5);
      BTNode one = new BTNode(1.5);
      
      
      BTNode two = new BTNode(2.0);
      BTNode four = new BTNode(4.0);
      
      
      plus.setLeft(multiply1);
      plus.setRight(multiply2);
      
      multiply1.setLeft(zero);
      multiply1.setRight(minus);
      
      minus.setLeft(five);
      minus.setRight(one);
      
      multiply2.setLeft(two);
      multiply2.setRight(four);
      
      return plus;
   }
   
   public static double evaluate(BTNode expTree){
      /*Evaluate an expression tree
      Input:
         BTNode expTree: an expression tree to evaluate
      Output:
         return: the result of evaluating the whole expression
      Ex.
      BTNode tree1 = makeTree1();
      BTNode tree2 = makeTree2();
      evaluate(tree1) -> 2.0
      evaluate(tree2) -> 11.0
      */
      
      if(expTree.getLeft().isLeaf() && expTree.getRight().isLeaf()){
        return arithmetic((String)expTree.getData(), (Double)expTree.getLeft().getData(), (Double)expTree.getRight().getData());  
      }
      else if(!expTree.getLeft().isLeaf() && expTree.getRight().isLeaf()){
         return arithmetic((String)expTree.getData(), evaluate(expTree.getLeft()), (Double)expTree.getRight().getData());
      }
      else if(!expTree.getRight().isLeaf() && expTree.getLeft().isLeaf()){
         return arithmetic((String)expTree.getData(), (Double)expTree.getLeft().getData(), (Double)evaluate(expTree.getRight()));
      }
      else{
         return arithmetic((String)expTree.getData(), evaluate(expTree.getLeft()), evaluate(expTree.getRight()));  
      }
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
   public static void main(String[] args){
      BTNode tree1 = ExpressionTrees.makeTree1();
   BTNode tree2 = ExpressionTrees.makeTree2();
   StdOut.println(ExpressionTrees.evaluate(tree1));
   StdOut.println(ExpressionTrees.evaluate(tree2));
   }

}
