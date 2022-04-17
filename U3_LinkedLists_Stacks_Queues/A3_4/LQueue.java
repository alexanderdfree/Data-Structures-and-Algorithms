/*
A minimal queue implementation using linked nodes
*/

public class LQueue{
   LNode next; //the next item up in the queue
   LNode last;
   int size;
   
   public LQueue(){
      /*
      Constructor. Initialize a new empty queue
      */
      this.next = null;
      this.size = 0;
      this.last = null;
   }
   
   public Object peek(){
      /*
      Peek at the next item in the queue (next to be released).
      The item remains in the queue (it is not removed). Returns
      null if the queue is empty.
      Input:
         this: the queue you want to peek at
      Output:
         return: the next item in the queue (or null if empty)
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
      if(this.next == null){
         return null;
      }
      else{
         return this.next.getData();
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
      this.size++;
      
      //add to the end of the queue
      
      /*if(this.next == null){
         this.next = newNode;
         this.last = this.next;
      }
      else{
         LNode end = this.next;
         while(end.getNext() != null){
            end = end.getNext();
         }
         end.setNext(newNode);
         this.last = end;
      }*/
      if (this.next == null){
         this.next = newNode;
         
      }
      else{
         this.last.setNext(newNode);
         
      }
      this.last = newNode;
   }
   
   public Object remove(){
      /*
      Remove the next item in the queue (or null if empty).
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
      
      if(this.next == null){
         return null;
      }
      else{
         Object o = this.next.getData();
         this.next = this.next.getNext();
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
      return this.next == null;
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
      
      /*int n = 0;
      LNode check = this.next;
      while(check != null){
         n++;
         check = check.getNext();
      }
      return n;*/
      return this.size;
   }
   
   

}