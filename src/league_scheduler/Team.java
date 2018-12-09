package league_scheduler;

public class Team {
    public String teamName;
    public int gamesAssigned = 0;
    public Team[] matchedAgainst = new Team[20];
    
    public Team(String givenName) {
        teamName = givenName;
    }
    
    public boolean checkForTeam(Team teamToCompare) {
        boolean contains = false;
        
        for (int i = 0; i < matchedAgainst.length; i++) {
            if (matchedAgainst[i] == teamToCompare) {
                contains = true;
            }
        }
        return contains;
    }
    
    public int checkUsedSlots() {
        int slotCount = 0;
        
        for (int i = 0; i < matchedAgainst.length; i++) {
            if (matchedAgainst[i] != null) {
                slotCount++;
            }
        }
        return slotCount;
    }
    
   @Override
   public String toString() {
    return teamName;
   }
}
