package me.mortuza.edetailingclone;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonTest {
    void createJson() {

        try {
            JSONArray jsonArray = new JSONArray();
            JSONObject detailJson = new JSONObject();
            for (int i = 0; i < 10; i++) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("PageNo", "1");
                jsonObject.put("PageType", "Page");
                jsonObject.put("PromotionTime", "10");
                jsonArray.put(jsonObject);
            }
            detailJson.put("Detail", jsonArray);
            Log.d("JsonTest", "createJson: " + detailJson.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
