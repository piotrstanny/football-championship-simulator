
package footballchampionship;

public class FootballChampionship {

    public static void main(String[] args) {

        System.out.println("Welcome to the Football Championship Simulator!");
        // Loading main menu:
        String menuChoice = PremierLeagueManager.menuList();

        // Create League object and use methods inherited from the class
        PremierLeagueManager premierLeague = new PremierLeagueManager();

        // Create Football Club
        FootballClub club1 = new FootballClub("Legia", "Warszawa");
//        System.out.println("Premier League clubs: " + premierLeague.displayNoOfClubs());
//        club1.displayStats();
//        System.out.println(club1);
    }
}
