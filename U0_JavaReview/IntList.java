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
      int[] newArr = new int[this.array.length * 2];
      if (this.size >= this.array.length){
         for(int i = 0; i < this.array.length; i++){
            newArr[i] = this.array[i];
         }
         this.array = newArr;
      }
      
      
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
      int[] oldArr = this.toArray();
      // int[] newArr = new int[this.array.length];
      for (int i = this.size-1; i > index; i--){
         //final int x = this.array[i];
         this.array[i-1] = oldArr[i];
      }
      
      this.size--;
      //this.array = newArr;
      
      return oldArr[index];
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
      int[] newArr = new int[this.array.length * 2];
      if (this.size >= this.array.length){
         for(int i = 0; i < this.array.length; i++){
            newArr[i] = this.array[i];
         }
         this.array = newArr;
      }
      
      
   }
    public void set(int index, int value){
      /*Set the value at index. Overwrite the previous value.
      Index must be within the list
      Input:
         int index: the index whose value we want to set
         int value: the new value to put at index
         this: an IntList object
      Output: None
      Side Effects: the value at index is now the given value
      Ex.
      IntList l = new IntList();
      l.add(5);
      l.add(-3);
      l.add(2);
      l.toString() -> [5, -3, 2]
      l.set(1, 8);
      l.toString() -> [5, 8, 2]
      l.set(2, -1);
      l.toString() -> [5, 8, -1]
      */
      this.array[index] = value;
   }
   public void swap(int index1, int index2){
      /*Swap the values at index1 and index2.
      Both indices must be in the list.
      Input:
         int index1: the index of the first value
         int index2: the index of the second value
         this: an IntList object
      Output: None
      Side Effects: the values at index1 and index2
      have swapped positions
      Ex.
      IntList l = new IntList()
      l.add(7);
      l.add(3);
      l.add(5);
      l.toString() -> [7, 3, 5]
      l.swap(0, 2);
      l.toString() -> [5, 3, 7]
      */
      int i = this.array[index1];
      this.array[index1] = this.array[index2];
      this.array[index2] = i;
   }
   public boolean contains(int value){
      /*Checks if this list contains value
      Input:
         int value: the value to check for
         this: an IntList object
      Output:
         return: whether the value is in the list
      Ex.
      IntList l = new IntList();
      l.add(4);
      l.add(2);
      l.add(-1);
      l.toString() -> [4, 2, -1]
      l.contains(2) -> true
      l.contains(-1) -> true
      l.contains(0) -> false
      */
      for (int i = 0; i < this.array.length; i++){
         if (this.array[i] == value){
            return true;
         }
      }
      return false;
   }
   public int indexOf(int value){
      /*Return the index of the first occurence of value
      in this list, or -1 if the value is not in the list
      Input:
         int value: the value to search for
         this: an IntList object
      Output:
         return: the index of the first occurence of value
         or -1 if the value is not in this list
      Ex.
      IntList l = new IntList();
      l.add(4);
      l.add(-7);
      l.add(8);
      l.add(4);
      l.toString() -> [4, -7, 8, 4]
      l.indexOf(4) -> 0
      l.indexOf(8) -> 2
      l.indexOf(5) -> -1
      */
      for (int i = 0; i < this.array.length; i++){
         if (this.array[i] == value){
            return i;
         }
      }
      return -1;
   }
   public int[] toArray(){
      /*Copy the contents of this list to an array
      Input:
         this: an IntList object
      Output:
         return: a new int[] containing this list's contents
      Ex.
      IntList l = new IntList();
      l.add(5);
      l.add(-1);
      l.add(9);
      l.toString() -> [5, -1, 9]
      int[] a = l.toArray()
      a[0] -> 5
      a[1] -> -1
      a[2] -> 9
      */
      int[] newArr = new int[this.size];
      for (int i = 0; i < this.size; i++){
         newArr[i] = this.array[i];
      }
      return newArr;
   }
   public void selectionSort(){
      /*Sort the contents of this list in ascending order
      Input:
         this: an IntList object
      Output: none
      Side Effects: the contents of this list are now sorted in 
                    ascending order
      Ex.
      IntList l = new IntList();
      l.add(4);
      l.add(-1);
      l.add(5);
      l.add(2);
      l.toString() -> [4, -1, 5, 2]
      l.selectionSort();
      l.toString() -> [-1, 2, 4, 5]*/
      
      
      //IntList sorted = new IntList();
      /*int[] sorted = new int[this.array.length];
      //int[] unsorted = this.array.toArray();
      StdOut.println("current arr: " + Arrays.toString(this.array));
      for (int i = 0; i < this.size; i++){
         int[] smallArr = Arrays.copyOf(IntList.smallest(this.array, this.size), 2);
         StdOut.println("smallarr: " + Arrays.toString(smallArr));
         int xyz = smallArr[0];
         sorted[i] = xyz;
         
         //StdOut.println(this.toString());
         int staticindex = smallArr[1];
         StdOut.println("static index: " + staticindex);
         this.remove(staticindex); //error here, need to use proper index
         //int current = this.unsorted[i];
         //sorted.set(i, );
         StdOut.println("current arr: " + Arrays.toString(this.array));
         StdOut.println("sorted: " + Arrays.toString(sorted));
      }
      StdOut.println("sorted: " + Arrays.toString(sorted));
      this.array = sorted;
      StdOut.println("current arr: " + Arrays.toString(this.array));
      //this.sorted.add() = c
      /*for (int i = 0; i < this.size; i++){
         //int current = this.unsorted[i];
         //sorted.set(i, );
         //this
      }*/
      
      //int[] sorted = new int[this.array.length];
      for (int i = 0; i < this.size; i++){
         int[] currentSmall = Arrays.copyOf(IntList.smallest(this.toArray(), i), 2);
         //StdOut.println(currentSmall[0]);
         
         /*if (this.size-1 == i){
            if()
         }
         else{*/
         this.swap(i, currentSmall[1]);
         //}
         if (i == this.size-1){
            
         }
      }
      //StdOut.println("current arr: " + Arrays.toString(this.array));
      this.add(this.array[0]);
      //StdOut.println("current arr: " + Arrays.toString(this.array));
      this.remove(0);
      //StdOut.println("current arr: " + Arrays.toString(this.array));
      //this.array = sorted;
      
      
      
   }
   public static int[] smallest(int[] Oarr, int st){
      
      int[] arr = Arrays.copyOf(Oarr, Oarr.length);
      int currentSmall = arr[0];
      int index = 0;
      for(int i = st; i < arr.length; i++){
         if (arr[i] < currentSmall){
            currentSmall = arr[i];
            index = i;
         }
      }
      int[] x = {currentSmall, index};
      return x;
   }
      
   //}
   public void insertionSort(){
      /*Sort the contents of this list in ascending order
      Input:
         this: an IntList object
      Output: None
      Side Effects: this list is now sorted in ascending order
      Ex.
      IntList l = new IntList();
      l.add(4);
      l.add(-1);
      l.add(5);
      l.add(2);
      l.toString() -> [4, -1, 5, 2]
      l.insertionSort();
      l.toString() -> [-1, 2, 4, 5]
      */
      int[] sorted = new int[this.size];
      //int[] unsorted = this.array;
      for(int i = 0; i < this.size; i++){
         //StdOut.println(Arrays.toString(this.array));
         int current = this.array[i];
         int greaterThanCounter = 0;
         int equalsCounter = 0;
         for(int x = 0; x < this.size; x++){
            //StdOut.println("x: " + x);
            //StdOut.println("this array x: " + this.array[x]);
            if (current == this.array[x]){
               equalsCounter++;
            }
            else if (current > this.array[x]){
               greaterThanCounter++;
               //StdOut.println(current + " compared to " + this.array[x] + " - result is " + (current > this.array[x]));
            }
         }
         //StdOut.println("counter: " + greaterThanCounter);
         sorted[greaterThanCounter] = current;
         for (int z = 0; z < equalsCounter; z++){
            sorted[greaterThanCounter+z] = current;
         }
         
         //StdOut.println(Arrays.toString(sorted));
      }
      this.array = sorted;
      
   }
   public static void main(String[] args){
      IntList l = new IntList();
      l.add(4);
      l.add(-1);
      l.add(5);
      l.add(2);
      StdOut.println(l.toString());
      l.insertionSort();
      StdOut.println(l.toString());
   
   } 
}
