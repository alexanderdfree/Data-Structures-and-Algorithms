public class Efficiency{
   public static void main(String[] args){
      //read in all the integers, and put them in a list
      IntList list = new IntList();
      while(!(StdIn.isEmpty())){
         list.add(StdIn.readInt());
      }
      
      //once you have a list of ints, time how long it takes to sort
      Stopwatch timer = new Stopwatch();
      
      //comment out one of the lines below to select which algorithm you are testing
      
      //list.selectionSort();
      //list.insertionSort();
      MergeSort.sort(list);
      
      
      StdOut.println("that took "+timer.elapsedTime()+" seconds");
   }
}