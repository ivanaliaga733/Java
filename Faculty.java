
package assignment7;

public class Faculty extends Person {
    //Variables 
    private String professorType;
    
    //Default Constructor
    Faculty()
    {
        super();
        this.professorType = professorType;
    }
    
    //Overloaded Constructor
    Faculty(String firstName, String lastName, int age, String gender, 
            String maritalStatus, String professorType)
    {
        super(firstName, lastName, age, maritalStatus, gender);
        setProfessorType(professorType);
    }
    
    //Set Method for Professor Type
    public void setProfessorType(String professorType)
    {
        if(professorType.equalsIgnoreCase("instructor"))
        {
            this.professorType = "Instructor";
        }
        else if(professorType.equalsIgnoreCase("assistant professor"))
        {
            this.professorType = "Assistant Professor";
        }
        else if(professorType.equalsIgnoreCase("associate professor"))
        {
            this.professorType = "Associate Professor";
        }
        else if(professorType.equalsIgnoreCase("full professor"))
        {
            this.professorType = "Full Professor";
        }
        else
        {
            this.professorType = "Assistant Professor";
        }
    }
    
    //Get Method for Professor Type
    public String getProfessorType()
    {
        return this.professorType;
    }
    
    //Override - toString method that Ovversides the one of the Person class
    @Override
    public String toString()
    {
        return "Faculty";
    }
    
    //Static Method - return personInfo
    @Override
    public String personInfo(boolean fullData)
    {
        if(fullData)
        {
            return super.personInfo(true) + "\nProfessor type: " + getProfessorType();
        }
        else
        {
            return super.personInfo(false);
        }
    }
    
    //Static Method - add new faculty
    public static boolean addFaculty(String firstName, String lastName, int age, 
            String gender, String maritalStatus, String professorType)
    {
        if(totPeople == MAXPEOPLE)
        {
            return false;
        }
        else
        {
            people[totPeople] = new Faculty(firstName, lastName, age, gender, 
            maritalStatus, professorType);
            totPeople++;
            return true;
        }
    }
}
