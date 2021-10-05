public class ShuffleCycle{
   public static int outRepeat(Deck d){
      /*How many out-shuffles does it take to restore 
      the given deck to its original order?
      Ex.
      Deck d1 = new Deck(8);
      ShuffleCycle.outRepeat(d1) -> 3
      */
         //---your code goes here---
         
      Deck f = d.clone();
      int i = 0;
      while(true){
         i++;
         f.outShuffle();
         if(f.equals(d)) return i;
      }
   }
   
   public static int inRepeat(Deck d){
   /*How many out-shuffles does it take to restore 
   the given deck to its original order?
   Ex.
   Deck d1 = new Deck(8);
   ShuffleCycle.inRepeat(d1) -> 6
   */
      //---your code goes here---
      
      Deck f = d.clone();
      //StdOut.println(f.toString());
      int i = 0;
      while(true){
         i++;
         f.inShuffle();
         //StdOut.println(f.toString());
         if(f.equals(d)) return i;
      }
      
   }
   public static void main(String args[]){
      Deck d1 = new Deck(54);
      StdOut.println(ShuffleCycle.outRepeat(d1));
      
      StdOut.println();
      
      Deck d2 = new Deck(54);
      StdOut.println(ShuffleCycle.inRepeat(d2));
      
      StdOut.println();
      
      Deck d3 = new Deck(12);
      StdOut.println(ShuffleCycle.outRepeat(d3));
      
      StdOut.println();
      
      Deck d4 = new Deck(12);
      StdOut.println(ShuffleCycle.inRepeat(d4));
   
   }
}
