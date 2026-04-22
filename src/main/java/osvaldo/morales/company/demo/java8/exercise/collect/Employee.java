package osvaldo.morales.company.demo.java8.exercise.collect;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class Employee
{
   private String firstName;
   private String lastName;
   private double salary; 
   private String department;
   private  int age;

   private int id;
   
   // constructor 
   public Employee(String firstName, String lastName, 
      double salary, String department,int age,int id)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.salary = salary;
      this.department = department;
      this.age = age;
      this.id=id;
   } 

   // set firstName
   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   // get firstName
   public String getFirstName()
   {
      return firstName;
   }

   // set lastName
   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   // get lastName
   public String getLastName()
   {
      return lastName;
   }

   // set salary
   public void setSalary(double salary)
   {
      this.salary = salary;
   }

   // get salary
   public double getSalary()
   {
      return salary;
   }

   // set department
   public void setDepartment(String department)
   {
      this.department = department;
   }

   // get department
   public String getDepartment()
   {
      return department;
   }

   // return Employee's first and last name combined
   public String getName()
   {
      return String.format("%s %s", getFirstName(), getLastName());
   }
   
    public static List<Employee> empleados() {
	      // initialize array of Employees
	      Employee[] employees = {
	         new Employee("Jason", "Red", 5000, "IT",4,4),
	         new Employee("Ashley", "Green", 7600, "IT",33,31),
	         new Employee("Matthew", "Indigo", 3587.5, "Sales",12,11),
	         new Employee("James", "Indigo", 4700.77, "Marketing",12,13),
	         new Employee("Luke", "Indigo", 6200, "IT",34,5),
	         new Employee("Jason", "Blue", 3200, "Sales",2,33),
	         new Employee("Wendy", "Brown", 4236.4, "Marketing",33,2)};

	      // get List view of the Employees
	      List<Employee> list = Arrays.asList(employees);
	      
	      return list;

   }

   // return a String containing the Employee's information
   @Override
   public String toString() 
   {
      return String.format("%-8s %-8s %8.2f   %s", 
         getFirstName(), getLastName(), getSalary(), getDepartment());
   } // end method toString
} // end class Employee


