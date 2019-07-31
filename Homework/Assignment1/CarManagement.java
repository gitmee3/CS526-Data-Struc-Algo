// car management using ArrayList
// for student management in homework 1, you must use LinkedList 

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class CarManagement {

	public static void main(String[] args) {
		
		ArrayList<Car> cars = new ArrayList<Car>();
		boolean done = false;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to the Car management system");
		
		//loop continues until user chooses to exit 
		while ( !done ){
			System.out.println("Choose an option:"); 
			System.out.println("   1. Add a car");
			System.out.println("   2. Update car make");
			System.out.println("   3. Display car information");
			System.out.println("   4. Exit");
			
			int selection;
			
			// check integer is entered
			if(input.hasNextInt()){
				selection = input.nextInt();
			}else{
				System.out.println("Number not entered, try again.");
				input.next();//bad input must be discarded
				continue;
			}
			
			//check valid selection
			if( selection < 1 || selection > 4){
				System.out.println("Please select a number between 1 and 4, inclusive.");
				continue;
			}
			
			if ( selection == 1 ){ // add a car
				boolean exists = false;
				System.out.println("Enter VIN: ");
				String vin = input.next();
				Car c = null;
				
				for (int i=0; i<cars.size(); i++){
					c = cars.get(i);
					if (c.getVIN().equals(vin)){
						exists = true;
						break;
					}
				}
				
				if (! exists){
					System.out.println("Enter make: ");
					String make = input.next();
					c = new Car(vin, make);
					cars.add(c);
					System.out.println("A car has been added.");
				}
				else {
					System.out.println("A car with the VIN already exists.");
				}
			}
			else if( selection == 2 ){// update make
				boolean exists = false;
				System.out.println("Enter VIN:");
				String vin = input.next();
				Car c = null;

				for (int i=0; i<cars.size(); i++){
					c = cars.get(i);
					if (c.getVIN().equals(vin)){
						exists = true;
						break;
					}
				}
				
				if (exists){
					System.out.println("Enter make:");
					String make = input.next();
					c.setMake(make);
					exists = true;
					System.out.println("Make updated.");
				}
				else {
					System.out.println("No Car with the given VIN.");
				}
	
			}
			else if ( selection == 3 ){// display car information
					boolean exists = false;
					
					System.out.print("Enter VIN:");
					String vin = input.next();
							
					Iterator<Car> carIterator = cars.iterator();
					
					while( carIterator.hasNext() ){
						Car c = carIterator.next();
						if( c.getVIN().equals(vin)){	
								System.out.println(c);
								exists = true;
								break;
						}
					}
					if ( !exists ){
						System.out.println("No car with the given VIN.");
					}
				}

			else if ( selection == 4 ){ // exit
				System.out.println("Goodbye.");
				done = true;
			}
		}
		input.close();
	}

}
