public class Horse{
   private int age;
   private double weight;
   private Student rider;
   
   public Horse(int a, double w, Student r){
      this.age = a;
      this.weight = w;
      this.rider = r;
   }
   public void eat(){
      this.weight += 5;
   }
   public void birthday(){
      this.weight += 10;
      this.age++;
   }
   public void changeRider(Student student){
      this.rider = student;
   }
}