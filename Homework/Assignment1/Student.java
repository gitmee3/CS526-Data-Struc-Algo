

public class Student {
  private String id;
  private String name;
  private double gpa;
  
  public Student() { }
  
  public Student(String i, String n, double a) {  
    id = i;
    name = n;
    gpa = a;
  }

  public String getID() { return id;}               
  public String getName() { return name; }          
  public double getGPA() { return gpa; }               
  public void setID(String ID) { this.id = ID; }
  public void setName(String name) { this.name = name; }
  public void setGPA(double gpa) { this.gpa = gpa; }
  
  public boolean equals(Object other) {            
    if (!(other instanceof Student)) return false;  
    Student s = (Student) other;                    
    return id.equals(s.id);                         
  }
  
  public String toString() {                        
    return "Name: " + name + "\n" + "Student ID: " + id + "\n" + "GPA: " + gpa + "\n";
  }
}
