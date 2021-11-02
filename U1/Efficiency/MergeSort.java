public class MergeSort{
   public static IntList merge(IntList sorted1, IntList sorted2){
      /*Merge two sorted lists into one new sorted list
      Input:
         IntList sorted1: an Intlist sorted in ascending order
         IntList sorted2: another IntList sorted in ascending order
      Output:
         return: a new IntList containing all the entries in sorted1
                 and sorted2, sorted in ascending order
      Side Effects: None, sorted1 and sorted2 are unchanged
      Ex.
      IntList l1 = new IntList();
      l1.add(1);
      l1.add(3);
      l1.add(5);
      IntList l2 = new IntList();
      l2.add(2);
      l2.add(4);
      l1.toString() -> [1, 3, 5]
      l2.toString() -> [2, 4]
      merge(l1, l2) -> [1, 2, 3, 4, 5]
      */
      IntList sorted3 = new IntList();
      int n = sorted1.size() + sorted2.size();
      int i = 0;
      int j = 0;
      while(sorted3.size() < n){
         if(i >= sorted1.size()){
            sorted3.add(sorted2.get(j));
            j++;
         }
         else if (j >= sorted2.size()){
            sorted3.add(sorted1.get(i));
            i++;
         }
         else{
            int next1 = sorted1.get(i);
            int next2 = sorted2.get(j);
            if(next1 < next2){
             sorted3.add(next1);
               i++;
            }
            else{
               sorted3.add(next2);
               j++;
            }
         }
      }
      return sorted3;
   }
   
   public static IntList sort(IntList unsorted){
      /*Sort unsorted in ascending order
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
      IntList sorted = new IntList();
      if(unsorted.size() == 0){
         return sorted;
      }
      else if(unsorted.size() == 1){
         sorted.add(unsorted.get(0));
         return sorted;
      }
      //split the list into left and right halves
      IntList left = new IntList();
      IntList right = new IntList();
      int mid = unsorted.size()/2;
      for(int i = 0; i < unsorted.size(); i++){
         if(i < mid){
            left.add(unsorted.get(i));
         }
         else{
            right.add(unsorted.get(i));
         }
      }
      //sort each half
      left = sort(left);
      right = sort(right);
      
      //re-merge the two sorted halves
      sorted = merge(left, right);
      return sorted;
   }
   
   public static void main(String[] args){
      IntList l = new IntList();
      l.add(5);
      l.add(1);
      l.add(4);
      l.add(3);
      l.add(2);
      IntList sorted = sort(l);
   }
      
         
}