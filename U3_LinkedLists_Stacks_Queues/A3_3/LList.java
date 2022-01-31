/*A minimal Linked List implementation*/

public class LList{
   
   private LNode start;   //the first node in the Linked List
   
   public LList(){
      /*
      Constructor, initialize a new empty list
      */
      this.start = null;
   }
   
   public String toString(){
      /*
      Return a String representing the contents of this list
      */
      String s = "[";
      LNode probe = this.start;
      int i = 0;
      while(probe != null){
         if(i != 0){
            s += ", ";
         }
         s += probe.getData();
         probe = probe.getNext();
         i++;
      }
      return s + "]";
   }
   
   public void add(Object o){
      /*
      Add o to the end of the list
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
      */
      LNode next = this.start;
      for(int i = 0; i < index; i++){
         next = next.getNext();
      }
      return next.getData();
   }
   
   public Object remove(int index){
      /*
      Removes the data at index from the list and 
      returns what was there. Index must be in-bounds
      or it may trigger an error.
      */
      if(index == 0){
         Object o = this.start.getData();
         this.start = this.start.getNext();
         return o;
      }
      LNode next = this.start;
      LNode prev = null;
      for(int i = 0; i < index; i++){
         prev = next;
         next = next.getNext();
      }
      Object o = next.getData();
      prev.setNext(next.getNext());
      return o;
   }
   
   public void insert(Object o, int index){
      /*
      Adds new data into the list at the specified index.
      Does not destroy any existing data, but merely shifts
      it out of the way. Index should be in-bounds + 1 or an error
      may occur.
      */
      LNode newNode = new LNode(o);
      if(index == 0){
         if(this.start == null){
            this.start = newNode;
         }
         else{
            newNode.setNext(this.start);
            this.start = newNode;
         }
      }
      else{
         LNode next = this.start;
         LNode prev = null;
         for(int i = 0; i < index; i++){
            prev = next;
            next = next.getNext();
         }
         prev.setNext(newNode);
         newNode.setNext(next);
      }
   }
   
   public void set(Object o, int index){
      /*
      Replace the value at index with o. Must be an index
      within the current bounds of the list
      */
      if(index == 0){
         LNode newNode = new LNode(o);
         newNode.setNext(this.start.getNext());
         this.start = newNode;
      }
      else{
         LNode find = this.start;
         LNode prev = null;
         for(int i = 0; i < index; i++){
            prev = find;
            find = find.getNext();
         }
         LNode newNode = new LNode(o);
         newNode.setNext(find.getNext());
         prev.setNext(newNode);
      }
   }
   
   public void clear(){
      /*
      Empties the list of all items.
      */
      this.start = null;
   }
      
   
   public void swap(int index1, int index2){
      /*
      Swap the items at index1 and index2. Both indices
      must be in-bounds (otherwise may result in ERROR).
      Swaps by changing links, not by copying data between
      nodes.
      */
      if(index1 == index2){
         return; //do nothing
      }
      LNode pre1 = null;
      LNode swap1 = this.start;
      LNode pre2 = null;
      LNode swap2 = this.start;
      //get all nodes to point to the proper nodes
      for(int i = 0; i < index1 || i < index2; i++){
         if(i < index1){
            pre1 = swap1;
            swap1 = swap1.getNext();
         }
         if(i < index2){
            pre2 = swap2;
            swap2 = swap2.getNext();
         }
      }
      //special cases for 1st node
      if(index1 == 0){
         if(index2 > 1){
            LNode temp = swap2.getNext();
            this.start = swap2;
            swap2.setNext(swap1.getNext());
            swap1.setNext(temp);
            pre2.setNext(swap1);
         }
         else if(index2 == 1){
            LNode temp = swap2.getNext();
            swap2.setNext(swap1);
            swap1.setNext(temp);
            this.start = swap2;
         }
      }
      else if(index2 == 0){
         if(index1 > 1){
            LNode temp = swap1.getNext();
            this.start = swap1;
            swap1.setNext(swap2.getNext());
            swap2.setNext(temp);
            pre1.setNext(swap2);
         }
         else if(index1 == 1){
            LNode temp = swap1.getNext();
            swap1.setNext(swap2);
            swap2.setNext(temp);
            this.start = swap1;
         }
      }        
      //indices more than 1 apart
      else if(Math.abs(index1 - index2) > 1){
         LNode temp1 = swap1.getNext();
         LNode temp2 = swap2.getNext();
         swap1.setNext(temp2);
         swap2.setNext(temp1);
         pre1.setNext(swap2);
         pre2.setNext(swap1);
      }
      //indices 1 apart - first option
      else if(index2 == index1 + 1){
         LNode temp = swap2.getNext();
         swap1.setNext(temp);
         pre1.setNext(swap2);
         swap2.setNext(swap1);
      }
      //indices 1 apart - second option
      else if(index1 == index2 + 1){
         LNode temp = swap1.getNext();
         swap2.setNext(temp);
         pre2.setNext(swap1);
         swap1.setNext(swap2);
      }
               
   }
   
   public int size(){
      /*
      Return the number of items in the list,
      a.k.a. the size of the list.
      */
      int count = 0;
      LNode probe = this.start;
      while(probe != null){
         count++;
         probe = probe.getNext();
      }
      return count;
   }
   
   public boolean contains(Object o){
      /*
      Check if this list contains o. Compares
      by value, not by memory location, i.e. uses
      .equals(), not == .
      */
      LNode probe = this.start;
      while(probe != null){
         if(probe.getData().equals(o)){
            return true;
         }
         else{
            probe = probe.getNext();
         }
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
      */
      LNode probe = this.start;
      int i = 0;
      while(probe != null){
         if(probe.getData().equals(o)){
            return i;
         }
         else{
            i++;
            probe = probe.getNext();
         }
      }
      return -1;
   }  
}