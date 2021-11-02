public class Pet{
   String name;
   int age;
   
   public Pet(String name, int age){
      /*Constructor, initialize a new Pet*/
      this.name = name;
      this.age = age;
   }
   
   public String getName(){
      /*Return this Pet's name*/
      return this.name;
   }
   
   public String talk(){
      /*What sound does the Pet make?*/
      return "Pet Sounds";
   }
   
   public void birthday(){
      /*Celebrate the Pet's birthday*/
      this.age++;
   }
}