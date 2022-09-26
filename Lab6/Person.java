public class Person {
    private String firstName;
    private String lastName;
    private String birthdate;
    //constructor for Person class
    public Person(String firstName, String lastName, String birthdate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
    }
    public Person(){

    }
    //getter methods
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getBirthdate(){
        return birthdate;
    }
}
