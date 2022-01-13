public class Gaussian{
    public static double pdf(double x, double mean, double std){
      /*Evaluate the value of the probability density function
      at x for the given values of the mean and std. dev.
      Input:
         double x: the point where you want to evaluate the PDF
         double mean: the mean value of the distribution
         double std: the standard deviation of the distribution
      Output:
         return: the value of the PDF at x
      Ex.
      pdf(0.5, 0.5, 1.0) -> 0.3989422804014327
      pdf(-1.0, 0.0, 1.0) -> 0.24197072451914337
      pdf(6.0, 0.0, 2.0) -> 0.0022159242059690038
      */
      //double z = x - mean/std
      double sq = (x - mean)/std;
      double exp = -0.5 * Math.pow(sq, 2);
      double eFunc = Math.pow(Math.E, exp);
      double denominator = std * Math.sqrt(Math.PI * 2);
      return eFunc / denominator;
    }
    public static double riemann(double xStart, double xFinish, double mean, double std, double dx){
      /*Calculate the area underneath PDF(x) from xStart to
      xFinish using a trapezoidal Riemann sum.
      Input:
         double xStart: the starting x-coordinate for the area 
         double xFinish: the ending x-coordinate for the area 
         double mean: the mean value of the distribution
         double std: the standard deviation of the distribution
         double dx: the step-size for drawing trapezoids
      Output:
         return: the area under PDF(x) from xStart to xFinish
      Ex.
      riemann(-1.0, 0.0, 0.0, 1.0, 0.001) -> 0.3413...
      riemann(-1.0, 1.0, 0.0, 1.0, 0.001) -> 0.6826...
      riemann(-1.0, 2.0, 1.0, 1.0, 0.001) -> 0.8185...
      */
      double remainder = (xFinish - xStart) % dx;
      double second = Gaussian.pdf((xFinish - remainder), mean, std);
      double done = Gaussian.pdf(xFinish, mean, std);
      double DONE = (second + done) * dx /2;
      double counter = xStart;
      double area = 0;
      while (counter < xFinish - remainder){
         double one = Gaussian.pdf(counter, mean, std);
         double two = Gaussian.pdf(counter + dx, mean, std);
         area += (one + two)/2;
         counter += dx;
      }
      area *= dx;
      return area + DONE;
   }
   public static double cdf(double x, double mean, double std, double dx){
      /*Evaluate the value of the Gaussian cumulative
      distribution function at x for the given values of the
      mean and standard deviation. Calculate the result
      numerically using a trapezoidal Riemann sum with dx 
      step size.
      Input:
         double x: the point where you want to evaluate the CDF
         double mean: the mean value of the distribution
         double std: the standard deviation of the distribution
         double dx: the step size to use for num. integration
      Output:
         return: the approx. value of the CDF at x
      Ex.
      cdf(-1.0, 0.0, 1.0, 0.01) -> 0.1586...
      cdf(2.0, 1.0, 2.0, 0.001) -> 0.6914...
      cdf(10.0, 10.0, 3.0, 0.001) -> 0.5
      */
      double total = 0;
      if (x > mean){
         total = 0.5 + Gaussian.riemann(mean, x, mean, std, dx);
         
      }
      else if (x < mean){
         total = 0.5 - Gaussian.riemann(x, mean, mean, std, dx);
      }
      else{
         return 0.5;
      }
      return total;
   }
   public static double inv_cdf(double p, double xLeft, double xRight, double mean, double std, double dx, double error){
      /*Find x such that cdf(x) = p for a Gaussian distribution
      with the given mean and standard deviation.
      Input:
         double p: the probability output from cdf(x) we want
         double xLeft: initial left bracket i.e. cdf(xLeft) < p
         double xRight: initial right bracket i.e. cdf(xRight)>p
         double mean: the mean value of the distribution
         double std: the standard deviation of the distribution
         double dx: the step size for evaluating the cdf(x)
         double error: the max. amount of acceptable error on x
      Output:
         return: the approx. value of x that makes cdf(x) = p
     Ex.
      inv_cdf(0.25, -3.0, 3.0, 0.0, 1.0, 0.0001, 0.0001) ~> -0.674...
      inv_cdf(0.80, -10.0, 10.0, 1.0, 3.0, 0.0001, 0.0001) ~> 3.524...
      */
      double middle = 0;
      while (xRight - xLeft > error){
            middle = (xLeft + xRight)/2;
            double cdfMid = Gaussian.cdf(middle, mean, std, dx);
            if (p > cdfMid){
               xLeft = middle;
            }
            else if (p < cdfMid){
               xRight = middle;
            }
            else{
               return middle;
            }
       }
       return middle;
   }
   public static double inv_cdf(double p, double mean, double std, double dx, double error){
      /*Find x such that cdf(x) = p for a Gaussian distribution
      with the given mean and standard deviation.
      Input:
         double p: the probability output from cdf(x) we want
         double mean: the mean value of the distribution
         double std: the standard deviation of the distribution
         double dx: the step size for evaluating the cdf(x)
         double error: the max. amount of acceptable error on x
      Output:
         return: the approx. value of x that makes cdf(x) = p
     Ex.
      inv_cdf(0.25, 0.0, 1.0, 0.0001, 0.0001) ~> -0.674...
      inv_cdf(0.80, 1.0, 3.0, 0.0001, 0.0001) ~> 3.524...
      */
      double left = 0;
      double right = 0;
      double rightD = std;
      double leftD = -std;
      while (Gaussian.cdf(mean + rightD, mean, std, dx) < p){
         rightD *= 2;
      }
      while(Gaussian.cdf(mean + leftD, mean, std, dx) > p){
         leftD *= 2;
      }
      left = mean + leftD;
      right = mean + rightD;
      return Gaussian.inv_cdf(p, left, right, mean, std, dx, error);
   }
}