public class SoccerAthlete extends Athlete{
    private String arenaType;
    private int numOfHalves;
    private int minutesPerHalf;
    //constructor for the SoccerAthlete class
    public SoccerAthlete(String firstName, String lastName,String birthDate, String athleteID, String athleteTeam, String athleteType,String arenaType, int numOfHalves, int minutesPerHalf){
        super(firstName,lastName,birthDate,athleteID,athleteTeam, athleteType);
        this.arenaType = arenaType;
        this.numOfHalves = numOfHalves;
        this.minutesPerHalf = minutesPerHalf;
    }
    //getter methods
    public String getArenaType(){
        return arenaType;
    }
    public int getNumOfHalves(){
        return numOfHalves;
    }
    public int minutesPerHalf(){
        return minutesPerHalf;
    }
    //gets the total time played for a soccer player
    @Override
    public int getTotalTimePlayed() {
        return numOfHalves*minutesPerHalf;
    }
    //returns all of the information about a soccer player instance
    public String toString(){
        return super.toString()+"\nArena type: "+arenaType+"\nNumber of halves: "+numOfHalves+"\nMinutes per half: "+minutesPerHalf+"\nTotal time played: "+getTotalTimePlayed();
    }
}
