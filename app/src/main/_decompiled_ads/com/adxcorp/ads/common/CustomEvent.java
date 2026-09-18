package com.adxcorp.ads.common;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class CustomEvent {
    public abstract void destroy();

    public void loadAd(Context context, Map<String, String> map, CustomEventListener customEventListener) {
    }

    public Map convertJsonToMap(MediationData mediationData) {
        HashMap map = new HashMap();
        try {
            map.put("ecpm", String.valueOf(mediationData.getEcpm()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (mediationData != null && !TextUtils.isEmpty(mediationData.getCustomEventParams())) {
            try {
                JSONObject jSONObject = new JSONObject(mediationData.getCustomEventParams());
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject.getString(next));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return map;
    }

    public void internalLoadAd(Context context, MediationData mediationData, long j, CustomEventListener customEventListener) {
        loadAd(context, convertJsonToMap(mediationData), customEventListener);
    }
}
