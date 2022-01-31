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
}
   