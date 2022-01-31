public class TestLList2{

   
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
   
   public static void testSize(){
      System.out.println("---------------------------------------------");
      System.out.println("Testing size()");
      System.out.println("-------------------");
      
      LList l = new LList();
      Testing.testEquals("Test 8.1", l.size(), 0);
      
      l.add(1);
      Testing.testEquals("Test 8.2", l.size(), 1);
      
      l.add(2);
      Testing.testEquals("Test 8.3", l.size(), 2);
      
      l.add(3);
      Testing.testEquals("Test 8.4", l.size(), 3);
      
      l.remove(0);
      Testing.testEquals("Test 8.5", l.size(), 2);
      
      l.remove(1);
      Testing.testEquals("Test 8.6", l.size(), 1);
      
      l.remove(0);
      Testing.testEquals("Test 8.7", l.size(), 0);
      
      l.add(1);
      l.add(2);
      l.add(3);
      Testing.testEquals("Test 8.8", l.size(), 3);
      
      l.remove(1);
      Testing.testEquals("Test 8.9", l.size(), 2);
      
      l.insert(2, 1);
      Testing.testEquals("Test 8.10", l.size(), 3);
      
      l.clear();
      Testing.testEquals("Test 8.11", l.size(), 0);
      
      System.out.println("---------------------------------------------");

   }
   
   public static void testContains(){
      System.out.println("---------------------------------------------");
      System.out.println("Testing contains()");
      System.out.println("-------------------");
      
      LList l = new LList();
      Testing.testEquals("Test 9.1", l.contains(1), false);
      
      l.add(1);
      Testing.testEquals("Test 9.2", l.contains(1), true);
      Testing.testEquals("Test 9.3", l.contains(2), false);
      
      l.add("cat");
      Testing.testEquals("Test 9.4", l.contains(1), true);
      Testing.testEquals("Test 9.5", l.contains("cat"), true);
      Testing.testEquals("Test 9.6", l.contains(2), false);
      Testing.testEquals("Test 9.7", l.contains("dog"), false);
      
      l.add(2.0);
      Testing.testEquals("Test 9.8", l.contains(1), true);
      Testing.testEquals("Test 9.9", l.contains("cat"), true);
      Testing.testEquals("Test 9.10", l.contains(2.0), true);
      Testing.testEquals("Test 9.11", l.contains(1.0), false);
      Testing.testEquals("Test 9.12", l.contains("Cat"), false);
      Testing.testEquals("Test 9.13", l.contains("1"), false);
      Testing.testEquals("Test 9.14", l.contains(2), false);
      
      l.remove(0);
      l.remove(1);
      l.remove(0);
      Testing.testEquals("Test 9.15", l.contains(1), false);
      Testing.testEquals("Test 9.16", l.contains("cat"), false);
      Testing.testEquals("Test 9.17", l.contains(2.0), false);
      
      l.add("horse");
      Testing.testEquals("Test 9.18", l.contains("horse"), true);
      Testing.testEquals("Test 9.19", l.contains(1), false);
      
      l.clear();
      Testing.testEquals("Test 9.20", l.contains("horse"), false);
      
      l.add(3);
      Testing.testEquals("Test 9.21", l.contains(3), true);
      Testing.testEquals("Test 9.22", l.contains("horse"), false);
      
      System.out.println("---------------------------------------------");
   }
   
   public static void testIndexOf(){
      System.out.println("---------------------------------------------");
      System.out.println("Testing indexOf()");
      System.out.println("-------------------");
      
      LList l = new LList();
      Testing.testEquals("Test 10.1", l.indexOf(1), -1);
      
      l.add(1);
      Testing.testEquals("Test 10.2", l.indexOf(1), 0);
      Testing.testEquals("Test 10.3", l.indexOf(2), -1);
      
      l.remove(0);
      Testing.testEquals("Test 10.4", l.indexOf(1), -1);
      
      l.add(1);
      l.add(2);
      Testing.testEquals("Test 10.5", l.indexOf(1), 0);
      Testing.testEquals("Test 10.6", l.indexOf(2), 1);
      Testing.testEquals("Test 10.7", l.indexOf(3), -1);
      
      l.clear();
      Testing.testEquals("Test 10.8", l.indexOf(1), -1);
      
      l.add(1);
      l.add(2);
      l.add(3);
      Testing.testEquals("Test 10.9", l.indexOf(1), 0);
      Testing.testEquals("Test 10.10", l.indexOf(2), 1);
      Testing.testEquals("Test 10.11", l.indexOf(3), 2);
      Testing.testEquals("Test 10.12", l.indexOf(4), -1);
      
      l.add(1);
      Testing.testEquals("Test 10.13", l.indexOf(1), 0);
      Testing.testEquals("Test 10.14", l.indexOf(2), 1);
      Testing.testEquals("Test 10.15", l.indexOf(3), 2);
      
      System.out.println("---------------------------------------------");
   }

   
   
   
   public static void main(String[] args){
      testAdd();
      testGet();
      testRemove();
      testInsert();
      testSet();
      testClear();
      testSwap();
      testSize();
      testContains();
      testIndexOf();
   }
}
 