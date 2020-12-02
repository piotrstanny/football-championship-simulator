package footballchampionship;

public class FootballClub extends SportsClub {
    int matchesPlayed, wins, draws, defeats, goalsScored, goalsReceived, points;

    FootballClub(String name, String location) {
        super(name, location);
    }

    int getWins() {
        return wins;
    }

    void setWins(int wins) {
        this.wins = wins;
    }

    int getDraws() {
        return draws;
    }

    void setDraws(int draws) {
        this.draws = draws;
    }

    int getDefeats() {
        return defeats;
    }

    void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    int getGoalsReceived() {
        return goalsReceived;
    }

    void setGoalsReceived(int goalsReceived) {
        this.goalsReceived = goalsReceived;
    }

    int getGoalsScored() {
        return goalsScored;
    }

    void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    int getPoints() {
        return points;
    }

    void setPoints(int points) {
        this.points = points;
    }

    int getMatchesPlayed() {
        return matchesPlayed;
    }

    void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }
}
