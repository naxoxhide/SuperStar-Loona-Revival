package com.tapjoy;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class TJCurrencyParameters {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2690b = null;
    public int c = -1;
    public String d = null;
    public int e = -1;
    public boolean f = false;
    public final HashMap g = new HashMap();
    public final HashMap h = new HashMap();
    public ArrayList i = new ArrayList();

    public TJCurrencyParameters(Context context) {
        if (context != null && this.a == null) {
            this.a = context;
        }
        a();
    }

    public final void a() {
        Context context = this.a;
        if (context == null) {
            return;
        }
        TJKeyValueStorage tJKeyValueStorage = new TJKeyValueStorage(context, TapjoyConstants.TJC_PREFERENCE);
        if (tJKeyValueStorage.contains(TapjoyConstants.PREF_SERVER_CURRENCY_IDS)) {
            String string = tJKeyValueStorage.getString(TapjoyConstants.PREF_SERVER_CURRENCY_IDS, "[]");
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String strOptString = jSONObject.optString("currency_id");
                    this.f = jSONObject.optString(TapjoyConstants.PREF_SERVER_CURRENCY_TYPE).equals(TapjoyConstants.PREF_SERVER_CURRENCY_SELF_MANAGED);
                    arrayList.add(strOptString);
                }
            } catch (JSONException unused) {
                TapjoyLog.e("CurrencyParams", "Failed to parse currency id list");
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.i = arrayList;
        }
    }
}
