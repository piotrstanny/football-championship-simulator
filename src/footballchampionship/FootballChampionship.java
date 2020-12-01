
package footballchampionship;

public class FootballChampionship {

    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to the Football Championship Simulator!");
        // Create Premier League instance
        PremierLeagueManager premierLeague = new PremierLeagueManager();
        // Load data from file if exists
        premierLeague.loadDataFromFile();
        // Current no of clubs in the league
        System.out.println("The season 2020-21 has begun!");
        System.out.println("There currently are " + premierLeague.getNoOfClubs() + " clubs in the Premier League.");

        // Loading main menu:
        String menuChoice = premierLeague.menuList();
        while (!menuChoice.equals("q")) {
            switch (menuChoice) {
                case "c":
                    System.out.println("\nCreate new club:\n---------------------");
                    premierLeague.createClub();
                    menuChoice = premierLeague.menuList();
                    break;
                case "r":
                    System.out.println("\nRemove club from Premier League:\n---------------------");
                    premierLeague.removeClub();
                    menuChoice = premierLeague.menuList();
                    break;
                case "s":
                    System.out.println("\nDisplay statistics of a club:\n---------------------");
                    premierLeague.displayClubStats();
                    menuChoice = premierLeague.menuList();
                    break;
                case "t":
                    System.out.println("\nDisplay Premier League table:\n---------------------------------------------");
                    premierLeague.displayTable();
                    menuChoice = premierLeague.menuList();
                    break;
                case "a":
                    System.out.println("\nAdd a played match:\n---------------------");
                    premierLeague.addMatch();
                    menuChoice = premierLeague.menuList();
                    break;
                case "f":
                    System.out.println("\nSave data to the file:\n---------------------");
                    premierLeague.saveToFile();
                    menuChoice = premierLeague.menuList();
                    break;
            }
        }
        // Closing the program:
        System.out.println("\nYour session has ended. Goodbye!");
    }
}
