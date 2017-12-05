package de.idrinth.dominant;

import java.math.BigDecimal;
import java.util.Map;
import org.json.JSONObject;
// see https://melkersson.eu/dominant/stat/colonies.json
public class Colony {
    private final BigDecimal longitude;
    private final BigDecimal latitude;
    private final long a0;
    private final long a1;
    private final long a2;
    private final long population;
    private final User owner;

    public Colony(JSONObject data, Map<Long, User> users) {
        longitude = data.getBigDecimal("lng");
        latitude = data.getBigDecimal("lat");

        a0 = data.getLong("a0");
        a1 = data.getLong("a1");
        a2 = data.getLong("a2");

        population = data.getLong("w");
        
        owner = users.get(data.optLong("o"));
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public long getA0() {
        return a0;
    }

    public long getA1() {
        return a1;
    }

    public long getA2() {
        return a2;
    }

    public long getPopulation() {
        return population;
    }

    public User getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "\n  Colony{" + "longitude=" + longitude + ", latitude=" + latitude + ", a0=" + a0 + ", a1=" + a1 + ", a2=" + a2 + ", population=" + population + '}';
    }
    
}
