/*
A program representing the operations of a credit card company
processing true and fraudulent credit card charges
*/

import java.util.ArrayList;

public class CreditCardDB{
   private ArrayList accounts; //a list of all the company's accounts
   
   public CreditCardDB(){
      /*Setup a new CreditCard*/
      this.accounts = new ArrayList();
   }
   
   public void addAccount(Account a){
      /*Add a new account to the accounts list*/
      int pos = 0;
      /*while ( > ((Account)this.accounts.get(pos)).getAccountNum()){
         pos++;
      }*/
      long num1 = a.getAccountNum();
      boolean max = false;
      int i = 0;
      while (max == false && i < this.accounts.size()){
      //for (int i = 0; i < this.accounts.size(); i++){
         Account acc = (Account)this.accounts.get(pos);
         long num = acc.getAccountNum();
         if (num1 > num){
            pos = i;
         }
         else{
            max = true;
         }
         i++;
      }
      
      this.accounts.add(pos, a);
   }
   
   public Account lookup_Bogo(long accountNum){
      /*Returns the Account object matching the given
      account number if it exists, otherwise return null
      
      Algorithm - Bogo Search. Not guaranteed to find the
      matching account, even if it exists, but likely to.
      */
      
      long maxReps = this.accounts.size()*100; //max. num. of checks before giving up
      
      //try to find the matching Account
      for(long l = 0; l < maxReps; l++){
         int randIndex = (int)(Math.random()*this.accounts.size()); //random index
         Account randAccount = (Account)this.accounts.get(randIndex); //random Account
         if(randAccount.getAccountNum() == accountNum){
            return randAccount;
         }
      }
      return null;
   }
   public Account lookup_Bisection(long accountNum){
      /*Returns the Account object matching the given
      account number if it exists, otherwise return null
      
      Algorithm - Bisection Search. Guaranteed to find the
      matching account (if it exists) quickly.
      */
      //long middle = (int)this.accounts.size()/2;
      int middle;
      int upper = this.accounts.size()-1;
      int lower = 0;
      //boolean found = false;
      while (lower < upper){
         middle = (upper + lower)/2;
         //int middleInt = middle;
         Account midAcc = (Account)this.accounts.get(middle);
         
         long midNum = midAcc.getAccountNum();
         //StdOut.println("MIDNUM: " + midNum);
         if (accountNum > midNum){
            lower = middle+1;
         }
         else if (accountNum < midNum){
            upper = middle-1;
         }
         else{
            return midAcc;
         }
         //StdOut.println("MIDDLE: " + middle);
      }
      return null;
   }      
   
   public void processCharge(Charge c){
      /*Process a charge which may or may not be valid*/
      
      //look up the matching account (if exists)
      Account a = this.lookup_Bisection(c.getAccountNum()); //CHANGE THIS LINE
      //if the account could not be found, reject the charge
      if(a == null){
         StdOut.println("Rejected: "+ c);
      }
      else{
         //verify that the details match
         if(a.verify(c)){
            a.process(c); //charges the account
         }
         else{
            StdOut.println("Rejected: " + c);
         }
      }
   }
   public Account lookup_Sequential(long accountNum){
      /*Returns the Account object matching the given
      account number if it exists, otherwise return null
      
      Algorithm - Sequential Search. Guaranteed to find the
      matching account (if it exists) eventually.
      */
      
      for (int i = 0; i < this.accounts.size(); i++){
         Account a = (Account)this.accounts.get(i); //random Account
         if(a.getAccountNum() == accountNum){
            return a;
         }
      }
      return null;
   }
   
   public static void main(String[] args){
      /*Loads a list of accounts from one file and a list of
      attempted charges from another file. Processes or rejects
      all of the charges*/
      String accountFile = args[0]; //name of the file with account info
      String chargeFile = args[1];  //name of the file with attempted charges
      
      //load the accounts into a database
      CreditCardDB db = new CreditCardDB();
      In accountLoad = new In(accountFile); //load the data in accountFile
      while(accountLoad.isEmpty() == false){
         long accNum = accountLoad.readLong();
         int expMonth = accountLoad.readInt();
         int expYear = accountLoad.readInt();
         int secCode = accountLoad.readInt();
         Account a = new Account(accNum, expMonth, expYear, secCode);
         db.addAccount(a);
      }
      accountLoad.close();
      
      //load and process the attempted charges
      In chargeLoad = new In(chargeFile);       //load the data in chargeFile
      while(chargeLoad.isEmpty() == false){
         long accNum = chargeLoad.readLong();
         int expMonth = chargeLoad.readInt();
         int expYear = chargeLoad.readInt();
         int secCode = chargeLoad.readInt();
         double amount = chargeLoad.readDouble();
         Charge c = new Charge(accNum, expMonth, expYear, secCode, amount);
         //attempt to process the charge
         db.processCharge(c);
      }
      chargeLoad.close();
   }
}
   