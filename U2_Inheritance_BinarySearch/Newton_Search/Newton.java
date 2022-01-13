public class Newton{
      public static double sqrt(double x, double left, double right, double err){
         /*Calculates the square root of x using Newton's Method (Bisection Search)
         Inputs:
            double x: the num. whose sqrt you want
            double left: initial left bracket, left * left < x
            double right: initial right bracket, right * right > x
            double err: the max. error on the answer
         Outputs:
            return: the approx. sqrt(x)
         Ex.
         sqrt(18, 4, 5, 0.1)   -> 4.21875
         sqrt(18, 4, 5, 0.01)  -> 4.24609375
         sqrt(18, 4, 5, 0.001) -> 4.24267578125
         */
         if(x < 0){
            throw new IllegalArgumentException("x must be >= 0");
         }
         double middle = 0;
         
         
         //boolean found = false;
         if (x >= 1){
            while ((right - left) > err){
               middle = (left + right)/2;
               double midSQ = Math.pow(middle, 2);
               if (x > midSQ){
                  left = middle;
               }
               else if (x < midSQ){
                  right = middle;
               }
               else{
                  return middle;
               }
               //StdOut.println("MIDDLE: " + middle);
            }
         }
         else{
            while (right - left > err){
               middle = (left + right)/2;
               double midSQ = Math.pow(middle, 2);
               if (midSQ > x){
                  right = middle;
               }
               else if (midSQ < x){
                  left = middle;
               }
               else{
                  return middle;
               }
               //StdOut.println("MIDDLE: " + middle);
            }
         }
         return middle;
      }
      
      //your code goes below
      public static double sqrt(double x, double err){
         /*Calculates the square root of x
         using Newton's Method (Bisection Search)
         Inputs:
            double x: the num. whose sqrt you want
            double err: the max. error on the answer
         Outputs:
            return: the approx. sqrt(x)
         Ex.
         sqrt(6.0, 0.001) -> 2.44970703125
         sqrt(4.0, 0.001) -> 2.0
         sqrt(1.0, 0.001) -> 1.0
         */
         //check if x is valid for sqrt()
         if(x < 0){
            throw new IllegalArgumentException("x must be >= 0");
         }
         double left;
         double right;
         double counter = 0;
         for (int i = 0; (Math.pow(i, 2) < x); i++){
            counter = i;
         }
         left = counter;
         right = counter + 1;
         return Newton.sqrt(x, left, right, err);
   }
}