
package assignment7;

public class Student extends Person {
    //Private member variables
    private String major;
    private String classStanding;
    private double GPA;
    private Faculty advisor;
    
    //Default Constructor - invokes the superclass default constructor
    Student(){
        super();
        major = "undeclared";
        classStanding = "Freshman";
        GPA = 0.0;                
    }
    
    //Overloading Constructor - takes in all Person attributes as parameters
    Student(String firstName, String lastName, int age, String gender, 
            String maritalStatus, String major, String classStanding, double GPA)
    {
        super(firstName, lastName, age, gender, maritalStatus);
        setMajor(major);
        setClassStanding(classStanding);
        setGPA(GPA);
    }
    
    //Set Method for Major 
    public void setMajor(String major){
        if(major.equalsIgnoreCase("CIS")||major.equalsIgnoreCase("Marketing")
            ||major.equalsIgnoreCase("Management")||major.equalsIgnoreCase("Finance")
            ||major.equalsIgnoreCase("Accounting"))
        {
            this.major=major.substring(0,1).toUpperCase() 
                +major.substring(1);
        }
        else
        {
            this.major="Undeclared";
        }
    }
    
    //Set Method for Class Standing
    public void setClassStanding(String classStanding){
        if(classStanding.equalsIgnoreCase("Freshman")||classStanding.equalsIgnoreCase("Sophomore")
            ||classStanding.equalsIgnoreCase("Junior")||classStanding.equalsIgnoreCase("Senior"))
        {
            this.classStanding=classStanding.substring(0,1).toUpperCase() 
                +classStanding.substring(1);
        }
        else
        {
            this.classStanding="Freshman";
        }
    }
    
    //Set Method for GPA
    public void setGPA(double GPA){
        if(GPA > 0.0 && GPA <= 4.0)
        {
            this.GPA = GPA;
        }
        else
        {
            this.GPA = 0.0;
        }
    }
    
    //Get Method for Major
    public String getMajor()
    {
        return this.major;
    }
    
    //Get Method for Class Standing
    public String getClassStanding()
    {
        return this.classStanding;
    }
    
    //Get Method for GPA
    public double getGPA()
    {
        return this.GPA;
    }
    
    //Overriden personInfo - method will invoke the Person Class's personInfo
    @Override
    public String personInfo(boolean fullData)
    {
        if(fullData)
        {
            return super.personInfo(true) + "\nMajor: " + getMajor()
                + "\nClass Standing: " + getClassStanding() + "\nGPA: " + getGPA();
        }
        else
        {
            return super.personInfo(false);
        }
    }
        
    //Static Method - Calculates the avg of all GPAs of the entire student population
    public static String showOverallGPA()
    {
        double num = 0.0;
        int count = 0;
        
        for(int i=0; i<totPeople; i++)
        {
            if(people[i] instanceof Student)
            {
                num += ((Student)people[i]).getGPA();
                count++;
            }
        }
        return "Average gpa of students is: " + num / count;
    }
    
    //Static Method - Creates Student instance 
    public static boolean addStudent(String firstName, String lastName, int age, 
            String gender, String maritalStatus, String major, String classStanding,
            double GPA)
    {
        if(totPeople == MAXPEOPLE)
        {
            return false;
        }
        else
        {
            people[totPeople] = new Student(firstName, lastName, age, 
                gender, maritalStatus, major, classStanding, GPA);
            totPeople++;
            return true;
        }
    }
    
    public void setAdvisor(Faculty advisor)
    {
        this.advisor = new Faculty(advisor.getFirstName(),advisor.getLastName(),
        advisor.getAge(),advisor.getMaritalStatus(),advisor.getGender(),advisor.getProfessorType());
    }
    
    public Person getAdvisor()
    {
        return advisor;
    }
    
    //toString method that Ovversides the one of the Person class
    @Override
    public String toString()
    {
        return "Student";
    }
}
