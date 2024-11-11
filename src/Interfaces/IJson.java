package Interfaces;

import org.json.JSONObject;

public interface IJson <T>{
    T jsonToThisClass(JSONObject json);
    JSONObject classToJson();

}
