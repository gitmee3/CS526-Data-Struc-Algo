
class Car {
 
   private String VIN;
   private String make;
   
   private static int numberOfCars = 0;
   
   public Car ( ) {numberOfCars++; } 
   public Car (String VIN, String make) {
	   this.VIN = VIN;
	   this.make = make;
	   numberOfCars++;
   }
   
   public String getVIN() { return VIN; }
   public String getMake() { return make; }          
   public static int getNumberOfCars() { return numberOfCars; }
   
   public void setVIN (String VIN){
	   this.VIN = VIN;
   }
   public void setMake(String make) {        
	   this.make = make ; 
   }             
   
   public String toString() {
	   String c = "VIN = " + this.VIN +
	            "\nMake = " + this.make;
	   return c;
   }

 }
