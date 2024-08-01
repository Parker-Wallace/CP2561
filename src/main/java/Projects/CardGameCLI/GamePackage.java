package Projects.CardGameCLI;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GamePackage {
    private JSONObject jsonObject;
    
    public GamePackage() {
        this.jsonObject = new JSONObject();
    }

    public GamePackage(String json) throws ParseException {
        JSONParser parser = new JSONParser();
        this.jsonObject = (JSONObject) parser.parse(json);
    }

    @SuppressWarnings("unchecked")
    public void put(String key, Object value) {
        this.jsonObject.put(key, value);
    }

    public Object get(String key) {
        return this.jsonObject.get(key);
    }

    @Override
    public String toString() {
        return this.jsonObject.toString();
    }

    // Add any other methods you need to interact with the JSONObject
}

