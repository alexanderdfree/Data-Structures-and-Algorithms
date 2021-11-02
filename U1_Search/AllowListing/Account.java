/*
A class representing an individual credit card account
*/
public class Account{
   private long accountNum; //the account number
   private int expMonth;    //the expiration month
   private int expYear;     //the expiration year
   private int secCode;     //the card security code
   private double balance;  //the current balance on the card
   
   public Account(long accNum, int expM, int expY, int sc){
      /*Create a new Credit Card Account with 0.0 balance*/
      this.accountNum = accNum;
      this.expMonth = expM;
      this.expYear = expY;
      this.secCode = sc;
      this.balance = 0.0;
   }
   
   public long getAccountNum(){
      /*Return the account number of this account*/
      return this.accountNum;
   }
   
   public String toString(){
      /*Return a String with the less sensitive account information*/
      return "Acct:"+this.accountNum+" $"+this.balance;
   }
   
   public boolean verify(Charge c){
      /*Verify that Charge c matches the account details
      of this Account. Simply returns true or false*/
      if(c.getAccountNum() == this.accountNum){
         if(c.getExpMonth() == this.expMonth){
            if(c.getExpYear() == this.expYear){
               if(c.getSecCode() == this.secCode){
                  return true;
               }
            }
         }
      }
      return false;
   }
   
   public void process(Charge c){
      /*Process Charge c on this Account. If the charge
      details don't match the Account details, throws an Exception*/
      if(this.verify(c) == false){
         throw new RuntimeException("charge details don't match acccount");
      }
      else{
         this.balance -= c.getAmount();
      }
   }
}
   
   
   
   