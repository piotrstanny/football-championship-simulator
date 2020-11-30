package footballchampionship;

public abstract class SportsClub {
    private String name, location;

    public SportsClub(String name, String location) {
        this.name = name;
        this.location = location;
    }
    // Set an abstract method
    public abstract void displayStats();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
