public class BasketballAthlete extends Athlete{
    private String arenaType;
    private int numOfQuarters;
    private int minutesPerQuarter;
    //constructor
    public BasketballAthlete(String firstName,String lastName, String birthDate, String athleteID, String athleteTeam, String athleteType, String arenaType, int numOfQuarters, int minutesPerQuarter){
        super(firstName,lastName,birthDate,athleteID,athleteTeam, athleteType);
        this.arenaType = arenaType;
        this.numOfQuarters = numOfQuarters;
        this.minutesPerQuarter = minutesPerQuarter;
    }
    //getter methods
    public String getArenaType(){
        return arenaType;
    }
    public int getNumOfQuarters(){
        return numOfQuarters;
    }
    public int getMinutesPerQuarter(){
        return minutesPerQuarter;
    }
    //returns all of the information about a basketball player instance
    public String toString(){
        return super.toString()+"\nArena type: "+arenaType+"\nNumber of quarters: "+numOfQuarters+"\nMinutes per quarter: "+minutesPerQuarter+"\nTotal time played: "+getTotalTimePlayed();
    }
    //gets the total time played for a basketball player
    @Override
    public int getTotalTimePlayed() {
        return numOfQuarters*minutesPerQuarter;
    }
}
