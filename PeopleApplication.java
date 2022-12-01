
package assignment7;

import java.io.*;
import java.util.*;

public class PeopleApplication {

    private static void menu()
    {
        System.out.println("Choices are:");
        System.out.println("\t(1) Read the people file");
        System.out.println("\t(2) List the people");
        System.out.println("\t(3) Display information about a person");
        System.out.println("\t(4) Display average age of people");
        System.out.println("\t(5) Display average gpa of students");
        System.out.println("\t(6) Assign an advisor to a student");
        System.out.println("\t(7) Quit");
    }
    
    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        boolean flag = false;
        do 
        {
            menu();
            System.out.println("What is your choice? ");
            String userChoice = in.nextLine();

            //switch statement to select menu option and display information
            switch (userChoice)
            {
                case "1":
                    try {
                        java.io.File txtFile = new File("people.txt");
                        Scanner file = new Scanner(txtFile);
                        
                        //loop - reads file 
                        while (file.hasNextLine()){
                            boolean add = false;
                            switch (file.next()){
                                case "FACULTY":
                                    add = Faculty.addFaculty(file.next(), file.next(), 
                                            file.nextInt(), file.next(), file.next(), file.next());
                                    file.nextLine();
                                    break;
                                    
                                case "STUDENT":
                                    add = Student.addStudent(file.next(), file.next(), 
                                            file.nextInt(), file.next(), file.next(), file.next(),
                                            file.next(), file.nextDouble());
                                    file.nextLine();
                                    break;
                                    
                                case "PERSON":
                                    add = Person.addPerson(file.next(), file.next(), 
                                            file.nextInt(), file.next(), file.next());
                                    file.nextLine();
                                    break;
                                    
                                default:
                                    file.nextLine();
                                    break;
                            }
                        }
                    System.out.println("File read successfully");
                    file.close();
                    }
                    catch (Exception e){
                        System.out.println("Error reading file: " + e.toString()); 
                    }
                    break;
                   
                case "2":
                    String fullList = Person.listPersons();
                    System.out.println("People List");
                    System.out.print(fullList);
                    break;
                    
                case "3":
                    System.out.println("Enter the first and last name of "
                            + "the person to search for");
                    String findName = in.nextLine();
                    int index = Person.findPerson(findName);
                    if(index == -1)
                    {
                        System.out.println("Person not found");
                    }
                    else
                    {
                        Person person = Person.getPerson(index);
                        System.out.println(person.personInfo(true));
                    }
                    break;
                    
                case "4":
                    System.out.println("Average age is: " + Person.averageAge());
                    break;
                    
                case "5":
                    System.out.println(Student.showOverallGPA());
                    break;
                
                case "6":
                    System.out.println("Enter the first and last name of the student to search for");                                     
                    System.out.println("Enter the first and last name of the student to search for");
                    System.out.println("Advisor Assigned");
                    break;
                    
                case "7":
                    flag = true;
                    System.out.println("goodbye");
                    break;
                default:
                    System.out.println("***Invalid choice, please try again");
                    break;
           }
        }
        while (!flag);
    }
    
}
