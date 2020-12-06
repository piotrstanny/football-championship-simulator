
package footballchampionship;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class PremierLeagueManager implements LeagueManager {
    // Max number of clubs that can belong to English Premier League
    private final int LEAGUE_CAPACITY = 20;
    // Create empty list of clubs
    List<FootballClub> clubsList = new ArrayList<>(LEAGUE_CAPACITY);
    // Max number of matches that can be played in one season in English Premier League
    private final int MATCHES_CAPACITY = 38;
    // Create empty list of matches
    List<Match> matchesList = new ArrayList<>(MATCHES_CAPACITY);

    // Implementation of method required by League Manager interface
    public int getNoOfClubs() {
        return clubsList.size();
    }


    // Menu methods
    String menuList() {
        System.out.println(
                "\nTo continue, choose option from the menu:\n"
                        + "---------------------------------------\n"
                        + "Q:\t Quit program\n"
                        + "C:\t Create a new club and add to the league\n"
                        + "R:\t Remove club from Premier League\n"
                        + "D:\t Details & stats of a club\n"
                        + "T:\t Table of the Premier League\n"
                        + "M:\t Add a match score\n"
                        + "S:\t Save data in to file\n"
                        + "G:\t Launch Graphical User Interface\n");
        Scanner sc = new Scanner(System.in);
        String menuChoice = sc.nextLine().toLowerCase();
        return menuChoice;
    }

    void createClub() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Type name of the club: ");
        String name =  sc.nextLine();
        // Validate input
        while (nameValidationFailed(name)) {
            name = sc.nextLine();
        }
        System.out.print("Type club's location: ");
        String location =  sc.nextLine();
        // Validate second input
        while (nameValidationFailed(location)) {
            location = sc.nextLine();
        }
        // Add new instance of a FootballClub to the clubs list
        clubsList.add(new FootballClub(name, location));
        // Confirm that added successfully
        System.out.println("...\n" + name + " club has been added!");
        displayClubsNoInfo();
    }

    void removeClub() {
        Scanner sc = new Scanner(System.in);
        // Display current clubs
        displayClubsNames(clubsList);
        System.out.print("Which club to REMOVE: ");
        String name =  sc.nextLine();
        // Validate input
        while (clubNotInLeague(name)) {
            System.out.print("Wrong club name!\nTry again: ");
            name = sc.nextLine();
        }
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
                        + "Wins:\t\t\t " + club.getWins() + "\n"
                        + "Draws:\t\t\t " + club.getDraws() + "\n"
                        + "Defeats:\t\t " + club.getDefeats() + "\n"
                        + "Goals scored:\t " + club.getGoalsScored() + "\n"
                        + "Goals received:\t " + club.getGoalsReceived() + "\n"
                        + "TOTAL POINTS:\t " + club.getPoints() + "\n"
                );
            }
        }
    }

    void displayTable() {
        System.out.format("                CLUB  |  MP   W   D   L  GS  GR  Pts\n");
        // Selection Sort to display clubs row in the right order
        for (int i = 0; i < clubsList.size() - 1; i++) {
            FootballClub firstUnsorted = clubsList.get(i);
            FootballClub bestClub = firstUnsorted;
            int index = i;

            for (int j = i+1; j < clubsList.size(); j++) {
                FootballClub next = clubsList.get(j);

                if (bestClub.getPoints() == next.getPoints()) {
                    // Resolve same points with goal difference
                    if (bestClub.getGoalsScored() - bestClub.getGoalsReceived() < next.getGoalsScored() - next.getGoalsReceived()) {
                        bestClub = next;
                        index = j;
                    }
                }
                if (bestClub.getPoints() < next.getPoints()) {
                    bestClub = next;
                    index = j;
                }
            }
            FootballClub sorted = bestClub;
            clubsList.set(index, firstUnsorted);
            clubsList.set(i,sorted);
            // Print out club with highest points directly
            displayRow(sorted);
            // After the last iteration, display the last element
            if (i == clubsList.size() - 2) {
                displayRow(clubsList.get(i + 1));
            }
        }

    }

    void addMatch() {
        // Collect data from the user
        Scanner sc = new Scanner(System.in);
        System.out.print("Type date of the match (dd-mm): ");
        String date = sc.nextLine();
        System.out.print("Type name of the club: ");
        String club1Name = sc.nextLine();
        System.out.print("Who they played against?: ");
        String club2Name = sc.nextLine();
        System.out.print("How many goals scored " + club1Name + "?: ");
        int club1Score = Integer.parseInt(sc.nextLine());
        System.out.print("How many goals scored " + club2Name + "?: ");
        int club2Score = Integer.parseInt(sc.nextLine());

        // Process input to update clubs statistics
        if (club1Score == club2Score) {
            updateClubsDraw(club1Name, club2Name, club1Score);
        } else if (club1Score > club2Score) {
            updateClubsWinLose(club1Name, club2Name, club1Score, club2Score);
        } else {
            updateClubsWinLose(club2Name, club1Name, club2Score, club1Score);
        }

        // Add match to the matches list
        matchesList.add(new Match(date, club1Name, club2Name, club1Score, club2Score));
    }

    void saveToFile() throws Exception {
        // Saving list of clubs
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
            System.out.println("...\nClubs list has been saved!");
        }
        catch (Exception error) {
            System.out.println("Exception error:\n" + error);
        }
        // Saving list of played matches
        try {
            File file = new File("." + File.separator + "played_matches.txt");
            file.createNewFile();
            FileWriter writer = new FileWriter(file);

            Iterator<Match> itr = matchesList.iterator();
            while (itr.hasNext()) {
                Match match = itr.next();
                writer.write(
                        match.getDate() + "\n"
                            + match.getClub1Name() + "\n"
                            + match.getClub2Name() + "\n"
                            + match.getClub1Score() + "\n"
                            + match.getClub2Score() + "\n"
                );
            }
            writer.close();
            System.out.println("...\nMatches data has been saved!");
        }
        catch (Exception error) {
            System.out.println("Exception error:\n" + error);
        }
    }

    void startGui() {
        System.out.println("...\nProgram starting in a new window...");
        EventQueue.invokeLater(new Runnable() {
            public void run() {
//                try {
//                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
//                    ex.printStackTrace();
//                }
                JFrame gui = new GUI(clubsList, matchesList, "Football Championship Simulator");
                gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gui.setSize(900,500);
                gui.setVisible(true);
            }
        });
    }


    // Additional methods
    void loadDataFromFile() throws Exception {
        try {
            // Load clubs list
            String path = System.getProperty("user.dir");
            Scanner readFile = new Scanner(new BufferedReader(new FileReader(path + File.separator + "clubs_list.txt")));
            while (readFile.hasNext()) {
                String name = readFile.nextLine();
                String location = readFile.nextLine();
                FootballClub club = new FootballClub(name, location);
                club.setMatchesPlayed(Integer.parseInt(readFile.nextLine()));
                club.setWins(Integer.parseInt(readFile.nextLine()));
                club.setDraws(Integer.parseInt(readFile.nextLine()));
                club.setDefeats(Integer.parseInt(readFile.nextLine()));
                club.setGoalsScored(Integer.parseInt(readFile.nextLine()));
                club.setGoalsReceived(Integer.parseInt(readFile.nextLine()));
                club.setPoints(Integer.parseInt(readFile.nextLine()));
                clubsList.add(club);
            }
            readFile.close();
            System.out.println("... Clubs has been loaded!");
        }
        catch (FileNotFoundException error) {
            System.out.println("Exception error:\nNo data to load!\nAdd and save data first, then reopen the simulator.\n");
        }
        // Load matches list
        try {
            String path = System.getProperty("user.dir");
            Scanner readFile = new Scanner(new BufferedReader(new FileReader(path + File.separator + "played_matches.txt")));
            while (readFile.hasNext()) {
                String date = readFile.nextLine();
                String club1Name = readFile.nextLine();
                String club2Name = readFile.nextLine();
                int club1Score = Integer.parseInt(readFile.nextLine());
                int club2Score = Integer.parseInt(readFile.nextLine());
                Match match = new Match(date, club1Name, club2Name, club1Score, club2Score);
                match.setDate(date);
                match.setClub1Name(club1Name);
                match.setClub2Name(club2Name);
                match.setClub1Score(club1Score);
                match.setClub2Score(club2Score);
                matchesList.add(match);
            }
            readFile.close();
            System.out.println("... Matches history has been loaded!\n");
        }
        catch (FileNotFoundException error) {
            System.out.println("Exception error:\nNo data to load!\nAdd and save data first, then reopen the simulator.\n");
        }
    }

    private void displayClubsNoInfo() {
        System.out.println("There are now " + getNoOfClubs() + " clubs in the Premier League.");
    }

    private void updateClubsDraw(String club1, String club2, int score) {
        Iterator<FootballClub> itr = clubsList.iterator();
        while (itr.hasNext()) {
            FootballClub club = itr.next();
            if (club.getName().equals(club1)) {
                club.setMatchesPlayed(club.getMatchesPlayed() + 1);
                club.setDraws(club.getDraws() + 1);
                club.setPoints(club.getPoints() + 1);
                club.setGoalsScored(club.getGoalsScored() + score);
                club.setGoalsReceived(club.getGoalsReceived() + score);
            }
        }
        Iterator<FootballClub> itr2 = clubsList.iterator();
        while (itr2.hasNext()) {
            FootballClub club = itr2.next();
            if (club.getName().equals(club2)) {
                club.setMatchesPlayed(club.getMatchesPlayed() + 1);
                club.setDraws(club.getDraws() + 1);
                club.setPoints(club.getPoints() + 1);
                club.setGoalsScored(club.getGoalsScored() + score);
                club.setGoalsReceived(club.getGoalsReceived() + score);
            }
        }
    }

    private void updateClubsWinLose(String winner, String loser, int winnerScore, int loserScore) {
        Iterator<FootballClub> itr = clubsList.iterator();
        while (itr.hasNext()) {
            FootballClub club = itr.next();
            if (club.getName().equals(winner)) {
                club.setMatchesPlayed(club.getMatchesPlayed() + 1);
                club.setWins(club.getWins() + 1);
                club.setGoalsScored(club.getGoalsScored() + winnerScore);
                club.setGoalsReceived(club.getGoalsReceived() + loserScore);
                club.setPoints(club.getPoints() + 3);
            }
        }
        Iterator<FootballClub> itr2 = clubsList.iterator();
        while (itr2.hasNext()) {
            FootballClub club = itr2.next();
            if (club.getName().equals(loser)) {
                club.setMatchesPlayed(club.getMatchesPlayed() + 1);
                club.setDefeats(club.getDefeats() + 1);
                club.setGoalsScored(club.getGoalsScored() + loserScore);
                club.setGoalsReceived(club.getGoalsReceived() + winnerScore);
            }
        }
    }

    private void displayRow(FootballClub club) {
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

    private void displayClubsNames(List<FootballClub> clubsList) {
        System.out.println("Current clubs list:");
        clubsList.forEach(club -> {
            if (clubsList.indexOf(club) < clubsList.size()-1) {
                System.out.print(club.getName() + ", ");
            } else {
                System.out.println(club.getName());
            }
        });
    }


    // Validation methods
    private boolean nameValidationFailed(String name) {
        if (name.equals("")) {
            System.out.print("Name cannot be empty!\nTry again: ");
            return true;
        }
        if (isInteger(name)) {
            System.out.print("Name cannot be a number!\nTry again: ");
            return true;
        }
        return false;
    }

    private boolean clubNotInLeague(String name) {
        Iterator<FootballClub> itr = clubsList.iterator();
        while (itr.hasNext()) {
            FootballClub club = itr.next();
            if (club.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    private boolean isInteger(String name) {
        try {
            int integer = Integer.parseInt(name);
            return true;
        }
        catch(NumberFormatException error) {
            return false;
        }
    }
} // End of main method
