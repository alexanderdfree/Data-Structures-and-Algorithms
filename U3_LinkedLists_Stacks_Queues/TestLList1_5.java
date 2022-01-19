public class TestLList1_5{

   
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
   
   public static void testSet(){
      System.out.println("---------------------------------------------");
      System.out.println("Testing set()");
      System.out.println("-------------------"); 
      
      LList l = new LList();
      l.add(1);
      l.set(2, 0);
      Testing.testEquals("Test 5.1", l.toString(), "2 -> null");
      
      l.add(3);
      l.set(4, 0);
      Testing.testEquals("Test 5.2", l.toString(), "4 -> 3 -> null");
      
      l.add(5);
      l.set(6, 1);
      Testing.testEquals("Test 5.3", l.toString(), "4 -> 6 -> 5 -> null");
      
      l.set(7, 2);
      Testing.testEquals("Test 5.4", l.toString(), "4 -> 6 -> 7 -> null");
      
      l.remove(2);
      l.set(8, 1);
      Testing.testEquals("Test 5.5", l.toString(), "4 -> 8 -> null");
      
      l.remove(0);
      l.set(9, 0);
      Testing.testEquals("Test 5.6", l.toString(), "9 -> null");
      
      l.remove(0);
      l.add(10);
      l.set(11, 0);
      Testing.testEquals("Test 5.7", l.toString(), "11 -> null");
      
      l.clear();
      l.add(12);
      l.set(13, 0);
      Testing.testEquals("Test 5.8", l.toString(), "13 -> null");
      
      System.out.println("---------------------------------------------");
   }
   
   public static void testClear(){
      System.out.println("---------------------------------------------");
      System.out.println("Testing clear()");
      System.out.println("-------------------");
      
      LList l = new LList();
      l.clear();
      Testing.testEquals("Test 6.1", l.toString(), "null");
      
      l.add(1);
      Testing.testEquals("Test 6.2", l.toString(), "1 -> null");
      l.clear();
      Testing.testEquals("Test 6.3", l.toString(), "null");
      
      l.add(1);
      l.add(2);
      Testing.testEquals("Test 6.4", l.toString(), "1 -> 2 -> null");
      l.clear();
      Testing.testEquals("Test 6.5", l.toString(), "null");
      
      l.add(1);
      l.add(2);
      l.add(3);
      Testing.testEquals("Test 6.6", l.toString(), "1 -> 2 -> 3 -> null");
      l.clear();
      Testing.testEquals("Test 6.7", l.toString(), "null");
      
      System.out.println("---------------------------------------------");
   }
   
   public static void testSwap(){
      System.out.println("---------------------------------------------");
      System.out.println("Testing swap()");
      System.out.println("-------------------");
      
      LList l = new LList();
      
      l.add(1);
      l.add(2);
      l.add(3);
      l.add(4);
      l.add(5);
      Testing.testEquals("Test 7.1", l.toString(), "1 -> 2 -> 3 -> 4 -> 5 -> null");
      
      l.clear();
      l.add(1);
      l.add(2);
      l.add(3);
      l.add(4);
      l.add(5);
      l.swap(1, 3);
      Testing.testEquals("Test 7.2", l.toString(), "1 -> 4 -> 3 -> 2 -> 5 -> null");
      
      l.clear();
      l.add(1);
      l.add(2);
      l.add(3);
      l.add(4);
      l.add(5);
      l.swap(3, 1);
      Testing.testEquals("Test 7.3", l.toString(), "1 -> 4 -> 3 -> 2 -> 5 -> null");
      
      l.clear();
      l.add(1);
      l.add(2);
      l.add(3);
      l.add(4);
      l.add(5);
      l.swap(0, 2);
      Testing.testEquals("Test 7.4", l.toString(), "3 -> 2 -> 1 -> 4 -> 5 -> null");
      
      l.clear();
      l.add(1);
      l.add(2);
      l.add(3);
      l.add(4);
      l.add(5);
      l.swap(2, 0);
      Testing.testEquals("Test 7.5", l.toString(), "3 -> 2 -> 1 -> 4 -> 5 -> null");
      
      l.clear();
      l.add(1);
      l.add(2);
      l.add(3);
      l.add(4);
      l.add(5);
      l.swap(1, 2);
      Testing.testEquals("Test 7.6", l.toString(), "1 -> 3 -> 2 -> 4 -> 5 -> null");
      
      l.clear();
      l.add(1);
      l.add(2);
      l.add(3);
      l.add(4);
      l.add(5);
      l.swap(2, 1);
      Testing.testEquals("Test 7.7", l.toString(), "1 -> 3 -> 2 -> 4 -> 5 -> null");
      
      l.clear();
      l.add(1);
      l.add(2);
      l.add(3);
      l.add(4);
      l.add(5);
      l.swap(0, 1);
      Testing.testEquals("Test 7.8", l.toString(), "2 -> 1 -> 3 -> 4 -> 5 -> null");
      
      l.clear();
      l.add(1);
      l.add(2);
      l.add(3);
      l.add(4);
      l.add(5);
      l.swap(1, 0);
      Testing.testEquals("Test 7.9", l.toString(), "2 -> 1 -> 3 -> 4 -> 5 -> null");
      
      l.clear();
      l.add(1);
      l.add(2);
      l.add(3);
      l.add(4);
      l.add(5);
      l.swap(2, 2);
      Testing.testEquals("Test 7.10", l.toString(), "1 -> 2 -> 3 -> 4 -> 5 -> null");
      
      l.clear();
      l.add(1);
      l.add(2);
      l.add(3);
      l.add(4);
      l.add(5);
      l.swap(0, 0);
      Testing.testEquals("Test 7.11", l.toString(), "1 -> 2 -> 3 -> 4 -> 5 -> null");
      
      l.clear();
      l.add(1);
      l.add(2);
      l.add(3);
      l.add(4);
      l.add(5);
      l.swap(0, 4);
      Testing.testEquals("Test 7.12", l.toString(), "5 -> 2 -> 3 -> 4 -> 1 -> null");
      
      l.clear();
      l.add(1);
      l.add(2);
      l.add(3);
      l.add(4);
      l.add(5);
      l.swap(4, 0);
      Testing.testEquals("Test 7.13", l.toString(), "5 -> 2 -> 3 -> 4 -> 1 -> null");
      
      l.clear();
      l.add(1);
      l.add(2);
      l.add(3);
      l.add(4);
      l.add(5);
      l.swap(2, 4);
      Testing.testEquals("Test 7.14", l.toString(), "1 -> 2 -> 5 -> 4 -> 3 -> null");
      
      l.clear();
      l.add(1);
      l.add(2);
      l.add(3);
      l.add(4);
      l.add(5);
      l.swap(4, 2);
      Testing.testEquals("Test 7.15", l.toString(), "1 -> 2 -> 5 -> 4 -> 3 -> null");
      
      l.clear();
      l.add(1);
      l.add(2);
      l.add(3);
      l.add(4);
      l.add(5);
      l.swap(3, 4);
      Testing.testEquals("Test 7.16", l.toString(), "1 -> 2 -> 3 -> 5 -> 4 -> null");
      
      l.clear();
      l.add(1);
      l.add(2);
      l.add(3);
      l.add(4);
      l.add(5);
      l.swap(4, 3);
      Testing.testEquals("Test 7.17", l.toString(), "1 -> 2 -> 3 -> 5 -> 4 -> null");
      
      l.clear();
      l.add(1);
      l.add(2);
      l.add(3);
      l.add(4);
      l.add(5);
      l.swap(4, 4);
      Testing.testEquals("Test 7.18", l.toString(), "1 -> 2 -> 3 -> 4 -> 5 -> null");
      
   }
   
   
   
   public static void main(String[] args){
      testAdd();
      testGet();
      testRemove();
      testInsert();
      testSet();
      testClear();
      testSwap();
   }
}
 