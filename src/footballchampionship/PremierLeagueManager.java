
package footballchampionship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PremierLeagueManager implements LeagueManager {
    // Create empty list of clubs
    List<FootballClub> clubsList = new ArrayList<>();

    // Implementation of method required by interface
    public int getNoOfClubs() {
        return clubsList.size();
    }

    // Menu methods
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

    public void createClub() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Type name of the club: ");
        String name =  sc.nextLine();
        System.out.print("Type club's location: ");
        String location =  sc.nextLine();
        // Add new instance of a FootballClub to the clubs list
        clubsList.add(new FootballClub(name, location));
        // Confirm that added successfully
        System.out.println(name + " club has been added!");
        System.out.println("There are now " + getNoOfClubs() + " clubs in the league.");
    }
}
