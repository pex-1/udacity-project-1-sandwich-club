package com.udacity.sandwichclub.utils;


import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class JsonUtils {

    public static final String NAME= "name";
    public static final String MAIN_NAME = "mainName";
    public static final String PLACE_OF_ORIGIN = "placeOfOrigin";
    public static final String DESCRIPTION = "description";
    public static final String IMAGE = "image";
    public static final String ALSO_KNOWN_AS = "alsoKnownAs";
    public static final String INGREDIENTS = "ingredients";

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        String mainName;
        List<String> alsoKnownAs = new ArrayList<>();;
        String placeOfOrigin;
        String description;
        String image;
        List<String> ingredients = new ArrayList<>();;

        JSONObject rootObject = new JSONObject(json);
        JSONObject name = rootObject.getJSONObject(NAME);

        //optString - returns "" if empty
        mainName = name.optString(MAIN_NAME);
        placeOfOrigin = rootObject.optString(PLACE_OF_ORIGIN);
        description = rootObject.optString(DESCRIPTION);
        image = rootObject.optString(IMAGE);

        JSONArray alsoKnownAsArray = name.getJSONArray(ALSO_KNOWN_AS);
        for (int i = 0; i < alsoKnownAsArray.length(); i++) {
            alsoKnownAs.add(alsoKnownAsArray.getString(i));
        }

        JSONArray ingredientsArray = rootObject.getJSONArray(INGREDIENTS);
        for (int i = 0; i < ingredientsArray.length(); i++) {
            ingredients.add(ingredientsArray.getString(i));
        }

        return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);

    }
}
