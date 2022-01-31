public class TestLStack{
   
   public static void testPeek(){
      System.out.println("---------------------------------------------");
      System.out.println("Testing peek()");
      System.out.println("-------------------");
      
      LStack s = new LStack();
      Testing.testEquals("Test 1.1", s.peek(), null);
      
      s.push(1);
      Testing.testEquals("Test 1.2", s.peek(), 1);
      
      s.push(2);
      Testing.testEquals("Test 1.3", s.peek(), 2);
   }
   
   public static void testPush(){
      System.out.println("---------------------------------------------");
      System.out.println("Testing push()");
      System.out.println("-------------------");
      
      LStack s = new LStack();
      s.push(1);
      Testing.testEquals("Test 2.1", s.peek(), 1);
     
      s.push(2);
      Testing.testEquals("Test 2.2", s.peek(), 2);
      
      s.push(3);
      Testing.testEquals("Test 2.3", s.peek(), 3);
      
      //stress test capacity
      for(int i = 4; i <= 100000; i++){
         s.push(i);
      }
      Testing.testEquals("Test 2.4", s.peek(), 100000);
   }
   
   public static void testPop(){
      System.out.println("---------------------------------------------");
      System.out.println("Testing pop()");
      System.out.println("-------------------");
      
      LStack s = new LStack();
      Testing.testEquals("Test 3.1", s.pop(), null);
      Testing.testEquals("Test 3.2", s.pop(), null);
      
      s.push(1);
      Testing.testEquals("Test 3.3", s.pop(), 1);
      Testing.testEquals("Test 3.4", s.pop(), null);
      Testing.testEquals("Test 3.5", s.pop(), null);
      
      s.push(1);
      s.push(2);
      Testing.testEquals("Test 3.6", s.pop(), 2);
      Testing.testEquals("Test 3.7", s.pop(), 1);
      Testing.testEquals("Test 3.8", s.pop(), null);
      
      s.push(1);
      s.push(2);
      s.push(3);
      Testing.testEquals("Test 3.9", s.pop(), 3);
      Testing.testEquals("Test 3.10", s.pop(), 2);
      Testing.testEquals("Test 3.11", s.pop(), 1);
      Testing.testEquals("Test 3.12", s.pop(), null);
   }
   
   public static void testIsEmpty(){
      System.out.println("---------------------------------------------");
      System.out.println("Testing isEmpty()");
      System.out.println("-------------------");
      
      LStack s = new LStack();
      Testing.testEquals("Test 4.1", s.isEmpty(), true);
      
      s.push(1);
      Testing.testEquals("Test 4.2", s.isEmpty(), false);
      
      s.pop();
      Testing.testEquals("Test 4.3", s.isEmpty(), true);
      
      s.push(1);
      s.push(2);
      Testing.testEquals("Test 4.4", s.isEmpty(), false);
      
      s.pop();
      Testing.testEquals("Test 4.5", s.isEmpty(), false);
      
      s.pop();
      Testing.testEquals("Test 4.6", s.isEmpty(), true);
   }
   
   
  public static void testSize(){
      System.out.println("---------------------------------------------");
      System.out.println("Testing size()");
      System.out.println("-------------------");
      
      LStack s = new LStack();
      Testing.testEquals("Test 5.1", s.size(), 0);
      
      s.push(1);
      Testing.testEquals("Test 5.2", s.size(), 1);
      
      s.pop();
      Testing.testEquals("Test 5.3", s.size(), 0);
      
      s.pop();
      Testing.testEquals("Test 5.4", s.size(), 0);
      
      s.push(1);
      s.push(2);
      Testing.testEquals("Test 5.5", s.size(), 2);
      
      s.peek();
      Testing.testEquals("Test 5.6", s.size(), 2);
      
      s.pop();
      Testing.testEquals("Test 5.7", s.size(), 1);
      
      s.pop();
      Testing.testEquals("Test 5.8", s.size(), 0);
   }
      
   public static void main(String[] args){
      testPeek();
      testPush();
      testPop();
      testIsEmpty();
      testSize();
   }
}