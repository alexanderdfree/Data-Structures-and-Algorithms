import java.util.*;
public class IntList{
   //Instance Variables - every IntList has a copy of these
   private int[] array;   //where the items in the list are stored
   private int size;      //how many items are in the list

   //Static Variables - all IntLists share these
   static int defaultCapacity = 10; //default storage capacity
   public IntList(int capacity){
      /*Constructor. Initializes a new empty IntList object with 
      the given initial capacity.
      Inputs:
         int capacity: the initial capacity of this.array
      Output:
         this: a new empty IntList with the given capacity
      Ex.
      IntList l = new IntList(5);
      l is now an empty list with room for 5 initial values
      */
      this.size = 0;
      this.array = new int[capacity];
   }
   public IntList(){
      /*Default Constructor. Initializes a new empty IntList 
      object with the default initial capacity.
      Inputs: None
      Outputs:
         this: a new empty IntList with the default capacity
      Ex.
      IntList l = new IntList();
      l is now an empty list with room for the default number of
      initial values.
      */
      this.size = 0;
      this.array = new int[defaultCapacity];
      
   }
   public void add(int value){
      /*Add the value to the end of this list.
      Input:
         int value: the value to be added to this list
         this: the IntList we are adding the value to
      Output: none
      Side Effect: value is now the last item in the list
      Ex.
      IntList l = new IntList(5);
      l.array -> [0, 0, 0, 0, 0]
      l.size -> 0
      l.add(1);
      l.array -> [1, 0, 0, 0, 0]
      l.size  -> 1
      l.add(2);
      l.array -> [1, 2, 0, 0, 0]
      l.size  -> 2
      */
      /*int[] newArr = new int[this.array.length];
      for (int i = 0; i < this.array.length; i++){
         newArr[i] = this.array[i];
      }*/
      this.array[this.size] = value;
      this.size++;
      //this.array = newArr;
   }
   public String toString(){
      /*Return a String representation of this list.
      Input:
         this: an IntList object
      Output:
         return: a String representing this list
      Ex.
      IntList l = new IntList();
      l.toString() -> "[]"
      l.add(3);
      l.toString() -> "[3]"
      l.add(-14);
      l.toString() -> "[3, -14]"
      l.add(782);
      l.toString() -> "[3, -14, 782]"
      */
      String list = "[";
      for (int i = 0; i < this.size; i++){
         list += this.array[i];
         if (i < this.size - 1){
            list += ", ";
         }
         
      }
      return list + "]";
   }
   public int size(){
      /*Return the current size of this list,
      i.e. the number of items in the list.
      Input:
         this: an IntList object
      Output:
         return: the size of this IntList
      Ex.
      IntList l = new IntList();
      l.size() -> 0
      l.add(5);
      l.size() -> 1
      l.add(-100);
      l.size() -> 2
      */
      return this.size;
   }
   public int get(int index){
      /*Return the item at index
      Input:
         int index: the index of the item to get
         this: the IntList to get the item from
      Output:
         return: the item at index
      Ex.
      IntList l = new IntList();
      l.add(5);
      l.add(7);
      l.add(-1);
      l.toString() -> [5, 7, -1]
      l.get(0) -> 5
      l.get(1) -> 7
      l.get(2) -> -1
      l.toString() -> [5, 7, -1]
      */
      return this.array[index];
   }
   public int remove(int index){
      /*Remove the item at index.
      Input:
         int index: the index of the item in this list to remove
         this: the IntList from which to remove the item
      Output:
         return: the item that was at index
      Side Effects: the item at index has been removed
      Ex.
      IntList l = new IntList();
      l.add(4);
      l.add(8);
      l.add(2);
      l.toString() -> [4, 8, 2]
      l.remove(0) -> 4
      l.toString() -> [8, 2]
      */
      int old = this.array[index];
      
      // int[] newArr = new int[this.array.length];
      for (int i = this.size-1; i > index; i--){
         this.array[i-1] = this.array[i];
      }
      
      this.size--;
      //this.array = newArr;
      
      return old;
   }
   public String toStringDebug(){
      /*Return a String representing this list, including the
      entries in storage that are past the edge of the list. Use
      one ] to show the end of the list, and the other ] to show
      the end of storage.
      Input:
         this: an IntList object
      Output:
         return: a String representing this list, more useful 
         for debugging
      Ex.
      IntList l = new IntList(5);
      l.add(7);
      l.add(-1);
      l.add(2);
      l.toString() -> [7, -1, 2]
      l.toString() -> [7, -1, 2], 0, 0]
      */
      /*String str = "[";
      for (int i = 0; i < this.array.length; i++){
         if (this.array[i] == null){
            
         }
      }*/
      String str = this.toString();
      for (int i = this.size; i < this.array.length; i++){
         str += ", 0";
      }
      return str + "]";
      
   }
   public void add(int index, int value){
      /*Add the given value to this list at index. Index must be 
      a valid index in the list, or the next index after the 
      last item in the list (you can't make a hole by adding far 
      past the last item)
      Input:
         int index: where to add the value to the list
         int value: the value to add to the list
         this: the IntList to add this value to
      Output: None
      Ex.
      IntList l = new IntList();
      l.add(10);
      l.add(5);
      l.add(8);
      l.toString() -> [10, 5, 8]
      l.add(0, -1);
      l.toString() -> [-1, 10, 5, 8]
      l.add(1, 6);
      l.toString() -> [-1, 6, 10, 5, 8]
      l.add(3, -13);
      l.toString() -> [-1 ,6, 10, -13, 5, 8]
      */
      if (index > this.size || index < 0){
      
      }
      else if(index == this.size){
         this.add(value);
      }
      else{
         for (int i = this.size; i >= index; i--){
            if (i < this.array.length-1){
               this.array[i+1] = this.array[i];
            }
         }
         this.array[index] = value;
         this.size++;
      }
   }
}