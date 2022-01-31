/*
A minimal queue implementation using array-based storage
*/

public class AQueue{
   private Object[] contents; //storage for items in queue
   private int size;          //num of items in queue
   
   //some parameters that determine queue storage behavior
   private static int initialCapacity = 10; //how big to make initial stack
   private static int resizeFactor = 2; //scale factor when you run out of room
   
   public AQueue(){
      /*
      Constructor. Initialize a new empty queue
      */
      this.contents = new Object[initialCapacity];
      this.size = 0;
   }
   public Object peek(){
      /*
      Peek at the next item in the queue (next to be removed).
      The item remains in the queue (it is not removed). Returns
      null if the queue is empty.
      Input:
         this: the queue you want to peek at
      Output:
         return: the next item in the queue (or null if empty)
      Side Effects: None, the queue is unaffected.
      Ex.
      AQueue q = new AQueue();
      q.peek() -> null
      q.add(1)
      q.peek() -> 1
      q.add(2)
      q.peek() -> 1
      q.add(3)
      q.peek() -> 1
      */
      if (this.size == 0) return null;
      return this.contents[0];
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
      AQueue q = new AQueue();
      q.add(1)
      q.peek() -> 1
      q.add(2)
      q.peek() -> 1
      q.add(3)
      q.peek() -> 1
      */
      if (this.size == this.contents.length){
         Object[] newArr = new Object[this.size * AQueue.resizeFactor];
         for (int i = 0; i < this.size; i++){
            newArr[i] = this.contents[i];
         }
         
         
         this.contents = newArr;
      }
      this.contents[this.size] = o;
      this.size++;
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
      AQueue q = new AQueue();
      q.remove() -> null
      q.add(1)
      q.remove() -> 1
      q.add(1)
      q.add(2)
      q.remove() -> 1
      q.remove() -> 2
      */
      if (this.size == 0) return null;
      for (int i = 0; i < this.size; i++){
         this.contents[i] = this.contents[i+1];
      }
      this.size--;
      return this.contents[0];
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
      AQueue q = new AQueue()
      q.isEmpty() -> true
      q.add(1)
      q.isEmpty() -> false
      q.remove()
      q.isEmpty() -> true
      */
      return (this.contents[0] == null);
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
      AQueue q = new AQueue()
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
   