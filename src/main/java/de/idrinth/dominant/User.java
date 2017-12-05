package de.idrinth.dominant;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
//see https://melkersson.eu/dominant/stat/colonies.json
public class User {
    private final String name;
    private final long id;
    private final long level;
    private final String country;
    private final String team;
    private final List<Colony> colonies = new ArrayList<>();

    public User(JSONObject data) {
        String[] teams = "Undecided,Fire,Forest,Water".split(",");

        name = data.optString("n");
        country = data.getString("c");
        team = teams[data.optInt("s")];

        level = data.getLong("l");
        id = data.getLong("i");
    }
    public void addColony(Colony colony) {
        colonies.add(colony);
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public long getLevel() {
        return level;
    }

    public String getCountry() {
        return country;
    }

    public String getTeam() {
        return team;
    }

    public List<Colony> getColonies() {
        return colonies;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", id=" + id + ", level=" + level + ", country=" + country + ", team=" + team + '}' + colonies;
    }
}
