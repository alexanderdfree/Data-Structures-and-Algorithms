public class Student{
   //instance variables, every Student has these
   private String lastName;
   private String firstName;
   private int id;
   private int gradYear;
   
   //static variables, only one shared by all members of the class
   private static int nextId = 1;
  
   public Student(String last, String first, int grad){
      //Constructor
      this.lastName = last;
      this.firstName = first;
      this.gradYear = grad;
      this.id = nextId;
      nextId++;
   }
   
   public int getID(){
      //Accessor. Get the Student's ID
      return this.id;
   }
   public String toString(){
      return this.lastName + ", " + this.firstName + " (CdeP " + this.gradYear + ") [" + this.id + "]";
   }
   public int compareTo(Student that){
      /*Compare this Student to that Student. Return
      a negative number is this Student should be earlier
      in a sorted list than that Student. Otherwise return a 
      positive number. Class year gets priority, then last name.
      Input:
         this: a Student object
         that: a Student object
      Output:
         return: a negative number if this comes before that
      Ex.
      Student s1 = new Student("Zhang", "Ethan, 2022);
      Student s2 = new Student("DiLullo", "Nico", 2023);
      Student s3 = new Student("Harris", "Pippa", 2023);
      s1.compareTo(s2) -> # < 0
      s2.compareTo(s1) -> # > 0
      s1.compareTo(s3) -> # < 0
      s3.compareTo(s1) -> # > 0
      s2.compareTo(s3) -> # < 0
      s3.compareTo(s2) -> # < 0
      */
      if (this.gradYear > that.gradYear){
         return 1;
      }
      else if(this.gradYear < that.gradYear){
         return -1;
      }
      else{
         if (this.lastName.compareTo(that.lastName) < 0) {
            return -1;
         }
         return 1;
      }
   }
   
}