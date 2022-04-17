/*
A class demonstrating some operations
using Stacks & Queues
*/

public class StacksNQueues{
   public static void queueToStack(LQueue q, LStack s){
      /*
      Transfers all of the items from q to s
      Input:
         q: a queue of Integers
         s: the stack to move them to
      Output: None
      Side Effects: q is empty and all the items have been
      moved to s
      Ex.
      q.toString() -> (front) [1, 2, 3, 4] (end)
      s.toString() -> (top) [] (bottom)
      queueToStack(q, s)
      q.toString() -> (front) [] (end)
      s.toString() -> (top) [4, 3, 2, 1] (bottom)
      */
      while(!q.isEmpty()){
         //Object n = ;
         s.push((Integer)q.remove());
      }
   }
   
   public static void stackToQueue(LStack s, LQueue q){
      /*
      Transfers all of the items from s to q
      Input:
         s: a stack of Integers
         q: the queue to move them to
      Output: None
      Side Effects: s is empty and all the items have been
      moved to q
      Ex.
      s.toString() -> (top) [1, 2, 3, 4] (bottom)
      q.toString() -> (front) [] (end)
      stackToQueue(s, q)
      s.toString() -> (top) [] (bottom)
      q.toString() -> (front) [1, 2, 3, 4] (end)
      */
      while(!s.isEmpty()){
         q.add((Integer)s.pop());
      }

   }
   
   public static int sumQueue(LQueue q){
      /*
      Calculate the sum of all elements in the queue.
      At the end of the method, q should be unchanged.
      Input:
         q: a queue of Integers
      Output:
         return: the sum of all values in q
      Side Effects: none, q should be unchanged
      Ex.
      q.toString() -> (front) [1, 2, 3, 4] (end)
      sumQueue(q) -> 10
      q.toString() -> (front) [1, 2, 3, 4] (end)
      */
      int sum = 0;
      for(int i = 0; i < q.size(); i++){
         int n = (Integer) q.remove();
         sum += n;
         q.add(n);
      }
      return sum;
   }
   
   public static int sumStack(LStack s){
      /*
      Calculate the sum of all of the elements in s.
      At the end of the method s should be unchanged.
      Input:
         s: a stack of integers
      Output:
         return: the sum of the elements in s
      Side Effects: none, s should be unchanged at the 
      end of the method.
      Ex.
      s.toString() -> (top) [1, 2, 3, 4] (bottom)
      sumStack(s) -> 10
      s.toString() -> (top) [1, 2, 3, 4] (bottom)
      */
      int sum = 0;
      LQueue q = new LQueue();
      
      
      stackToQueue(s, q);
      while(!q.isEmpty()){
         int n = (Integer)q.remove();
         sum += n;
         s.push(n);
      }
      stackToQueue(s, q);
      queueToStack(q, s);
      return sum;
   }
   public static boolean isSorted(LStack s){
      /*
      Write a method called isSorted() that accepts a stack of integers as an argument
      and returns true if the elements in the stack occur in ascending order from top to bottom.
      That is, the smallest element should be on top, growing larger toward the bottom. 
      An empty or 1-item stack is considered sorted. Your method must restore the stack to its original state
      before returning. Use one queue or stack, but not both, as auxiliary storage.
         Ex。
         s.toString() -> (top) [2, 3, 8, 8, 11, 17, 20, 20] (bottom)
         isSorted(s) -> true
         s.toString() -> (top) [2, 3, 8, 8, 11, 17, 20, 20] (bottom)
      */
      if (s.size() == 0 || s.size() == 1) return true;
      
      int placeholder = (Integer) s.peek() - 1;
      
      LStack s2 = new LStack();
      boolean toReturn = true;
      int a = s.size();
      
      while(!s.isEmpty()){
         int temp = (Integer)s.pop();
         s2.push(temp);
         if (temp <= placeholder){
            toReturn = false;
         }
         placeholder = temp;
         //q.add(temp);
      }
      
      //queueToStack(q, s);
      //s = s2;
      for (int i = 0; i < a; i++){
         s.push(s2.pop());
      }
      return toReturn;
      
      
   }
   public static boolean isPalindrome(LQueue q){
      /*
      Write a method called isPalindrome() that accepts a queue of integers as an argument
      and returns true if the numbers in the queue are the same in reverse order, false otherwise.
      The empty queue should be considered a palindrome. Your method must restore the queue to its 
      original state before returning. Use one stack as auxiliary storage.
      Ex.
         q.toString() -> (front) [3, 8, 17, 9, 17, 8, 3] (end)
         isPalindrome(q) -> true
         q.toString() -> (front) [3, 8, 17, 9, 17, 8, 3] (end)
      */
      
      if (q.size() == 0 || q.size() == 1) return true;
      if (q.size() % 2 == 0) return false;
      
      
      LStack save = new LStack();
      //queueToStack(q, save);
      boolean toReturn = true;
      int a = q.size();
      
      for (int i = 0; i < a; i++){
         Object n = (Integer)q.remove();
         save.push(n);
         q.add(n);
      }
      
      for (int i = 0; i < a; i++){
         q.add(q.peek());
         
         int n = (Integer) q.remove();
         int m = (Integer) save.pop();
         
         if (n != m){
            toReturn = false;
         }
         
      }
      
      return toReturn;
   }
}