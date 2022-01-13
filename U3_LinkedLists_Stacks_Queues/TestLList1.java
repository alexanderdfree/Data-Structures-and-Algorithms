public class TestLList1{

   
   public static void testAdd(){
      System.out.println("---------------------------------------------");
      System.out.println("Testing add()");
      System.out.println("-------------------");
      
      LList l = new LList();
      l.add(1);
      Testing.testEquals("Test 1.1", l.toString(), "1 -> null");
      
      l.add(2);
      Testing.testEquals("Test 1.2", l.toString(), "1 -> 2 -> null");
      
      l.add(3);
      Testing.testEquals("Test 1.3", l.toString(), "1 -> 2 -> 3 -> null");
      
      l.add(4);
      Testing.testEquals("Test 1.4", l.toString(), "1 -> 2 -> 3 -> 4 -> null");
      
      System.out.println("---------------------------------------------");
   }
   
   public static void testGet(){
      System.out.println("---------------------------------------------");
      System.out.println("Testing get()");
      System.out.println("-------------------");

      LList l = new LList();
      l.add(1);
      Testing.testEquals("Test 2.1", l.get(0), 1);
      Testing.testEquals("Test 2.2", l.toString(), "1 -> null");
      
      l.add(2);
      Testing.testEquals("Test 2.3", l.get(0), 1);
      Testing.testEquals("Test 2.4", l.get(1), 2);
      Testing.testEquals("Test 2.5", l.toString(), "1 -> 2 -> null");
      
      l.add(3);
      Testing.testEquals("Test 2.6", l.get(0), 1);
      Testing.testEquals("Test 2.7", l.get(1), 2);
      Testing.testEquals("Test 2.8", l.get(2), 3);
      Testing.testEquals("Test 2.9", l.toString(), "1 -> 2 -> 3 -> null");
      
      System.out.println("---------------------------------------------");
   }

   public static void testRemove(){
      System.out.println("---------------------------------------------");
      System.out.println("Testing remove()");
      System.out.println("-------------------");
      
      LList l = new LList();
      l.add(1);
      Testing.testEquals("Test 3.1", l.remove(0), 1);
      Testing.testEquals("Test 3.2", l.toString(), "null");
      
      l.add(2);
      Testing.testEquals("Test 3.3", l.toString(), "2 -> null");
      l.add(3);
      Testing.testEquals("Test 3.4", l.toString(), "2 -> 3 -> null");
      Testing.testEquals("Test 3.5", l.remove(0), 2);
      Testing.testEquals("Test 3.6", l.toString(), "3 -> null");
      
      l.add(4);
      Testing.testEquals("Test 3.7", l.toString(), "3 -> 4 -> null");
      Testing.testEquals("Test 3.8", l.remove(1), 4);
      Testing.testEquals("Test 3.9", l.toString(), "3 -> null");
      
      l.add(5);
      l.add(6);
      Testing.testEquals("Test 3.10", l.toString(), "3 -> 5 -> 6 -> null");
      Testing.testEquals("Test 3.11", l.remove(0), 3);
      Testing.testEquals("Test 3.12", l.toString(), "5 -> 6 -> null");
      
      l.add(7);
      Testing.testEquals("Test 3.13", l.toString(), "5 -> 6 -> 7 -> null");
      Testing.testEquals("Test 3.14", l.remove(1), 6);
      Testing.testEquals("Test 3.15", l.toString(), "5 -> 7 -> null");
      
      l.add(8);
      Testing.testEquals("Test 3.16", l.toString(), "5 -> 7 -> 8 -> null");
      Testing.testEquals("Test 3.17", l.remove(2), 8);
      Testing.testEquals("Test 3.18", l.toString(), "5 -> 7 -> null");
      
      System.out.println("---------------------------------------------");
   }
   
   public static void testInsert(){
      System.out.println("---------------------------------------------");
      System.out.println("Testing insert()");
      System.out.println("-------------------");
      
      LList l = new LList();
      l.insert(1, 0);
      Testing.testEquals("Test 4.1", l.toString(), "1 -> null");
      
      l.insert(2, 0);
      Testing.testEquals("Test 4.2", l.toString(), "2 -> 1 -> null");
      
      l.remove(0);
      l.insert(2, 1);
      Testing.testEquals("Test 4.3", l.toString(), "1 -> 2 -> null");
      
      l.insert(3, 0);
      Testing.testEquals("Test 4.4", l.toString(), "3 -> 1 -> 2 -> null");
      
      l.remove(0);
      l.insert(3, 1);
      Testing.testEquals("Test 4.5", l.toString(), "1 -> 3 -> 2 -> null");
      
      l.remove(1);
      l.insert(3, 2);
      Testing.testEquals("Test 4.6", l.toString(), "1 -> 2 -> 3 -> null");
      
      l.insert(4, 0);
      Testing.testEquals("Test 4.7", l.toString(), "4 -> 1 -> 2 -> 3 -> null");
      
      l.remove(0);
      l.insert(4, 1);
      Testing.testEquals("Test 4.8", l.toString(), "1 -> 4 -> 2 -> 3 -> null");
      
      l.remove(1);
      l.insert(4, 2);
      Testing.testEquals("Test 4.9", l.toString(), "1 -> 2 -> 4 -> 3 -> null");
      
      l.remove(2);
      l.insert(4, 3);
      Testing.testEquals("Test 4.10", l.toString(), "1 -> 2 -> 3 -> 4 -> null");
      
      System.out.println("---------------------------------------------");
   }
   
   public static void main(String[] args){
      testAdd();
      testGet();
      testRemove();
      testInsert();
   }
}
 