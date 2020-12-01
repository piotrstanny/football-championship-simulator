
package footballchampionship;

public class FootballChampionship {

    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to the Football Championship Simulator!");
        // Create League object
        PremierLeagueManager premierLeague = new PremierLeagueManager();
        // Current no of clubs in the league
        System.out.println("There currently are " + premierLeague.getNoOfClubs() + " clubs in the Premier League.");

        // Loading main menu:
        String menuChoice = PremierLeagueManager.menuList();
        while (!menuChoice.equals("q")) {
            switch (menuChoice) {
                case "c":
                    System.out.println("\nCreate new club:\n---------------------");
                    premierLeague.createClub();
                    menuChoice = PremierLeagueManager.menuList();
                    break;
                case "r":
                    System.out.println("\nRemove club from Premier League:\n---------------------");
                    premierLeague.removeClub();
                    menuChoice = PremierLeagueManager.menuList();
                    break;
                case "s":
                    System.out.println("\nDisplay statistics of a club:\n---------------------");
                    premierLeague.displayClubStats();
                    menuChoice = PremierLeagueManager.menuList();
                    break;
                case "t":
                    System.out.println("\nDisplay Premier League table:\n---------------------------------------------");
                    premierLeague.displayTable();
                    menuChoice = PremierLeagueManager.menuList();
                    break;
                case "a":
                    System.out.println("\nAdd a played match:\n---------------------");
//                    method();
                    menuChoice = PremierLeagueManager.menuList();
                    break;
                case "f":
                    System.out.println("\nSave data to the file:\n---------------------");
                    premierLeague.saveToFile();
                    menuChoice = PremierLeagueManager.menuList();
                    break;
            }
        }
        // Closing the program:
        System.out.println("\nYour session has ended. Goodbye!");
    }
}
