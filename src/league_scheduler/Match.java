package league_scheduler;
import java.util.Hashtable;
import java.util.Random;
import java.util.Arrays;

public class Match {
    private static Random rand = new Random();
    public String matchDate;
    public Team teamOne;
    public Team teamTwo;
    
    public Match(Team[] teamContainer, int matchNumber, Hashtable matchDates) {
        matchDate = matchDates.get(matchNumber).toString();
        teamOne = drawTeamOne(teamContainer);
        teamTwo = drawTeamTwo(teamContainer);
    }
    
    private Team drawTeamOne(Team[] teamContainer) {
        Team temp = teamContainer[generateRandom(0, 8)];
        temp.gamesAssigned += 1;
        return temp;
    }
    
    private Team drawTeamTwo(Team[] teamContainer) {
        Team temp = teamContainer[generateRandom(0, 8)];
        int counter = 99;
        
        while (temp == teamOne || temp.checkForTeam(teamOne) || temp.gamesAssigned >= 2) {
            temp = teamContainer[generateRandom(0, 8)];
            if (counter <= 0) {
                temp.matchedAgainst[temp.checkUsedSlots()] = teamOne;
                break;
            } else {
                counter--;
            }
        }
        temp.matchedAgainst[temp.checkUsedSlots()] = teamOne;
        
        return temp;
    }
    
    private static int generateRandom(int min, int max) {
        return rand.nextInt(max-min+1) + min;
    }
    
   @Override
   public String toString() {
    return (teamOne.toString() + " VS " + teamTwo.toString() + " on " + matchDate);
   }
}
