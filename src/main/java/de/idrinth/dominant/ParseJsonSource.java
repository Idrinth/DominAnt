package de.idrinth.dominant;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;

public class ParseJsonSource {
    public Map<Long, User> get() throws IOException {
        Map<Long, User> users = new HashMap<>();
        parseUsers(users);
        parseColonies(users);
        return users;
    }
    private void parseUsers(Map<Long, User> users) throws IOException {
        JSONArray usersData = new JSONArray(
                IOUtils.resourceToString("/data/users.json", Charset.forName("utf-8")).substring(6)
        );
        int index = 0;
        while(index < usersData.length()) {
            User user = new User(usersData.getJSONObject(index));
            users.put(user.getId(), user);
            index++;
        }
    }
    private void parseColonies(Map<Long, User> users) throws IOException {
        JSONArray colonyData = new JSONArray(
                IOUtils.resourceToString("/data/colonies.json", Charset.forName("utf-8")).substring(9)
        );
        int index = 0;
        while(index < colonyData.length()) {
            Colony c = new Colony(colonyData.getJSONObject(index), users);
            c.getOwner().addColony(c);
            index++;
        }
    }
}
