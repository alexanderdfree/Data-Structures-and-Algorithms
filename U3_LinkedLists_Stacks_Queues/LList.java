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
      //LNode z;
      if (index == 0){
         //this.start = null;
         this.start = this.start.getNext();
         return placeholder;
      }
      /*if (index == 1){
         Object placeholder2 = this.start.getNext().getData();
         this.start.setNext(this.start.getNext().getNext());
         LNode a = this.start.getNext();
         a = null;
         
         return placeholder2;
      }*/
      
      for (int i = 0; i < index-1; i++){
         x = x.getNext();
         /*if (x.getNext() != null){
            StdOut.println(x.getData());
         }*/
      }

      if (x == null){
         return "ERROR";
      }
      else if (x.getNext() == null){
         Object save = x.getData();
         return save; // should be null i think
      }
      else{
         LNode y = x.getNext(); // node to delete
         LNode z = y.getNext(); // node after
         Object a = y.getData(); // obj
         x.setNext(z); // link (skip over y)
         return a;
      }
      
      //
      
      
      //
      
      
      
      
      /*
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
      }*/
      
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
      /*LNode newNode = new LNode(o); //put data in a node
      LNode x = this.start;
      LNode a = this.start;
      
      
      if(this.start == null){//special case for first item in list
         this.start = newNode;
      }
      if (index == 0){
         LNode original = this.start;
         newNode.setNext(original);
         this.start = newNode;
      }
      else{//otherwise, find the end of the list
         for (int i = 0; i < index; i++){
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
            x.setNext(newNode);
         }
      }*/
      /*LNode newNode = new LNode(o); //put data in a node
      if(this.start == null){//special case for first item in list
         this.start = newNode;
      }
      else{//otherwise, find the end of the list
         LNode end = this.start;
         int i = 0;
         while(i < index-1){
            end = end.getNext();
            i++;
         }
         LNode after = end.getNext();
         newNode.setNext(after);
         end.setNext(newNode);//tack the new node onto the end
         
      }*/
      LNode newNode = new LNode(o);
      
      
      LNode x = this.start;
      
      if(this.start == null){//special case for first item in list
         this.start = newNode;
      }
      
      else if(index == 0){
         LNode test = new LNode(this.start.getData());
         test.setNext(this.start.getNext());
         newNode.setNext(test);
         this.start = newNode;
         //this.start = this.start.getNext();
         //
         
      }
      
      else{
         for (int i = 0; i < index-1; i++){
            x = x.getNext();
            //StdOut.println(x);
         }
         if(x.getNext() == null){
            this.add(o);
         
         }
         else{
            LNode after = new LNode(x.getNext().getData());
            after.setNext(x.getNext().getNext());
            x.setNext(newNode);
            newNode.setNext(after);
         }
      }
      
      
   }
   public void set(Object o, int index){
      /*
      Replace the value at index with o. Must be an index
      within the current bounds of the list. Should not use
      any other helper methods previously coded like add(),
      get(), remove() etc. as this would be inefficient.
      Inputs:
         this: the list you want to modify
         o: the new data to put in the list
         index: where to put this data (must be in-bounds)
      Results:
         Side Effects: the previous item at index is replaced by o
      Ex.
      LList l = new LList()
      l.add(1)
      l.add(2)
      l.add(3)
      l.toString() -> "1 -> 2 -> 3 -> null"
      l.set(4, 1)
      l.toString() -> "1 -> 4 -> 3 -> null"
      l.set(5, 3) -> ERROR (possibly)
      */
      LNode x = this.start;
      LNode newNode = new LNode(o);
      for (int i = 0; i < index-1; i++){
         x = x.getNext();
         
         //StdOut.println(x);
      }
      if (index == 0){
         newNode.setNext(x.getNext());
         this.start = newNode;
      }
      
      else if(x.getNext() != null && x.getNext().getNext() != null){
         newNode.setNext(x.getNext().getNext());
      }
      
      x.setNext(newNode);
      
   }
   public void clear(){
      /*
      Empties the list of all items.
      Inputs:
         this: the list to empty
      Results:
         Side Effects: the list is now empty with nothing in it
      Ex.
      LList l = new LList()
      l.add(1)
      l.add(2)
      l.add(3)
      l.toString() -> "1 -> 2 -> 3 -> null"
      l.clear()
      l.toString() -> "null"
      */
      this.start = null;
   }
   public void swap(int index1, int index2){
      /*
      Swap the items at index1 and index2. Both indices
      must be in-bounds (otherwise may result in ERROR).
      Swaps by changing links, not by copying data between
      nodes. Should not use call on any other helper methods.
      Inputs:
         this: the list we are swapping items in
         index1: the index of the 1st item to swap
         index2: the index of the 2nd item to swap
      Results:
         Side Effects: the items at index1 and index2 in
                       this list have been swapped
      Ex.
      LList l = new LList()
      l.add(1)
      l.add(2)
      l.add(3)
      l.add(4)
      l.add(5)
      l.toString() -> "1 -> 2 -> 3 -> 4 -> 5 -> null
      l.swap(1, 3)
      l.toString() -> "1 -> 4 -> 3 -> 2 -> 5 -> null
      l.swap(2, 0)
      l.toString() -> "3 -> 4 -> 1 -> 2 -> 5 -> null
      l.swap(3, 4)
      l.toString() -> "3 -> 4 -> 1 -> 5 -> 2 -> null
      l.swap(1, 0)
      l.toString() -> "4 -> 3 -> 1 -> 5 -> 2 -> null
      l.swap(3, 3)
      l.toString() -> "4 -> 3 -> 1 -> 5 -> 2 -> null
      l.swap  (1, 3) -> ERROR
      */
      LNode node1 = this.start;
      LNode node2 = this.start;
      
      if (index1 != index2){
         
         if (Math.abs(index1-index2) == 1){
            /*int a = 0;
            int b = 0;*/
            for (int i = 0; i < index1-1; i++){
               node1 = node1.getNext();
               
               //StdOut.println(x);
            }
            for (int i = 0; i < index2-1; i++){
               node2 = node2.getNext();
               
               //StdOut.println(x);
            }
            LNode copy1 = new LNode(node1.getNext().getData());
            LNode copy2 = new LNode(node2.getNext().getData());
            LNode start = new LNode(this.start.getData());
            if (index1 > index2){
               //node2.setNext(node1.getNext());
               //node1.setNext(node2);
               if (index2 == 0){
                  if (node1.getNext().getNext() != null){
                     start.setNext(node1.getNext().getNext());
                  }
                  
                  //LNode copy2 = new LNode(node2.getNext().getData());
                  
                  copy1.setNext(start);
                  this.start = copy1;
                  
                  
                  node1.setNext(start);
               }
               else{
                  copy1.setNext(copy2);
                  copy2.setNext(node1.getNext().getNext());
                  node2.setNext(copy1);
               }
               
            }
            else{
               /*copy2.setNext(copy1);
               copy1.setNext(node2.getNext());
               node1.setNext(copy2);*/
               if (index1 == 0){
                  if (node2.getNext().getNext() != null){
                     start.setNext(node2.getNext().getNext());
                  }
                  
                  //LNode copy2 = new LNode(node2.getNext().getData());
                  
                  copy2.setNext(start);
                  this.start = copy2;
                  
                  
                  node2.setNext(start);
               }
               else{
                  copy2.setNext(copy1);
                  copy1.setNext(node2.getNext().getNext());
                  node1.setNext(copy2);
               }
            }
            
         }
         else if (index1 == 0){
            
            //CODE WORKS EVERYWHERE EXCEPT WHEN INDICES ARE SEPARATED BY 1
            
            
            
            for (int i = 0; i < index2-1; i++){
               node2 = node2.getNext();
            }
            
            LNode start = new LNode(this.start.getData());
            if (node2.getNext().getNext() != null){
               start.setNext(node2.getNext().getNext());
            }
            
            LNode copy2 = new LNode(node2.getNext().getData());
            
            copy2.setNext(this.start.getNext());
            this.start = copy2;
            
            
            node2.setNext(start);
            
         }
         
         else if (index2 == 0){
            for (int i = 0; i < index1-1; i++){
               node1 = node1.getNext();
            }
            LNode copy1 = new LNode(node1.getNext().getData());
            LNode start = new LNode(this.start.getData());
            copy1.setNext(this.start.getNext());
            this.start = copy1;
            
            if (node1.getNext().getNext() != null){
               start.setNext(node1.getNext().getNext());
            }
            node1.setNext(start);
            
         }
         else{
            for (int i = 0; i < index1-1; i++){
               if (node1.getNext() != null){
                  node1 = node1.getNext();
               }
               //StdOut.println(x);
            }
            for (int i = 0; i < index2-1; i++){
               if (node2.getNext() != null){
                  node2 = node2.getNext();
               }
               //StdOut.println(x);
            }
            LNode copy1 = new LNode(node1.getNext().getData());
            LNode copy2 = new LNode(node2.getNext().getData());
            if (node1.getNext().getNext() != null){
               copy2.setNext(node1.getNext().getNext());
            }
            if (node2.getNext().getNext() != null){
               copy1.setNext(node2.getNext().getNext());
            }
            node1.setNext(copy2);
            node2.setNext(copy1);
         }
      }
   }
   public int size(){
      /*
      Return the number of items in the list,
      a.k.a. the size of the list.
      Inputs:
         this: the list whose size you want to check
      Results:
         return: the number of items in the list
      Ex.
      LList l = new LList()
      l.size() -> 0
      l.add(1)
      l.size() -> 1
      l.add(2)
      l.size() -> 2
      l.add(3)
      l.size() -> 3
      l.remove(0)
      l.size() -> 2
      */
      int counter = 0;
      LNode x = this.start;
      
      while (x != null){
         x = x.getNext();
         counter++;
         //StdOut.println(x);
      }
      return counter;
   }
   public boolean contains(Object o){
      /*
      Check if this list contains o. Compares
      by value, not by memory location, i.e. uses
      .equals(), not == .
      Inputs:
         this: the list to search through
         o: the Object to search for
      Results:
         return: true if the Object exists in the list.
                 false otherwise
      Ex.
      LList l = new LList()
      l.add(1)
      l.add(2)
      l.add(3)
      l.contains(1) -> true
      l.contains(2) -> true
      l.contains(3) -> true
      l.contains(4) -> false
      l.contains("3") -> false
      */
      LNode x = this.start;
      
      while (x != null){
         
         if (x.getData().equals(o)){
            return true;
         }
         x = x.getNext();
      }
      return false;
   }
   public int indexOf(Object o){
      /*
      Find the index of the given value in the list.
      Checks for equality by value, not by memory location,
      i.e. uses .equals() not == . If the same value is
      at multiple indices, return the smallest one. If the
      value is not in the list, return -1.
      Inputs:
         this: the list to search through
         o: the value to search for
      Results:
         return: the smallest index with a matching value
                 or -1 if the value is not in the list
      Ex.
      LList l = new LList()
      l.add(3)
      l.add(1)
      l.add(3)
      l.indexOf(3) -> 0
      l.indexOf(1) -> 1
      l.indexOf(2) -> -1
      */
      LNode x = this.start;
      int counter = 0;
      
      while (x != null){
         if (x.getData().equals(o)){
            return counter;
         }
         
         x = x.getNext();
         
         counter++;
      }
      return -1;
   }


}