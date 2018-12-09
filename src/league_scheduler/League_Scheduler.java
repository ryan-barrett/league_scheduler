package league_scheduler;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Hashtable;

public class League_Scheduler {

    public static void main(String[] args) {
        Scanner mainScan = new Scanner(System.in);
        
        Team[] teamContainer = new Team[9];
        Match[] matchContainer = new Match[9];
        int numTeams = 9;
        int numMatches = 9;
        
        Hashtable matchDates = assignDates();
        
        for (int i = 0; i < numTeams; i++) {
            System.out.println("Enter name for team number " + (i+1));
            teamContainer[i] = (new Team(mainScan.nextLine()));
        }
        System.out.println("Current team list: " + Arrays.toString(teamContainer));
        
        System.out.println("Generating matches...");
        for (int i = 0; i < numMatches; i++) {
            matchContainer[i] = (new Match(teamContainer, i, matchDates));
        }
        System.out.println("Current match list: ");
        for (int i = 0; i < numMatches; i++) {
            System.out.println(matchContainer[i].toString());
        }
    }
    
    public static Hashtable assignDates() {
        Hashtable dateTable = new Hashtable();
        
        dateTable.put(0, "Saturday August 4");
        dateTable.put(1, "Sunday August 5");
        dateTable.put(2, "Saturday August 10");
        dateTable.put(3, "Sunday August 11");
        dateTable.put(4, "Saturday August 17");
        dateTable.put(5, "Sunday August 18");
        dateTable.put(6, "Saturday August 24");
        dateTable.put(7, "Sunday August 25");
        dateTable.put(8, "Saturday August 31");
        
        return dateTable;
    }
    
}
