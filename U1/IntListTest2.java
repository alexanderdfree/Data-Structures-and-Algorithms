public class IntListTest2{

   public static boolean testAdd(){
      int i = 0;   
      boolean pass = true;
      
      IntList list;
      
      //basic functionality
      i++;
      list = new IntList(10);
      list.add(1);
      list.add(-1);
      list.add(0);
      if(list.size() != 3){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(1);");
         System.out.println("\tlist.add(-1);");
         System.out.println("\tlist.add(0);");
         System.out.print("\tlist.size() is "+list.size());
         System.out.println(" should be "+3);
      }
      
      i++;
      list = new IntList(10);
      list.add(1);
      list.add(-1);
      list.add(0);
      if(!(list.toString().equals("[1, -1, 0]"))){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(1);");
         System.out.println("\tlist.add(-1);");
         System.out.println("\tlist.add(0);");
         System.out.print("\tlist.toString() is "+list.toString());
         System.out.println(" should be "+"[1, -1, 0]");
      }
      
      i++;
      list = new IntList(10);
      list.add(1);
      list.add(-1);
      list.add(0);
      if(!(list.toStringDebug().equals("[1, -1, 0], 0, 0, 0, 0, 0, 0, 0]"))){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(10);");
         System.out.println("\tlist.add(1);");
         System.out.println("\tlist.add(-1);");
         System.out.println("\tlist.add(0);");
         System.out.print("\tlist.toStringDebug() is "+list.toStringDebug());
         System.out.println(" should be "+"[1, -1, 0], 0, 0, 0, 0, 0, 0, 0]");
      }
      
      //overflow capacity
      i++;
      list = new IntList(2);
      list.add(1);
      list.add(-1);
      list.add(0);
      if(list.size() != 3){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(2);");
         System.out.println("\tlist.add(1);");
         System.out.println("\tlist.add(-1);");
         System.out.println("\tlist.add(0);");
         System.out.print("\tlist.size() is "+list.size());
         System.out.println(" should be "+3);
      }
      
      i++;
      list = new IntList(2);
      list.add(1);
      list.add(-1);
      list.add(0);
      if(!(list.toString().equals("[1, -1, 0]"))){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(2);");
         System.out.println("\tlist.add(1);");
         System.out.println("\tlist.add(-1);");
         System.out.println("\tlist.add(0);");
         System.out.print("\tlist.toString() is "+list.toString());
         System.out.println(" should be "+"[1, -1, 0]");
      }
      
      return pass;
   }
   
   public static boolean testAddIndex(){
      int i = 0;   
      boolean pass = true;
      
      IntList list;
      
      //basic functionality
      i++;
      list = new IntList(5);
      list.add(0, 3);
      list.add(0, 1);
      list.add(1, 2);
      if(list.size() != 3){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(5);");
         System.out.println("\tlist.add(0, 3);");
         System.out.println("\tlist.add(0, 1);");
         System.out.println("\tlist.add(1, 2);");
         System.out.print("\tlist.size() is "+list.size());
         System.out.println(" should be "+3);
      }
      
      i++;
      list = new IntList(5);
      list.add(0, 3);
      list.add(0, 1);
      list.add(1, 2);
      if(!(list.toString().equals("[1, 2, 3]"))){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(5);");
         System.out.println("\tlist.add(0, 3);");
         System.out.println("\tlist.add(0, 1);");
         System.out.println("\tlist.add(1, 2);");
         System.out.print("\tlist.toString() is "+list.toString());
         System.out.println(" should be "+"[1, 2, 3]");
      }
      
      i++;
      list = new IntList(5);
      list.add(0, 3);
      list.add(0, 1);
      list.add(1, 2);
      if(!(list.toStringDebug().equals("[1, 2, 3], 0, 0]"))){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(5);");
         System.out.println("\tlist.add(0, 3);");
         System.out.println("\tlist.add(0, 1);");
         System.out.println("\tlist.add(1, 2);");
         System.out.print("\tlist.toStringDebug() is "+list.toStringDebug());
         System.out.println(" should be "+"[1, 2, 3], 0, 0]");
      }
      
      //overflow capacity
      i++;
      list = new IntList(2);
      list.add(0, 3);
      list.add(0, 1);
      list.add(1, 2);
      if(list.size() != 3){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(2);");
         System.out.println("\tlist.add(0, 3);");
         System.out.println("\tlist.add(0, 1);");
         System.out.println("\tlist.add(1, 2);");
         System.out.print("\tlist.size() is "+list.size());
         System.out.println(" should be "+3);
      }
      
      i++;
      list = new IntList(2);
      list.add(0, 3);
      list.add(0, 1);
      list.add(1, 2);
      if(!(list.toString().equals("[1, 2, 3]"))){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(2);");
         System.out.println("\tlist.add(0, 3);");
         System.out.println("\tlist.add(0, 1);");
         System.out.println("\tlist.add(1, 2);");
         System.out.print("\tlist.toString() is "+list.toString());
         System.out.println(" should be "+"[1, 2, 3]");
      }
      
      return pass;
   }
   
   
   public static boolean testSet(){
      int i = 0;   
      boolean pass = true;
      
      IntList list;
      
      //basic functionality
      i++;
      list = new IntList(2);
      list.add(1);
      list.add(2);
      list.set(1, 3);
      if(list.size() != 2){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(2);");
         System.out.println("\tlist.add(1);");
         System.out.println("\tlist.add(2);");
         System.out.println("\tlist.set(1, 3);");
         System.out.print("\tlist.size() is "+list.size());
         System.out.println(" should be "+2);
      }
      
      i++;
      list = new IntList(2);
      list.add(1);
      list.add(2);
      list.set(1, 3);
      if(!(list.toString().equals("[1, 3]"))){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(2);");
         System.out.println("\tlist.add(1);");
         System.out.println("\tlist.add(2);");
         System.out.println("\tlist.set(1, 3);");
         System.out.print("\tlist.toString() is "+list.toString());
         System.out.println(" should be "+"[1, 3]");
      }
      
      return pass;
   }
   
   public static boolean testSwap(){
      int i = 0;   
      boolean pass = true;
      
      IntList list;
      //basic functionality
      i++;
      list = new IntList(2);
      list.add(1);
      list.add(2);
      list.swap(0, 1);
      if(list.size() != 2){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(2);");
         System.out.println("\tlist.add(1);");
         System.out.println("\tlist.add(2);");
         System.out.println("\tlist.swap(0, 1);");
         System.out.print("\tlist.size() is "+list.size());
         System.out.println(" should be "+2);
      }
      
      i++;
      list = new IntList(2);
      list.add(1);
      list.add(2);
      list.swap(0, 1);
      if(!(list.toString().equals("[2, 1]"))){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tlist = new IntList(2);");
         System.out.println("\tlist.add(1);");
         System.out.println("\tlist.add(2);");
         System.out.println("\tlist.swap(0, 1);");
         System.out.print("\tlist.toString() is "+list.toString());
         System.out.println(" should be "+"[2, 1]");
      }
      
      return pass;
   }
   
   public static boolean testContains(){
      int i = 0;   
      boolean pass = true;
      
      IntList list1;
      
      i++;
      list1 = new IntList(3);
      list1.add(1);
      list1.add(2);
      list1.add(1);
      if(list1.contains(1) != true){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tIntList list1 = new IntList(3);");
         System.out.println("\tlist1.add(1);");
         System.out.println("\tlist1.add(2);");
         System.out.println("\tlist1.add(1);");
         System.out.print("\tlist1.contains(1) is "+list1.contains(1));
         System.out.println(" should be "+"true");
      }
      
      i++;
      list1 = new IntList(3);
      list1.add(1);
      list1.add(2);
      list1.add(1);
      if(list1.contains(2) != true){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tIntList list1 = new IntList(3);");
         System.out.println("\tlist1.add(1);");
         System.out.println("\tlist1.add(2);");
         System.out.println("\tlist1.add(1);");
         System.out.print("\tlist1.contains(2) is "+list1.contains(2));
         System.out.println(" should be "+"true");
      }
      
      i++;
      list1 = new IntList(3);
      list1.add(1);
      list1.add(2);
      list1.add(1);
      if(list1.contains(3) != false){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tIntList list1 = new IntList(3);");
         System.out.println("\tlist1.add(1);");
         System.out.println("\tlist1.add(2);");
         System.out.println("\tlist1.add(1);");
         System.out.print("\tlist1.contains(3) is "+list1.contains(3));
         System.out.println(" should be "+"false");
      }
      
      return pass;
   }
   
   public static boolean testIndexOf(){   
      int i = 0;   
      boolean pass = true;
      
      IntList list1;
      
      i++;
      list1 = new IntList(3);
      list1.add(1);
      list1.add(2);
      list1.add(1);
      if(list1.indexOf(1) != 0){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tIntList list1 = new IntList(3);");
         System.out.println("\tlist1.add(1);");
         System.out.println("\tlist1.add(2);");
         System.out.println("\tlist1.add(1);");
         System.out.print("\tlist1.indexOf(1) is "+list1.indexOf(1));
         System.out.println(" should be "+0);
      }
      
      i++;
      list1 = new IntList(3);
      list1.add(1);
      list1.add(2);
      list1.add(1);
      if(list1.indexOf(2) != 1){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tIntList list1 = new IntList(3);");
         System.out.println("\tlist1.add(1);");
         System.out.println("\tlist1.add(2);");
         System.out.println("\tlist1.add(1);");
         System.out.print("\tlist1.indexOf(2) is "+list1.indexOf(2));
         System.out.println(" should be "+1);
      }
      
      i++;
      list1 = new IntList(3);
      list1.add(1);
      list1.add(2);
      list1.add(1);
      if(list1.indexOf(3) != -1){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tIntList list1 = new IntList(3);");
         System.out.println("\tlist1.add(1);");
         System.out.println("\tlist1.add(2);");
         System.out.println("\tlist1.add(1);");
         System.out.print("\tlist1.indexOf(3) is "+list1.indexOf(3));
         System.out.println(" should be "+ -1);
      }
      
      return pass;
   }
   
   public static boolean testToArray(){   
      int i = 0;   
      boolean pass = true;
      
      IntList list;
      int[] arr;
      
      i++;
      list = new IntList();
      arr = list.toArray();
      if(arr.length != 0){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tIntList list = new IntList();");
         System.out.println("\tint[] arr = list.toArray();");
         System.out.print("\tarr.length" + arr.length);
         System.out.println(" should be " + 0);
      }
      
      i++;
      list = new IntList(10);
      list.add(1);
      list.add(2);
      list.add(3);
      arr = list.toArray();
      if(!(((arr[0] == 1)&&(arr[1] == 2))&&(arr[2] == 3))){
         pass = false;
         System.out.println("Failed Test "+i+":");
         System.out.println("\tIntList list = new IntList();");
         System.out.println("\tlist.add(1);");
         System.out.println("\tlist.add(2);");
         System.out.println("\tlist.add(3);");
         System.out.println("\tint[] arr = list.toArray();");
         System.out.print("\tarr[0] is " + arr[0]);
         System.out.println(" should be " + 1);
         System.out.print("\tarr[1] is " + arr[1]);
         System.out.println(" should be " + 2);
         System.out.print("\tarr[2] is " + arr[2]);
         System.out.println(" should be " + 3);
      }
      
      return pass;
   }
      
   public static void main(String[] args){
      System.out.println("----------------------------------------");
      System.out.println("Testing add(int value):");
      if(testAdd()) System.out.println("All Tests Passed");
      System.out.println("----------------------------------------");
      
      System.out.println("----------------------------------------");
      System.out.println("Testing add(int index, int value):");
      if(testAddIndex()) System.out.println("All Tests Passed");
      System.out.println("----------------------------------------");
      
      System.out.println("----------------------------------------");
      System.out.println("Testing set(int index, int value):");
      if(testSet()) System.out.println("All Tests Passed");
      System.out.println("----------------------------------------");
      
      System.out.println("----------------------------------------");
      System.out.println("Testing swap(int index1, int index2):");
      if(testSwap()) System.out.println("All Tests Passed");
      System.out.println("----------------------------------------");
      
      System.out.println("----------------------------------------");
      System.out.println("Testing contains():");
      if(testContains()) System.out.println("All Tests Passed");
      System.out.println("----------------------------------------");
      
      System.out.println("----------------------------------------");
      System.out.println("Testing indexOf():");
      if(testIndexOf()) System.out.println("All Tests Passed");
      System.out.println("----------------------------------------");
      
      System.out.println("----------------------------------------");
      System.out.println("Testing toArray():");
      if(testToArray()) System.out.println("All Tests Passed");
      System.out.println("----------------------------------------");
     
   }

}
      
      
