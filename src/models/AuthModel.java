package models;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class AuthModel {
    private JSONArray users;

    public AuthModel() {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("user.json"));
            JSONObject jsonObject = (JSONObject) obj;
            users = (JSONArray) jsonObject.get("users");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public boolean authenticate(String username, String password) {
        for (Object obj : users) {
            JSONObject user = (JSONObject) obj;
            if (user.get("username").equals(username) && user.get("password").equals(password)) {
                return true;
            }
        }
        return false;
    }
}