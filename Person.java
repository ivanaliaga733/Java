
package assignment7;

public class Person {
    protected static int MAXPEOPLE = 100;
    protected static int totPeople = 0;
    
    protected static Person[] people = new Person[MAXPEOPLE];
    
    
    private String firstName;
    private String lastName;
    private int age;
    private String maritalStatus;
    private String gender;
    
    //default constructor
    public Person()
    {
        this.firstName = "First";
        this.lastName = "Last";
        this.age = 0;
        this.gender = "Unknown";
        this.maritalStatus = "Unknown";
    }
    
    //overloading constructor
    public Person(String firstName, String lastName, int age, String gender, String maritalStatus)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setGender(gender);
        setMaritalStatus(maritalStatus);
    }
    
    //boolean indicates whether full data of the person will be included or not
    public String personInfo(boolean fullData)
    {
        //if parameter is true, method should concatenate full data
        if(fullData){
            return "Person Information\n" + "Person Name: " + firstName + " " + lastName 
                    + "\nAge: " + age + "\nGender: " + gender 
                    + "\nMarital Status: " + maritalStatus;
        }
        //else return only first and last name
        return "First Name: " + firstName + " Last Name: " + lastName;
    }
    
    //method - tests to see if that value is equal to the person's name
    public boolean equals(String name)
    {
        if(name.equalsIgnoreCase(firstName + " " + lastName))
        {
            return true;
        }
        else{
            return false;
        }
    }
    
    public void setFirstName(String firstName)
    {
       this.firstName=firstName.substring(0,1).toUpperCase()+firstName.substring(1).toLowerCase();
        
    }
    
    public String getFirstName()
    {
        return this.firstName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName.substring(0,1).toUpperCase()+lastName.substring(1).toLowerCase();
    }
    
    public String getLastName()
    {
        return this.lastName;
    }
    
    public void setAge(int age)
    {
        if(age<0)
        {
            this.age = 0;
        }
        else
        {
            this.age = age;
        }
    }
    
    public int getAge()
    {
        return this.age;
    }
    
    public String getMaritalStatus()
    {
        return this.maritalStatus;
    }
    public void setMaritalStatus(String maritalStatus)
    {
        if(maritalStatus.equalsIgnoreCase("married"))
        {
            this.maritalStatus = "Married";
        }
        else if(maritalStatus.equalsIgnoreCase("single"))
        {
            this.maritalStatus = "Single";
        }
        else if(maritalStatus.equalsIgnoreCase("divorced"))
        {
            this.maritalStatus = "Divorced";
        }
        else if(maritalStatus.equalsIgnoreCase("widowed"))
        {
            this.maritalStatus = "Widowed";
        }
        else
        {
            this.maritalStatus = "Unknown";
        }
    }
    
//    public String getMaritalStatus()
//    {
//        return this.maritalStatus;
//    }
    public String getGender()
    {
        return this.gender;
    }
    public void setGender(String gender)
    {
        if(gender.equalsIgnoreCase("male"))
        {
            this.gender = "Male";
        }
        else if(gender.equalsIgnoreCase("female"))
        {
            this.gender = "Female";
        }
        else
        {
            this.gender = "Unknown";
        }
    }
    
//    public String getGender()
//    {
//        return this.gender;
//    }
    
    
    //From assignement 6
    
    public static String listPersons()
    {
        StringBuilder nameList = new StringBuilder();
        for (int i = 0; i <totPeople; i++){
            nameList.append(people[i].getFirstName()).append(" ").append(people[i].getLastName()).append("\n");
        }
        return nameList.toString();
    }
        
    public static int findPerson(String name) 
    {
        name = name.toLowerCase();
        for (int i=0;i<totPeople;i++)
        {
            if(people[i].equals(name))
            {
                return i;
            }
        }
        return -1;
    }
        
    public static boolean addPerson(String firstName, String lastName, int age, 
            String gender, String maritalStatus)
    {
        if(totPeople < MAXPEOPLE)
        {
            Person person = new Person(firstName, lastName, age, gender, maritalStatus);
            people[totPeople++] = person;
            return true;
        }
        return false; 
    }
    
    public static double averageAge()
    {
        int sum = 0; 
        for(int i=0;i<totPeople;i++)
        {
            sum += people[i].getAge();
        }
        if(totPeople == 0)
        {
            return 0;
        }
        return (double) sum / totPeople;
    }
    
    public static Person getPerson(int index)
    {
        return people[index];
    }
    
    public static boolean isEmpty()
    {
        if(totPeople == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    //Override toString Method
    @Override
    public String toString()
    {
        return "Person";
    }
}
