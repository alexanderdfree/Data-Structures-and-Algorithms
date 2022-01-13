/*A minimal Linked List implementation*/

public class LList{
   private LNode start;   //the first node in the Linked List
   
   public LList(){
      /*Constructor, initialize a new empty list*/
      this.start = null;
   }
   
   public String toString(){
      /*Return a String representing the contents of this list*/
      if(this.start == null){
         return "null";
      }
      else{
         return this.start.toString();
      }
   }
   
   public void add(Object o){
      /*
      Add o to the end of the list
      Inputs:
         this: the LList to add to
         o: the data to add to the list
      Results:
         Side Effects: a new node containing o has been added to
                       the end of the list
      Ex.
      LList l = new LList()
      l.toString() -> "null"
      l.add(1)
      l.toString() -> "1 -> null"
      l.add(2)
      l.toString() -> "1 -> 2 -> null"
      l.add(3)
      l.toString() -> "1 -> 2 -> 3 -> null"
      */
      LNode newNode = new LNode(o); //put data in a node
      if(this.start == null){//special case for first item in list
         this.start = newNode;
      }
      else{//otherwise, find the end of the list
         LNode end = this.start;
         while(end.getNext() != null){
            end = end.getNext();
         }
         end.setNext(newNode);//tack the new node onto the end
      }
   }
   public Object get(int index){
      /*
      Get the data at index. If index is out of bounds may
      result in an unprotected error
      Inputs:
         this: the LList we are checking
         index: the index in the list to check
      Results:
         return: the data (not the node) at index
         Side Effects: none, the list is unchanged
      Ex.
      LList l = new LList()
      l.add(1)
      l.add(2)
      l.add(3)
      l.toString() -> "1 -> 2 -> 3 -> null"
      l.get(0) -> 1
      l.get(1) -> 2
      l.get(2) -> 3
      l.get(3) -> ERROR (possibly)
      l.toString() -> "1 -> 2 -> 3 -> null"
      */
      Object placeholder = this.start;
      LNode x = this.start;
      for (int i = 0; i < index; i++){
         x = x.getNext();
         //StdOut.println(x);
      }
      return x.getData();
    }
    public Object remove(int index){
      /*
      Removes the data at index from the list and 
      returns what was there. Index must be in-bounds
      or it may trigger an error.
      Input:
         this: the list you are looking in
         index: the index of the item to remove
      Results:
         return: return the data that was at index
         Side Effects: that node has been removed from the list
      Ex.
      LList l = new LList()
      l.add(1)
      l.add(2)
      l.add(3)
      l.toString() -> "1 -> 2 -> 3 -> null"
      l.remove(1) -> 2
      l.toString() -> "1 -> 3 -> null"
      l.remove(1) -> 3
      l.toString() -> "1 -> null"
      l.remove(0) -> 1
      l.toString() -> "null"
      l.remove(0) -> ERROR (possibly)
      */
      Object placeholder = this.start.getData();
      LNode x = this.start;
      LNode z;
      if (index == 0){
         this.start = null;
         return placeholder;
      }
      
      for (int i = 0; i < index-1; i++){
         x = x.getNext();
         //StdOut.println(x);
      }
      
      Object save = x.getData();
      
      
      LNode y = x.getNext();
      
      
      if (y != null){
         Object save2 = y.getData();
         z = y.getNext();
         x.setNext(z);
         y = null;
         return save2;
      }
      else{
         return save;
      }
      
      //if (z)
      
      
      
    }
    public void insert(Object o, int index){
      /*
      Adds new data into the list at the specified index.
      Does not destroy any existing data, but merely shifts
      it out of the way. Index should be in-bounds+1 or an error
      may occur.
      Inputs:
         this: the list you are adding to
         o: the data to be added to the list
         index: the index where we want to insert (in-bounds+1)
      Results:
         Side Effects: this list now contains o at index
      Ex.
      LList l = new LList()
      l.insert(1, 0)
      l.toString() -> "1 -> null"
      l.insert(2, 0)
      l.toString() -> "2 -> 1 -> null"
      l.insert(3, 1)
      l.toString() -> "2 -> 3 -> 1 -> null"
      l.insert(4, 4) -> ERROR (possibly)
      */
      LNode newNode = new LNode(o); //put data in a node
      LNode x = this.start;
      LNode a = this.start;
      
      
      if(this.start == null){//special case for first item in list
         this.start = newNode;
      }
      if (index == 0){
         //newNode.setNext(this.start);
         this.start = newNode;
      }
      else{//otherwise, find the end of the list
         for (int i = 0; i < index-1; i++){
            x = x.getNext();
            //StdOut.println(x);
         }
         //tack the new node onto the end
         if (x == null){
            x = newNode;
         }
         if (x.getNext() == null){
            x.setNext(newNode);
         }
         else{
            LNode y = x.getNext();
            newNode.setNext(y);
            //x.setNext(newNode);
         }
      }
   }


}