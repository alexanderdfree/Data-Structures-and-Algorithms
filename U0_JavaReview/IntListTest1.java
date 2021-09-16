public class IntListTest1{
   
   public static boolean testConstructor(){
      int i = 0;   
      boolean pass = true;
      
      IntList list;
      int capacity;
      
      i++;
      capacity = 5;
      list = new IntList(capacity);
      if(list.size != 0){
         pass = false;
         System.out.println("Failed Test "+i+": ");
         System.out.println("\tlist = new IntList("+capacity+")");
         System.out.print("\tlist.size is "+list.size);
         System.out.println(", should be "+0);
      }
      
      i++;
      capacity = 5;
      list = new IntList(capacity);
      if(list.array.length != capacity){
         pass = false;
         System.out.println("Failed Test "+i+": ");
         System.out.println("\tlist = new IntList("+capacity+")");
         System.out.print("\tlist.array.length is "+list.array.length);
         System.out.println(", should be "+capacity);
      }
      
      i++;
      capacity = 14;
      list = new IntList(capacity);
      if(list.array.length != capacity){
         pass = false;
         System.out.println("Failed Test "+i+": ");
         System.out.println("\tlist = new IntList("+capacity+")");
         System.out.print("\tlist.array.length is "+list.array.length);
         System.out.println(", should be "+capacity);
      }
      return pass;
   }
   
   public static boolean testConstructor_Default(){
      int i = 0;   
      boolean pass = true;
      
      IntList list;
      
      i++;
      list = new IntList();
      if(list.size != 0){
         pass = false;
         System.out.println("Failed Test "+i+": ");
         System.out.println("\tlist = new IntList()");
         System.out.print("\tlist.size is "+list.size);
         System.out.println(", should be "+0);
      }
      
      i++;
      list = new IntList();
      if(list.array.length <= 0){
         pass = false;
         System.out.println("Failed Test "+i+": ");
         System.out.println("\tlist = new IntList()");
         System.out.println("\tlist.array.length should be positive");
      }
      
      return pass;
   }
   
   public static boolean testSize(){
      int i = 0;   
      boolean pass = true;
      
      IntList list;
      int size;
      
      i++;
      size = 10;
      list = new IntList();
      list.size = size;
      if(list.size() != size){
         pass = false;
         System.out.println("Failed Test "+i+": ");
         System.out.print("\tlist.size() is "+list.size());
         System.out.println(" should be "+size);
      }
      
      i++;
      size = -4;
      list = new IntList();
      list.size = size;
      if(list.size() != size){
         pass = false;
         System.out.println("Failed Test "+i+": ");
         System.out.print("\tlist.size() is "+list.size());
         System.out.println(" should be "+size);
      }
      
      return pass;
   }
   
   public static boolean testAdd(){
      int i = 0;   
      boolean pass = true;
      
      IntList list;
      
      i++;
      list = new IntList(10);
      list.add(-10);
      if(list.size() != 1){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(-10);");
         System.out.print("\tlist.size() is "+list.size());
         System.out.println(" should be "+1);
      }
      
      i++;
      list = new IntList(10);
      list.add(-10);
      if(list.array[0] != -10){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(-10);");
         System.out.print("\tlist.array[0] is "+list.array[0]);
         System.out.println(" should be "+-10);
      }
      
      i++;
      list = new IntList(10);
      list.add(-10);
      list.add(5);
      if(list.size() != 2){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(-10);");
         System.out.println("\tlist.add(5);");
         System.out.print("\tlist.size() is "+list.size());
         System.out.println(" should be "+2);
      }
      
      i++;
      list = new IntList(10);
      list.add(-10);
      list.add(5);
      if(list.array[0] != -10){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(-10);");
         System.out.println("\tlist.add(5);");
         System.out.print("\tlist.array[0] is "+list.array[0]);
         System.out.println(" should be "+-10);
      }
      
      i++;
      list = new IntList(10);
      list.add(-10);
      list.add(5);
      if(list.array[1] != 5){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(-10);");
         System.out.println("\tlist.add(5);");
         System.out.print("\tlist.array[1] is "+list.array[1]);
         System.out.println(" should be "+5);
      }
      
      return pass;
   }
   
   public static boolean testAddIndex(){
      int i = 0;   
      boolean pass = true;
      
      IntList list;
      
      i++;
      list = new IntList(10);
      list.add(0, 3);
      if(list.size() != 1){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(0, 3);");
         System.out.print("\tlist.size() is "+list.size());
         System.out.println(" should be "+1);
      }
      
      i++;
      list = new IntList(10);
      list.add(0, 3);
      if(list.array[0] != 3){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(0, 3);");
         System.out.print("\tlist.array[0] is "+list.array[0]);
         System.out.println(" should be "+3);
      }
      
      i++;
      list = new IntList(10);
      list.add(0, 3);
      list.add(0, 4);
      if(list.size() != 2){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(0, 3);");
         System.out.println("\tlist.add(0, 4);");
         System.out.print("\tlist.size is "+list.size());
         System.out.println(" should be "+2);
      }
      
      i++;
      list = new IntList(10);
      list.add(0, 3);
      list.add(0, 4);
      if(list.array[0] != 4){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(0, 3);");
         System.out.println("\tlist.add(0, 4);");
         System.out.print("\tlist.array[0] is "+list.array[0]);
         System.out.println(" should be "+4);
      }
      
      i++;
      list = new IntList(10);
      list.add(0, 3);
      list.add(0, 4);
      if(list.array[1] != 3){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(0, 3);");
         System.out.println("\tlist.add(0, 4);");
         System.out.print("\tlist.array[1] is "+list.array[1]);
         System.out.println(" should be "+3);
      }
      
      i++;
      list = new IntList(10);
      list.add(0, 3);
      list.add(0, 4);
      list.add(1, 5);
      if(list.size() != 3){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(0, 3);");
         System.out.println("\tlist.add(0, 4);");
         System.out.println("\tlist.add(1, 5);");
         System.out.print("\tlist.size() is "+list.size());
         System.out.println(" should be "+3);
      }
      
      i++;
      list = new IntList(10);
      list.add(0, 3);
      list.add(0, 4);
      list.add(1, 5);
      if(list.array[0] != 4){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(0, 3);");
         System.out.println("\tlist.add(0, 4);");
         System.out.println("\tlist.add(1, 5);");
         System.out.print("\tlist.array[0] is "+list.array[0]);
         System.out.println(" should be "+4);
      }
      
      i++;
      list = new IntList(10);
      list.add(0, 3);
      list.add(0, 4);
      list.add(1, 5);
      if(list.array[1] != 5){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(0, 3);");
         System.out.println("\tlist.add(0, 4);");
         System.out.println("\tlist.add(1, 5);");
         System.out.print("\tlist.array[1] is "+list.array[1]);
         System.out.println(" should be "+5);
      }
      
      i++;
      list = new IntList(10);
      list.add(0, 3);
      list.add(0, 4);
      list.add(1, 5);
      if(list.array[2] != 3){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(0, 3);");
         System.out.println("\tlist.add(0, 4);");
         System.out.println("\tlist.add(1, 5);");
         System.out.print("\tlist.array[2] is "+list.array[2]);
         System.out.println(" should be "+3);
      }
      
      i++;
      list = new IntList(10);
      list.add(0, 3);
      list.add(0, 4);
      list.add(1, 5);
      list.add(3, 6);
      if(list.size() != 4){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(0, 3);");
         System.out.println("\tlist.add(0, 4);");
         System.out.println("\tlist.add(1, 5);");
         System.out.println("\tlist.add(3, 6);");
         System.out.print("\tlist.size() is "+list.size());
         System.out.println(" should be "+4);
      }
      
      i++;
      list = new IntList(10);
      list.add(0, 3);
      list.add(0, 4);
      list.add(1, 5);
      list.add(3, 6);
      if(list.array[0] != 4){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(0, 3);");
         System.out.println("\tlist.add(0, 4);");
         System.out.println("\tlist.add(1, 5);");
         System.out.println("\tlist.add(3, 6);");
         System.out.print("\tlist.array[0] is "+list.array[0]);
         System.out.println(" should be "+4);
      }
      
      i++;
      list = new IntList(10);
      list.add(0, 3);
      list.add(0, 4);
      list.add(1, 5);
      list.add(3, 6);
      if(list.array[1] != 5){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(0, 3);");
         System.out.println("\tlist.add(0, 4);");
         System.out.println("\tlist.add(1, 5);");
         System.out.println("\tlist.add(3, 6);");
         System.out.print("\tlist.array[1] is "+list.array[1]);
         System.out.println(" should be "+5);
      }
      
      i++;
      list = new IntList(10);
      list.add(0, 3);
      list.add(0, 4);
      list.add(1, 5);
      list.add(3, 6);
      if(list.array[2] != 3){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(0, 3);");
         System.out.println("\tlist.add(0, 4);");
         System.out.println("\tlist.add(1, 5);");
         System.out.println("\tlist.add(3, 6);");
         System.out.print("\tlist.array[2] is "+list.array[2]);
         System.out.println(" should be "+3);
      }
      
      i++;
      list = new IntList(10);
      list.add(0, 3);
      list.add(0, 4);
      list.add(1, 5);
      list.add(3, 6);
      if(list.array[3] != 6){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(0, 3);");
         System.out.println("\tlist.add(0, 4);");
         System.out.println("\tlist.add(1, 5);");
         System.out.println("\tlist.add(3, 6);");
         System.out.print("\tlist.array[3] is "+list.array[3]);
         System.out.println(" should be "+6);
      }
      
      return pass;
   }
   
   public static boolean testGet(){
      int i = 0;   
      boolean pass = true;
      
      IntList list;
      
      i++;
      list = new IntList(10);
      list.add(1);
      list.add(2);
      list.add(3);
      if(list.get(0) != 1){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(1);");
         System.out.println("\tlist.add(2);");
         System.out.println("\tlist.add(3);");
         System.out.print("\tlist.get(0) is "+list.get(0));
         System.out.println(" should be "+1);
      }
      
      i++;
      list = new IntList(10);
      list.add(1);
      list.add(2);
      list.add(3);
      if(list.get(1) != 2){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(1);");
         System.out.println("\tlist.add(2);");
         System.out.println("\tlist.add(3);");
         System.out.print("\tlist.get(1) is "+list.get(1));
         System.out.println(" should be "+2);
      }
      
      i++;
      list = new IntList(10);
      list.add(1);
      list.add(2);
      list.add(3);
      if(list.get(2) != 3){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(1);");
         System.out.println("\tlist.add(2);");
         System.out.println("\tlist.add(3);");
         System.out.print("\tlist.get(2) is "+list.get(2));
         System.out.println(" should be "+3);
      }
      
      return pass;
   }
   
   public static boolean testRemove(){
      int i = 0;   
      boolean pass = true;
      
      IntList list;
      
      i++;
      list = new IntList(10);
      list.add(1);
      list.add(2);
      list.add(3);
      int result = list.remove(1);
      int expected = 2;
      if(result != expected){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(1);");
         System.out.println("\tlist.add(2);");
         System.out.println("\tlist.add(3);");
         System.out.print("\tlist.remove(1) is "+result);
         System.out.println(" should be "+expected);
      }
      
      i++;
      list = new IntList(10);
      list.add(1);
      list.add(2);
      list.add(3);
      list.remove(1);
      if(list.size() != 2){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(1);");
         System.out.println("\tlist.add(2);");
         System.out.println("\tlist.add(3);");
         System.out.println("\tlist.remove(1);");
         System.out.print("\tlist.size() is "+list.size());
         System.out.println(" should be "+2);
      }
      
      i++;
      list = new IntList(10);
      list.add(1);
      list.add(2);
      list.add(3);
      list.remove(1);
      if(list.array[0] != 1){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(1);");
         System.out.println("\tlist.add(2);");
         System.out.println("\tlist.add(3);");
         System.out.println("\tlist.remove(1);");
         System.out.print("\tlist.array[0] is "+list.array[0]);
         System.out.println(" should be "+1);
      }
      
      i++;
      list = new IntList(10);
      list.add(1);
      list.add(2);
      list.add(3);
      list.remove(1);
      if(list.array[1] != 3){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(1);");
         System.out.println("\tlist.add(2);");
         System.out.println("\tlist.add(3);");
         System.out.println("\tlist.remove(1);");
         System.out.print("\tlist.array[1] is "+list.array[1]);
         System.out.println(" should be "+3);
      }
      
      i++;
      list = new IntList(10);
      list.add(1);
      list.add(2);
      list.add(3);
      list.add(4);
      list.remove(1);
      if(list.array[2] != 4){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(1);");
         System.out.println("\tlist.add(2);");
         System.out.println("\tlist.add(3);");
         System.out.println("\tlist.add(4);");
         System.out.println("\tlist.remove(1);");
         System.out.print("\tlist.array[2] is "+list.array[2]);
         System.out.println(" should be "+4);
      }
      
      return pass;
   }
   
   public static boolean testToString(){
      int i = 0;   
      boolean pass = true;
      
      IntList list;
      
      i++;
      list = new IntList(10);
      if(list.toString().equals("[]") == false){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.print("\tlist.toString() is "+list.toString());
         System.out.println(" should be "+"[]");
      }
      
      i++;
      list = new IntList(10);
      list.add(1);
      if(list.toString().equals("[1]") == false){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(1);");
         System.out.print("\tlist.toString() is "+list.toString());
         System.out.println(" should be "+"[1]");
      }
      
      i++;
      list = new IntList(10);
      list.add(1);
      list.add(2);
      if(list.toString().equals("[1, 2]") == false){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(1);");
         System.out.println("\tlist.add(2);");
         System.out.print("\tlist.toString() is "+list.toString());
         System.out.println(" should be "+"[1, 2]");
      }
      
      i++;
      list = new IntList(10);
      list.add(1);
      list.add(2);
      list.add(3);
      if(list.toString().equals("[1, 2, 3]") == false){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(1);");
         System.out.println("\tlist.add(2);");
         System.out.println("\tlist.add(3);");
         System.out.print("\tlist.toString() is "+list.toString());
         System.out.println(" should be "+"[1, 2, 3]");
      }
      
      return pass;
   }
   
   public static boolean testToStringDebug(){
      int i = 0;   
      boolean pass = true;
      
      IntList list;
      
      i++;
      list = new IntList(4);
      if(list.toStringDebug().equals("[], 0, 0, 0, 0]") == false){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(4);");
         System.out.print("\tlist.toStringDebug() is "+list.toStringDebug());
         System.out.println(" should be "+"[], 0, 0, 0, 0]");
      }
      
      i++;
      list = new IntList(4);
      list.add(1);
      if(list.toStringDebug().equals("[1], 0, 0, 0]") == false){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(4);");
         System.out.println("\tlist.add(1);");
         System.out.print("\tlist.toStringDebug() is "+list.toStringDebug());
         System.out.println(" should be "+"[1], 0, 0, 0]");
      }
      
      i++;
      list = new IntList(4);
      list.add(1);
      list.add(2);
      if(list.toStringDebug().equals("[1, 2], 0, 0]") == false){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(4);");
         System.out.println("\tlist.add(1);");
         System.out.println("\tlist.add(2);");
         System.out.print("\tlist.toStringDebug() is "+list.toStringDebug());
         System.out.println(" should be "+"[1, 2], 0, 0]");
      }
      
      i++;
      list = new IntList(4);
      list.add(1);
      list.add(2);
      list.add(3);
      if(list.toStringDebug().equals("[1, 2, 3], 0]") == false){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(4);");
         System.out.println("\tlist.add(1);");
         System.out.println("\tlist.add(2);");
         System.out.println("\tlist.add(3);");
         System.out.print("\tlist.toStringDebug() is "+list.toStringDebug());
         System.out.println(" should be "+"[1, 2, 3], 0]");
      }
      
      i++;
      list = new IntList(4);
      list.add(1);
      list.add(2);
      list.add(3);
      list.add(4);
      if(list.toStringDebug().equals("[1, 2, 3, 4]]") == false){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(4);");
         System.out.println("\tlist.add(1);");
         System.out.println("\tlist.add(2);");
         System.out.println("\tlist.add(3);");
         System.out.println("\tlist.add(4);");
         System.out.print("\tlist.toStringDebug() is "+list.toStringDebug());
         System.out.println(" should be "+"[1, 2, 3, 4]]");
      }
      
      return pass;
   }


   
   public static void main(String[] args){
      System.out.println("----------------------------------------");
      System.out.println("Testing IntList(int capacity):");
      if(testConstructor()) System.out.println("All Tests Passed");
      System.out.println("----------------------------------------");
      
      System.out.println("----------------------------------------");
      System.out.println("Testing IntList():");
      if(testConstructor_Default()) System.out.println("All Tests Passed");
      System.out.println("----------------------------------------");
      
      System.out.println("----------------------------------------");
      System.out.println("Testing size():");
      if(testSize()) System.out.println("All Tests Passed");
      System.out.println("----------------------------------------");
      
      System.out.println("----------------------------------------");
      System.out.println("Testing add(int value):");
      if(testAdd()) System.out.println("All Tests Passed");
      System.out.println("----------------------------------------");
      
      System.out.println("----------------------------------------");
      System.out.println("Testing add(int index, int value):");
      if(testAddIndex()) System.out.println("All Tests Passed");
      System.out.println("----------------------------------------");
      
      System.out.println("----------------------------------------");
      System.out.println("Testing get(int index):");
      if(testGet()) System.out.println("All Tests Passed");
      System.out.println("----------------------------------------");
      
      System.out.println("----------------------------------------");
      System.out.println("Testing remove(int index):");
      if(testRemove()) System.out.println("All Tests Passed");
      System.out.println("----------------------------------------");
      
      System.out.println("----------------------------------------");
      System.out.println("Testing toString():");
      if(testToString()) System.out.println("All Tests Passed");
      System.out.println("----------------------------------------");
      
      System.out.println("----------------------------------------");
      System.out.println("Testing toStringDebug():");
      if(testToStringDebug()) System.out.println("All Tests Passed");
      System.out.println("----------------------------------------");
   }
}    