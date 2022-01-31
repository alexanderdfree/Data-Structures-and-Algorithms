/*
A minimal stack implementation using an array as storage
*/

public class AStack{
   private Object[] contents; //holds stack contents
   private int size;          //keeps track of num. items in stack
   
   //some parameters that determine stack storage behavior
   private static int initialCapacity = 10; //how big to make initial stack
   private static int resizeFactor = 2; //scale factor when you run out of room
   
   public AStack(){
      /*
      Contructor. Sets up a new stack
      */
      this.contents = new Object[initialCapacity];
      this.size = 0;
   }
   
   private void resize(){
      /*
      Helper Method. Increase the capacity of the internal
      storage array.
      */
      
      //make a new array that is bigger
      Object[] newContents = new Object[this.contents.length * resizeFactor];
      //copy over the contents of current array
      for(int i = 0; i < this.size; i++){
         newContents[i] = this.contents[i];
      }
      //replace the old array with the new array
      this.contents = newContents;
   }
   
   public Object peek(){
      /*
      Peek at the current item on top of the stack.
      Does not remove that item from the stack.
      Returns null if the stack is empty.
      Inputs:
         this: a stack you want to peek at
      Outputs:
         return: the item currently on top of the stack,
                 or null if the stack is empty
      Side Effects: None, the stack remains unchanged
      Ex.
      AStack s = new AStack()
      s.peek() -> null
      s.push(1)
      s.peek() -> 1
      s.push(2)
      s.peek() -> 2
      s.push(3)
      s.peek() -> 3
      */
      if(this.size == 0){
         return null;
      }
      else{
         return this.contents[this.size - 1];
      }
   }
   
   public void push(Object o){
      /*
      Push data onto the top of the stack.
      Inputs:
         this: the stack you want to push onto
         o: the data to push onto the stack
      Outputs: None
      Side Effects: this stack now has o on top of it
      Ex.
      AStack s = new AStack()
      s.peek() -> null
      s.push(1)
      s.peek() -> 1
      s.push(2)
      s.peek() -> 2
      s.push(3)
      s.peek() -> 3
      */
      //check if you need to resize
      if(this.size + 1 == this.contents.length){
         this.resize();//increase array capacity
      }
      
      this.contents[this.size] = o;//add item to stack
      this.size++;                 //increase size count
   }
   
   public Object pop(){
      /*
      Remove and return the item on top of the stack.
      Return null if the stack is empty.
      Inputs:
         this: the stack you want to pop from
      Outputs:
         return: the item that was on top of the stack,
                 or null if the stack was empty
      Side Effects: the returned item is no longer on top of the stack
      Ex.
      AStack s = new AStack()
      s.pop() -> null
      s.push(1)
      s.pop() -> 1
      s.pop() -> null
      s.push(1)
      s.push(2)
      s.pop() -> 2
      s.pop() -> 1
      s.pop() -> null
      s.push(1)
      s.push(2)
      s.push(3)
      s.pop() -> 3
      s.pop() -> 2
      s.pop() -> 1
      s.pop() -> null
      */
      if(this.size == 0){
         return null;
      }
      else{
         this.size--;//decrement size first since otherwise I need to do -1 anyway
         return this.contents[this.size];
         //technically I don't need to clear out the old item
         //since it will get overwritten by the next push() call
      }
   }
   
   public boolean isEmpty(){
      /*
      Check if this stack has no items in it.
      Inputs:
         this: the stack you are checking
      Outputs:
         return: true if this stack is empty,
                 false if not
      Side Effects: None, the stack is unchanged
      Ex.
      AStack s = new AStack()
      s.isEmpty() -> true
      s.push(1)
      s.isEmpty() -> false
      s.pop()
      s.isEmpty() -> true
      */
      return this.size == 0;
   }
   
   public int size(){
      /*
      Check how many items are currently in the stack.
      Inputs:
         this: the stack you want to check
      Outputs:
         return: the number of items in this stack
      Side Effects: None, the stack is unchanged
      Ex.
      AStack s = new AStack()
      s.size() -> 0
      s.push(1)
      s.size() -> 1
      s.pop()
      s.size() -> 0
      s.push(1)
      s.push(2)
      s.size() -> 2
      s.pop()
      s.size() -> 1
      s.pop()
      s.size() -> 0
      */
      return this.size;
   }
      
      
}