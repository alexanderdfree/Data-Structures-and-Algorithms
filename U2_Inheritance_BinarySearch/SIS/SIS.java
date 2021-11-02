/*
A class representing a student database
*/

import java.util.ArrayList;

public class SIS{
   private String schoolName;
   private ArrayList students;
   
   public SIS(String schoolName){
      this.schoolName = schoolName;
      this.students = new ArrayList();
   }
   
   public void addStudent(Student s){
      /*Adds s to the students list*/
      this.students.add(s);
   }
   public String toString(){
      /*Return a String representation of this SIS
      Ex.
      sys.toString()
      Thacher School
      -------------------
      McCraw, Kuma (CdeP 2022) [1]
      Cheng, Natalie (CdeP 2022) [2]
      Huber, Grace (CdeP 2021) [3]*/
      String str = this.schoolName;
      str += "\n -------- \n";
      for (int i = 0; i < students.size(); i++){
         str += students.get(i).toString() + "\n";
      }
      return str;
      
   
   }
   public void removeStudent(int id){
      /*Remove a student from the SIS based on their student ID
      number (not the same as numerical index)*/
      for (int i = 0; i < students.size(); i++){
         if (((Student)this.students.get(i)).getID() == id){
            this.students.remove(i);
         }
      }
   }
   public static void main(String[] args){
      SIS admin = new SIS("The Thacher School");
      while(StdIn.isEmpty() == false){
         String line = StdIn.readLine();
         String[] tokens = line.split(",");
         String last = tokens[0];
         String first = tokens[1];
         int year = Integer.parseInt(tokens[2]);
         Student s = new Student(last, first, year);
         admin.addStudent(s);
      }
      //admin.removeStudent(49);
      admin.order();
      StdOut.print(admin);
   }
   public void order(){
      /*Order the students in SIS by class and then alphabetical
      */
      for(int i = 1; i < this.students.size(); i++){
         for (int x = i; x > 0; x--){
            if (((Student)this.students.get(x)).compareTo((Student)this.students.get(x-1)) < 0){
               //swap them
               Student s = (Student)this.students.get(x);
               this.students.set(x, this.students.get(x-1));
               this.students.set(x-1, s);
            }
         }
      }
   }

}
   
   