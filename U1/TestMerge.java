public class TestMerge{
   public static void testMerge(){
      IntList left, right, merged;
      
      //Test 1.1
      left = new IntList();
      right = new IntList();
      merged = MergeSort.merge(left, right);
      Testing.testEquals("Test 1.1", merged.toString(), "[]");
      
      //Test 1.2
      left = new IntList();
      right = new IntList();
      left.add(1);
      merged = MergeSort.merge(left, right);
      Testing.testEquals("Test 1.2", merged.toString(), "[1]");
      
      //Test 1.3
      left = new IntList();
      right = new IntList();
      right.add(1);
      merged = MergeSort.merge(left, right);
      Testing.testEquals("Test 1.3", merged.toString(), "[1]");
      
      //Test 1.4
      left = new IntList();
      right = new IntList();
      left.add(1);
      right.add(1);
      merged = MergeSort.merge(left, right);
      Testing.testEquals("Test 1.4", merged.toString(), "[1, 1]");
      
      //Test 1.5
      left = new IntList();
      right = new IntList();
      left.add(1);
      left.add(2);
      right.add(3);
      merged = MergeSort.merge(left, right);
      Testing.testEquals("Test 1.5", merged.toString(), "[1, 2, 3]");
      
      //Test 1.6
      left = new IntList();
      right = new IntList();
      left.add(1);
      left.add(3);
      right.add(2);
      merged = MergeSort.merge(left, right);
      Testing.testEquals("Test 1.6", merged.toString(), "[1, 2, 3]");
      
      //Test 1.7
      left = new IntList();
      right = new IntList();
      left.add(1);
      right.add(2);
      right.add(3);
      merged = MergeSort.merge(left, right);
      Testing.testEquals("Test 1.7", merged.toString(), "[1, 2, 3]");
      
      //Test 1.8
      left = new IntList();
      right = new IntList();
      left.add(1);
      left.add(1);
      right.add(2);
      merged = MergeSort.merge(left, right);
      Testing.testEquals("Test 1.8", merged.toString(), "[1, 1, 2]");
      
      //Test 1.9
      left = new IntList();
      right = new IntList();
      left.add(1);
      right.add(1);
      right.add(2);
      merged = MergeSort.merge(left, right);
      Testing.testEquals("Test 1.9", merged.toString(), "[1, 1, 2]");
      
      //Test 1.10
      left = new IntList();
      right = new IntList();
      left.add(2);
      right.add(1);
      right.add(1);
      merged = MergeSort.merge(left, right);
      Testing.testEquals("Test 1.10", merged.toString(), "[1, 1, 2]");
      
      //Test 1.11
      left = new IntList();
      right = new IntList();
      left.add(1);
      left.add(1);
      right.add(1);
      merged = MergeSort.merge(left, right);
      Testing.testEquals("Test 1.11", merged.toString(), "[1, 1, 1]");
      
      //Test 1.12
      left = new IntList();
      right = new IntList();
      left.add(1);
      right.add(1);
      right.add(1);
      merged = MergeSort.merge(left, right);
      Testing.testEquals("Test 1.12", merged.toString(), "[1, 1, 1]");
      
      //Test 1.13
      left = new IntList();
      right = new IntList();
      left.add(1);
      left.add(1);
      right.add(1);
      right.add(1);
      merged = MergeSort.merge(left, right);
      Testing.testEquals("Test 1.13", merged.toString(), "[1, 1, 1, 1]");
      
      //Test 1.14
      left = new IntList();
      right = new IntList();
      left.add(1);
      left.add(2);
      right.add(1);
      right.add(2);
      merged = MergeSort.merge(left, right);
      Testing.testEquals("Test 1.14", merged.toString(), "[1, 1, 2, 2]");
      
      //Test 1.15
      left = new IntList();
      right = new IntList();
      left.add(1);
      left.add(2);
      right.add(3);
      right.add(4);
      merged = MergeSort.merge(left, right);
      Testing.testEquals("Test 1.15", merged.toString(), "[1, 2, 3, 4]");
      
      //Test 1.16
      left = new IntList();
      right = new IntList();
      left.add(3);
      left.add(4);
      right.add(1);
      right.add(2);
      merged = MergeSort.merge(left, right);
      Testing.testEquals("Test 1.16", merged.toString(), "[1, 2, 3, 4]");
      
      //Test 1.17
      left = new IntList();
      right = new IntList();
      left.add(1);
      left.add(3);
      right.add(2);
      right.add(4);
      merged = MergeSort.merge(left, right);
      Testing.testEquals("Test 1.17", merged.toString(), "[1, 2, 3, 4]");
      
      //Test 1.18
      left = new IntList();
      right = new IntList();
      left.add(2);
      left.add(4);
      right.add(1);
      right.add(3);
      merged = MergeSort.merge(left, right);
      Testing.testEquals("Test 1.18", merged.toString(), "[1, 2, 3, 4]");
      
      //Test 1.19
      left = new IntList();
      right = new IntList();
      left.add(1);
      left.add(1);
      left.add(1);
      right.add(1);
      right.add(1);
      merged = MergeSort.merge(left, right);
      Testing.testEquals("Test 1.19", merged.toString(), "[1, 1, 1, 1, 1]");
      
      //Test 1.20
      left = new IntList();
      right = new IntList();
      left.add(1);
      left.add(2);
      left.add(3);
      right.add(1);
      right.add(2);
      merged = MergeSort.merge(left, right);
      Testing.testEquals("Test 1.20", merged.toString(), "[1, 1, 2, 2, 3]");
      
      //Test 1.21
      left = new IntList();
      right = new IntList();
      left.add(1);
      left.add(2);
      left.add(3);
      right.add(4);
      right.add(5);
      merged = MergeSort.merge(left, right);
      Testing.testEquals("Test 1.21", merged.toString(), "[1, 2, 3, 4, 5]");
      
      //Test 1.22
      left = new IntList();
      right = new IntList();
      left.add(1);
      left.add(2);
      right.add(3);
      right.add(4);
      right.add(5);
      merged = MergeSort.merge(left, right);
      Testing.testEquals("Test 1.22", merged.toString(), "[1, 2, 3, 4, 5]");
      
      //Test 1.23
      left = new IntList();
      right = new IntList();
      left.add(1);
      left.add(3);
      left.add(5);
      right.add(2);
      right.add(4);
      merged = MergeSort.merge(left, right);
      Testing.testEquals("Test 1.23", merged.toString(), "[1, 2, 3, 4, 5]");
      
      //Test 1.24
      left = new IntList();
      right = new IntList();
      left.add(2);
      left.add(4);
      right.add(1);
      right.add(3);
      right.add(5);
      merged = MergeSort.merge(left, right);
      Testing.testEquals("Test 1.24", merged.toString(), "[1, 2, 3, 4, 5]");
      
      //Test 1.25
      left = new IntList();
      right = new IntList();
      left.add(-8);
      left.add(0);
      left.add(0);
      left.add(4);
      left.add(5);
      right.add(-10);
      right.add(2);
      right.add(2);
      right.add(3);
      right.add(4);
      right.add(6);
      merged = MergeSort.merge(left, right);
      Testing.testEquals("Test 1.25", merged.toString(), "[-10, -8, 0, 0, 2, 2, 3, 4, 4, 5, 6]");
   }
   
   public static void main(String[] args){
      testMerge();
   }
}