package com.tapjoy;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class TJDataFetcher {
    public final JSONObject a = new JSONObject();

    public final JSONObject a(JSONArray jSONArray) throws JSONException {
        Object obj;
        for (int i = 0; i < jSONArray.length(); i++) {
            if (jSONArray.get(i).equals("USER_ID")) {
                String userID = TapjoyConnectCore.getUserID();
                JSONObject jSONObject = this.a;
                if (userID == null || userID.isEmpty()) {
                    obj = userID;
                    obj = JSONObject.NULL;
                }
                obj = userID;
                jSONObject.put("USER_ID", obj);
            }
        }
        return this.a;
    }
}
