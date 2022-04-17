/*
An efficient queue implementation using linked nodes
*/

public class LQueue{
   private LNode front; //the item at the front of the line
   private LNode end;   //the item at the end of the line
   private int size;    //number of items currently in the queue
   
   public LQueue(){
      /*
      Constructor. Initialize a new empty queue
      */
      this.front = null;
      this.end = null;
      this.size = 0;
   }
   
   public String toString(){
      /*Return a String representing the contents of this queue.
      Inputs:
         this: the queue you want to examine
      Outputs:
         return: a String representing the contents of this queue
      Ex.
      LQueue q = new LQueue()
      q.add(1)
      q.add(2)
      q.add(3)
      q.toString() -> (front) [1, 2, 3] (end)
      q.remove()
      q.toString() -> (front) [2, 3] (end)
      q.remove()
      q.remove()
      q.toString() -> (front) [] (end)
      */
      String s = "(front) [";
      LNode check = this.front;
      int i = 0;
      while(check != null){
         if(i != 0){
            s += ", ";
         }
         s += check.getData();
         check = check.getNext();
         i++;
      }
      s += "] (end)";
      return s;
   }
   
   public Object peek(){
      /*
      Peek at the item at the front of the queue. The item remains
      in the queue (it is not removed). Returns null if the queue 
      is empty.
      Input:
         this: the queue you want to peek at
      Output:
         return: the item at the front of the queue (or null if empty)
      Side Effects: None, the queue is unaffected.
      Ex.
      LQueue q = new LQueue();
      q.peek() -> null
      q.add(1)
      q.peek() -> 1
      q.add(2)
      q.peek() -> 1
      q.add(3)
      q.peek() -> 1
      */
      if(this.front == null){
         return null;
      }
      else{
         return this.front.getData();
      }
   }
   
   public void add(Object o){
      /*
      Add a new item to the end of the queue.
      Inputs:
         this: the queue to add an item to
         o: the item to add to the end of the queue
      Outputs: None
      Side Effects: this queue now has o added to the end
      Ex.
      LQueue q = new LQueue();
      q.add(1)
      q.peek() -> 1
      q.add(2)
      q.peek() -> 1
      q.add(3)
      q.peek() -> 1
      */
      LNode newNode = new LNode(o);
      //add to the end of the queue
      if(this.front == null){
         this.front = newNode;
         this.end = newNode;
      }
      else{
         this.end.setNext(newNode);
         this.end = newNode;
      }
      this.size++;
   }
   
   public Object remove(){
      /*
      Remove the item at the front of the queue (or null if empty).
      Inputs:
         this: the queue to remove the next item from
      Outputs:
         return: the next item in the queue (or null if empty).
      Side Effects: the next item has been removed from the queue
      Ex.
      LQueue q = new LQueue();
      q.remove() -> null
      q.add(1)
      q.remove() -> 1
      q.add(1)
      q.add(2)
      q.remove() -> 1
      q.remove() -> 2
      */
      if(this.front == null){
         return null;
      }
      else{
         Object o = this.front.getData();
         this.front = this.front.getNext();
         this.size--;
         return o;
      }
   }
   
   public boolean isEmpty(){
      /*
      Check if this queue has no items in it.
      Inputs:
         this: the queue you are checking
      Outputs:
         return: true if this queue is empty,
                 false if not
      Side Effects: None, the queue is unchanged
      Ex.
      LQueue q = new LQueue()
      q.isEmpty() -> true
      q.add(1)
      q.isEmpty() -> false
      q.remove()
      q.isEmpty() -> true
      */
      return this.front == null;
   }
   
   public int size(){
      /*
      Check how many items are currently in the queue.
      Inputs:
         this: the queue you want to check
      Outputs:
         return: the number of items currently in this queue
      Side Effects: None, the queue is unchanged
      Ex.
      LQueue q = new LQueue()
      q.size() -> 0
      q.add(1)
      q.size() -> 1
      q.remove()
      q.size() -> 0
      q.add(1)
      q.add(2)
      q.size() -> 2
      q.remove()
      q.size() -> 1
      q.remove()
      q.size() -> 0
      */
      return this.size;
   }
   
   

}