public class Beads{
   public static void arrayBeads(){
      int index = 4;
      char[] arr = new char[11];
      arr[0] = 'J';
      arr[1] = 'A';
      arr[2] = 'C';
      arr[3] = 'Q';
      arr[4] = 'U';
      arr[5] = 'E';
      arr[6] = 'L';
      arr[7] = 'I';
      arr[8] = 'N';
      arr[9] = 'E';
      
      for (int i = 10; i > index; i--){
         arr[i] = '.';
      }
      
      arr[index] = 'X';
      
      arr[5] = 'U';
      arr[6] = 'E';
      arr[7] = 'L';
      arr[8] = 'I';
      arr[9] = 'N';
      arr[10] = 'E';
      String a = "";
      for (int i = 0; i < 11; i++){
         a += arr[i];
         
      }
      StdOut.println(a);
   }
   public static void linkedBeads(){
      LNode l1 = new LNode("J");
      LNode l2 = new LNode("A");
      LNode l3 = new LNode("C");
      LNode l4 = new LNode("Q");
      LNode l5 = new LNode("U");
      LNode l6 = new LNode("E");
      LNode l7 = new LNode("L");
      LNode l8 = new LNode("I");
      LNode l9 = new LNode("N");
      LNode l10 = new LNode("E");
      
      l1.setNext(l2);
      l2.setNext(l3);
      l3.setNext(l4);
      l4.setNext(l5);
      l5.setNext(l6);
      l6.setNext(l7);
      l7.setNext(l8);
      l8.setNext(l9);
      l9.setNext(l10);
      
      LNode l11 = new LNode("X");
      
      l4.setNext(l11);
      l11.setNext(l5);
      
      StdOut.println(l1.toString());

   }
   
   public static void myNecklace(){
      LNode a1 = new LNode("A");
      LNode a2 = new LNode("L");
      LNode a3 = new LNode("E");
      LNode a4 = new LNode("X");
      
      a1.setNext(a2);
      a2.setNext(a3);
      a3.setNext(a4);
      
      StdOut.println(a1.toString());
      
      LNode c1 = new LNode("C");
      LNode c2 = new LNode("H");
      LNode c3 = new LNode("A");
      LNode c4 = new LNode("O");
      
      a1.setNext(c1);
      c1.setNext(a2);
      a2.setNext(c2);
      c2.setNext(a3);
      a3.setNext(c3);
      c3.setNext(a4);
      a4.setNext(c4);
      
      StdOut.println(a1.toString());
   }
}