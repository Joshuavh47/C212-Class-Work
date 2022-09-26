public abstract class Athlete extends Person {
    private String athleteID;
    private String athleteTeam;
    private String athleteType;
    //constructor for Athlete
    public Athlete(String firstName, String lastName, String birthDate, String athleteID, String athleteTeam, String athleteType){
        super(firstName, lastName,birthDate);
        this.athleteID = athleteID;
        this.athleteTeam=athleteTeam;
        this.athleteType=athleteType;
    }
    public Athlete(){

    }
    //displays info about the athlete
    public String toString(){
        return "First name: "+getFirstName()+"\nLast name: "+getLastName()+"\nBirthdate: "+getFirstName()+"\nAthlete ID: "+athleteID+"\nAthlete Team: "+athleteTeam+"\nAthlete type: "+athleteType;
    }
    //abstract method used to get the total time played in all of the child classes
    public abstract int getTotalTimePlayed();
}
