public class MergeSort{
   public static IntList merge(IntList sorted1, IntList sorted2){
      /*Merge two sorted lists into one new sorted list
      Input:
         IntList sorted1: an Intlist sorted in ascending order
         IntList sorted2: another sorted IntList
      Output:
         return: a new IntList containing all the entries in
                 sorted1 and sorted2, sorted in ascending order
      Side Effects: None, sorted1 and sorted2 are unchanged
      Ex.
      IntList list1 = new IntList();
      list1.add(1);
      list1.add(3);
      list1.add(5);
      IntList list2 = new IntList();
      list2.add(2);
      list2.add(4);
      list1.toString() -> [1, 3, 5]
      list2.toString() -> [2, 4]
      merge(list1, list2) -> [1, 2, 3, 4, 5]
      */
      int list1pos = 0;
      int list2pos = 0;
      int totalpos = 0;
      int totalSlots = sorted1.toArray().length + sorted2.toArray().length;
      int totalSize = sorted1.size()+sorted2.size();
      IntList sorted3 = new IntList(totalSlots);
      while (totalpos < totalSize){
         /*StdOut.println("sorted: " + sorted3.toString());
         StdOut.println("totalpos: " + totalpos);
         StdOut.println("1pos: " + list1pos);
         StdOut.println("2pos: " + list2pos);
         StdOut.println(sorted1.get(list1pos) + " is less than " + sorted2.get(list2pos) +  " " + (sorted1.get(list1pos) < sorted2.get(list2pos)));
         */
         
         if(list1pos >= sorted1.size()){
            sorted3.add(sorted2.get(list2pos));
            list2pos++;
         }
         else if(list2pos >= sorted2.size()){
            sorted3.add(sorted1.get(list1pos));
            list1pos++;
         }
         else{
            if (sorted1.get(list1pos) < sorted2.get(list2pos)){
               //sorted3.set(totalpos, sorted1.get(list1pos));
               sorted3.add(sorted1.get(list1pos));
               list1pos++;
            }
            else if(sorted1.get(list1pos) > sorted2.get(list2pos)){
               //sorted3.set(totalpos, sorted2.get(list2pos));
               sorted3.add(sorted2.get(list2pos));
               list2pos++;
            }
            else{
               //sorted3.set(totalpos, sorted1.get(list1pos));
               sorted3.add(sorted1.get(list1pos));
               list1pos++;
            }
         }
         totalpos++;
      }
      
      return sorted3;
   }
   public static IntList sort(IntList unsorted){
      /*Sort an unsorted list in ascending order
      Input:
         IntList unsorted: an unsorted IntList
      Output:
         return: a new IntList containing the same
                 values as unsorted, but sorted
      Side Effects: None, unsorted is unaffected
      Ex.
      IntList l = new IntList();
      l.add(5);
      l.add(1);
      l.add(4);
      l.add(2);
      l.add(3);
      l.toString() -> [5, 1, 4, 2, 3]
      sort(l) -> [1, 2, 3, 4, 5]
      */
      if (unsorted.size() < 2) return unsorted;
      
      //IntList sorted = new IntList(unsorted.size());
      
      int s = unsorted.size();
      /*if (s%2 == 0){
         IntList unsorted1 = new IntList(s/2);
         IntList unsorted2 = new IntList(s/2);
      }
      else{
         IntList unsorted1 = new IntList(s/2);
         IntList unsorted2 = new IntList(s/2+1);
      }*/
      IntList unsorted1 = new IntList();
      IntList unsorted2 = new IntList();
      
      for(int i = 0; i < s; i++){
         if (i < s/2){
            unsorted1.add(unsorted.get(i));
         }
         else{
            unsorted2.add(unsorted.get(i));
         }
         
         //unsorted.get(i);
      }
      
      unsorted1.insertionSort();
      unsorted2.insertionSort();
      return MergeSort.merge(unsorted1, unsorted2);
   }
   public static void main(String args[]){
      IntList list1 = new IntList();
      list1.add(1);
      list1.add(3);
      list1.add(5);
      IntList list2 = new IntList();
      list2.add(2);
      list2.add(4);
      //merge(list1, list2);
      StdOut.println(merge(list1, list2).toString());
   }
}