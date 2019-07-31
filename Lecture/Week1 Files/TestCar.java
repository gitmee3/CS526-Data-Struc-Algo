

public class TestCar {

	public static void main(String[] args) {
		Car c1 = new Car("ABCD", "GM");
		Car c2 = new Car("WXYZ", "Ford");
		Car c3 = new Car();
		c3.setVIN("B123");
		c3.setMake("Honda");
		
		System.out.println("VIN of car c3 is: " + c3.getVIN());
		System.out.println("Make of car c3 is: " + c3.getMake());

		System.out.println("Number of cars, with static method, is: " + Car.getNumberOfCars());
		
		System.out.println("Car c1 is: \n" + c1);
		System.out.println("Car c2 is: \n" + c2);
	}
	

}
