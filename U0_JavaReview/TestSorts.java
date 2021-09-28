public class TestSorts{
   public static void testSelectionSort(){
      IntList l;
      
      l = new IntList();
      l.selectionSort();
      Testing.testEquals("Test 1.1", l.toString(), "[]");
      
      l= new IntList();
      l.add(5);
      l.selectionSort();
      Testing.testEquals("Test 1.2", l.toString(), "[5]");
      
      l = new IntList();
      l.add(5);
      l.add(4);
      l.selectionSort();
      Testing.testEquals("Test 1.3", l.toString(), "[4, 5]");
      
      l = new IntList();
      l.add(5);
      l.add(4);
      l.add(3);
      l.selectionSort();
      Testing.testEquals("Test 1.4", l.toString(), "[3, 4, 5]");
      
      l = new IntList();
      l.add(5);
      l.add(5);
      l.add(5);
      l.selectionSort();
      Testing.testEquals("Test 1.5", l.toString(), "[5, 5, 5]");
      
      l = new IntList();
      l.add(5);
      l.add(4);
      l.add(3);
      l.add(2);
      l.add(1);
      l.selectionSort();
      Testing.testEquals("Test 1.6", l.toString(), "[1, 2, 3, 4, 5]");
      
      l = new IntList();
      l.add(5);
      l.add(4);
      l.add(5);
      l.add(2);
      l.add(5);
      l.selectionSort();
      Testing.testEquals("Test 1.7", l.toString(), "[2, 4, 5, 5, 5]");
      
      l = new IntList();
      l.add(1);
      l.add(0);
      l.add(0);
      l.add(0);
      l.add(0);
      l.selectionSort();
      Testing.testEquals("Test 1.8", l.toString(), "[0, 0, 0, 0, 1]");
      
      l = new IntList();
      l.add(1);
      l.add(0);
      l.add(0);
      l.add(0);
      l.add(1);
      l.selectionSort();
      Testing.testEquals("Test 1.9", l.toString(), "[0, 0, 0, 1, 1]");
      
      l = new IntList();
      l.add(Integer.MAX_VALUE);
      l.add(Integer.MIN_VALUE);
      l.add(Integer.MAX_VALUE);
      l.add(Integer.MIN_VALUE);
      l.add(Integer.MAX_VALUE);
      l.selectionSort();
      Testing.testEquals("Test 1.10", l.toString(), "[-2147483648, -2147483648, 2147483647, 2147483647, 2147483647]");
   }
   
   public static void testInsertionSort(){
      IntList l;
      
      l = new IntList();
      l.insertionSort();
      Testing.testEquals("Test 2.1", l.toString(), "[]");
      
      l= new IntList();
      l.add(5);
      l.insertionSort();
      Testing.testEquals("Test 2.2", l.toString(), "[5]");
      
      l = new IntList();
      l.add(5);
      l.add(4);
      l.insertionSort();
      Testing.testEquals("Test 2.3", l.toString(), "[4, 5]");
      
      l = new IntList();
      l.add(5);
      l.add(4);
      l.add(3);
      l.insertionSort();
      Testing.testEquals("Test 2.4", l.toString(), "[3, 4, 5]");
      
      l = new IntList();
      l.add(5);
      l.add(5);
      l.add(5);
      l.insertionSort();
      Testing.testEquals("Test 2.5", l.toString(), "[5, 5, 5]");
      
      l = new IntList();
      l.add(5);
      l.add(4);
      l.add(3);
      l.add(2);
      l.add(1);
      l.insertionSort();
      Testing.testEquals("Test 2.6", l.toString(), "[1, 2, 3, 4, 5]");
      
      l = new IntList();
      l.add(5);
      l.add(4);
      l.add(5);
      l.add(2);
      l.add(5);
      l.insertionSort();
      Testing.testEquals("Test 2.7", l.toString(), "[2, 4, 5, 5, 5]");
      
      l = new IntList();
      l.add(1);
      l.add(0);
      l.add(0);
      l.add(0);
      l.add(0);
      l.insertionSort();
      Testing.testEquals("Test 2.8", l.toString(), "[0, 0, 0, 0, 1]");
      
      l = new IntList();
      l.add(1);
      l.add(0);
      l.add(0);
      l.add(0);
      l.add(1);
      l.insertionSort();
      Testing.testEquals("Test 2.9", l.toString(), "[0, 0, 0, 1, 1]");
      
      l = new IntList();
      l.add(Integer.MAX_VALUE);
      l.add(Integer.MIN_VALUE);
      l.add(Integer.MAX_VALUE);
      l.add(Integer.MIN_VALUE);
      l.add(Integer.MAX_VALUE);
      l.insertionSort();
      Testing.testEquals("Test 2.10", l.toString(), "[-2147483648, -2147483648, 2147483647, 2147483647, 2147483647]");
   }
   
   public static void main(String[] args){
      StdOut.println("-------------------------------------");
      StdOut.println("Testing Selection Sort");
      StdOut.println("----------------------");
      testSelectionSort();
      StdOut.println("-------------------------------------");
      
      StdOut.println("-------------------------------------");
      StdOut.println("Testing Insertion Sort");
      StdOut.println("----------------------");
      testInsertionSort();
      StdOut.println("-------------------------------------");
   }
}
   