public class Student{
   private String first;
   private String last;
   private int gradYear;
   
   public Student(String f, String l, int gY){
      this.first = f;
      this.last = l;
      this.gradYear = gY;
   }
   public String toString(){
      return this.first + " " + this.last + " [" +this.gradYear + "]";
   }
   public int compareTo(Student other){
      /*Compares this Student to another Student alphabetically
      by last name.
      Inputs:
         this: a Student object
         other: another Student object
      Returns:
         -1 if this comes before other alphabetically
          0 if this is tied with other alphabetically
          1 if this comes after other alphabetically
      Ex.
      Student ana = new Student(Ana, Palacios, 2023)
      Student todd = new Student(Todd, Rosenbaum, 2023)
      Student grace = new Student(Grace, Yang, 2023)
      
      ana.compareTo(todd) -> -1
      todd.compareTo(ana) -> 1
      ana.compareTo(ana) -> 0
      grace.compareTo(ana) -> -1
      */
      
      //compare by last name
      //use the built-in compareTo() from String library
      int comp = this.last.compareTo(other.last);
      if(comp == 0){//if last names are tied, compare first
         comp = this.first.compareTo(other.first);
      }
      if(comp > 0){
         comp = 1;
      }
      else if(comp < 0){
         comp = -1;
      }
      return comp;
   }
   public void repeatYear(){
      this.gradYear++;
   }
   public int getGradYear(){
      return this.gradYear;
   }

}