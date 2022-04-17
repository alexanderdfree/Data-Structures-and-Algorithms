public class TestStacksNQueues{
      public static void main(String[] args){
      
      LQueue q;
      LStack s;
      
      //Test queueToStack()
      StdOut.println("-------------------------------------------------");
      StdOut.println("Testing queueToStack()");
      StdOut.println("-------------------------------------------------");
      q = new LQueue();
      s = new LStack();
      
      q.add(1);
      q.add(2);
      q.add(3);
      q.add(4);
      
      Testing.testEquals("Test 1.0", q.toString(), "(front) [1, 2, 3, 4] (end)");
      StacksNQueues.queueToStack(q, s);
      
      Testing.testEquals("Test 1.1", q.toString(), "(front) [] (end)");
      Testing.testEquals("Test 1.2", s.toString(), "(top) [4, 3, 2, 1] (bottom)");
      StdOut.println("-------------------------------------------------");
      
      //Test stackToQueue()
      StdOut.println("-------------------------------------------------");
      StdOut.println("Testing stackToQueue()");
      StdOut.println("-------------------------------------------------");
      q = new LQueue();
      s = new LStack();
      s.push(1);
      s.push(2);
      s.push(3);
      s.push(4);
      
      Testing.testEquals("Test 2.0", s.toString(), "(top) [4, 3, 2, 1] (bottom)");
      StacksNQueues.stackToQueue(s, q);
      
      Testing.testEquals("Test 2.1", s.toString(), "(top) [] (bottom)");
      Testing.testEquals("Test 2.2", q.toString(), "(front) [4, 3, 2, 1] (end)");      
      
      //Test sumQueue()
      StdOut.println("-------------------------------------------------");
      StdOut.println("Testing sumQueue()");
      StdOut.println("-------------------------------------------------");
      q = new LQueue();
      s = new LStack();
      q.add(1);
      q.add(2);
      q.add(3);
      q.add(4);
      
      Testing.testEquals("Test 3.0", q.toString(), "(front) [1, 2, 3, 4] (end)");
      Testing.testEquals("Test 3.1", StacksNQueues.sumQueue(q), 10);
      Testing.testEquals("Test 3.2", q.toString(), "(front) [1, 2, 3, 4] (end)");
      StdOut.println("-------------------------------------------------");
      
      //Test sumStack()
      StdOut.println("-------------------------------------------------");
      StdOut.println("Testing sumStack()");
      StdOut.println("-------------------------------------------------");
      q = new LQueue();
      s = new LStack();
      s.push(1);
      s.push(2);
      s.push(3);
      s.push(4);
      
      Testing.testEquals("Test 4.0", s.toString(), "(top) [4, 3, 2, 1] (bottom)");
      Testing.testEquals("Test 4.1", StacksNQueues.sumStack(s), 10);
      Testing.testEquals("Test 4.2", s.toString(), "(top) [4, 3, 2, 1] (bottom)");
      StdOut.println("-------------------------------------------------");

      
      //Test reverseHalf()
      /*
      StdOut.println("-------------------------------------------------");
      StdOut.println("Testing reverseHalf()");
      StdOut.println("-------------------------------------------------");
      q = new LQueue();
      q.add(1);
      q.add(8);
      q.add(7);
      q.add(2);
      q.add(9);
      q.add(18);
      q.add(12);
      q.add(0);
      
      Testing.testEquals("Test 5.0", q.toString(), "(front) [1, 8, 7, 2, 9, 18, 12, 0] (end)");
      StacksNQueues.reverseHalf(q);
      Testing.testEquals("Test 5.1", q.toString(), "(front) [1, 0, 7, 18, 9, 2, 12, 8] (end)");
      
      q.remove();
      
      Testing.testEquals("Test 5.2", q.toString(), "(front) [0, 7, 18, 9, 2, 12, 8] (end)");
      StacksNQueues.reverseHalf(q);
      Testing.testEquals("Test 5.3", q.toString(), "(front) [0, 12, 18, 9, 2, 7, 8] (end)");
      */

    
      //Test isPalindrome()
      
      StdOut.println("-------------------------------------------------");
      StdOut.println("Testing isPalindrome()");
      StdOut.println("-------------------------------------------------");
      q = new LQueue();
      q.add(3);
      q.add(8);
      q.add(17);
      q.add(9);
      q.add(17);
      q.add(8);
      q.add(3);
      
      Testing.testEquals("Test 6.0", q.toString(), "(front) [3, 8, 17, 9, 17, 8, 3] (end)");
      Testing.testEquals("Test 6.1", StacksNQueues.isPalindrome(q), true);
      Testing.testEquals("Test 6.2", q.toString(), "(front) [3, 8, 17, 9, 17, 8, 3] (end)");
      
      q.remove();
      Testing.testEquals("Test 6.3", q.toString(), "(front) [8, 17, 9, 17, 8, 3] (end)");
      Testing.testEquals("Test 6.4", StacksNQueues.isPalindrome(q), false);
      Testing.testEquals("Test 6.5", q.toString(), "(front) [8, 17, 9, 17, 8, 3] (end)");
      
      
      //Test switchPairs()
      /*
      StdOut.println("-------------------------------------------------");
      StdOut.println("Testing switchPairs()");
      StdOut.println("-------------------------------------------------");
      s = new LStack();
      s.push(1);
      s.push(2);
      s.push(8);
      s.push(6);
      s.push(-1);
      s.push(15);
      s.push(7);
      
      Testing.testEquals("Test 7.0", s.toString(), "(top) [7, 15, -1, 6, 8, 2, 1] (bottom)");
      StacksNQueues.switchPairs(s);
      Testing.testEquals("Test 7.1", s.toString(), "(top) [7, -1, 15, 8, 6, 1, 2] (bottom)");
      
      s.pop();
      Testing.testEquals("Test 7.2", s.toString(), "(top) [-1, 15, 8, 6, 1, 2] (bottom)");
      StacksNQueues.switchPairs(s);
      Testing.testEquals("Test 7.3", s.toString(), "(top) [15, -1, 6, 8, 2, 1] (bottom)");
      */

      //Test isSorted()
      
      StdOut.println("-------------------------------------------------");
      StdOut.println("Testing isSorted()");
      StdOut.println("-------------------------------------------------");
      s = new LStack();
      s.push(30);
      s.push(20);
      s.push(10);
      s.push(0);
      
      Testing.testEquals("Test 8.0", s.toString(), "(top) [0, 10, 20, 30] (bottom)");
      boolean b1 = StacksNQueues.isSorted(s);
      Testing.testEquals("Test 8.1", b1, true);
      Testing.testEquals("Test 8.2", s.toString(), "(top) [0, 10, 20, 30] (bottom)");
      
      s.pop();
      s.pop();
      s.push(25);
      s.push(10);
      s.push(5);
      s.push(0);
      
      Testing.testEquals("Test 8.3", s.toString(), "(top) [0, 5, 10, 25, 20, 30] (bottom)");
      boolean b2 = StacksNQueues.isSorted(s);
      Testing.testEquals("Test 8.4", b2, false);
      Testing.testEquals("Test 8.5", s.toString(), "(top) [0, 5, 10, 25, 20, 30] (bottom)");
      

   }
}