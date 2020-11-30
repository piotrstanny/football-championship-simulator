
package footballchampionship;

import java.util.Scanner;

public class PremierLeagueManager implements LeagueManager {

    int noOfFootballClubs = 0;

    public static String menuList() {
        System.out.println(
                "\nTo continue, choose from the list of menu options:\n"
                        + "---------------------------\n"
                        + "Q:\t Quit program\n"
                        + "C:\t Create a new club and add to the league\n"
                        + "R:\t Remove club from Premier League\n"
                        + "S:\t Display statistics of a club\n"
                        + "T:\t Display Premier League Table\n"
                        + "A:\t Add a match score\n"
                        + "F:\t Save data in to file");
        Scanner sc = new Scanner(System.in);
        String menuChoice = sc.nextLine().toLowerCase();
        return menuChoice;
    }

    // Add implementation of methods required by interface
    public int displayNoOfClubs() {
        return noOfFootballClubs;
    }
}
