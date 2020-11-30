
package footballchampionship;

public class FootballChampionship {

    public static void main(String[] args) {

        System.out.println("Welcome to the Football Championship Simulator!");
        // Create League object and use methods inherited from the class
        PremierLeagueManager premierLeague = new PremierLeagueManager();

        // Loading main menu:
        String menuChoice = PremierLeagueManager.menuList();

        while (!menuChoice.equals("q")) {
            switch (menuChoice) {
                case "c":
                    System.out.println("\nCreate new club:\n---------------------");
//                    method();
                    menuChoice = PremierLeagueManager.menuList();
                    break;
                case "d":
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

        // Create Football Club
        FootballClub club1 = new FootballClub("Legia", "Warszawa");
//        System.out.println("Premier League clubs: " + premierLeague.displayNoOfClubs());
//        club1.displayStats();
//        System.out.println(club1);


        // Closing the program:
        System.out.println("\nYour session has ended. Goodbye!");
    }
}
