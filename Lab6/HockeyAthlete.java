public class HockeyAthlete extends Athlete{
    private int numOfPeriods;
    private int minutesPerPeriod;
    //constructor for the HockeyAthlete class
    public HockeyAthlete(String firstName, String lastName,String birthDate, String athleteID, String athleteTeam, String athleteType, int numOfPeriods, int minutesPerPeriod){
        super(firstName,lastName,birthDate,athleteID,athleteTeam, athleteType);
        this.numOfPeriods=numOfPeriods;
        this.minutesPerPeriod=minutesPerPeriod;
    }
    //gets the total time played for a Hockey Player
    @Override
    public int getTotalTimePlayed(){
        return numOfPeriods*minutesPerPeriod;
    }
    //getter methods
    public int getNumOfPeriods(){
        return numOfPeriods;
    }
    public int getMinutesPerPeriod(){
        return minutesPerPeriod;
    }
    //returns all of the info of a HockeyAthlete instance
    public String toString(){
        return super.toString()+"\nNumber of periods: "+numOfPeriods+"\nMinutes per period: "+minutesPerPeriod+"\nTotal time played: "+getTotalTimePlayed();
    }


}
