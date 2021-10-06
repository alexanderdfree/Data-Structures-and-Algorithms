public class TestMergeSort{
   public static void testSort(){
      IntList list, sorted;
      
      //Test 1
      list = new IntList();
      sorted = MergeSort.sort(list);
      Testing.testEquals("Test 2.1", sorted.toString(), "[]");
      
      //Test 2
      list = new IntList();
      list.add(1);
      sorted = MergeSort.sort(list);
      Testing.testEquals("Test 2.2", sorted.toString(), "[1]");
      
      //Test 3
      list = new IntList();
      list.add(1);
      list.add(1);
      sorted = MergeSort.sort(list);
      Testing.testEquals("Test 2.3", sorted.toString(), "[1, 1]");
      
      //Test 4
      list = new IntList();
      list.add(1);
      list.add(2);
      sorted = MergeSort.sort(list);
      Testing.testEquals("Test 2.4", sorted.toString(), "[1, 2]");
      
      //Test 5
      list = new IntList();
      list.add(2);
      list.add(1);
      sorted = MergeSort.sort(list);
      Testing.testEquals("Test 2.5", sorted.toString(), "[1, 2]");
      
      //Test 6
      list = new IntList();
      list.add(1);
      list.add(1);
      list.add(1);
      sorted = MergeSort.sort(list);
      Testing.testEquals("Test 2.6", sorted.toString(), "[1, 1, 1]");
      
      //Test 7
      list = new IntList();
      list.add(1);
      list.add(2);
      list.add(3);
      sorted = MergeSort.sort(list);
      Testing.testEquals("Test 2.7", sorted.toString(), "[1, 2, 3]");
      
      //Test 8
      list = new IntList();
      list.add(3);
      list.add(2);
      list.add(1);
      sorted = MergeSort.sort(list);
      Testing.testEquals("Test 2.8", sorted.toString(), "[1, 2, 3]");
      
      //Test 9
      list = new IntList();
      list.add(3);
      list.add(1);
      list.add(2);
      sorted = MergeSort.sort(list);
      Testing.testEquals("Test 2.9", sorted.toString(), "[1, 2, 3]");
      
      //Test 10
      list = new IntList();
      list.add(1);
      list.add(1);
      list.add(1);
      list.add(1);
      sorted = MergeSort.sort(list);
      Testing.testEquals("Test 2.10", sorted.toString(), "[1, 1, 1, 1]");
      
      //Test 11
      list = new IntList();
      list.add(1);
      list.add(2);
      list.add(3);
      list.add(4);
      sorted = MergeSort.sort(list);
      Testing.testEquals("Test 2.11", sorted.toString(), "[1, 2, 3, 4]");
      
      //Test 12
      list = new IntList();
      list.add(4);
      list.add(3);
      list.add(2);
      list.add(1);
      sorted = MergeSort.sort(list);
      Testing.testEquals("Test 2.12", sorted.toString(), "[1, 2, 3, 4]");
      
      //Test 13
      list = new IntList();
      list.add(2);
      list.add(1);
      list.add(2);
      list.add(1);
      sorted = MergeSort.sort(list);
      Testing.testEquals("Test 2.13", sorted.toString(), "[1, 1, 2, 2]");
      
      //Test 14
      list = new IntList();
      list.add(1);
      list.add(1);
      list.add(1);
      list.add(1);
      list.add(1);
      sorted = MergeSort.sort(list);
      Testing.testEquals("Test 2.14", sorted.toString(), "[1, 1, 1, 1, 1]");
      
      //Test 15
      list = new IntList();
      list.add(5);
      list.add(4);
      list.add(3);
      list.add(2);
      list.add(1);
      sorted = MergeSort.sort(list);
      Testing.testEquals("Test 2.15", sorted.toString(), "[1, 2, 3, 4, 5]");
      
      //Test 16
      list = new IntList();
      list.add(1);
      list.add(2);
      list.add(3);
      list.add(2);
      list.add(1);
      sorted = MergeSort.sort(list);
      Testing.testEquals("Test 2.16", sorted.toString(), "[1, 1, 2, 2, 3]");
      
      //Test 17
      list = new IntList();
      list.add(1);
      list.add(1);
      list.add(1);
      list.add(1);
      list.add(1);
      list.add(1);
      sorted = MergeSort.sort(list);
      Testing.testEquals("Test 2.17", sorted.toString(), "[1, 1, 1, 1, 1, 1]");
      
      //Test 18
      list = new IntList();
      list.add(6);
      list.add(5);
      list.add(4);
      list.add(3);
      list.add(2);
      list.add(1);
      sorted = MergeSort.sort(list);
      Testing.testEquals("Test 2.18", sorted.toString(), "[1, 2, 3, 4, 5, 6]");
      
      //Test 19
      list = new IntList();
      list.add(6);
      list.add(3);
      list.add(3);
      list.add(6);
      list.add(3);
      list.add(3);
      sorted = MergeSort.sort(list);
      Testing.testEquals("Test 2.19", sorted.toString(), "[3, 3, 3, 3, 6, 6]");
      
      //Test 20
      list = new IntList();
      list.add(6);
      list.add(4);
      list.add(2);
      list.add(5);
      list.add(3);
      list.add(1);
      sorted = MergeSort.sort(list);
      Testing.testEquals("Test 2.20", sorted.toString(), "[1, 2, 3, 4, 5, 6]");
      
      //Test 21
      list = new IntList();
      list.add(5);
      list.add(3);
      list.add(1);
      list.add(4);
      list.add(2);
      list.add(6);
      sorted = MergeSort.sort(list);
      Testing.testEquals("Test 2.21", sorted.toString(), "[1, 2, 3, 4, 5, 6]");
      
       //Test 22
      list = new IntList();
      list.add(-1);
      list.add(8);
      list.add(3);
      list.add(4);
      list.add(0);
      list.add(7);
      list.add(3);
      list.add(-2);
      list.add(6);
      sorted = MergeSort.sort(list);
      Testing.testEquals("Test 2.22", sorted.toString(), "[-2, -1, 0, 3, 3, 4, 6, 7, 8]");
   }
   
   public static void main(String[] args){
      StdOut.println("------------------------------");
      StdOut.println("Testing MergeSort.sort()");
      testSort();
      StdOut.println("------------------------------");
   }
}