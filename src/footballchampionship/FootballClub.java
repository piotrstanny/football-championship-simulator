package footballchampionship;

public class FootballClub extends SportsClub {
    int wins, draws, defeats, goalsReceived, goalsScored, points, matchesPlayed = 0;

    public FootballClub(String name, String location) {
        super(name, location);
    }

    public void displayStats() {
        System.out.println("Club's statistics:" + wins + draws + defeats);
    }

    @Override
    public String toString() {
        return "FootballClub{" +
                "name: " + getName() + ", " +
                "location: " + getLocation() +
                '}';
    }
}
