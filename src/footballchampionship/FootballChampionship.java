
package footballchampionship;

public class FootballChampionship {

    public static void main(String[] args) {

        System.out.println("Welcome to the Football Championship Simulator!");
        // Create League object
        PremierLeagueManager premierLeague = new PremierLeagueManager();
        //
        System.out.println(premierLeague.getNoOfClubs());

        // Loading main menu:
        String menuChoice = PremierLeagueManager.menuList();

        while (!menuChoice.equals("q")) {
            switch (menuChoice) {
                case "c":
                    System.out.println("\nCreate new club:\n---------------------");
                    premierLeague.createClub();
                    System.out.println(premierLeague.getNoOfClubs());
                    menuChoice = PremierLeagueManager.menuList();
                    break;
                case "R":
                    System.out.println("\nRemove club from Premier League:\n---------------------");
//                    method();
                    menuChoice = PremierLeagueManager.menuList();
                    break;
                case "s":
                    System.out.println("\nDisplay statistics of a club:\n---------------------");
//                    method();
                    menuChoice = PremierLeagueManager.menuList();
                    break;
                case "t":
                    System.out.println("\nDisplay Premier League table:\n---------------------");
//                    method();
                    menuChoice = PremierLeagueManager.menuList();
                    break;
                case "a":
                    System.out.println("\nAdd a played match:\n---------------------");
//                    method();
                    menuChoice = PremierLeagueManager.menuList();
                    break;
                case "f":
                    System.out.println("\nSave data to the file:\n---------------------");
//                    method();
                    menuChoice = PremierLeagueManager.menuList();
                    break;
            }
        }
        // Closing the program:
        System.out.println("\nYour session has ended. Goodbye!");
    }
}
