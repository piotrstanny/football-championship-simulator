package footballchampionship;

public abstract class SportsClub {
    private String name, location;

    SportsClub(String name, String location) {
        this.name = name;
        this.location = location;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getLocation() {
        return location;
    }

    void setLocation(String location) {
        this.location = location;
    }
}
