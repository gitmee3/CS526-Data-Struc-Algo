package HW1;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author SHAO
 */
public class StudentManagement {

    public static void main(String[] args) {

        //LinkedList used to store student information
        LinkedList<Student> info = new LinkedList<Student>();

        while (true) {
            System.out.println("\nChoose an option:\n\n"
                    + "1. Add a student\n"
                    + "2. Remove a student\n"
                    + "3. Update student GPA\n"
                    + "4. Display student information\n"
                    + "5. Display all students\n"
                    + "6. Exit\n");

            //Record user's input choice
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            //Used to record whether existing student ID that user enter
            boolean exist = false;

            //Switch block
            switch (choice) {
                //Add a new student function
                case 1:
                    System.out.print("Please enter the student ID: ");
                    Scanner input1 = new Scanner(System.in);
                    String id = input1.nextLine();

                    //Find whether student ID exist in all data
                    for (Student s : info) {
                        if (s.getID().equals(id)) {
                            System.out.println("\nThis student ID already exists.");
                            exist = true;//change exist mark to true
                            break;
                        }
                    }
                    //If not exist, show prompt message
                    if (!exist) {
                        System.out.print("Please enter a name: ");
                        String name = input1.nextLine();
                        System.out.print("Please enter a GPA: ");
                        String GPA = input1.nextLine();

                        //Create an student object
                        Student student = new Student(id, name, Double.parseDouble(GPA));

                        //Add student object into arraylist
                        info.add(student);
                        System.out.println("\nAdd a student successfully.");
                    }
                    break;
                //Remove a student function
                case 2:
                    System.out.print("Please enter the student ID: ");
                    Scanner input2 = new Scanner(System.in);
                    String id2 = input2.nextLine();

                    //Find whether student ID exist in all data
                    for (Student s : info) {
                        if (s.getID().equals(id2)) {
                            info.remove(s);//Remove this student info
                            System.out.println("\nRemove this student successfully.");
                            exist = true;//change exist mark to true
                            break;
                        }
                    }
                    //If not exist, show error message
                    if (!exist) {
                        System.out.println("\nThere is no student with the given ID.");
                    }
                    break;
                //Update student info function
                case 3:
                    System.out.print("Please enter the student ID: ");
                    Scanner input3 = new Scanner(System.in);
                    String id3 = input3.nextLine();

                    //Find whether student ID exist in all data
                    for (Student s : info) {
                        if (s.getID().equals(id3)) {
                            System.out.print("Please enter the new GPA: ");
                            String GPA = input3.nextLine();
                            s.setGPA(Double.parseDouble(GPA));//Update info
                            System.out.println("\nUpdate GPA successfully.");
                            exist = true;//change exist mark to true
                            break;
                        }
                    }
                    //If not exist, show error message
                    if (!exist) {
                        System.out.println("\nThere is no student with the given ID.");
                    }
                    break;
                //Display student info function
                case 4:
                    System.out.print("Please enter the student ID: ");
                    Scanner input4 = new Scanner(System.in);
                    String id4 = input4.nextLine();

                    //Find whether student ID exist in all data
                    for (Student s : info) {
                        if (s.getID().equals(id4)) {
                            System.out.println(s.toString());//Call toString() function
                            exist = true;//change exist mark to true
                            break;
                        }
                    }
                    //If not exist, show error message
                    if (!exist) {
                        System.out.println("\nThere is no student with the given ID.");
                    }
                    break;
                case 5:
                    //Print all students' detail information
                    for (Student s : info) {
                        System.out.println(s.toString());//Call toString() function
                    }
                    break;
                case 6:
                    //Exit the system
                    System.out.println("Bye");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nPlease enter a correct number in (1, 2, 3, 4, 5)");
                    break;
            }
        }
    }
}
