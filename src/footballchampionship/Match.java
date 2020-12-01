package footballchampionship;

public class Match {
    String date, club1Name, club2Name;
    int club1Score, club2Score;

    public Match(String date, String club1Name, String club2Name, int club1Score, int club2Score) {
        this.date = date;
        this.club1Name = club1Name;
        this.club2Name = club2Name;
        this.club1Score = club1Score;
        this.club2Score = club2Score;
    }

    public String getDate() {
        return date;
    }

    public String getClub1Name() {
        return club1Name;
    }

    public String getClub2Name() {
        return club2Name;
    }

    public int getClub1Score() {
        return club1Score;
    }

    public int getClub2Score() {
        return club2Score;
    }
}
