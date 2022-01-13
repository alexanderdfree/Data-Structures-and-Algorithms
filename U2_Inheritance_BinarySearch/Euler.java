public class Euler{
   public static double number(int n){
      /*Calculate the value of Euler's Number
      using his original method of compounding 100%
      annual interest on an initial amount of $1.
      Inputs:
         int n: the number of periods to divide the year into
      Outputs:
         return: an approximation for e
      Ex.
      number(1) -> 2.0
      number(2) -> 2.25
      number(3) -> 2.3703703703703702
      number(100) -> 2.704813829421526
      */
      return Math.pow((1.0 + (1.0/n)), n);
   }
   public static double exp(double x, double err){
      /*Approximate the value of e^x using an infinite series.
      Stop when the next term is smaller than err.
      Inputs:
         double x: the value we want to raise e to
         double err: determines when to stop the series
      Outputs:
         return: approximate value of e^x
      Ex.
      exp(1.0, 0.01) -> 2.708333333333333
      exp(1.0, 0.0001) -> 2.7182539682539684
      exp(2.0, 0.0001) -> 7.388994708994708
      exp(2.5, 0.0001) -> 12.182464915219967
      exp(-1.0, 0.0001) -> 0.3678571428571429
      */
      boolean negative = false;
      if (x < 0){
         negative = true;
         x = 0 - x;
      }
      double total = 1;
      double current = 1;
      int i = 1;
      double num = 1;
      double den = 1;
      while (current >= err){
            
            num *= x;
            den *= i;
            current = num/den;
            total+=current;
            i++;
      }
      if (negative){
         total = 1/total;
      }
      return total;
   }
   public static double ln(double x, double err, double l, double r){
      /*Approximates ln(x) to within err. Solves for the value y
      that satisfies e^y = x. Must be given initial left and right
      bounds on y. Uses the same error for calculating exp()
      Inputs:
         double x: the value we want to take the log of
         double err: the max. error on our final answer
         double l: initial left bound, less than the solution
         double r: initial right bound, greater than the solution
      Outputs:
         return: approximate solution to ln(x)
      Ex.
      ln(10.0, 0.0001, 1.0, 10.0) -> 2.302585092994046
      ln(2.71828, 0.0001, 0.0, 10.0) -> 1.0000133514404297
      ln(0.1, 0.0001, -10.0, 0.0) -> -2.3022193908691406
      */
      double middle = 0;
      while (r - l > err){
            middle = (l + r)/2;
            double exponent = Euler.exp(middle, err);
            if (exponent < x){
               l = middle;
            }
            else if (exponent > x){
               r = middle;
            }
            else{
               return middle;
            }
       }
       return middle;
   }
   public static double ln(double x, double err){
      /*Approximates ln(x) to within err. Solves for the value y
      that satisfies e^y = x. Uses same error for calculating exp()
      Inputs:
         double x: the value we want to take the log of
         double err: the max. error on our final answer
      Outputs:
         return: approximate solution to ln(x)
      Ex.
      ln(10.0, 0.0001) -> 2.302585092994046
      ln(2.71828, 0.0001) -> 1.0000133514404297
      ln(0.1, 0.0001) -> -2.3022193908691406
      ln(1.0, 0.0001) -> 0.0
      */
      double left = 0;
      double right = 0;
      if (x == 0) return 0;
      else if (x > 1){
         left = 0;
         right = 1;
         while (Euler.exp(right, err) < x){
            right *= 2;
         }
         
      }
      else if (x < 1){
         left = -1;
         right = 0;
         while (Euler.exp(left, err) > x){
            left *= 2;
         }
      }
      
      return Euler.ln(x, err, left, right);
   }
   public static double log(double base, double x, double err){
      /*Approximate the log_base(x)
      Inputs:
         double base: the base of the logarithm to take
         double x: the number to take the log of
         double err: the max. error in calculations
      Output:
         return: approximate answer to log_base(x)
      Ex.
      log(10.0, 100.0, 0.0001) -> 2.0
      log(2.0, 256.0, 0.0001) -> 8.0
      log(0.5, 4.0, 0.0001) -> -2.0
      */
      return Euler.ln(x, err)/Euler.ln(base, err);
   }
   public static double pow(double a, double b, double err){
      /*Approximate a^b to within err. Only works for
      positive a
      Inputs:
         double a: the base (must be positive)
         double b: the exponent
         double err: the max. error on the answer
      Output:
         return: approximate answer for a^b
      Ex.
      pow(2.0, 4.0, 0.0001) -> 16.0
      pow(64.0, 0.5, 0.0001) -> 8.0
      pow(10.0, -1.0, 0.0001) -> 0.1 
      pow(2.5, 7.5, 0.0001) -> 965.050555
      */
      return Euler.exp(b * Euler.ln(a, err), err);
   }
}