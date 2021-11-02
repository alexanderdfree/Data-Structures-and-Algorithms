/*
A class for representing credit card charges
*/

public class Charge{
   private long accountNum;    //the account to charge
   private int expMonth;       //the expiration month given for the charge
   private int expYear;        //the expiration year given for the charge
   private int secCode;        //the security code given for the charge
   private double amount;      //the amount for the charge
   
   public Charge(long accNum, int expM, int expY, int sc, double amt){
      /*Initialize a new credit card charge*/
      this.accountNum = accNum;
      this.expMonth = expM;
      this.expYear = expY;
      this.secCode = sc;
      this.amount = amt;
   }
   
   public long getAccountNum(){
      /*Accessor. Get the account number associated with the charge*/
      return this.accountNum;
   }
   
   public int getExpMonth(){
      /*Accessor. Get the expiration month associated with the charge*/
      return this.expMonth;
   }
   
   public int getExpYear(){
      /*Accessor. Get the expiration year associated with the charge*/
      return this.expYear;
   }
   
   public int getSecCode(){
      /*Accessor. Get the security code associated with the charge*/
      return this.secCode;
   }
   
   public double getAmount(){
      /*Accessor. Get the dollar amount associated with the charge*/
      return this.amount;
   }
   
   public String toString(){
      /*Return a String representation of the charge*/
      return "Acct:" + this.accountNum +
                 " " + this.expMonth +
                 "/" + this.expYear +
                 " (" + this.secCode + 
                 ") $" + this.amount;
   }
}
   
   