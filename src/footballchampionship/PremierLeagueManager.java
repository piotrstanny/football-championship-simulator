
package footballchampionship;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PremierLeagueManager implements LeagueManager {
    // Maximum number of clubs that can belong to English Premier League
    private final int LEAGUE_CAPACITY = 20;
    // Create empty list of clubs
    List<FootballClub> clubsList = new ArrayList<>(LEAGUE_CAPACITY);

    // Implementation of method required by interface
    public int getNoOfClubs() {
        return clubsList.size();
    }

    // Menu methods
    static String menuList() {
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

    void createClub() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Type name of the club: ");
        String name =  sc.nextLine();
        System.out.print("Type club's location: ");
        String location =  sc.nextLine();
        // Add new instance of a FootballClub to the clubs list
        clubsList.add(new FootballClub(name, location));
        // Confirm that added successfully
        System.out.println("...\n" + name + " club has been added!");
        displayClubsNoInfo();
    }

    void removeClub() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Name of the club to REMOVE: ");
        String name =  sc.nextLine();

        Iterator<FootballClub> itr = clubsList.iterator();
        while (itr.hasNext()) {
            FootballClub club = itr.next();
            if (club.getName().equals(name)) {
                itr.remove();
                System.out.println("...\n" + name + " removed!");
            }
        }
        displayClubsNoInfo();
    }

    void displayClubStats() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Name of the club: ");
        String name =  sc.nextLine();

        Iterator<FootballClub> itr = clubsList.iterator();
        while (itr.hasNext()) {
            FootballClub club = itr.next();
            if (club.getName().equals(name)) {
                System.out.println(
                        "...\n" + name + " Club from " + club.getLocation() + ":\n"
                        + "---------------------------\n"
                        + "Matches played:\t " + club.getMatchesPlayed() + "\n"
                        + "Wins:\t " + club.getWins() + "\n"
                        + "Draws:\t " + club.getDraws() + "\n"
                        + "Defeats:\t " + club.getDefeats() + "\n"
                        + "Goals scored:\t " + club.getGoalsScored() + "\n"
                        + "Goals received:\t " + club.getGoalsReceived() + "\n"
                        + "TOTAL POINTS:\t " + club.getPoints() + "\n"
                );
            }
        }
    }

    void displayTable() {
        System.out.format("                CLUB  |  MP   W   D   L  GS  GR  Pts\n");
        Iterator<FootballClub> itr = clubsList.iterator();
        while (itr.hasNext()) {
            FootballClub club = itr.next();
            System.out.format("%20s" + "%7d" + "%4d" + "%4d" + "%4d" + "%4d" + "%4d" + "%4d\n",
                    club.getName(),
                    club.getMatchesPlayed(),
                    club.getWins(),
                    club.getDraws(),
                    club.getDefeats(),
                    club.getGoalsScored(),
                    club.getGoalsReceived(),
                    club.getPoints()
                    );
        }
    }

    void saveToFile() throws Exception {
        try {
            File file = new File("." + File.separator + "clubs_list.txt");
            file.createNewFile();
            FileWriter writer = new FileWriter(file);

            Iterator<FootballClub> itr = clubsList.iterator();
            while (itr.hasNext()) {
                FootballClub club = itr.next();
                writer.write(
                        club.getName() + "\n"
                        + club.getLocation() + "\n"
                        + club.getMatchesPlayed() + "\n"
                        + club.getWins() + "\n"
                        + club.getDraws() + "\n"
                        + club.getDefeats() + "\n"
                        + club.getGoalsScored() + "\n"
                        + club.getGoalsReceived() + "\n"
                        + club.getPoints() + "\n"
                        );
            }
            writer.close();
            System.out.println("...\nData has been saved to the file!");
        }
        catch (Exception error) {
            System.out.println("Exception error:\n" + error);
        }
    }

    // Additional methods
    void displayClubsNoInfo() {
        System.out.println("There are now " + getNoOfClubs() + " clubs in the Premier League.");
    }
}
