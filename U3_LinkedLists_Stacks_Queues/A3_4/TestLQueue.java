public class TestLQueue{
   
   public static void testPeek(){
      System.out.println("---------------------------------------------");
      System.out.println("Testing peek()");
      System.out.println("-------------------");
      
      LQueue q = new LQueue();
      Testing.testEquals("Test 1.1", q.peek(), null);
      
      q.add(1);
      Testing.testEquals("Test 1.2", q.peek(), 1);
      
      Testing.testEquals("Test 1.3", q.peek(), 1);
      
      q.add(2);
      Testing.testEquals("Test 1.4", q.peek(), 1);
   }
   
   public static void testEnqueue(){
      System.out.println("---------------------------------------------");
      System.out.println("Testing add()");
      System.out.println("-------------------");
      
      LQueue q = new LQueue();
      q.add(1);
      Testing.testEquals("Test 2.1", q.peek(), 1);
      
      q.add(2);
      Testing.testEquals("Test 2.2", q.peek(), 1);
      
      //stress test
      for(int i = 3; i <= 10000; i++){
         q.add(i);
      }
      Testing.testEquals("Test 2.3", q.peek(), 1);
   }
   
   public static void testDequeue(){
      System.out.println("---------------------------------------------");
      System.out.println("Testing remove()");
      System.out.println("-------------------");
      
      LQueue q = new LQueue();
      Testing.testEquals("Test 3.1", q.remove(), null);
      Testing.testEquals("Test 3.2", q.remove(), null);
      
      q.add(1);
      Testing.testEquals("Test 3.3", q.remove(), 1);
      Testing.testEquals("Test 3.4", q.remove(), null);
      
      q.add(1);
      q.add(2);
      Testing.testEquals("Test 3.5", q.remove(), 1);
      Testing.testEquals("Test 3.6", q.remove(), 2);
      Testing.testEquals("Test 3.7", q.remove(), null);
      
      q.add(1);
      q.add(2);
      q.add(3);
      Testing.testEquals("Test 3.8", q.remove(), 1);
      Testing.testEquals("Test 3.9", q.remove(), 2);
      Testing.testEquals("Test 3.10", q.remove(), 3);
      Testing.testEquals("Test 3.11", q.remove(), null);
      
      //Stress Test
      for(int i = 1; i <= 10000; i++){
         q.add(i);
      }
      Testing.testEquals("Test 3.12", q.remove(), 1);
      for(int i = 2; i < 10000; i++){
         q.remove();
      }
      Testing.testEquals("Test 3.13", q.remove(), 10000);
   }
   
   public static void testIsEmpty(){
      System.out.println("---------------------------------------------");
      System.out.println("Testing isEmpty()");
      System.out.println("-------------------");
      
      LQueue q = new LQueue();
      Testing.testEquals("Test 4.1", q.isEmpty(), true);
      
      q.add(1);
      Testing.testEquals("Test 4.2", q.isEmpty(), false);
      
      q.remove();
      Testing.testEquals("Test 4.3", q.isEmpty(), true);
      
      q.remove();
      Testing.testEquals("Test 4.4", q.isEmpty(), true);
      
      q.add(1);
      q.add(2);
      Testing.testEquals("Test 4.5", q.isEmpty(), false);
      
      q.remove();
      q.remove();
      Testing.testEquals("Test 4.6", q.isEmpty(), true);
      
      q.add(1);
      q.add(2);
      q.add(3);
      Testing.testEquals("Test 4.7", q.isEmpty(), false);
      
      q.remove();
      q.remove();
      q.remove();
      Testing.testEquals("Test 4.8", q.isEmpty(), true);
      
      //Stress Test
      for(int i = 0; i <= 10000; i++){
         q.add(i);
      }
      Testing.testEquals("Test 4.9", q.isEmpty(), false);
      for(int i = 0; i < 10000; i++){
         q.remove();
      }
      Testing.testEquals("Test 4.10", q.isEmpty(), false);
      q.remove();
      Testing.testEquals("Test 4.11", q.isEmpty(), true);
  }
  
  public static void testSize(){
      System.out.println("---------------------------------------------");
      System.out.println("Testing size()");
      System.out.println("-------------------");
      
      LQueue q = new LQueue();
      Testing.testEquals("Test 4.1", q.size(), 0);
      
      q.remove();
      Testing.testEquals("Test 4.2", q.size(), 0);
      
      q.add(1);
      Testing.testEquals("Test 4.3", q.size(), 1);
      
      q.remove();
      Testing.testEquals("Test 4.4", q.size(), 0);
      
      q.add(1);
      q.add(2);
      Testing.testEquals("Test 4.5", q.size(), 2);
      
      q.remove();
      q.remove();
      Testing.testEquals("Test 4.6", q.size(), 0);
      
      q.add(1);
      q.add(2);
      q.add(3);
      Testing.testEquals("Test 4.7", q.size(), 3);
      
      q.remove();
      q.remove();
      q.remove();
      Testing.testEquals("Test 4.8", q.size(), 0);
      
      for(int i = 1; i <= 10000; i++){
         q.add(i);
      }
      Testing.testEquals("Test 4.9", q.size(), 10000);
      
      for(int i = 1; i <= 10000; i++){
         q.remove();
      }
      Testing.testEquals("Test 4.10", q.size(), 0);
   }
   
   public static void main(String[] args){
      testPeek();
      testEnqueue();
      testDequeue();
      testIsEmpty();
      testSize();
   }
}