import java.util.*;

public class Deck{
   private int[] cards;
   
   public Deck(int n){
      /*Initialize a new unshuffled deck of length n
      Ex.
      Deck d = new Deck(4);
      d.toString() -> "1, 2, 3, 4"
      */
         //---your code here---
         this.cards = new int[n];
         for (int i = 0; i < n; i++){
            this.cards[i] = i+1;
         }
         
   }
   public Deck(String order){
      /*Create a new Deck with the given cards ordered as provided
      Ex.
      Deck d = new Deck("79, 2, 3, 7");
      d.toString() -> "79, 2, 3, 7"
      */
         //---your code here---
         
         
         String[] arr = order.split(", ");
         cards = new int[arr.length];
         for (int i = 0; i < arr.length; i++){
            this.cards[i] = Integer.parseInt(arr[i]);
         }
      
   }
   public String toString(){
      /*Return a String representing the Deck
      Ex.
      Deck d = new Deck(8);
      d.toString() -> "1, 2, 3, 4, 5, 6, 7, 8"
      */
         //---your code here---
         /*String str = "";
         for (int i = 0; i < this.cards.length; i++){
               str += (i + ", ");
               
         }
         str-=
         return str;*/
         return Arrays.toString(this.cards);
         
      
      
   }
   public boolean equals(Deck that){
      /*Check if this Deck is equivalent to that Deck
      Ex.
      Deck d1 = new Deck("1, 2, 3");
      Deck d2 = new Deck(3);
      d1.equals(d2) -> true
      d2 = new Deck(4);
      d1.equals(d2) -> false
      d2 = new Deck("3, 2, 1");
      d1.equals(d2) -> false
      */
         //---your code here---
         if (this.cards.length != that.cards.length) return false;
         for (int i = 0; i < this.cards.length; i++){
            if (this.cards[i] != that.cards[i]) return false;
         }
         return true;
   }
   
   public Deck clone(){
   /*Return an exact copy of this Deck
   Ex.
   Deck d1 = new Deck("6, -1, 8");
   Deck d2 = d1.clone();
   d2.toString() -> "6, -1, 8"
   d1 = new Deck(4);
   d1.toString() -> "1, 2, 3, 4"
   d2.toString() -> "6, -1, 8"
   */
      //---your code here---
      Deck cloned = new Deck(this.cards.length);
      for (int i = 0; i < this.cards.length; i++){
         cloned.cards[i] = this.cards[i];
      }
      
      return cloned;
   }
   public void outShuffle(){
      /*Shuffle the deck using the Out-Shuffle technique
      Ex.
      Deck d1 = new Deck(6);
      d1.toString() -> "1, 2, 3, 4, 5, 6"
      d1.outShuffle();
      d1.toString() -> "1, 4, 2, 5, 3, 6"
      
      Deck d2 = new Deck(7);
      d2.toString() -> "1, 2, 3, 4, 5, 6, 7"
      d2.outShuffle()
      d2.toString() -> "1, 4, 2, 5, 3, 6, 7"
      */
         //---your code here---
      /*int n = (int)Math.floor(this.cards.length/2);
      int[] evenArr = new int[n];
      int[] oddArr = new int[n + 1];
      int a = 0;
      int b = 0;
      for (int i = 0; i < this.cards.length; i++){
         if(i % 2 == 0){
            oddArr[a] = this.cards[i];
            a++;
         }
         else{
            evenArr[b] = this.cards[i];
            b++;
         }
      }
      int[] newCards = new int[this.cards.length]; 
      for (int i = 0; i < this.cards.length; i++){
         
         newCards[i]
      }
      
      StdOut.println(Arrays.toString(oddArr));*/
      int n = (int)Math.floor(this.cards.length/2);
      int[] firstArr = new int[n];
      int[] secondArr;
      int a = 0;
      int b = 0;
      int x = 0;
      if (this.cards.length % 2 == 0){
         x = n;
         secondArr = new int[n];
      }
      else {
         x = n+1;
         secondArr = new int[n + 1];
      }
      for(int i = 0; i < n; i++){
         firstArr[i] = this.cards[i];
      }
      for(int i = n; i < this.cards.length; i++){
         secondArr[i-n] = this.cards[i];
      }
      if (this.cards.length % 2 == 0){
         for(int i = 0; i < this.cards.length; i++){
            if(i % 2 == 0){
               this.cards[i] = firstArr[a];
               a++;
            }
            else{
               this.cards[i] = secondArr[b];
               b++;
            }
            //this.cards[this.cards.length-1] = secondArr[a];
         }
      }
      else{
         for(int i = 0; i < this.cards.length-1; i++){
            if(i % 2 == 0){
               this.cards[i] = firstArr[a];
               a++;
            }
            else{
               this.cards[i] = secondArr[b];
               b++;
            }
            this.cards[this.cards.length-1] = secondArr[a];
         }
      }
   }
  
   public void inShuffle(){
      /*Shuffle the order of the deck using the In-Shuffle technique
      Ex.
      Deck d1 = new Deck(6);
      d1.toString() -> "1, 2, 3, 4, 5, 6"
      d1.inShuffle();
      d1.toString() -> "4, 1, 5, 2, 6, 3"
      
      Deck d2 = new Deck(7);
      d2.toString() -> "1, 2, 3, 4, 5, 6, 7"
      d2.inShuffle()
      d2.toString() -> "4, 1, 5, 2, 6, 3, 7"
      */
         //---your code here---
      int n = (int)Math.floor(this.cards.length/2);
      int[] firstArr = new int[n];
      int[] secondArr;
      int a = 0;
      int b = 0;
      if (this.cards.length % 2 == 0){
         secondArr = new int[n];
      }
      else {
         secondArr = new int[n + 1];
      }
      for(int i = 0; i < n; i++){
         firstArr[i] = this.cards[i];
      }
      for(int i = n; i < this.cards.length; i++){
         secondArr[i-n] = this.cards[i];
      }
      for(int i = 0; i < this.cards.length; i++){
         if(i % 2 == 0){
            this.cards[i] = secondArr[a];
            a++;
         }
         else{
            this.cards[i] = firstArr[b];
            b++;
         }
      }
      
   }
   public static void main(String args[]){
      /*Deck d1 = new Deck(7);
    StdOut.println(d1.toString());
      d1.inShuffle();
      StdOut.println(d1.toString());
      
      StdOut.println();*/
      
      Deck d2 = new Deck(7);
      StdOut.println(d2.toString());
      d2.outShuffle();
      StdOut.println(d2.toString());
   }


}